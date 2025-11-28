package org.example.lab6_20224848.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "heroes_navales")
public class HeroeNaval {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String rango;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(columnDefinition = "TEXT")
    private String resena;

    private String pais;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getRango() { return rango; }
    public void setRango(String rango) { this.rango = rango; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getResena() { return resena; }
    public void setResena(String resena) { this.resena = resena; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }
}