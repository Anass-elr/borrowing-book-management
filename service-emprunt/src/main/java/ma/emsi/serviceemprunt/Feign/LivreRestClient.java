package ma.emsi.serviceemprunt.Feign;


import ma.emsi.serviceemprunt.model.Livre;
import org.apache.http.HttpStatus;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name ="service-livre")
@EnableFeignClients
public interface LivreRestClient {

    @GetMapping("/api/livre/{id}")
    public ResponseEntity<Livre> getLivreById(@PathVariable(name = "id") String id);


    @GetMapping("/api/livre/byLib/{lib}")
    public ResponseEntity<Livre> getLivreByLib(@PathVariable(name = "lib") String lib);

}
