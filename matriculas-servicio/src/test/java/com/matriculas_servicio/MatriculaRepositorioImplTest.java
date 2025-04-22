package com.matriculas_servicio;

import com.matriculas_servicio.dto.MatriculaRespuesta;
import com.matriculas_servicio.dto.MatriculaSolicitud;
import com.matriculas_servicio.repositorio.MatriculaRepositorioImpl;
import com.matriculas_servicio.repositorio.entidad.MatriculaEntidad;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class MatriculaRepositorioImplTest {

    @Test
    void deberiaPersistirMatriculaCorrectamente() {
        EntityManager entityManager = mock(EntityManager.class);
        MatriculaRepositorioImpl repositorio = new MatriculaRepositorioImpl();
        repositorio.em = entityManager;

        MatriculaSolicitud solicitud = new MatriculaSolicitud(1, 2);

        MatriculaRespuesta respuesta = repositorio.asignarMatricula(solicitud);

        ArgumentCaptor<MatriculaEntidad> captor = ArgumentCaptor.forClass(MatriculaEntidad.class);
        verify(entityManager, times(1)).persist(captor.capture());

        MatriculaEntidad entidadPersistida = captor.getValue();
        assertThat(entidadPersistida.getUsuarioId()).isEqualTo(1);
        assertThat(entidadPersistida.getAsignaturaId()).isEqualTo(2);
        assertThat(entidadPersistida.getEstado()).isEqualTo("ACTIVA");
        assertThat(entidadPersistida.getFechaMatricula()).isEqualTo(LocalDate.now());

        assertThat(respuesta.getUsuarioId()).isEqualTo(1);
        assertThat(respuesta.getAsignaturaId()).isEqualTo(2);
        assertThat(respuesta.getEstado()).isEqualTo("ACTIVA");
    }
}