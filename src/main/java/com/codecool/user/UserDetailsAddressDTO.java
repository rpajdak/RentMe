package com.codecool.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDetailsAddressDTO {

  private String city;
  private String address;
  private String lat;
  private String lng;
}
