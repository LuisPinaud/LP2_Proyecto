package com.proyecto.service;

import java.util.List;
import com.proyecto.model.ReporteMensual;

public interface ReporteMensualService {
    List<ReporteMensual> buscarReporteMensual(int mes, int anio);
}
