package com.eventosapp.eventosapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class teste {
	
	@RequestMapping("/teste")
	public String meuteste() {
		return "teste";
	}
}
