package ma.emi.reservation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;


@AllArgsConstructor @NoArgsConstructor
@Data
public class EmpruntRequest {

    private String idPersonne;
    private String idLivre;
    private String idReservation;
    private String cne;

    private String libLivre;

    private Date dateEmprunte;

    private Date   retourLivre;


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
}
