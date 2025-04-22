package com.asignaturas_servicio.repositorio;

import com.asignaturas_servicio.dto.AsignaturaRespuesta;
import com.asignaturas_servicio.dto.AsignaturaSolicitud;
import com.asignaturas_servicio.excepciones.AsignaturaExcepcion;
import com.asignaturas_servicio.repositorio.entidad.AsignaturaEntidad;
import com.asignaturas_servicio.repositorio.interfaces.AsignaturaRepositorio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class AsignaturaRepositorioImpl implements AsignaturaRepositorio {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public AsignaturaRespuesta crearAsignatura(AsignaturaSolicitud asignaturaSolicitud) {
        AsignaturaEntidad entidad = new AsignaturaEntidad(asignaturaSolicitud.getNombre(),
                asignaturaSolicitud.getCreditos(), asignaturaSolicitud.getDescripcion());
        em.persist(entidad);
        return mapearRespuesta(entidad);
    }

    @Override
    public AsignaturaRespuesta consultarAsignatura(Integer id) {
        AsignaturaEntidad entidad = em.find(AsignaturaEntidad.class, Long.valueOf(id));
        if (entidad == null) {
            throw new AsignaturaExcepcion("No se encuentra la asignatura con el id: " + id);
        }
        return mapearRespuesta(entidad);
    }

    private AsignaturaRespuesta mapearRespuesta(AsignaturaEntidad entidad){
        return new AsignaturaRespuesta(entidad.getId(), entidad.getNombre(), entidad.getCreditos(), entidad.getDescripcion());
    }
}
