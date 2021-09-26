package com.codecool.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserNameDTO {

  private String firstName;
  private String lastName;
}
