package com.codecool.reservation;

import com.codecool.reservation.domain.Reservation;
import com.codecool.reservation.dto.ReservationDTO;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class ReservationConverter {

  public List<ReservationDTO> entitiesToDTO(List<Reservation> reservations) {
    return reservations.stream()
        .map(reservation -> entityToDTO(reservation))
        .collect(toList());
  }

  public ReservationDTO entityToDTO(Reservation reservation) {
    return ReservationDTO.builder()
        .id(reservation.getId())
        .dateStart(reservation.getDateStart())
        .dateEnd(reservation.getDateEnd())
        .build();
  }

  public Reservation DTOToEntity(ReservationDTO reservationDTO) {
    Reservation reservation = new Reservation();
        reservation.setId(reservationDTO.getId());
        reservation.setDateStart(reservationDTO.getDateStart());
        reservation.setDateEnd(reservationDTO.getDateEnd());
    return reservation;
  }
}
