package com.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AutoresController {


	@GetMapping("/autores")
	public String autores() {
		return "listAutores";
	}
	
	
}
