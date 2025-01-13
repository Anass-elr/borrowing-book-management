package ma.emsi.securityservice;

import ma.emsi.securityservice.config.RsaKeysConfig;
import ma.emsi.securityservice.config.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeysConfig.class)
public class SecurityServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityServiceApplication.class, args);
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /*
    @Bean
    CommandLineRunner commandLineRunner(JdbcUserDetailsManager jdbcUserDetailsManager){
        PasswordEncoder passwordEncoder = passwordEncoder();
        return args -> {
            jdbcUserDetailsManager.createUser(
                    User.withUsername("user1")
                            .password(passwordEncoder.encode("1234"))
                            .roles("USER").build());

            jdbcUserDetailsManager.createUser(
                    User.withUsername("user2")
                            .password(passwordEncoder.encode("1234"))
                            .roles("USER").build());

            jdbcUserDetailsManager.createUser(
                    User.withUsername("admin")
                            .password(passwordEncoder.encode("1234"))
                            .roles("USER","ADMIN").build());
        };

    } */


    @Bean
    CommandLineRunner commandLineRunnerUserDetails(AccountService accountService){
        return args -> {
           accountService.addNewRole("USER");
           accountService.addNewRole("ADMIN");

           accountService.addNewUser("user1","1234","user1@gmil.com","1234");
           accountService.addNewUser("user2","1234","user2@gmil.com","1234");
           accountService.addNewUser("admin","1234","admin@gmil.com","1234");

           accountService.addRoleToUser("user1","USER");
           accountService.addRoleToUser("user2","USER");
           accountService.addRoleToUser("admin","ADMIN");

        };

    }
}
