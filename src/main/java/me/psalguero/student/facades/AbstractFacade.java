package me.psalguero.student.facades;

import me.psalguero.student.beans.response.GenericResponseHeaderBean;
import me.psalguero.student.beans.response.ResultBean;
import org.springframework.beans.factory.InitializingBean;

import java.time.LocalDateTime;

public abstract class AbstractFacade implements InitializingBean {

  @Override
  public void afterPropertiesSet() throws Exception {

  }

  protected GenericResponseHeaderBean getResultHeader(String code, String message) {
    GenericResponseHeaderBean genericResponseHeaderBean = new GenericResponseHeaderBean();
    genericResponseHeaderBean.setResult(new ResultBean());
    genericResponseHeaderBean.getResult().setCode(code);
    genericResponseHeaderBean.getResult().setMessage(message);
    genericResponseHeaderBean.getResult().setDateTime(LocalDateTime.now().toString());
    return genericResponseHeaderBean;
  }
}
