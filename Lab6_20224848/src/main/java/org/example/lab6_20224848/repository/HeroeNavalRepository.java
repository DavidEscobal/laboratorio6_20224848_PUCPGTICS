package org.example.lab6_20224848.repository;

import org.example.lab6_20224848.entity.HeroeNaval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroeNavalRepository extends JpaRepository<HeroeNaval, Long> {
    // Métodos personalizados si los necesitas
}