package ma.emi.reservation.Feign;


import ma.emi.reservation.model.EmpruntRequest;
import ma.emi.reservation.model.EmprunteDtoResponse;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="service-emprunt")
@EnableFeignClients
public interface EmpruntRestClient {
    @PostMapping("/api/emprunte")
    public EmprunteDtoResponse saveEmprunte(@RequestBody EmpruntRequest emprunteDto);

    @GetMapping("/api/emprunte/byDateRetourLivre/{idLivre}")
    public EmprunteDtoResponse getDateRetourLivre(@PathVariable String idLivre);
}
