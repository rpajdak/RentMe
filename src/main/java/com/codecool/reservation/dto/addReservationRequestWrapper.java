package com.codecool.reservation.dto;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class addReservationRequestWrapper {
    Long itemId;
    ReservationDTO reservationDTO;
}
