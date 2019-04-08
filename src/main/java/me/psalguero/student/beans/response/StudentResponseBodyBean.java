package me.psalguero.student.beans.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.psalguero.student.beans.request.AbstractBodyBean;
import me.psalguero.student.entities.Student;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseBodyBean extends AbstractBodyBean implements Serializable {

  private static final long serialVersionUID = 4195026754723173908L;

  @JsonProperty("student")
  private Student student;
}
