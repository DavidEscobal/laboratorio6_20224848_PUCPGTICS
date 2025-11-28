package org.example.lab6_20224848.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "solicitudes_asignacion_cancion")
public class SolicitudAsignacionCancion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuarios", referencedColumnName = "id") // Cambiado a "usuarios"
    private Usuarios usuario;

    @Column(name = "atendida")
    private Boolean atendida = false;

    @Column(name = "fecha_solicitud")
    private LocalDateTime fechaSolicitud = LocalDateTime.now();

    // Constructores
    public SolicitudAsignacionCancion() {}

    public SolicitudAsignacionCancion(Usuarios usuario) {
        this.usuario = usuario;
    }

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

    public Boolean getAtendida() {
        return atendida;
    }

    public void setAtendida(Boolean atendida) {
        this.atendida = atendida;
    }

    public LocalDateTime getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDateTime fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }
}