package ma.emsi.serviceutilisateurs.web;


import lombok.AllArgsConstructor;
import ma.emsi.serviceutilisateurs.entities.Personne;
import ma.emsi.serviceutilisateurs.service.IPersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personne")
public class PersonneRestController {

     @Autowired
     private IPersonneService personneService;

     @GetMapping("/{id}")
     public ResponseEntity<Personne> personne(@PathVariable String id){

          return ResponseEntity
                  .status(HttpStatus.OK)
                  .body(personneService.findById(id));
     }

     @GetMapping("byCne/{cne}")
     public ResponseEntity<Personne> personneByCne(@PathVariable(name = "cne") String cne){

          return ResponseEntity
                  .status(HttpStatus.OK)
                  .body(personneService.findByCne(cne));
     }

     @GetMapping
     public ResponseEntity<List<Personne>> personne(){

          return ResponseEntity
                  .status(HttpStatus.OK)
                  .body(personneService.findAll());
     }

     @PostMapping
     public ResponseEntity<Personne> personne(@RequestBody Personne personne){

          return ResponseEntity
                  .status(HttpStatus.CREATED)
                  .body(personneService.savePersonne(personne));
     }

     @PutMapping ("/{id}")
     public ResponseEntity<Personne> personne(@PathVariable String id,@RequestBody Personne personne){

          return ResponseEntity
                  .status(HttpStatus.OK)
                  .body(personneService.updatePersonne(id,personne));
     }


     @DeleteMapping("/{id}")
     public ResponseEntity<Personne> deletePersonne(@PathVariable String id){

          return ResponseEntity
                  .status(HttpStatus.FOUND)
                  .body(personneService.deletePersonne(id));
     }
}
