package ma.emsi.serviceutilisateurs.repositories;

import ma.emsi.serviceutilisateurs.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonneRepository extends JpaRepository<Personne,String> {
    Personne findPersonneByCne(String cne);
}
