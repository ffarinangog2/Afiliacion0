package com.uteq.afiliacion.afiliacion.entity;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "afiliacion")
public class Afiliacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cliente_id", nullable = false)
    private Long clienteId;

    @Column(name = "fecha_afiliacion")
    private LocalDate fechaAfiliacion;

    private String estado;

    public Afiliacion() {}

    public Long getId() {
        return id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public LocalDate getFechaAfiliacion() {
        return fechaAfiliacion;
    }

    public void setFechaAfiliacion(LocalDate fechaAfiliacion) {
        this.fechaAfiliacion = fechaAfiliacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
