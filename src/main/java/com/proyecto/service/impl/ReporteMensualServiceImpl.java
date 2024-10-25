package com.proyecto.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.model.ReporteMensual;
import com.proyecto.repository.ReporteMensualRepository;
import com.proyecto.service.ReporteMensualService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReporteMensualServiceImpl implements  ReporteMensualService {
    
    private final ReporteMensualRepository reporteMensualRepository;

    @Override
    public List<ReporteMensual> buscarReporteMensual(int mes, int anio) {
        // TODO Auto-generated method stub
        return reporteMensualRepository.findVentasMensuales(mes,anio);
    }

    
}
