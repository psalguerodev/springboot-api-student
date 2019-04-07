package me.psalguero.student.beans.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@NoArgsConstructor
@Setter
public class GenericResponseHeaderBean extends AbstractHeaderBean {

  private static final long serialVersionUID = -3055205685954574699L;

  @JsonProperty("result")
  private ResultBean result;

}
