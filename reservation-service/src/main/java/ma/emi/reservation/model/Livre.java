package ma.emi.reservation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Livre {

    private  String id;
    private String       libLivre;

    private String       auteur;
    private double    prixLivre;

    private int          nbEnStoque;

    private List<String> categoryIds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLibLivre() {
        return libLivre;
    }

    public void setLibLivre(String libLivre) {
        this.libLivre = libLivre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public double getPrixLivre() {
        return prixLivre;
    }

    public void setPrixLivre(double prixLivre) {
        this.prixLivre = prixLivre;
    }

    public int getNbEnStoque() {
        return nbEnStoque;
    }

    public void setNbEnStoque(int nbEnStoque) {
        this.nbEnStoque = nbEnStoque;
    }

    public List<String> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<String> categoryIds) {
        this.categoryIds = categoryIds;
    }
}
