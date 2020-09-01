package com.codecool.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name="reservations")
public class Reservation {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name= "id")
    private Long id;
    @Column(name= "item_id")
    private Long itemId;
    @Column(name= "renter_id")
    private Long appUserId;
    @CreationTimestamp
    private Date rentingStartDate;
    @CreationTimestamp
    private Date rentingEndDate;

    public Reservation() {
    }


}
