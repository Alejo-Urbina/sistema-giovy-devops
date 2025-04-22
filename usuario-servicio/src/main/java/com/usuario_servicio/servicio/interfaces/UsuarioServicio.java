package com.usuario_servicio.servicio.interfaces;

import com.usuario_servicio.dto.UsuarioRespuesta;
import com.usuario_servicio.dto.UsuarioSolicitud;

public interface UsuarioServicio {

    UsuarioRespuesta crearUsuario (UsuarioSolicitud usuarioSolicitud);

    UsuarioRespuesta consultarUsuario (Integer id);

}
