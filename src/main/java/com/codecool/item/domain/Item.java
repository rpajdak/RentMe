package com.codecool.item.domain;

import com.codecool.reservation.domain.Reservation;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "items")
public class Item {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "item_id")
    private String itemId;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private double price;
    @Column(name = "pic_url")
    private String picUrl;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    Collection<Reservation> reservations;

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }
}
