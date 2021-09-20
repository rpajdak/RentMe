package com.codecool.reservation.domain;

import lombok.Getter;
import lombok.Setter;

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
    @Column(name = "date_start")
    private LocalDate dateStart;
    @Column(name = "date_end")
    private LocalDate dateEnd;

    public Reservation() {
    }


}
