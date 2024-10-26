package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	//Log admins;
	@GetMapping("/login")
	public String loginAdmin(Model model) {
		model.addAttribute("admin",new AdministradorEntity());
		return "loginAdministrador";
	}
	@PostMapping("/login")
	public String logeoAdmin(@ModelAttribute("admin") AdministradorEntity adminFormulario,
	                         Model model, HttpSession sesion) {
	    boolean validarAdmin = adminService.validarAdmin(adminFormulario);
	    if (validarAdmin) {
	        sesion.setAttribute("admin", adminFormulario.getEmail());
	        System.out.println("Ingresó el usuairo: " + adminFormulario.getNombreAdmin());
	        return "redirect:/lb/index";
	    }
	    model.addAttribute("Invalido", "Credenciales erróneas"); 
	    model.addAttribute("admin", new AdministradorEntity());
	    return "loginAdministrador"; 
	}

	//Register
	@GetMapping("/registrarAdmin")
	public String registrarAdmin(Model model) {
		model.addAttribute("admin", new AdministradorEntity());
		return("registrarAdmin");
	}
	@PostMapping("/registrarAdmin")
	public String registroAdmin(@ModelAttribute("admin")AdministradorEntity adminFormulario,
			Model model, @RequestParam("fotoAdmin") MultipartFile foto) {
		adminService.crearAdmin(adminFormulario, foto);
		
		return "loginAdministrador";
	}
	//List of Admins;
	
	
}
