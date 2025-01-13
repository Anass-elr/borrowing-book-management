package ma.emsi.serviceemprunt.service;

import java.time.LocalDate;

import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.emsi.serviceemprunt.Feign.LivreRestClient;
import ma.emsi.serviceemprunt.Feign.PersonneRestClient;
import ma.emsi.serviceemprunt.dtos.EmpruntDtoRequest;
import ma.emsi.serviceemprunt.dtos.EmprunteDtoResponse;
import ma.emsi.serviceemprunt.entities.Emprunte;
import ma.emsi.serviceemprunt.model.Livre;
import ma.emsi.serviceemprunt.model.Personne;
import ma.emsi.serviceemprunt.repositories.EmpruntRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Transactional
public class EmpruntService {

    @Autowired
    private EmpruntRepository  empruntRepository;

    @Autowired
    private ModelMapper        modelMapper;

    @Autowired
    private LivreRestClient    livreRestClient;

    @Autowired
    private PersonneRestClient personneRestClient;

    public Emprunte getById(String id){
        return  empruntRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Emprrunte NOT FOUND"));
    }


    public EmprunteDtoResponse getEmpruntById(String id){
        return  modelMapper.map(empruntRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("")), EmprunteDtoResponse.class);
    }

    public List<EmprunteDtoResponse> getEmprunts(){
        return  empruntRepository.findAll()
                .stream()
                .map(emprunte -> modelMapper.map(emprunte, EmprunteDtoResponse.class))
                .collect(Collectors.toList());
    }

    public EmprunteDtoResponse saveEmprunt(EmpruntDtoRequest emprunteDto){

        Livre livre       = livreRestClient.getLivreById(emprunteDto.getIdLivre()).getBody();
        Personne personne = personneRestClient.personne(emprunteDto.getIdPersonne()).getBody();


        Emprunte emprunte = new Emprunte();

        emprunte.setLivre(livre);

        emprunte.setPersonne(personne);
        emprunte.setIdPersonne(personne.getId());
        emprunte.setIdLivre(livre.getId());
        emprunte.setCoutEmpruntJounalie(livre.getPrixLivre());
        emprunte.setLivre(livre);
        emprunte.setPersonne(personne);
        emprunte.setDateEmprunte(emprunteDto.getDateEmprunte());
        emprunte.setRetourLivre(emprunteDto.getRetourLivre());
        LocalDate localDate = convertToLocalDate(emprunteDto.getDateEmprunte());
        LocalDate localDate1 = convertToLocalDate(emprunteDto.getRetourLivre());

        double prix = (livre.getPrixLivre()*3)/100;
        emprunte.setCoutEmpruntJounalie(
               prix);


        prix = (livre.getPrixLivre()*5)/100;
        emprunte.setCoutRetartJournalier(
               prix
        );

        // modifier le stoque de livres
        long days= ChronoUnit.DAYS.between(localDate, localDate1);
        System.out.println("DAys  : "+days);

        prix = days*emprunte.getCoutEmpruntJounalie();
        emprunte.setCoutEmprunt(prix);

        Emprunte emprunte1=empruntRepository.save(emprunte);
        emprunte1.setPersonne(personne);
        emprunte1.setLivre(livre);
        return modelMapper.map(emprunte, EmprunteDtoResponse.class);

    }


    public EmprunteDtoResponse saveEmpruntRetourne(String id, Date dateRetoure){

        Emprunte  emprunte = getById(id);

        emprunte.setRetoune(true);
        emprunte.setRetourLivre_Personne(dateRetoure);

        LocalDate localDate1 = convertToLocalDate(emprunte.getRetourLivre());
        LocalDate localDate2 = convertToLocalDate(dateRetoure);

        if(localDate1.isBefore(localDate2)){
            emprunte.setPenalite(true);
            long daysBetween = ChronoUnit.DAYS.between(localDate1, localDate2);
            emprunte.setCoutRetard(daysBetween*emprunte.getCoutEmpruntJounalie());
            System.out.println("Days : " +daysBetween);
        }
        else {
            emprunte.setCoutRetard(0d);
        }
        empruntRepository.save(emprunte);
        return modelMapper.map(emprunte ,EmprunteDtoResponse.class );

    }

    public List<EmprunteDtoResponse> getEmpruntesByPersonne(String idPersonne){

        Personne personne = personneRestClient.personne(idPersonne).getBody();

        List<Emprunte> empruntesList = empruntRepository.findEmpruntesByIdPersonne(idPersonne);

        empruntesList.forEach(emprunte -> {
            emprunte.setPersonne(personne);
            Livre livre = livreRestClient.getLivreById(emprunte.getIdLivre()).getBody();
            emprunte.setLivre(livre);
        });


        List<EmprunteDtoResponse> empruntesListDto=  empruntesList.stream()
                .map(emprunte -> modelMapper.map(emprunte , EmprunteDtoResponse.class))
                .toList();

        return empruntesListDto ;
    }


    private static LocalDate convertToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }


}
