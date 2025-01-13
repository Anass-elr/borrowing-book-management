package ma.emsi.servicelivre.repositories;


import ma.emsi.servicelivre.entities.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivreRepository extends JpaRepository<Livre,String> {

    public Livre findLivreByLibLivre(String lib);
}
