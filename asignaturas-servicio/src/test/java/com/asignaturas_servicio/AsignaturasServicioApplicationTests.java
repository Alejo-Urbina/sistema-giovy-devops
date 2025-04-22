package com.asignaturas_servicio;

import com.asignaturas_servicio.dto.AsignaturaSolicitud;
import com.asignaturas_servicio.repositorio.interfaces.AsignaturaRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AsignaturasServicioApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private AsignaturaRepositorio repositorio;

	private Integer asignaturaId;

	@BeforeEach
	void setUp() {

		AsignaturaSolicitud asignatura = new AsignaturaSolicitud("Matemáticas", 5, "Curso base");
		asignaturaId = repositorio.crearAsignatura(asignatura).getId();
	}

	@Test
	void debeObtenerAsignaturaPorId() throws Exception {
		mockMvc.perform(get("/asignatura/{id}", asignaturaId)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(asignaturaId))
				.andExpect(jsonPath("$.nombre").value("Matemáticas"))
				.andExpect(jsonPath("$.creditos").value(5))
				.andExpect(jsonPath("$.descripcion").value("Curso base"));
	}

}
