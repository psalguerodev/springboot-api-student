package me.psalguero.student.beans.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.psalguero.student.beans.AbstractMessageBean;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@NoArgsConstructor
@Setter
public class StudentResponseBean extends AbstractMessageBean<GenericResponseHeaderBean, StudentResponseBodyBean> {

  private static final long serialVersionUID = 4195026754723173908L;

  public StudentResponseBean(GenericResponseHeaderBean headerBean) {
    super(headerBean);
  }

}
