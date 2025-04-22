package com.asignaturas_servicio.repositorio.interfaces;

import com.asignaturas_servicio.dto.AsignaturaRespuesta;
import com.asignaturas_servicio.dto.AsignaturaSolicitud;

public interface AsignaturaRepositorio {

    AsignaturaRespuesta crearAsignatura(AsignaturaSolicitud asignaturaSolicitud);

    AsignaturaRespuesta consultarAsignatura(Integer id);

}
