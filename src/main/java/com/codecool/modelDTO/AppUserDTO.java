package com.codecool.modelDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AppUserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String postCode;
    private Double lat;
    private Double lng;

}
