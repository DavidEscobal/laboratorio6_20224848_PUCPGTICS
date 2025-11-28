package org.example.lab6_20224848.repository;

import org.example.lab6_20224848.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {
    Usuarios findByCorreo(String correo);
}
