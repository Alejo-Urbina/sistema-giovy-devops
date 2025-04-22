package com.matriculas_servicio.servicio.interfaces;

import com.matriculas_servicio.dto.AsignaRespuesta;
import com.matriculas_servicio.dto.MatriculaRespuesta;
import com.matriculas_servicio.dto.MatriculaSolicitud;
import com.matriculas_servicio.dto.UsuaRespuesta;
import com.matriculas_servicio.externo.dto.AsignaturaRespuesta;

import java.util.List;

public interface MatriculaServicio {

    MatriculaRespuesta asignarMatricula(MatriculaSolicitud matriculaSolicitud);

    List<AsignaRespuesta> obtenerAsignaturasPorUsuario(Integer usuarioId);

    List<UsuaRespuesta> obtenerUsuariosPorAsignatura(Integer asignaturaId);

}
