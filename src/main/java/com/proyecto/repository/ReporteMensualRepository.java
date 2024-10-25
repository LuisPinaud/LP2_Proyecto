package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proyecto.model.PedidoEntity;
import com.proyecto.model.ReporteMensual;

@Repository
public interface ReporteMensualRepository extends JpaRepository<PedidoEntity,Integer>{
    @Query("SELECT new com.tu.paquete.ReporteMensual(p.fechapedido.month, p.fechapedido.year, COUNT(dp), SUM(dp.precio * dp.cantidad)) " +
           "FROM PedidoEntity p JOIN p.detallesPedidos dp " +
           "WHERE FUNCTION('YEAR', p.fechapedido) = :anio AND FUNCTION('MONTH', p.fechapedido) = :mes " +
           "GROUP BY p.fechapedido.month, p.fechapedido.year")
    List<ReporteMensual> findVentasMensuales(@Param("mes") int mes, @Param("anio") int anio);
}
