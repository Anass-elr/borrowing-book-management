package ma.emsi.servicelivre.service;


import lombok.AllArgsConstructor;
import ma.emsi.servicelivre.dtos.LivreDto;
import ma.emsi.servicelivre.entities.Categorie;
import ma.emsi.servicelivre.entities.Livre;
import ma.emsi.servicelivre.repositories.CategorieRepository;
import ma.emsi.servicelivre.repositories.LivreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional

public class LivreService implements ILivreService{

    private LivreRepository     livreRepository;
    private CategorieRepository categorieRepository;
    private final ModelMapper modelMapper;


    @Override
    public LivreDto findLivreById(String id) {
        return modelMapper.map(livreRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("BOOK NOT FOUND EXCEPTION")),LivreDto.class );
    }

    @Override
    public LivreDto findLivreByLib(String lib) {
        return modelMapper.map(livreRepository.findLivreByLibLivre(lib),LivreDto.class );
    }

    @Override
    public Boolean isItAvailable(String id){
        Livre livre =livreRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("BOOK NOT FOUND EXCEPTION"));

        if(livre.getNbEnStoque()!=0) return true;
        return false;
    }


    @Override
    public List<LivreDto> findAllLivres() {
        return livreRepository.findAll().stream()
                .map(livre -> modelMapper.map(livre,LivreDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public LivreDto saveLivre(LivreDto livreDto) {

        if(livreDto == null) throw new RuntimeException("INPUT IS EMPTY");

        List<Categorie> categories = new ArrayList<>();

        Livre livre = Livre.builder().prixLivre(livreDto.getPrixLivre()).nbEnStoque(livreDto.getNbEnStoque())
                .libLivre(livreDto.getLibLivre()).build();

        livreDto.getCategoryIds().forEach(cat->{
            Categorie  categorie  = categorieRepository.findById(cat)
                    .orElseThrow(()-> new RuntimeException("CAT NULL"));
            categories.add(categorie);
        });

        livre.setCategories(categories);
        Livre livre1=  livreRepository.save(livre);

        return  modelMapper.map(livre1, LivreDto.class);
    }

    @Override
    public LivreDto deleteLivreById(String id) {
        if(id == null) throw new RuntimeException("");

        LivreDto livreDto = findLivreById(id);
        livreRepository.deleteById(id);
        return livreDto;

    }

    @Override
    public LivreDto updateLivre(String id, LivreDto livreDto) {
        if (livreDto == null || id == null) throw new RuntimeException("INPUT IS EMPTY");

        List<Categorie> categories = new ArrayList<>();

        livreDto.getCategoryIds().forEach(cat ->
                categories.add(categorieRepository
                        .findById(cat)
                        .orElse(null)));
        Livre livre = modelMapper.map(livreDto,Livre.class);
        livre.setCategories(categories);
        livre.setId(id);
        livreRepository.save(livre);

        return livreDto;
    }





}
