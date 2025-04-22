package com.matriculas_servicio.dto;

import java.time.LocalDate;

public class MatriculaRespuesta {

    private Integer id;
    private Integer usuarioId;
    private Integer asignaturaId;
    private LocalDate fechaMatricula;
    private String estado;

    public MatriculaRespuesta() {
    }

    public MatriculaRespuesta(Integer id, Integer usuarioId, Integer asignaturaId, LocalDate fechaMatricula, String estado) {
        this.id = id;
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

    public Integer getAsignaturaId() {
        return asignaturaId;
    }

    public void setAsignaturaId(Integer asignaturaId) {
        this.asignaturaId = asignaturaId;
    }

    public LocalDate getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(LocalDate fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
