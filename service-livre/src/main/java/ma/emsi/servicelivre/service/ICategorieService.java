package ma.emsi.servicelivre.service;

import ma.emsi.servicelivre.entities.Categorie;

import java.util.List;

public interface ICategorieService {

    Categorie findByCategorieId(String Id);
    List<Categorie> findAllCategories();

    Categorie saveCategorie(Categorie categorie);

    Categorie updateCategorie(String id , Categorie categorie);

    Categorie deleteCategorie(String id);

}
