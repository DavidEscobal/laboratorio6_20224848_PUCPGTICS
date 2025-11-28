package org.example.lab6_20224848.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "usuarios")
@Getter @Setter
public class Usuarios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                          // PK: usuarios.id

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100, unique = true)
    private String correo;                    // login

    @Column(nullable = false, length = 255)
    private String password;                  // hash BCrypt

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rol_id")              // FK a roles.id
    private roles rol;
}
