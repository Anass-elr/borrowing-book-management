package ma.emi.reservation.Feign;


import ma.emi.reservation.model.Personne;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name ="service-utilisateurs")
@EnableFeignClients
public interface PersonneRestClient {
    @GetMapping("api/personne/{id}")
    public ResponseEntity<Personne> personne(@PathVariable String id);

    @GetMapping("api/personne/byCne/{cne}")
    public ResponseEntity<Personne> personneByCne(@PathVariable String cne) ;

}