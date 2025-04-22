package com.usuario_servicio.repositorio;

import com.usuario_servicio.dto.UsuarioRespuesta;
import com.usuario_servicio.dto.UsuarioSolicitud;
import com.usuario_servicio.excepciones.UsuarioExcepcion;
import com.usuario_servicio.repositorio.entidad.UsuarioEntidad;
import com.usuario_servicio.repositorio.interfaces.UsuarioRepositorio;
import jakarta.transaction.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class UsuarioRepositorioImpl implements UsuarioRepositorio {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public UsuarioRespuesta crearUsuario(UsuarioSolicitud usuarioSolicitud) {
        UsuarioEntidad entidad = new UsuarioEntidad(usuarioSolicitud.getNombre(),
                usuarioSolicitud.getCorreo(), usuarioSolicitud.getTipo(), LocalDate.now());

        em.persist(entidad);

        return mapearRespuesta(entidad);
    }

    @Override
    public UsuarioRespuesta consultarUsuario(Integer id) {
        UsuarioEntidad entidad = em.find(UsuarioEntidad.class, Long.valueOf(id));
        if (entidad == null) {
            throw new UsuarioExcepcion("No se encuentra el usuario con el id: " + id);
        }
        return mapearRespuesta(entidad);
    }

    private UsuarioRespuesta mapearRespuesta(UsuarioEntidad entidad) {
        return new UsuarioRespuesta(
                entidad.getId(),
                entidad.getNombre(),
                entidad.getCorreo(),
                entidad.getTipo(),
                entidad.getFechaRegistro()
        );
    }
}
