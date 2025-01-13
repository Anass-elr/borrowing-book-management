package ma.emi.reservation.Feign;


import ma.emi.reservation.model.Livre;
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


    @GetMapping("/api/livre/availableStoque/{id}")
    public ResponseEntity<Boolean> LivreAvailabe(@PathVariable(name = "id") String id);


    @PutMapping("/api/livre/{id}")
    public ResponseEntity<Livre> updateLivre(@PathVariable(name = "id") String id, @RequestBody Livre livreDto);

}