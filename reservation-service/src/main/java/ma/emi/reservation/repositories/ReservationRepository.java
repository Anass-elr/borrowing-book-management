package ma.emi.reservation.repositories;

import ma.emi.reservation.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,String> {

    List<Reservation> findReservationByDateDisponibilitePossible(LocalDate date);
    List<Reservation> findReservationByIdPersonne(String idPersonne);


}
