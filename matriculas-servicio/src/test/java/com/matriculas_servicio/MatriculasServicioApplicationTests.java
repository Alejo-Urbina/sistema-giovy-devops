package com.matriculas_servicio;

import com.matriculas_servicio.dto.MatriculaSolicitud;
import com.matriculas_servicio.externo.AsignaturaCliente;
import com.matriculas_servicio.externo.UsuarioCliente;
import com.matriculas_servicio.externo.dto.AsignaturaRespuesta;
import com.matriculas_servicio.externo.dto.UsuarioRespuesta;
import com.matriculas_servicio.repositorio.interfaces.MatriculaRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.ArgumentMatchers.anyInt;

@SpringBootTest
@AutoConfigureMockMvc
public class MatriculasServicioApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private MatriculaRepositorio repositorio;

	@MockBean
	private UsuarioCliente usuarioCliente;

	@MockBean
	private AsignaturaCliente asignaturaCliente;

	private Integer usuarioId = 1;
	private Integer asignaturaId = 10;

	@BeforeEach
	void setUp() {

		MatriculaSolicitud matricula = new MatriculaSolicitud(usuarioId, asignaturaId);
		repositorio.asignarMatricula(matricula);

		Mockito.when(usuarioCliente.obtenerUsuario(anyInt()))
				.thenReturn(new UsuarioRespuesta(usuarioId,"Juan Perez","juan.perez@example.com","ESTUDIANTE", LocalDate.now()));
		Mockito.when(asignaturaCliente.obtenerAsignatura(anyInt()))
				.thenReturn(new AsignaturaRespuesta(asignaturaId, "Física", 4, "Curso de Física General"));
	}

	@Test
	void debeObtenerAsignaturasPorUsuario() throws Exception {
		mockMvc.perform(get("/matricula/usuario/{id}", usuarioId)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.size()").value(1))
				.andExpect(jsonPath("$[0].nombre").value("Física"))
				.andExpect(jsonPath("$[0].creditos").value(4))
				.andExpect(jsonPath("$[0].descripcion").value("Curso de Física General"));
	}
}
