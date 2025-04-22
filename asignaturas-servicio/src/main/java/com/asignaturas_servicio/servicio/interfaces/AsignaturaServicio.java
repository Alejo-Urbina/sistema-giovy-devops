package com.asignaturas_servicio.servicio.interfaces;

import com.asignaturas_servicio.dto.AsignaturaRespuesta;
import com.asignaturas_servicio.dto.AsignaturaSolicitud;

public interface AsignaturaServicio {

    AsignaturaRespuesta crearAsignatura(AsignaturaSolicitud asignaturaSolicitud);

    AsignaturaRespuesta consultarAsignatura(Integer id);

}
