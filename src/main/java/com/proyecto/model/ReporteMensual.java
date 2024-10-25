package com.proyecto.model;

public class ReporteMensual {
    private int mes;
    private int anio;
    private Long cantidadVentas;
    private  Double totalVentas;

    
    public int getMes() {
        return mes;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }
    public int getAnio() {
        return anio;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }
    public Long getCantidadVentas() {
        return cantidadVentas;
    }
    public void setCantidadVentas(Long cantidadVentas) {
        this.cantidadVentas = cantidadVentas;
    }
    public Double getTotalVentas() {
        return totalVentas;
    }
    public void setTotalVentas(Double totalVentas) {
        this.totalVentas = totalVentas;
    }
    
    public ReporteMensual(int mes, int anio, Long cantidadVentas, Double totalVentas) {
        this.mes = mes;
        this.anio = anio;
        this.cantidadVentas = cantidadVentas;
        this.totalVentas = totalVentas;
    }
    public ReporteMensual() {
    }
    @Override
    public String toString() {
        return "ReporteMensual [mes=" + mes + ", anio=" + anio + ", cantidadVentas=" + cantidadVentas + ", totalVentas="
                + totalVentas + "]";
    }


}
