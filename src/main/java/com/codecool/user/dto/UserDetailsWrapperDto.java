package com.codecool.user.dto;

import lombok.Builder;
import lombok.Data;

import com.codecool.user.UserDetailsAddressDTO;

@Data
@Builder
public class UserDetailsWrapperDto {

  private UserNameDTO userName;
  private UserDetailsAddressDTO userDetailsAddress;
}
