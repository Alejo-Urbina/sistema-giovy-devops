package com.matriculas_servicio.repositorio.entidad;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "matriculas")
public class MatriculaEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "usuario_id")
    private Integer usuarioId;
    @Column(name = "asignatura_id")
    private Integer asignaturaId;
    @Column(name = "fecha_matricula")
    private LocalDate fechaMatricula;
    private String estado;

    public MatriculaEntidad() {
    }

    public MatriculaEntidad(Integer usuarioId, Integer asignaturaId, LocalDate fechaMatricula, String estado) {
        this.usuarioId = usuarioId;
        this.asignaturaId = asignaturaId;
        this.fechaMatricula = fechaMatricula;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public LocalDate getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(LocalDate fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public Integer getAsignaturaId() {
        return asignaturaId;
    }

    public void setAsignaturaId(Integer asignaturaId) {
        this.asignaturaId = asignaturaId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
