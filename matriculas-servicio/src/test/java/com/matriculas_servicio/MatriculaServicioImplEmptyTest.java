package com.matriculas_servicio;


import com.matriculas_servicio.externo.AsignaturaCliente;
import com.matriculas_servicio.externo.UsuarioCliente;
import com.matriculas_servicio.repositorio.interfaces.MatriculaRepositorio;
import com.matriculas_servicio.servicio.MatriculaServicioImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class MatriculaServicioImplEmptyTest {

    private MatriculaRepositorio repositorio;
    private UsuarioCliente usuarioCliente;
    private AsignaturaCliente asignaturaCliente;
    private MatriculaServicioImpl servicio;

    @BeforeEach
    void setUp() {
        repositorio = mock(MatriculaRepositorio.class);
        usuarioCliente = mock(UsuarioCliente.class);
        asignaturaCliente = mock(AsignaturaCliente.class);
        servicio = new MatriculaServicioImpl(repositorio, usuarioCliente, asignaturaCliente);
    }

    @Test
    void deberiaRetornarListaVaciaSiNoTieneAsignaturas() {
        Integer usuarioId = 1;

        when(repositorio.obtenerAsignaturasPorUsuario(usuarioId)).thenReturn(Collections.emptyList());
        when(usuarioCliente.obtenerUsuario(usuarioId)).thenReturn(null); // no importa porque no se consulta

        List<?> resultado = servicio.obtenerAsignaturasPorUsuario(usuarioId);
        assertThat(resultado).isEmpty();
    }
}