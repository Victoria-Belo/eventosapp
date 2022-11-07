package com.eventosapp.eventosapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	
	@RequestMapping(value="/ ", method = { RequestMethod.GET, RequestMethod.POST })
	public String index() {
<<<<<<< HEAD
		return "index";
=======
		return "src/main/resources/templates/index";
>>>>>>> acf81d209420b7b96300f3b06547106dbf2780c6
	}
}
