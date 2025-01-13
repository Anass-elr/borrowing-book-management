package ma.emsi.servicelivre.web;


import lombok.AllArgsConstructor;
import ma.emsi.servicelivre.entities.Categorie;
import ma.emsi.servicelivre.repositories.CategorieRepository;
import ma.emsi.servicelivre.service.ICategorieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorie")

@AllArgsConstructor
public class CategorieRestController {


    private ICategorieService categorieService;


    @GetMapping
    public ResponseEntity<List<Categorie>> categories(){
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(categorieService.findAllCategories());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Categorie> categories(@PathVariable String id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(categorieService.findByCategorieId(id));
    }

    @PostMapping
    public ResponseEntity<Categorie> categories(@RequestBody Categorie categorie){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categorieService.saveCategorie(categorie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Categorie> deleteCategories(@PathVariable(name = "id") String id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(categorieService.deleteCategorie(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Categorie> categories(@PathVariable(name = "id") String id,@RequestBody Categorie categorie){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(categorieService.updateCategorie(id,categorie));
    }



}
