package com.usuario_servicio.repositorio.entidad;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "usuarios")
public class UsuarioEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String correo;
    private String tipo;
    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

    public UsuarioEntidad() {
    }

    public UsuarioEntidad(String nombre, String correo, String tipo, LocalDate fechaRegistro) {
        this.nombre = nombre;
        this.correo = correo;
        this.tipo = tipo;
        this.fechaRegistro = fechaRegistro;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
