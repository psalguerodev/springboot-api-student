package me.psalguero.student.controllers;

import me.psalguero.student.configs.ConstantsConfig;
import me.psalguero.student.exceptions.GenericException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
				value = ConstantsConfig.BASE_PATH + ConstantsConfig.STUDENT_MAIN_PATH,
				path = ConstantsConfig.BASE_PATH + ConstantsConfig.STUDENT_MAIN_PATH
)
public class StudentController {

	@GetMapping
	public String getStudent() throws GenericException {
		return "Student - Santa Cruz";
	}
}
