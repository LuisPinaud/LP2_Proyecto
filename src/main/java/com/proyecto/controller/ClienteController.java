
package com.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.model.ClienteEntity;
import com.proyecto.service.ClienteService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RequestMapping("/cliente")
@Controller
public class ClienteController {

	private final ClienteService clienteService;
	
	@GetMapping("/registrarCliente")
	public String registrarCliente(Model model) {
		model.addAttribute("cliente",new ClienteEntity());
		return "registrarCliente";
	}
	@PostMapping("/registrarCliente")
	public String registrarCliente(@ModelAttribute("cliente") ClienteEntity clienteFormulario,
			Model model, @RequestParam("foto") MultipartFile foto) {
		clienteService.crearCliente(clienteFormulario, foto);
		return "listEditoriales";
	}
	
	
	
	//post here 
	
	
}
