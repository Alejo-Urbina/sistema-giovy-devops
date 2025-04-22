package com.matriculas_servicio.dto;

public class MatriculaSolicitud {

    private Integer usuarioId;
    private Integer asignaturaId;

    public MatriculaSolicitud() {
    }

    public MatriculaSolicitud(Integer usuarioId, Integer asignaturaId) {
        this.usuarioId = usuarioId;
        this.asignaturaId = asignaturaId;
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
}
