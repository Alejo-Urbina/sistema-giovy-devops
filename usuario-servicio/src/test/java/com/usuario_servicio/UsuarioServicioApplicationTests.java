package com.usuario_servicio;

import com.usuario_servicio.dto.UsuarioSolicitud;
import com.usuario_servicio.repositorio.interfaces.UsuarioRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(properties = "spring.profiles.active=test")
@AutoConfigureMockMvc
@Import(TestSecurityConfig.class)
class UsuarioServicioApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private UsuarioRepositorio repositorio;

	private Integer usuarioId;

	@BeforeEach
	void setUp() {
		UsuarioSolicitud usuario = new UsuarioSolicitud("Juan Pérez", "juan@example.com", "ESTUDIANTE");
		usuarioId = repositorio.crearUsuario(usuario).getId();
	}

	@Test
	void debeObtenerUsuarioPorId() throws Exception {
		mockMvc.perform(get("/usuarios/{id}", usuarioId)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(usuarioId))
				.andExpect(jsonPath("$.nombre").value("Juan Pérez"))
				.andExpect(jsonPath("$.correo").value("juan@example.com"))
				.andExpect(jsonPath("$.tipo").value("ESTUDIANTE"));
	}

}
