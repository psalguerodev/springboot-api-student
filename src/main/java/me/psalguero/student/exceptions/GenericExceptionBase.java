package me.psalguero.student.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericExceptionBase extends RuntimeException {

  private String code;

  public GenericExceptionBase(String code, String message) {
    super(message);
    this.code = code;
  }
}
