package com.usuario_servicio.controlador;

import com.usuario_servicio.dto.UsuarioRespuesta;
import com.usuario_servicio.dto.UsuarioSolicitud;
import com.usuario_servicio.servicio.interfaces.UsuarioServicio;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {

    private final UsuarioServicio servicio;

    public UsuarioControlador(UsuarioServicio servicio) {
        this.servicio = servicio;
    }

    @PostMapping
    public UsuarioRespuesta crearUsuario(@RequestBody UsuarioSolicitud usuarioSolicitud){
        return servicio.crearUsuario(usuarioSolicitud);
    }

    @GetMapping("/{id}")
    public UsuarioRespuesta consultarUsuario(@PathVariable("id") Integer id){
        return servicio.consultarUsuario(id);
    }

}
