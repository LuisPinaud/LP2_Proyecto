package com.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.model.AdministradorEntity;
import com.proyecto.service.AdminService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
	
	private final AdminService adminService;
	
	
	@GetMapping("/login")
	public String loginAdmin() {
		return "loginAdministrador";
	}
	@PostMapping("/login")
	public String logeoAdmin() {
		return "";
	}

	@GetMapping("/registrarAdmin")
	public String registrarAdmin(Model model) {
		model.addAttribute("admin", new AdministradorEntity());
		return("registrarAdmin");
	}
	@PostMapping("/registrarAdmin")
	public String registroAdmin(@ModelAttribute("admin")AdministradorEntity adminFormulario,
			Model model, @RequestParam("fotoAdmin") MultipartFile foto) {
		adminService.crearAdmin(adminFormulario, foto);
		return "registrarAdmin";
	}
}
