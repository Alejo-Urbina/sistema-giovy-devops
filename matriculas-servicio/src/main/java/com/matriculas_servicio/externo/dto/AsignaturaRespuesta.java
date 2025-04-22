package com.matriculas_servicio.externo.dto;

public class AsignaturaRespuesta {

    private Integer id;
    private String nombre;
    private Integer creditos;
    private String descripcion;

    public AsignaturaRespuesta(Integer id, String nombre, Integer creditos, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.creditos = creditos;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
