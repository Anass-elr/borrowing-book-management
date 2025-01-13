package ma.emsi.serviceutilisateurs.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@AllArgsConstructor @NoArgsConstructor
@Data
@Getter @Setter
@Entity

@Builder
public  class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String cne;

    // Gestion Des Exception de Unique

    private  String  email;
    private Date     dateNaissance;

    private String nom ;
    private String prenom ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
