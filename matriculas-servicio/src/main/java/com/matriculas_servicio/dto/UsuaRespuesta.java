package com.matriculas_servicio.dto;

public class UsuaRespuesta {

    private String nombre;
    private String tipo;

    public UsuaRespuesta(String nombre, String tipo ) {
        this.nombre = nombre;
        this.tipo = tipo;
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
