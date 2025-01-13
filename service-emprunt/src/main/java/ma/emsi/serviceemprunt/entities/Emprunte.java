package ma.emsi.serviceemprunt.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.emsi.serviceemprunt.model.Livre;
import ma.emsi.serviceemprunt.model.Personne;

import java.util.Date;


@Entity
@AllArgsConstructor  @NoArgsConstructor


@Builder
public class Emprunte {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String idPersonne;

    private String idLivre;

    private String idReservation;

    private Date       dateEmprunte;
    private Date       retourLivre;

    private Date       retourLivre_Personne;

    private boolean     penalite = false ;

    private boolean     retoune = false;

    private double     coutEmpruntJounalie ;
    private  double    coutRetartJournalier;


    private double      coutEmprunt;

    private double      coutRetard;

    @Transient
    private Livre    livre;

    @Transient
    private Personne personne;


    public double getCoutRetartJournalier() {
        return coutRetartJournalier;
    }

    public void setCoutRetartJournalier(double coutRetartJournalier) {
        this.coutRetartJournalier = coutRetartJournalier;
    }


    public boolean isRetoune() {
        return retoune;
    }

    public void setRetoune(boolean retoune) {
        this.retoune = retoune;
    }


    public double getCoutRetard() {
        return coutRetard;
    }

    public void setCoutRetard(double coutRetard) {
        this.coutRetard = coutRetard;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(String idReservation) {
        this.idReservation = idReservation;
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

    public boolean isPenalite() {
        return penalite;
    }

    public void setPenalite(boolean penalite) {
        this.penalite = penalite;
    }

    public double getCoutEmprunt() {
        return coutEmprunt;
    }

    public void setCoutEmprunt(double coutEmprunt) {
        this.coutEmprunt = coutEmprunt;
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

    public double getCoutEmpruntJounalie() {
        return coutEmpruntJounalie;
    }

    public void setCoutEmpruntJounalie(double coutEmpruntJounalie) {
        this.coutEmpruntJounalie = coutEmpruntJounalie;
    }
}
