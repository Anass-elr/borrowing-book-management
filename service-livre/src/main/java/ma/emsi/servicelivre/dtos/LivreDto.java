package ma.emsi.servicelivre.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LivreDto {

    private String id;

    private String       libLivre;

    private String       auteur;

    private int          nbEnStoque;
    private double       prixLivre;

    private List<String> categoryIds;

}
