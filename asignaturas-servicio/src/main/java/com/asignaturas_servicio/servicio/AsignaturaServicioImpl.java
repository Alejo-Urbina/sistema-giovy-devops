package com.asignaturas_servicio.servicio;

import com.asignaturas_servicio.dto.AsignaturaRespuesta;
import com.asignaturas_servicio.dto.AsignaturaSolicitud;
import com.asignaturas_servicio.repositorio.interfaces.AsignaturaRepositorio;
import com.asignaturas_servicio.servicio.interfaces.AsignaturaServicio;
import org.springframework.stereotype.Service;

@Service
public class AsignaturaServicioImpl implements AsignaturaServicio {

    private final AsignaturaRepositorio repositorio;

    public AsignaturaServicioImpl(AsignaturaRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public AsignaturaRespuesta crearAsignatura(AsignaturaSolicitud asignaturaSolicitud) {
        return repositorio.crearAsignatura(asignaturaSolicitud);
    }

    @Override
    public AsignaturaRespuesta consultarAsignatura(Integer id) {
        return repositorio.consultarAsignatura(id);
    }

}
