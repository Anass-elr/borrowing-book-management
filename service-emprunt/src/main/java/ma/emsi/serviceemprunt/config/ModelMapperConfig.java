package ma.emsi.serviceemprunt.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
       /* modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT) // Use STRICT matching strategy
                .setFieldMatchingEnabled(true) // Enables field matching
                .setSkipNullEnabled(true); // Skip mapping null fields */
        return modelMapper;
    }

}
