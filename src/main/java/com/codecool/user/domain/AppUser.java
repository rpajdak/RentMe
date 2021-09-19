package com.codecool.user.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import com.codecool.item.domain.Item;

import java.util.Collection;
import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "users")
public class AppUser {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "user_id")
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
  //  @OneToMany(cascade = ALL, orphanRemoval = true)
//  @JoinColumn(name = "user_id", updatable = false, nullable = false)
  @OneToMany(
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  Collection<Item> itemList;

  public String getFullName() {
    return firstName + " " + lastName;
  }

  public void addItem(Item item) {
    itemList.add(item);
  }
}
