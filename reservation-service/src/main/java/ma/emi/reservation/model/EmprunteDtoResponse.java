package ma.emi.reservation.model;

import java.time.LocalDate;
import java.util.Date;

public class EmprunteDtoResponse {

    private String cne;

    private String libLivre;

    private LocalDate dateEmprunte;

    private LocalDate   retourLivre;

    private LocalDate    retourLivre_Personne;

    private double        coutEmprunt;

    private double        coutRetard;

    private Livre   livre;

    private Personne personne;

}
