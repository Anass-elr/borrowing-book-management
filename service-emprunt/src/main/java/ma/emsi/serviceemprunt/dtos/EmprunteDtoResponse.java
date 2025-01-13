package ma.emsi.serviceemprunt.dtos;

import lombok.*;
import ma.emsi.serviceemprunt.model.Livre;
import ma.emsi.serviceemprunt.model.Personne;

import java.util.Date;

@AllArgsConstructor @NoArgsConstructor
@Data
public class EmprunteDtoResponse {

    private String idPersonne;

    private String idLivre;

    private Date   dateEmprunte;

    private Date   retourLivre;

    private Date    retourLivre_Personne;

    private double        coutEmprunt;

    private double        coutRetard;

    private Livre   livre;

    private Personne personne;


    public double getCoutEmprunt() {
        return coutEmprunt;
    }

    public void setCoutEmprunt(double coutEmprunt) {
        this.coutEmprunt = coutEmprunt;
    }

    public double getCoutRetard() {
        return coutRetard;
    }

    public void setCoutRetard(double coutRetard) {
        this.coutRetard = coutRetard;
    }



    public Date getDateEmprunte() {
        return dateEmprunte;
    }

    public void setDateEmprunte(Date dateEmprunte) {
        this.dateEmprunte = dateEmprunte;
    }

    public Date getRetourLivre() {
        return retourLivre;
    }

    public void setRetourLivre(Date retourLivre) {
        this.retourLivre = retourLivre;
    }

    public Date getRetourLivre_Personne() {
        return retourLivre_Personne;
    }

    public void setRetourLivre_Personne(Date retourLivre_Personne) {
        this.retourLivre_Personne = retourLivre_Personne;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public String getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(String idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getIdLivre() {
        return idLivre;
    }

    public void setIdLivre(String idLivre) {
        this.idLivre = idLivre;
    }
}
