package ma.emsi.serviceutilisateurs.dtos;

import jakarta.persistence.Column;

import java.util.Date;

public class PersonneDto {
    private String cne;

    // Gestion Des Exception de Unique

    private  String  email;
    private Date dateNaissance;

    private String nom ;
    private String prenom ;

}
