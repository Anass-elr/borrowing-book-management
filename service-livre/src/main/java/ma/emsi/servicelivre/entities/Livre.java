package ma.emsi.servicelivre.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@AllArgsConstructor @NoArgsConstructor
@Data
@Builder
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String libLivre;

    private String auteur;

    private int nbEnStoque;

    private double prixLivre;

    @ManyToMany
    private List<Categorie> categories = new ArrayList<>();

}
