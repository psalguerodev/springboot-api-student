package me.psalguero.student.exceptions.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomExceptionBean {

  private int code;
  private String message;
  private LocalDateTime timestamp;
  private String path;
  private String error;

}
