package com.codecool.reservation.dto;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class AddReservationRequestWrapper {
        Long itemId;
        ReservationDTO reservationDTO;
}
