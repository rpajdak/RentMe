package com.codecool.reservation;

import com.codecool.item.ItemService;
import com.codecool.item.domain.Item;
import com.codecool.reservation.domain.Reservation;
import com.codecool.reservation.dto.AddReservationRequestWrapper;
import com.codecool.reservation.dto.ReservationDTO;
import com.codecool.user.UserService;
import com.codecool.user.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import java.util.List;
import static java.util.stream.Collectors.toList;

@AllArgsConstructor
public class ReservationService {

  private ReservationRepository reservationRepository;
  private ReservationConverter reservationConverter;
  private ItemService itemService;
  private UserService userService;

  public List<ReservationDTO> getAllReservations() {
    return reservationRepository.findAll()
        .stream()
        .map(reservationConverter::entityToDTO)
        .collect(toList());
  }

  public Reservation findById(Long id) {
    return reservationRepository.getReservationById(id);
  }

  public void addReservation(AddReservationRequestWrapper addReservationRequestWrapper, Authentication authentication) {

    final Reservation reservation = reservationConverter.DTOToEntity(addReservationRequestWrapper.getReservationDTO());

    Item reservedItem = itemService.getItemById(addReservationRequestWrapper.getItemId());
    reservedItem.addReservation(reservation);

    User reservationHolder = userService.getUserByEmail(authentication.getName());
    reservationHolder.addReservation(reservation);

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
        .map(reservationConverter::entityToDTO)
        .collect(toList());
  }
}
