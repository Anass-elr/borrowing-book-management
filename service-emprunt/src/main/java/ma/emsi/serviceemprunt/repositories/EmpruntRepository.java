package ma.emsi.serviceemprunt.repositories;

import ma.emsi.serviceemprunt.entities.Emprunte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpruntRepository extends JpaRepository<Emprunte,String> {

    List<Emprunte> findEmpruntesByIdPersonne(String idPersonne);
    List<Emprunte>  findEmpruntesByIdLivreOrderByRetourLivreAsc(String idLivre);
}
