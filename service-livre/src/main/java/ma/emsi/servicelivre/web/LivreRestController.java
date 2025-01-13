package ma.emsi.servicelivre.web;


import lombok.AllArgsConstructor;
import ma.emsi.servicelivre.dtos.LivreDto;
import ma.emsi.servicelivre.service.ILivreService;
import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livre")
@AllArgsConstructor

public class LivreRestController {


    private ILivreService livreService;


    @GetMapping("/{id}")
    public ResponseEntity<LivreDto> getLivreById(@PathVariable(name = "id") String id){
        return ResponseEntity
                .status(HttpStatus.SC_OK)
                .body(livreService.findLivreById(id));
    }

    @GetMapping("/byLib/{lib}")
    public ResponseEntity<LivreDto> getLivreByLib(@PathVariable(name = "lib") String lib){
        return ResponseEntity
                .status(HttpStatus.SC_OK)
                .body(livreService.findLivreByLib(lib));
    }

    @GetMapping
    public ResponseEntity<List<LivreDto>> getLivres(){
        return ResponseEntity
                .status(HttpStatus.SC_OK)
                .body(livreService.findAllLivres());
    }
    
    @PostMapping
    public ResponseEntity<LivreDto> postLivre(@RequestBody LivreDto livreDto){
        return ResponseEntity
                .status(HttpStatus.SC_CREATED)
                .body(livreService.saveLivre(livreDto));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<LivreDto> deleteLivre(@PathVariable(name = "id")  String id){
        return ResponseEntity
                .status(HttpStatus.SC_OK)
                .body(livreService.deleteLivreById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivreDto> updateLivre(@PathVariable(name = "id")  String id,@RequestBody LivreDto livreDto){
        return ResponseEntity
                .status(HttpStatus.SC_OK)
                .body(livreService.updateLivre(id,livreDto));
    }


    @GetMapping("availableStoque/{id}")
    public ResponseEntity<Boolean> LivreAvailabe(@PathVariable(name = "id")  String id){
        return ResponseEntity
                .status(HttpStatus.SC_OK)
                .body(livreService.isItAvailable(id));
    }




}
