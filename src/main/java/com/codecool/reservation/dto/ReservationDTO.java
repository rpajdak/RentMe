package com.codecool.reservation.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class ReservationDTO {

  private Long id;
  private Long itemID;
  private Long ownerID;
  private LocalDate dateStart;
  private LocalDate dateEnd;
}
