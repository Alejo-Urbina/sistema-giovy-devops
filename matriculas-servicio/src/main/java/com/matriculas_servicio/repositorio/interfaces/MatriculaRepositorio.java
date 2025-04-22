package com.matriculas_servicio.repositorio.interfaces;

import com.matriculas_servicio.dto.MatriculaRespuesta;
import com.matriculas_servicio.dto.MatriculaSolicitud;
import com.matriculas_servicio.dto.UsuaRespuesta;

import java.util.List;

public interface MatriculaRepositorio {

    MatriculaRespuesta asignarMatricula(MatriculaSolicitud matriculaSolicitud);

    List<Integer> obtenerAsignaturasPorUsuario(Integer usuarioId);

    List<Integer> obtenerUsuariosPorAsignatura(Integer asignaturaId);

}
