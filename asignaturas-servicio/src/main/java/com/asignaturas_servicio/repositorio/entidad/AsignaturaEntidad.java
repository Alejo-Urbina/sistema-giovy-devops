package com.asignaturas_servicio.repositorio.entidad;

import jakarta.persistence.*;

@Entity(name = "asignaturas")
public class AsignaturaEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private Integer creditos;
    private String descripcion;

    public AsignaturaEntidad() {
    }

    public AsignaturaEntidad(String nombre, Integer creditos, String descripcion) {
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
