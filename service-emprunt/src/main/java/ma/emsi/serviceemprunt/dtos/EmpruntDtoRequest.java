package ma.emsi.serviceemprunt.dtos;

import ma.emsi.serviceemprunt.model.Livre;
import ma.emsi.serviceemprunt.model.Personne;

import java.util.Date;

public class EmpruntDtoRequest {

    private String idPersonne;

    private String idLivre;

    private Date   dateEmprunte;

    private Date   retourLivre;

    private Date   retourLivre_Personne;



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
