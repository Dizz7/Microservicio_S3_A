package cl.duoc.micro_a.controller;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.test.web.servlet.ResultHandler;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import tools.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;



import cl.duoc.micro_a.model.Usuario;
import cl.duoc.micro_a.service.UsuarioService;


@WebMvcTest(UsuarioController.class)
class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private UsuarioService service;

    private Usuario usuario1;

    @BeforeEach 
    void setUp() {
        usuario1 = new Usuario();
        usuario1.setId(1L);
        usuario1.setN_usuario("usuarioPrueba");
        usuario1.setRol("admin");
        usuario1.setDireccion("Calle Wallaby 42 Sydney");
    }

    @Test 
    void testGetAllUsuarios() throws Exception {
        when(service.getAllUsuarios()).thenReturn(Arrays.asList(usuario1));

        mockMvc.perform(get("/usuarios"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(Arrays.asList(usuario1))));
    }

    @Test 
    void testGetUsuarioById() throws Exception {
        when(service.getUsuarioById(1L)).thenReturn(Optional.of(usuario1));
        mockMvc.perform(get("/usuarios/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(usuario1)));
    }

    @Test
    void testCreateUsuario() throws Exception {
        when(service.createUsuario(any(Usuario.class)))
                .thenReturn(usuario1);

        mockMvc.perform(post("/usuarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(usuario1)))
                .andDo(print())
                .andDo(mostrarCausaDelError())
                .andExpect(status().isCreated())
                .andExpect(content().json(
                        objectMapper.writeValueAsString(usuario1)));

        verify(service).createUsuario(any(Usuario.class));
    }

    @Test
    void testUpdateUsuario() throws Exception {
        when(service.updateUsuario(eq(1L), any(Usuario.class)))
                .thenReturn(usuario1);

        mockMvc.perform(put("/usuarios/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(usuario1)))
                .andDo(print())
                .andDo(mostrarCausaDelError())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(Arrays.asList(usuario1))));
    }

    @Test 
    void testDeleteUsuario() throws Exception {
        doNothing().when(service).deleteUsuario(1L);

        mockMvc.perform(delete("/usuarios/1"))
                .andExpect(status().isOk());
                verify(service).deleteUsuario(1L);
    }


    private ResultHandler mostrarCausaDelError() {
            return result -> {
                Exception exception = result.getResolvedException();

                if (exception != null) {
                    throw new AssertionError(
                            "La petición falló: " + exception.getMessage(),
                            exception
                    );
                }
            };
        }

}

