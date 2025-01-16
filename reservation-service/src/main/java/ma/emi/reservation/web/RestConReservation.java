package ma.emi.reservation.web;

import ma.emi.reservation.dtos.ReservationRequest;
import ma.emi.reservation.dtos.ReservationResponse;
import ma.emi.reservation.entities.Reservation;
import ma.emi.reservation.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class RestConReservation {

    ReservationService reservationService ;

    public RestConReservation(ReservationService reservationService) {
        this.reservationService = reservationService;
    }


    @PostMapping
    public Reservation saveReservation(@RequestBody ReservationRequest reservationRequest){

        return reservationService.saveReservation(reservationRequest);
    }


    @GetMapping("/{id}")
    public List<Reservation> getByIdPerso(@PathVariable String id){

        return reservationService.getReservationByIdPersonne(id);
    }


}
