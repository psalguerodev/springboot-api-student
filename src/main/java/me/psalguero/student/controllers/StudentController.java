package me.psalguero.student.controllers;

import me.psalguero.student.beans.response.StudentResponseBean;
import me.psalguero.student.configs.ConstantsConfig;
import me.psalguero.student.exceptions.GenericException;
import me.psalguero.student.facades.StudentFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
				value = ConstantsConfig.BASE_PATH + ConstantsConfig.STUDENT_MAIN_PATH,
				path = ConstantsConfig.BASE_PATH + ConstantsConfig.STUDENT_MAIN_PATH
)
public class StudentController {

	@Autowired
	private StudentFacade studentFacade;

	@GetMapping("/{name}")
	public ResponseEntity<StudentResponseBean> getStudent(@PathVariable String name) throws GenericException {
		return studentFacade.findStudentByName(name);
	}

}
