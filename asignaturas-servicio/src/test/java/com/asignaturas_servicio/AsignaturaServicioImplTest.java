package com.asignaturas_servicio;

import com.asignaturas_servicio.dto.AsignaturaRespuesta;
import com.asignaturas_servicio.dto.AsignaturaSolicitud;
import com.asignaturas_servicio.repositorio.interfaces.AsignaturaRepositorio;
import com.asignaturas_servicio.servicio.AsignaturaServicioImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AsignaturaServicioImplTest {

    private AsignaturaRepositorio repositorio;
    private AsignaturaServicioImpl servicio;

    @BeforeEach
    void setUp() {
        repositorio = Mockito.mock(AsignaturaRepositorio.class);
        servicio = new AsignaturaServicioImpl(repositorio);
    }

    @Test
    void crearAsignatura_debeRetornarAsignaturaRespuestaCorrecta() {
        AsignaturaSolicitud solicitud = new AsignaturaSolicitud("Historia", 4, "Curso introductorio");
        AsignaturaRespuesta respuestaEsperada = new AsignaturaRespuesta(1, "Historia", 4, "Curso introductorio");

        Mockito.when(repositorio.crearAsignatura(solicitud)).thenReturn(respuestaEsperada);

        AsignaturaRespuesta respuesta = servicio.crearAsignatura(solicitud);

        Assertions.assertThat(respuesta).isEqualTo(respuestaEsperada);
    }

    @Test
    void consultarAsignatura_debeRetornarAsignaturaRespuestaCorrecta() {
        Integer id = 10;
        AsignaturaRespuesta respuestaEsperada = new AsignaturaRespuesta(id, "Física", 6, "Curso avanzado");

        Mockito.when(repositorio.consultarAsignatura(id)).thenReturn(respuestaEsperada);

        AsignaturaRespuesta respuesta = servicio.consultarAsignatura(id);

        Assertions.assertThat(respuesta).isEqualTo(respuestaEsperada);
    }
}