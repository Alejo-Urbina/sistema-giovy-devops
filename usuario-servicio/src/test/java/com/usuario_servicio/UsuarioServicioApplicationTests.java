package com.usuario_servicio;

import com.usuario_servicio.dto.UsuarioSolicitud;
import com.usuario_servicio.repositorio.interfaces.UsuarioRepositorio;
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
class UsuarioServicioApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private UsuarioRepositorio repositorio;

	private Integer usuarioId;

	private final String TOKEN = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTc0NDY4NzE4NSwiZXhwIjoxNzQ0NjkwNzg1fQ.tA3taJbhHpGN5Fv9BGr1NTT1WpkJzWaZiicNjF-KT9s";

	@BeforeEach
	void setUp() {
		UsuarioSolicitud usuario = new UsuarioSolicitud("Juan Pérez", "juan@example.com", "ESTUDIANTE");
		usuarioId = repositorio.crearUsuario(usuario).getId();
	}

	@Test
	void debeObtenerUsuarioPorId() throws Exception {
		mockMvc.perform(get("/usuarios/{id}", usuarioId)
						.header("Authorization", TOKEN)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(usuarioId))
				.andExpect(jsonPath("$.nombre").value("Juan Pérez"))
				.andExpect(jsonPath("$.correo").value("juan@example.com"))
				.andExpect(jsonPath("$.tipo").value("ESTUDIANTE"));
	}

}
