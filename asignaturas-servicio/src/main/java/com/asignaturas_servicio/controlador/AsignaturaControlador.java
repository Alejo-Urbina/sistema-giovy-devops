package com.asignaturas_servicio.controlador;

import com.asignaturas_servicio.dto.AsignaturaRespuesta;
import com.asignaturas_servicio.dto.AsignaturaSolicitud;
import com.asignaturas_servicio.servicio.interfaces.AsignaturaServicio;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/asignatura")
public class AsignaturaControlador {

    private final AsignaturaServicio servicio;

    public AsignaturaControlador(AsignaturaServicio servicio) {
        this.servicio = servicio;
    }

    @PostMapping
    public AsignaturaRespuesta crearAsignatura(@RequestBody AsignaturaSolicitud asignaturaSolicitud){
        return servicio.crearAsignatura(asignaturaSolicitud);
    }

    @GetMapping("/{id}")
    public AsignaturaRespuesta consultarAsignatura(@PathVariable("id") Integer id){
        return servicio.consultarAsignatura(id);
    }

}
