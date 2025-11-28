package org.example.lab6_20224848.repository;

import org.example.lab6_20224848.entity.Intencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IntencionRepository extends JpaRepository<Intencion, Long> {

    // Verificar si el usuario ya tiene una intención en la misma sesión (mismo día)
    @Query("SELECT COUNT(i) FROM Intencion i WHERE i.usuarios.id = :usuarioId AND DATE(i.fecha) = CURRENT_DATE")
    long countByUsuarioToday(@Param("usuarioId") Long usuarioId);

    // ✅ USAR @QUERY EXPLÍCITO para evitar problemas de nomenclatura
    @Query("SELECT i FROM Intencion i WHERE i.usuarios.id = :usuarioId ORDER BY i.fecha DESC")
    List<Intencion> findIntencionesByUsuarioId(@Param("usuarioId") Long usuarioId);

    // Encontrar todas las intenciones ordenadas por fecha (para admin)
    List<Intencion> findAllByOrderByFechaDesc();
}