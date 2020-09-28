package com.codecool.modelDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AppUserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String city;
    private String postCode;
    private Double lat;
    private Double lng;

    public static final class Builder {
        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private String address;
        private String city;
        private Boolean isAdmin;
        private String postCode;
        private Double lat;
        private Double lng;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

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

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder postCode(String postCode) {
            this.postCode = postCode;
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

        public Builder lat(Double lat) {
            this.lat = lat;
            return this;
        }

        public Builder lng(Double lng) {
            this.lng = lng;
            return this;
        }

        public AppUserDTO build() {
            AppUserDTO appUserDTO = new AppUserDTO();
            appUserDTO.id = this.id;
            appUserDTO.firstName = this.firstName;
            appUserDTO.lastName = this.lastName;
            appUserDTO.address = this.address;
            appUserDTO.postCode = this.postCode;
            appUserDTO.city = this.city;
            appUserDTO.lat = this.lat;
            appUserDTO.lng = this.lng;
            return appUserDTO;
        }
    }
}
