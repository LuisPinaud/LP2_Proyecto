package com.proyecto.controller;
import com.proyecto.model.AutorEntity;
import com.proyecto.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/autor")
public class AutorController {
	@Autowired
    private AutorService autorService;

    @GetMapping("/listar")
    public String listarAutores(Model model) {
        List<AutorEntity> autores = autorService.listadoAutores();
        model.addAttribute("autores", autores);
        return "listAutores";
    }

    @GetMapping("/registrar")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("autor", new AutorEntity());
        return "autoresRegister";
    }

    @PostMapping("/registrar")
    public String registrarAutor(@ModelAttribute AutorEntity autor) {
        autorService.registrarAutor(autor);
        return "redirect:/autor/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") Integer id, Model model) { 
        AutorEntity autor = autorService.buscarAutorPorId(id);
        model.addAttribute("autor", autor);
        return "autorInfo";
    }

    @PostMapping("/editar/{id}")
    public String actualizarAutor(@PathVariable("id") Integer id, @ModelAttribute AutorEntity autor) {
        autorService.actualizarAutor(id, autor); 
        return "redirect:/autor/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarAutor(@PathVariable("id") Integer id) { 
        autorService.eliminarAutor(id);
        return "redirect:/autor/listar";
    }
}
