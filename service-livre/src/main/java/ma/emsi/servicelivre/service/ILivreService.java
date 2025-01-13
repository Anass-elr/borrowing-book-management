package ma.emsi.servicelivre.service;

import ma.emsi.servicelivre.dtos.LivreDto;
import ma.emsi.servicelivre.entities.Livre;

import java.util.List;

public interface ILivreService {

    LivreDto findLivreById(String id);

    Boolean isItAvailable(String id);

    List<LivreDto> findAllLivres();
    LivreDto saveLivre(LivreDto livreDto);

    LivreDto deleteLivreById(String id);

    LivreDto updateLivre(String id,LivreDto livreDto);

    LivreDto findLivreByLib(String lib);
}
