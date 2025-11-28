package org.example.lab6_20224848.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "asignaciones_cancion")
public class AsignacionCancion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "cancion_id", nullable = false)
    private CancionCriolla cancion;

    private Integer intentos = 0;
    private Boolean adivinada = false;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public CancionCriolla getCancion() {
        return cancion;
    }

    public void setCancion(CancionCriolla cancion) {
        this.cancion = cancion;
    }

    public Integer getIntentos() {
        return intentos;
    }

    public void setIntentos(Integer intentos) {
        this.intentos = intentos;
    }

    public Boolean getAdivinada() {
        return adivinada;
    }

    public void setAdivinada(Boolean adivinada) {
        this.adivinada = adivinada;
    }
}