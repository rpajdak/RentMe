package com.codecool.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name="reservations")
public class Reservation {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private Long itemId;
    private Long appUserId;
    private Date rentingStartDate;
    private Date rentingEndDate;

    public Reservation() {
    }


}
