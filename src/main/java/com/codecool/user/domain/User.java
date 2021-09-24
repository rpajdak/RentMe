package com.codecool.user.domain;

import com.codecool.reservation.domain.Reservation;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Collection;
import javax.persistence.*;

import com.codecool.item.domain.Item;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "users")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "is_admin")
    private Boolean isAdmin;
    @Column(name = "post_code")
    private String postCode;
    @Column(name = "lat")
    private Double lat;
    @Column(name = "lng")
    private Double lng;
    @Column(name = "enabled")
    private int enabled;
    @Column(name = "role")
    private String role;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    Collection<Item> items;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    Collection<Reservation> reservations;

    public void addItem(Item item) {
        items.add(item);
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }
}
