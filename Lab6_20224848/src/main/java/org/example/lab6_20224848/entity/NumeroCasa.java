package org.example.lab6_20224848.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "numeros_casa")
public class NumeroCasa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuarios usuario;

    @Column(nullable = false)
    private Integer numeroObjetivo;

    private Integer intentos = 0;
    private Boolean adivinado = false;

    // Getters y Setters
}
