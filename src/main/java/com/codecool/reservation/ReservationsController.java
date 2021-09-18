package com.codecool.reservation;

import com.codecool.converter.ReservationConverter;
import com.codecool.reservation.dto.ReservationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.status;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/reservations")
public class ReservationsController {

  private ReservationService reservationService;

  public ReservationsController(ReservationService reservationService) {
    this.reservationService = reservationService;
  }

  @GetMapping(value = "/", produces = APPLICATION_JSON_VALUE)
  @ResponseStatus(OK)
  public List<ReservationDTO> getAllReservations() {
    return reservationService.getAllReservations();
  }

  @GetMapping(params = "ownerId", produces = APPLICATION_JSON_VALUE)
  @ResponseBody
  @ResponseStatus(OK)
  public List<ReservationDTO> getReservationsByOwner(
      @RequestParam(value = "ownerId") Long ownerId) {
    return reservationService.getReservationsByOwnerId(ownerId);
  }

  @PostMapping()
  @ResponseBody
  @ResponseStatus(CREATED)
  public ResponseEntity<Object> attemptToAddReservation(
      @RequestBody ReservationDTO reservationDTO) {
    reservationService.addReservation(ReservationConverter.DTOToEntity(reservationDTO));
    return status(CREATED).body("Account has been created.");
  }

}
