package com.codecool.reservation;

import com.codecool.reservation.domain.Reservation;
import com.codecool.reservation.dto.ReservationDTO;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Component
public class ReservationConverter {

    public static List<ReservationDTO> entitiesToDTO(List<Reservation> reservations) {
        return reservations.stream()
                .map(reservation -> entityToDTO(reservation))
                .collect(toList());
    }

    public static ReservationDTO entityToDTO(Reservation reservation) {
        return ReservationDTO.builder()
            .id(reservation.getId())
            .ownerID(reservation.getOwner().getId())
            .itemID(reservation.getItem().getId())
            .dateStart(reservation.getDateStart())
            .dateEnd(reservation.getDateEnd())
            .build();
    }
    //TODO thing to consider- should we store entire AppUser and Item here?
//    public static Reservation DTOToEntity(ReservationDTO reservationDTO) {
//        Reservation reservation = new Reservation();
//        reservation.setId(reservationDTO.getId());
//        reservation.setItem(reservationDTO.getItem());
//        reservation.setOwner(reservationDTO.getOwner());
//        reservation.setDateStart(reservationDTO.getDateStart());
//        reservation.setDateEnd(reservationDTO.getDateEnd());
//        return reservation;
//    }
}
