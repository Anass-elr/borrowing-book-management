package ma.emi.reservation.service;


import lombok.AllArgsConstructor;
import ma.emi.reservation.Feign.EmpruntRestClient;
import ma.emi.reservation.Feign.LivreRestClient;
import ma.emi.reservation.Feign.PersonneRestClient;
import ma.emi.reservation.dtos.ReservationRequest;
import ma.emi.reservation.dtos.ReservationResponse;
import ma.emi.reservation.entities.Reservation;
import ma.emi.reservation.model.EmpruntRequest;
import ma.emi.reservation.model.EmprunteDtoResponse;
import ma.emi.reservation.model.Livre;
import ma.emi.reservation.model.Personne;
import ma.emi.reservation.repositories.ReservationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService {

    @Autowired
     private ReservationRepository reservationRepository;

    @Autowired
    private ModelMapper        modelMApper;

     @Autowired
     private LivreRestClient    livreRestClient;

     @Autowired
     private PersonneRestClient personneRestClient;

     @Autowired
     private EmpruntRestClient empruntRestClient;

    public Reservation saveReservation(ReservationRequest reservationRequest){

        Livre livre             = livreRestClient.getLivreById(reservationRequest.getIdLivre()).getBody();
        Personne personne       = personneRestClient.personne(reservationRequest.getIdPersonne()).getBody();


        Date date =        empruntRestClient.getDateRetourLivre(reservationRequest.getIdLivre()).getRetourLivre();

        System.out.println(reservationRequest.getIdLivre());
        Reservation reservation = new Reservation();
        reservation.setIdLivre(reservationRequest.getIdLivre());
        reservation.setIdPersonne(reservationRequest.getIdPersonne());

        reservation.setDureeJours(reservationRequest.getDureeJours());


        if (date != null) {
            LocalDate retourLocalDate = date.toInstant()
                    .atZone(ZoneId.systemDefault()) // Ou ZoneId.of("UTC") pour UTC
                    .toLocalDate();
            reservation.setDateDisponibilitePossible(retourLocalDate);

            System.out.println("Converted LocalDate: " + retourLocalDate);
        } else {
            System.out.println("Date de retour est null");
        }
        reservation.setDateReservation(LocalDate.now());
        reservation.setLivre(livre);
        reservation.setPersonne(personne);

        reservationRepository.save(reservation);
        return  reservation;

    }


    public Reservation getReservation(String id){
       return reservationRepository.findById(id).orElseThrow(()-> new RuntimeException(""));
    }


    public List<Reservation> getReservationByIdPersonne(String idPeronne){
        return reservationRepository.findReservationByIdPersonne(idPeronne);
    }

    /*
    public Reservation getReservationByLivre(String lib){
        return reservationRepository.findReservationByLivreLibLivre(lib);
    }


    public Reservation deleteReservationByPersonneCne(String cne){
        Reservation reservation= reservationRepository.findReservationByPersonneCne(cne);
        reservationRepository.deleteById(reservation.getIdReservation());
        return reservation;
    }
*/

    /**
    public List<EmprunteDtoResponse> updateReservation(){

        LocalDate today = LocalDate.now();
        List<Reservation> reservations = reservationRepository.findReservationByDateDisponibilitePossible(today);
        List<EmprunteDtoResponse> emprunteDtoResponseList = new ArrayList<>();

        reservations.forEach(reservation -> {
            Livre livre =   livreRestClient.getLivreById(reservation.getIdLivre()).getBody();
            Personne personne = personneRestClient.personne(reservation.getIdPersonne()).getBody();
            LocalDate todayDate = LocalDate.now();

            if(livre.getNbEnStoque()>0){
                reservation.setValid(true);

                EmpruntRequest empruntRequest = new EmpruntRequest();
                empruntRequest.setDateEmprunte(todayDate);

                // Future date after adding dureeJours
                LocalDate futureDate = todayDate.plusDays(reservation.getDureeJours());

                empruntRequest.setRetourLivre(futureDate);
                livre.setNbEnStoque(livre.getNbEnStoque()-1);
                Livre livre1= livreRestClient.updateLivre(livre.getLibLivre() , livre).getBody();
                empruntRequest.setLibLivre(livre.getLibLivre());
                empruntRequest.setCne(personne.getCne());

                empruntRequest.setIdReservation(reservation.getIdReservation());
                emprunteDtoResponseList.add(empruntRestClient.saveEmprunte(empruntRequest));

                reservation.setLivre(livre1);
                reservationRepository.save(reservation);
            }
        });
        return  emprunteDtoResponseList;
    }*/



}
