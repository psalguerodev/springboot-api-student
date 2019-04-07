package me.psalguero.student.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("requestTimeInterceptopr")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {

  private final Logger logger = LoggerFactory.getLogger(RequestTimeInterceptor.class);

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    request.setAttribute("startTime", System.currentTimeMillis());
    return true;
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                              Object handler, Exception ex) throws Exception {
    long starTime = (long) request.getAttribute("startTime");
    long timeRequest = System.currentTimeMillis() - starTime;
    logger.warn("Request Url {} >> Request Time {} ms.", request.getServletPath(), timeRequest);
    super.afterCompletion(request, response, handler, ex);
  }
}
