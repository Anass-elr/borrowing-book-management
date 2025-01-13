package ma.emsi.servicelivre.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Data
@Builder
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String libCategorie;



}
