package ma.emsi.serviceutilisateurs.service;

import jakarta.transaction.Transactional;
import ma.emsi.serviceutilisateurs.entities.Personne;
import ma.emsi.serviceutilisateurs.repositories.PersonneRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class PersonneService implements IPersonneService {

    @Autowired
    private PersonneRepository personneRepository;

    @Override
    public Personne findById(String id) {
        return personneRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Person NOT FOUND EXC"));

    }

    @Override
    public Personne findByCne(String cne) {

        return personneRepository.findPersonneByCne(cne);
    }



    @Override
    public List<Personne> findAll() {
        return personneRepository.findAll();
    }

    @Override
    public Personne savePersonne(Personne personne) {
        if(personne != null)
          return personneRepository.save(personne);

        else
            throw new RuntimeException("");
    }

    @Override
    public Personne updatePersonne(String id, Personne personne) {
        findById(id);
        return personneRepository.save(personne);
    }

    @Override
    public Personne deletePersonne(String id) {
         Personne  personne1 = findById(id);

          personneRepository.deleteById(id);
          return personne1;
    }
}
