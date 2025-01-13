package ma.emsi.serviceemprunt;

import ma.emsi.serviceemprunt.config.RsaKeysConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients(basePackages = "ma.emsi.*")
@EnableConfigurationProperties(RsaKeysConfig.class)

public class ServiceEmpruntApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceEmpruntApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(){
		return args -> {

		};
	}


}
