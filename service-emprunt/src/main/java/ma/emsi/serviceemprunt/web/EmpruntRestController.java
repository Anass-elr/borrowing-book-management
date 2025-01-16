package ma.emsi.serviceemprunt.web;


import ma.emsi.serviceemprunt.dtos.EmpruntDtoRequest;
import ma.emsi.serviceemprunt.dtos.EmprunteDtoResponse;
import ma.emsi.serviceemprunt.entities.Emprunte;
import ma.emsi.serviceemprunt.service.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/emprunte")
public class EmpruntRestController {

    @Autowired
    EmpruntService empruntService;

    @PostMapping
    public EmprunteDtoResponse saveEmprunte(@RequestBody EmpruntDtoRequest emprunteDto){
       return empruntService.saveEmprunt(emprunteDto);
    }

    @GetMapping
    public List<EmprunteDtoResponse> getEmpruntes(){
       return empruntService.getEmprunts();
    }


    @GetMapping("{id}")
    public Emprunte getEmprunteById(@PathVariable String id){
        return  empruntService.getById(id);
    }




    @GetMapping("/byUser/{id}")
    public List<EmprunteDtoResponse> getEmprunteByUserId(@PathVariable String id){
        return  empruntService.getEmpruntesByPersonne(id);
    }

    @GetMapping("/byDateRetourLivre/{idLivre}")
    public EmprunteDtoResponse getDateRetourLivre(@PathVariable String idLivre){
        return  empruntService.getEmpruntByDateRtourLivre(idLivre);
    }


    @PutMapping("/retouneLivre/{id}")

    public EmprunteDtoResponse retourneLivre(@PathVariable String id ){
        return  empruntService.saveEmpruntRetourne(id);
    }

}
