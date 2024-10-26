package com.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyecto.model.EditorialEntity;
import com.proyecto.service.EditorialService;

@Controller
public class EditorialController {
	@Autowired
	private EditorialService editorialService;
	
	@GetMapping("/lista_editorial")
	public String listaEditorial(Model model) {
		List<EditorialEntity> lstEditorial = editorialService.listadoEditoriales();
		model.addAttribute("lstEditorial", lstEditorial);
		return "listEditoriales";
	}
	
	@GetMapping("/registrar_editorial")
	public String vistaRegistrarEditorial(Model model) {
		model.addAttribute("editorial", new EditorialEntity());
		return "editorialRegister";
	}
	
	@PostMapping("/registrar_editorial")
	public String registrarEditorial(@ModelAttribute("editorial") EditorialEntity edito, Model model) {
		editorialService.reistrarEditorial(edito);
		return "redirect:/lista_editorial";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminarEditorial(@PathVariable("id")Integer id) {
		editorialService.eliminarEditorial(id);
		return "redirect:/lista_editorial";
	}
	
	@GetMapping("/editar_editorial/{id}")
	public String vistaModificarEditorial(@PathVariable("id") Integer id, Model model) {
		EditorialEntity encontradoEdi = editorialService.buscarEditorialPorId(id);
		model.addAttribute("editorialEn", encontradoEdi);
		return "editorialInfo";
	}
	
	@PostMapping("/editar_empleado/{id}")
	public String modificarEmpleado(@PathVariable("id")Integer id, 
			@ModelAttribute("editorialEn") EditorialEntity nuevo, Model model) {
		
		editorialService.actualizarEditorial(id, nuevo);
		return "redirect:/lista_editorial";
	}
}
