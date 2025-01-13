package ma.emi.reservation.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.emi.reservation.model.Livre;
import ma.emi.reservation.model.Personne;

import java.time.LocalDate;
import java.util.Date;


@Entity
@AllArgsConstructor @NoArgsConstructor
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idReservation;

    private String       idPersonne;

    private String       idLivre;
    private LocalDate    dateReservation;

    private LocalDate    dateDisponibilitePossible;

    private LocalDate     dateEmprunte;

    private int           dureeJours;
    private boolean       valid = false;

    @Transient
    private Livre   livre ;

    @Transient
    private Personne personne;


    public String getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(String idReservation) {
        this.idReservation = idReservation;
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

    public LocalDate getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(LocalDate dateReservation) {
        this.dateReservation = dateReservation;
    }

    public LocalDate getDateDisponibilitePossible() {
        return dateDisponibilitePossible;
    }

    public void setDateDisponibilitePossible(LocalDate dateDisponibilitePossible) {
        this.dateDisponibilitePossible = dateDisponibilitePossible;
    }

    public LocalDate getDateEmprunte() {
        return dateEmprunte;
    }

    public void setDateEmprunte(LocalDate dateEmprunte) {
        this.dateEmprunte = dateEmprunte;
    }

    public int getDureeJours() {
        return dureeJours;
    }

    public void setDureeJours(int dureeJours) {
        this.dureeJours = dureeJours;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
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
