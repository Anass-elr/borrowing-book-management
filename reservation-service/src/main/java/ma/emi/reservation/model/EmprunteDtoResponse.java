package ma.emi.reservation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor @NoArgsConstructor
@Data

public class EmprunteDtoResponse {

    private String cne;

    private String libLivre;

    private Date dateEmprunte;

    private Date   retourLivre;

    private Date    retourLivre_Personne;

    private double        coutEmprunt;

    private double        coutRetard;

    private Livre   livre;

    private Personne personne;


    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public String getLibLivre() {
        return libLivre;
    }

    public void setLibLivre(String libLivre) {
        this.libLivre = libLivre;
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
}
