package com.usuario_servicio.servicio;

import com.usuario_servicio.dto.UsuarioRespuesta;
import com.usuario_servicio.dto.UsuarioSolicitud;
import com.usuario_servicio.repositorio.interfaces.UsuarioRepositorio;
import com.usuario_servicio.servicio.interfaces.UsuarioServicio;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    private final UsuarioRepositorio repositorio;

    public UsuarioServicioImpl(UsuarioRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public UsuarioRespuesta crearUsuario(UsuarioSolicitud usuarioSolicitud) {
        return repositorio.crearUsuario(usuarioSolicitud);
    }

    @Override
    public UsuarioRespuesta consultarUsuario(Integer id) {
        return repositorio.consultarUsuario(id);
    }
}
