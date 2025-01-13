package ma.emsi.serviceutilisateurs.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Etudiant  {

    private String codeEtud;

    @ManyToOne
    private Classe classe;



}
