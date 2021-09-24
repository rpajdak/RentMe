package com.codecool.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String city;
    private String postCode;
    private Double lat;
    private Double lng;
    private String role;
    private String password;
    private Boolean isAdmin;
    private int enabled;
}
