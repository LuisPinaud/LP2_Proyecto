package com.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class librocontroller {

    @GetMapping("/")
    public String listarProducto(Model model) {
        return "loginAdministrador";
    }
}
