package org.example.lab6_20224848.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mesas")
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private Integer numero;

    private Integer capacidad = 4;
    private Boolean disponible = true;

    // Getters y Setters
}