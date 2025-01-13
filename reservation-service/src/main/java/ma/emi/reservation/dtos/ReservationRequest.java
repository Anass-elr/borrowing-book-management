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
public class ReservationRequest {

    private String      idPersonne;
    private String      idLivre;
    private LocalDate   dateReservation;
    private LocalDate   dateDisponibilitePossible;
    private int         dureeJours;


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

    public int getDureeJours() {
        return dureeJours;
    }

    public void setDureeJours(int dureeJours) {
        this.dureeJours = dureeJours;
    }
}
