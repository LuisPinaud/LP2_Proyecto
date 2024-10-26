package com.proyecto.controller;
import com.proyecto.model.CategoriaEntity;
import com.proyecto.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	@Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listar")
    public String listarCategorias(Model model) {
        List<CategoriaEntity> categorias = categoriaService.listadoCategorias();
        model.addAttribute("categorias", categorias);
        return "listCategorias"; 
    }

    

    @PostMapping("/registrar")
    public String registrarCategoria(@ModelAttribute CategoriaEntity categoria) {
        categoriaService.registrarCategoria(categoria);
        return "redirect:/admin/libros";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") Integer id, Model model) {
        CategoriaEntity categoria = categoriaService.buscarCategoriaPorId(id);
        model.addAttribute("categoria", categoria);
        return "categoriaInfo";  
    }

    @PostMapping("/editar/{id}")
    public String actualizarCategoria(@PathVariable("id") Integer id, @ModelAttribute CategoriaEntity categoria) {
        categoriaService.actualizarCategoria(id, categoria);
        return "redirect:/categoria/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCategoria(@PathVariable("id") Integer id) {
        categoriaService.eliminarCategoria(id);
        return "redirect:/categoria/listar";
    }
}
