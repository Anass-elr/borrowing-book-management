package ma.emsi.serviceemprunt.Feign;


import ma.emsi.serviceemprunt.model.Livre;
import org.apache.http.HttpStatus;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name ="service-livre")
@EnableFeignClients
public interface LivreRestClient {

    @GetMapping("/api/livre/{id}")
    public ResponseEntity<Livre> getLivreById(@PathVariable(name = "id") String id);


    @GetMapping("/api/livre/byLib/{lib}")
    public ResponseEntity<Livre> getLivreByLib(@PathVariable(name = "lib") String lib);


    @PutMapping("/api/livre//{id}")
    public ResponseEntity<Livre> updateLivre(@PathVariable(name = "id")  String id,@RequestBody Livre livre);
}
