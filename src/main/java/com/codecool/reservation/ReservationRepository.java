package com.codecool.reservation;

import com.codecool.reservation.domain.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;


public interface ReservationRepository extends Repository<Reservation, Long> {

  Reservation getReservationById(Long id);

  @Query("select r from Reservation r left join r.owner o where r.owner.id = :id")
  List<Reservation> getReservationsByOwnerId(Long id);

  List<Reservation> findAll();

  Reservation save(Reservation reservation);

  void deleteById(Long id);
}
