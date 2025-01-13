package ma.emi.reservation.dtos;

import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.emi.reservation.model.Livre;
import ma.emi.reservation.model.Personne;

import java.time.LocalDate;
import java.util.Date;


@AllArgsConstructor @NoArgsConstructor
@Data
public class ReservationResponse {


    private String idPersonne;

    private String idLivre;
    private Date dateReservation;

    private LocalDate date_disponibilite_possible;

    private Date dateEmprunte;

    private int dureeJours;

    private Livre livre ;

    private Personne personne;

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

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public LocalDate getDate_disponibilite_possible() {
        return date_disponibilite_possible;
    }

    public void setDate_disponibilite_possible(LocalDate date_disponibilite_possible) {
        this.date_disponibilite_possible = date_disponibilite_possible;
    }

    public Date getDateEmprunte() {
        return dateEmprunte;
    }

    public void setDateEmprunte(Date dateEmprunte) {
        this.dateEmprunte = dateEmprunte;
    }

    public int getDureeJours() {
        return dureeJours;
    }

    public void setDureeJours(int dureeJours) {
        this.dureeJours = dureeJours;
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

