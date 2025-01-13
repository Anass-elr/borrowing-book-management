package ma.emsi.serviceutilisateurs.service;

import ma.emsi.serviceutilisateurs.entities.Personne;

import java.util.List;

public interface IPersonneService {

    Personne findById(String id);

    Personne findByCne(String cne);

    List<Personne> findAll();

    Personne savePersonne(Personne personne);
    Personne updatePersonne(String id,Personne personne);
    Personne deletePersonne(String id);

}
