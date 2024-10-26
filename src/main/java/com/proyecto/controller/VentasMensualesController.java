package com.proyecto.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.model.ReporteMensual;
import com.proyecto.service.ReporteMensualService;

import lombok.AllArgsConstructor;


@Controller
@AllArgsConstructor
public class VentasMensualesController {
    
    private final ReporteMensualService reporteMensualService;

    @GetMapping("/ventasMensuales")
    public String getReporteMensual(Model model,@RequestParam int mes,@RequestParam int anio) {

        List<ReporteMensual> reporteMensual = reporteMensualService.buscarReporteMensual(mes, anio);
        model.addAttribute("dataVentasMensuales",reporteMensual);

        return "ventasMensuales";
    }
    
}
