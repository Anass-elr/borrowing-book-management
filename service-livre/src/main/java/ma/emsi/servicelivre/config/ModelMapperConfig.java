package ma.emsi.servicelivre.config;


import ma.emsi.servicelivre.dtos.LivreDto;
import ma.emsi.servicelivre.entities.Categorie;
import ma.emsi.servicelivre.entities.Livre;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Custom Converter to map categories to categoryIds
        Converter<List<Categorie>, List<String>> categoryConverter = context ->
                context.getSource().stream()
                        .map(Categorie::getId)  // Extract the 'id' from each Categorie
                        .collect(Collectors.toList());  // Collect them into a list of Strings

        // Configuring the mapping between Livre and LivreDto
        modelMapper.addMappings(new PropertyMap<Livre, LivreDto>() {
            @Override
            protected void configure() {
                using(categoryConverter).map(source.getCategories(), destination.getCategoryIds());
            }
        });

        return modelMapper;
    }
}