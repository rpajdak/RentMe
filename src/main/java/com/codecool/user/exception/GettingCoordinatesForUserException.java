package com.codecool.user.exception;

public class GettingCoordinatesForUserException extends RuntimeException {

  public GettingCoordinatesForUserException(String message, Exception e) {
    super(message, e);
  }
}
