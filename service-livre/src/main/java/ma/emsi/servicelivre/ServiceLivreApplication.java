package ma.emsi.servicelivre;

import ma.emsi.servicelivre.config.RsaKeysConfig;
import ma.emsi.servicelivre.entities.Categorie;
import ma.emsi.servicelivre.entities.Livre;
import ma.emsi.servicelivre.repositories.CategorieRepository;
import ma.emsi.servicelivre.repositories.LivreRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class ServiceLivreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceLivreApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(CategorieRepository categorieRepository, LivreRepository livreRepository){
			return args -> {

				Categorie categorie = Categorie.builder()
						.libCategorie("Histoire").build();


						Categorie cat = Categorie.builder()
								.libCategorie("Science").build();


						Categorie cats = Categorie.builder()
								.libCategorie("Sport").build();

						categorieRepository.save(categorie);
				categorieRepository.save(cat);

				categorieRepository.save(cats);


				categorieRepository.findAll().forEach(
						categorie1 -> {
							Livre livre = Livre.builder().libLivre("livre"+categorie1.getLibCategorie()).prixLivre(123.00)
									.categories(List.of(categorie1)).nbEnStoque(3).auteur("Auteur").build();
						  livreRepository.save(livre);
						}
				);

			};
	}

}
