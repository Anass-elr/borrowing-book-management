package ma.emsi.servicelivre.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity */
public class SecConfig {
/*
    private RsaKeysConfig rsaKeysConfig;

    public SecConfig(RsaKeysConfig rsaKeysConfig) {
        this.rsaKeysConfig = rsaKeysConfig;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(aut->aut.requestMatchers("/token/**","/service-livre/api/**").permitAll()
                        .anyRequest().authenticated())
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)  // Updated method
                .build();
    }



    @Bean
    public JwtDecoder jwtDecoder(){
        return NimbusJwtDecoder.withPublicKey(rsaKeysConfig.publickey()).build();
    }

 */

}
