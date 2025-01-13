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

    public ReservationResponse saveReservation(ReservationRequest reservationRequest){

        Livre livre = livreRestClient.getLivreById(reservationRequest.getIdLivre()).getBody();
        Personne personne = personneRestClient.personne(reservationRequest.getIdPersonne()).getBody();

        Reservation reservation = modelMApper.map(reservationRequest , Reservation.class);
        reservation.setLivre(livre);
        reservation.setPersonne(personne);

        reservationRepository.save(reservation);
        return modelMApper.map(reservation , ReservationResponse.class);

    }


    public Reservation getReservation(String id){
       return reservationRepository.findById(id).orElseThrow(()-> new RuntimeException(""));
    }

/*
    public Reservation getReservationByPersonneCne(String cne){
        return reservationRepository.findReservationByPersonneCne(cne);
    }
    public Reservation getReservationByLivre(String lib){
        return reservationRepository.findReservationByLivreLibLivre(lib);
    }


    public Reservation deleteReservationByPersonneCne(String cne){
        Reservation reservation= reservationRepository.findReservationByPersonneCne(cne);
        reservationRepository.deleteById(reservation.getIdReservation());
        return reservation;
    }
*/

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

                emprunteDtoResponseList.add(empruntRestClient.saveEmprunte(empruntRequest));

                reservation.setLivre(livre1);
                reservationRepository.save(reservation);
            }
        });
        return  emprunteDtoResponseList;
    }



}
