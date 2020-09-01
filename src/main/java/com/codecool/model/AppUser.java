package com.codecool.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "users")
public class AppUser {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private String city;
    private Boolean isAdmin;

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public AppUser() {
    }

    public AppUser(String firstName, String lastName, String email, String password, String address,
                   String city, boolean isAdmin) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.city = city;
        this.isAdmin = isAdmin;
    }

    public static final class Builder {
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String address;
        private String city;
        private Boolean isAdmin;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder isAdmin(boolean isAdmin) {
            this.isAdmin = isAdmin;
            return this;
        }

        public AppUser build() {
            AppUser appUser = new AppUser();
            appUser.firstName = this.firstName;
            appUser.lastName = this.lastName;
            appUser.email = this.email;
            appUser.password = this.password;
            appUser.address = this.address;
            appUser.city = this.city;
            appUser.isAdmin = this.isAdmin;
            return appUser;
        }
    }
}
