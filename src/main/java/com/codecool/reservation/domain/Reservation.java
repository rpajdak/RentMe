package com.codecool.reservation.domain;

import lombok.Getter;
import lombok.Setter;

import com.codecool.item.domain.Item;
import com.codecool.user.domain.AppUser;

import java.time.LocalDate;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "reservations")
public class Reservation {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "id")
  private Long id;
  @OneToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "item_id")
  private Item item;
  @OneToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "renter_id")
  private AppUser owner;
  @Column(name = "date_start")
  private LocalDate dateStart;
  @Column(name = "date_end")
  private LocalDate dateEnd;

  public Reservation() {
  }


}
