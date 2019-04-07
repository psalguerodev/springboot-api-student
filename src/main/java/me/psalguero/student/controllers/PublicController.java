package me.psalguero.student.controllers;

import me.psalguero.student.configs.ConstantsConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
				value = ConstantsConfig.BASE_PATH + ConstantsConfig.PUBLIC_MAIN_PATH,
				path = ConstantsConfig.BASE_PATH + ConstantsConfig.PUBLIC_MAIN_PATH
)
public class PublicController {

	@GetMapping
	public String publicApi() {
		return "Public Api";
	}


}
