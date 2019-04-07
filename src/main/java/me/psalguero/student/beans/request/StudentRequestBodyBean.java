package me.psalguero.student.beans.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentRequestBodyBean extends AbstractBodyBean {

  private static final long serialVersionUID = 1987947709960799847L;

  // TODO pending for POST Method
}
