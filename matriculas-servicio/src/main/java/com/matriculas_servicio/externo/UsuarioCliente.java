package com.matriculas_servicio.externo;

import com.matriculas_servicio.externo.dto.UsuarioRespuesta;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuarios-servicio", url = "http://localhost:8081", configuration = com.matriculas_servicio.configuracion.FeignClientConfig.class)
public interface UsuarioCliente {

    @GetMapping("/usuarios/{id}")
    UsuarioRespuesta obtenerUsuario(@PathVariable("id") Integer id);
}
