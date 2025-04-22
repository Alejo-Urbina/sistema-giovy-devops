package com.matriculas_servicio.controlador;

import com.matriculas_servicio.dto.AsignaRespuesta;
import com.matriculas_servicio.dto.MatriculaRespuesta;
import com.matriculas_servicio.dto.MatriculaSolicitud;
import com.matriculas_servicio.dto.UsuaRespuesta;
import com.matriculas_servicio.servicio.interfaces.MatriculaServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matricula")
public class MatriculaControlador {

    private final MatriculaServicio servicio;

    public MatriculaControlador(MatriculaServicio servicio) {
        this.servicio = servicio;
    }

    @PostMapping
    public MatriculaRespuesta crearUsuario(@RequestBody MatriculaSolicitud matriculaSolicitud){
        return servicio.asignarMatricula(matriculaSolicitud);
    }

    @GetMapping("/usuario/{id}")
    public List<AsignaRespuesta> consultarAsignaturasPorUsuario(@PathVariable("id") Integer usuarioId){
        return servicio.obtenerAsignaturasPorUsuario(usuarioId);
    }

    @GetMapping("/asignatura/{id}")
    public List<UsuaRespuesta> consultarUsuariosPorAsignatura(@PathVariable("id") Integer asignaturaId){
        return servicio.obtenerUsuariosPorAsignatura(asignaturaId);
    }

}
