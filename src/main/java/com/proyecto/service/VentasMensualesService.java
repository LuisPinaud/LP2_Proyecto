package com.proyecto.service;

import java.util.List;

import com.proyecto.model.ReporteMensual;

public interface VentasMensualesService {
    List<ReporteMensual> obtenerReporteMensual(int mes,int anio);
}