package ma.emi.reservation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;


@AllArgsConstructor @NoArgsConstructor
@Data
public class EmpruntRequest {


    private String cne;

    private String libLivre;

    private LocalDate dateEmprunte;

    private LocalDate   retourLivre;

    private LocalDate   retourLivre_Personne;

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

    public LocalDate getDateEmprunte() {
        return dateEmprunte;
    }

    public void setDateEmprunte(LocalDate dateEmprunte) {
        this.dateEmprunte = dateEmprunte;
    }

    public LocalDate getRetourLivre() {
        return retourLivre;
    }

    public void setRetourLivre(LocalDate retourLivre) {
        this.retourLivre = retourLivre;
    }

    public LocalDate getRetourLivre_Personne() {
        return retourLivre_Personne;
    }

    public void setRetourLivre_Personne(LocalDate retourLivre_Personne) {
        this.retourLivre_Personne = retourLivre_Personne;
    }
}
