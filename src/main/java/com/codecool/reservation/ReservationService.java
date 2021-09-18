package com.codecool.reservation;

import com.codecool.reservation.domain.Reservation;
import com.codecool.reservation.dto.ReservationDTO;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.*;

@Service
public class ReservationService {

  private ReservationRepository reservationRepository;

  public ReservationService(ReservationRepository reservationRepository) {
    this.reservationRepository = reservationRepository;
  }

  public List<ReservationDTO> getAllReservations() {
    return reservationRepository.findAll()
        .stream()
        .map(ReservationConverter::entityToDTO)
        .collect(toList());
  }

  public Reservation findById(Long id) {

    return reservationRepository.getReservationById(id);
  }

  public void addReservation(Reservation reservation) {

    reservationRepository.save(reservation);
  }

  public void updateReservation(Reservation reservation) {

    reservationRepository.save(reservation);
  }

  public void deleteReservationById(Long id) {

    reservationRepository.deleteById(id);
  }

  public List<ReservationDTO> getReservationsByOwnerId(Long ownerId) {
    return reservationRepository.getReservationsByOwnerId(ownerId)
        .stream()
        .map(ReservationConverter::entityToDTO)
        .collect(toList());
  }
}
