package com.usuario_servicio;


import com.usuario_servicio.dto.UsuarioRespuesta;
import com.usuario_servicio.dto.UsuarioSolicitud;
import com.usuario_servicio.repositorio.interfaces.UsuarioRepositorio;
import com.usuario_servicio.servicio.UsuarioServicioImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class UsuarioServicioImplTest {

    private UsuarioRepositorio repositorio;
    private UsuarioServicioImpl servicio;

    @BeforeEach
    void setUp() {
        repositorio = mock(UsuarioRepositorio.class);
        servicio = new UsuarioServicioImpl(repositorio);
    }

    @Test
    void crearUsuarioDebeRetornarRespuestaCorrecta() {
        UsuarioSolicitud solicitud = new UsuarioSolicitud("Pedro Pardo", "pedro@example.com", "ESTUDIANTE");
        UsuarioRespuesta respuestaEsperada = new UsuarioRespuesta(1, "Pedro Pardo", "pedro@example.com", "ESTUDIANTE", null);

        when(repositorio.crearUsuario(solicitud)).thenReturn(respuestaEsperada);

        UsuarioRespuesta respuesta = servicio.crearUsuario(solicitud);

        assertThat(respuesta).isEqualTo(respuestaEsperada);
        verify(repositorio).crearUsuario(solicitud);
    }

    @Test
    void consultarUsuarioDebeRetornarUsuarioCorrecto() {
        Integer id = 5;
        UsuarioRespuesta respuestaEsperada = new UsuarioRespuesta(5, "Laura Diaz", "laura@example.com", "DOCENTE", null);

        when(repositorio.consultarUsuario(id)).thenReturn(respuestaEsperada);

        UsuarioRespuesta respuesta = servicio.consultarUsuario(id);

        assertThat(respuesta.getId()).isEqualTo(5);
        assertThat(respuesta.getNombre()).isEqualTo("Laura Diaz");
        verify(repositorio).consultarUsuario(id);
    }
}