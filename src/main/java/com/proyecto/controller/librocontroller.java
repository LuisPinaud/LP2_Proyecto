package com.proyecto.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.model.AutorEntity;
import com.proyecto.model.LibroCategoriaEntity;
import com.proyecto.model.LibroEntity;
import com.proyecto.service.AutorService;
import com.proyecto.service.LibroCategoriaService;
import com.proyecto.service.LibroService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class LibroController {
	
    private final LibroService libroService;
    private final AutorService autorService;
    private final LibroCategoriaService libroCategoriaService;

    @GetMapping("/libros")
    public String libros(Model model, HttpSession sesion) {
        List<LibroEntity> listaLibros = libroService.listadoLibros();
        model.addAttribute("libros", listaLibros);
        return "pagLibros"; 
    }
    
    @PostMapping("/agregarLibros")
    public String registrarLibro(@ModelAttribute("libro") LibroEntity libroEntity, 
    		Model model, @RequestParam("foto") MultipartFile imagen) {
    	List<AutorEntity> listarAutores = autorService.listadoAutores();
    	List<LibroCategoriaEntity> listarCategoriaLibros = libroCategoriaService.listarTodosCategoriaLibro();
    	model.addAttribute("autores", listarAutores);
    	model.addAttribute("categoriaLibros", listarCategoriaLibros);
    	model.addAttribute("libro", new LibroEntity());
    	libroService.registrarLibro(libroEntity, imagen);
    	return "redirect:/admin/pagLibros";
    }
    
}
