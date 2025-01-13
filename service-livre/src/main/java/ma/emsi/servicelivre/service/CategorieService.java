package ma.emsi.servicelivre.service;

import lombok.AllArgsConstructor;
import ma.emsi.servicelivre.entities.Categorie;
import ma.emsi.servicelivre.repositories.CategorieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategorieService implements ICategorieService{

    private CategorieRepository categorieRepository;
    @Override
    public Categorie findByCategorieId(String id) {
        return categorieRepository.findById(id)
                .orElseThrow(()->  new RuntimeException("CATEGORIE NOT FOUND EXCEPTION"));
    }

    @Override
    public List<Categorie> findAllCategories() {
        return categorieRepository.findAll();
    }

    @Override
    public Categorie saveCategorie(Categorie categorie) {

        if(categorie == null)  throw new RuntimeException("EMPTY INPUT");
        Categorie categorieDB = categorieRepository.findCategorieByLibCategorie(categorie.getLibCategorie());
        if(categorieDB != null) throw new RuntimeException("Categerie with Same lib already exist");


        return categorieRepository.save(categorie);

    }

    @Override
    public Categorie updateCategorie(String id, Categorie categorie) {
          Categorie categorie1 = findByCategorieId(id);

          return categorieRepository.save(categorie);
    }

    @Override
    public Categorie deleteCategorie(String id) {
        Categorie categorie1 = findByCategorieId(id);

        categorieRepository.deleteById(id);

        return categorie1;
    }
}
