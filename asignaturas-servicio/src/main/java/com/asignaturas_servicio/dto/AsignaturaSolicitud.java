package com.asignaturas_servicio.dto;

public class AsignaturaSolicitud {

    private String nombre;
    private Integer creditos;
    private String descripcion;

    public AsignaturaSolicitud(String nombre, Integer creditos, String descripcion) {
        this.nombre = nombre;
        this.creditos = creditos;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
