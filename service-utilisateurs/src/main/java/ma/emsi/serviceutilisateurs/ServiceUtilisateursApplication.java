package ma.emsi.serviceutilisateurs;

import ma.emsi.serviceutilisateurs.config.RsaKeysConfig;
import ma.emsi.serviceutilisateurs.entities.Personne;
import ma.emsi.serviceutilisateurs.repositories.PersonneRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeysConfig.class)

public class ServiceUtilisateursApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceUtilisateursApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(PersonneRepository personneRepository){

		return args -> {
				for(int i =0 ;i< 3 ; i++){
				 Personne personne=	new Personne();
				 personne.setNom("Perso"+i); personne.setEmail("Perso"+i+"@gmail.com"); personne.setCne(UUID.randomUUID().toString());

				personneRepository.save(personne);
				}
		};
	}

}
