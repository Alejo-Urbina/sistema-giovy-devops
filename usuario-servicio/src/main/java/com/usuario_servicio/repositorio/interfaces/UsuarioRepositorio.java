package com.usuario_servicio.repositorio.interfaces;

import com.usuario_servicio.dto.UsuarioSolicitud;
import com.usuario_servicio.dto.UsuarioRespuesta;

public interface UsuarioRepositorio {

    UsuarioRespuesta crearUsuario (UsuarioSolicitud usuarioSolicitud);

    UsuarioRespuesta consultarUsuario (Integer id);

}
