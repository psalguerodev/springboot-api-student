package me.psalguero.student.facades;

import me.psalguero.student.beans.response.StudentResponseBean;
import me.psalguero.student.beans.response.StudentResponseBodyBean;
import me.psalguero.student.entities.Student;
import me.psalguero.student.services.StudentService;
import me.psalguero.student.utils.FormatUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class StudentFacade extends AbstractFacade {

  private final Logger logger = LoggerFactory.getLogger(StudentFacade.class);

  @Autowired
  private StudentService studentService;

  public ResponseEntity<StudentResponseBean> findStudentByName(String name) {
    logger.warn(String.format("BEGINNING FOR [findStudentByName] - Request %n%s", FormatUtil.fromObjectToJson(name)));

    StudentResponseBean studentResponseBean = new StudentResponseBean();

    Student student = studentService.findByName(name);


    if (Objects.isNull(student)) {
      studentResponseBean.setHeader(getResultHeader("0001", "Not found student"));
      logger.warn(String.format("ENDING FOR [findStudentByName] - Request %n%s", FormatUtil.fromObjectToJson(name)));
      return new ResponseEntity<>(studentResponseBean, HttpStatus.NOT_FOUND);
    }

    studentResponseBean.setBody(new StudentResponseBodyBean());
    studentResponseBean.getBody().setStudent(student);
    studentResponseBean.setHeader(getResultHeader("0000", "Success find"));

    ResponseEntity<StudentResponseBean> studentResponseBeanResponseEntity = new ResponseEntity<>(studentResponseBean, HttpStatus.OK);
    logger.warn(String.format("ENDING FOR [findStudentByName] - Request %n%s", FormatUtil.fromObjectToJson(studentResponseBean)));

    return studentResponseBeanResponseEntity;
  }


}
