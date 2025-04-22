package com.matriculas_servicio.externo;

import com.matriculas_servicio.externo.dto.AsignaturaRespuesta;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "asignaturas-servicio", url = "http://localhost:8082")
public interface AsignaturaCliente {

    @GetMapping("/asignatura/{id}")
    AsignaturaRespuesta obtenerAsignatura(@PathVariable("id") Integer id);
}