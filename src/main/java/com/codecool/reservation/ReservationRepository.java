package com.codecool.reservation;

import com.codecool.reservation.domain.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ReservationRepository extends Repository<Reservation, Long> {

    Reservation getReservationById(Long id);

    @Query(value = "select * from reservations r" +
            " left join users_reservations ur on r.id = ur.reservations_id" +
            " left join users u on ur.user_id = u.id" +
            " where u.id = :id", nativeQuery = true)
    List<Reservation> getReservationsByOwnerId(Long id);

    List<Reservation> findAll();

    Reservation save(Reservation reservation);

    void deleteById(Long id);
}
