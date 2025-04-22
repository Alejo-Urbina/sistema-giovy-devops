package com.usuario_servicio.dto;

public class UsuarioSolicitud {

    String nombre;
    String correo;
    String tipo;

    public UsuarioSolicitud(String nombre, String correo, String tipo) {
        this.nombre = nombre;
        this.correo = correo;
        this.tipo = tipo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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
}
