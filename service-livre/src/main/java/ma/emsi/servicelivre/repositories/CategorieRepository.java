package ma.emsi.servicelivre.repositories;

import ma.emsi.servicelivre.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie,String> {

    Categorie findCategorieByLibCategorie(String libCategorie);
}
