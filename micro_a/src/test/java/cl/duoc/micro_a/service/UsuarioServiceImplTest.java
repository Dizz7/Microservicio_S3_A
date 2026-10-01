package cl.duoc.micro_a.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import cl.duoc.micro_a.model.Usuario;
import cl.duoc.micro_a.repository.UsuarioRepository;



@ExtendWith (MockitoExtension.class)

class UsuarioServiceImplTest {
    @Mock 
    private UsuarioRepository usuarioRepository;

    @InjectMocks 
    private UsuarioServiceImpl service;

    private Usuario usuario1;
    private Usuario usuario2;
    

    @BeforeEach 
    void setUp() {
        usuario1 = new Usuario();
        usuario1.setId(1L);
        usuario1.setN_usuario("usuarioPrueba");
        usuario1.setRol("admin");
        usuario1.setDireccion("Calle Wallaby 42 Sydney");

        usuario2 = new Usuario();
        usuario2.setId(2L);
        usuario2.setN_usuario("usuarioPrueba2");
        usuario2.setRol("user");
        usuario2.setDireccion("Avenida Siempre Viva 742 Springfield");


    }

    @Test 
    void testGetAllUsuarios() {
        when(usuarioRepository.findAll()).thenReturn(Arrays.asList(usuario1, usuario2));

        List<Usuario> usuarios = service.getAllUsuarios();

        assertEquals(2, usuarios.size());
        verify(usuarioRepository, times(1)).findAll();
    }

    @Test 
    void testGetUsuarioById() {
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario1));

        Optional<Usuario> usuario = service.getUsuarioById(1L);

        assertTrue(usuario.isPresent());
        assertEquals("usuarioPrueba", usuario.get().getN_usuario());
        verify(usuarioRepository, times(1)).findById(1L);
    }

    @Test 
    void testCreateUsuario() {
        when(usuarioRepository.save(usuario1)).thenReturn(usuario1);

        Usuario createdUsuario = service.createUsuario(usuario1);

        assertEquals("usuarioPrueba", createdUsuario.getN_usuario());
        verify(usuarioRepository, times(1)).save(usuario1);
    }

    @Test 
    void testUpdateUsuarioExists() {
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario1));   
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario1);

        Usuario updatedUsuario = new Usuario();
        updatedUsuario.setN_usuario("Usuario Actualizado");
        updatedUsuario.setRol("user");
        updatedUsuario.setDireccion("Calle Wallaby 42 Sydney");
    
        Usuario result = service.updateUsuario(1L, updatedUsuario);

        assertEquals("Usuario Actualizado", result.getN_usuario());
        assertEquals("user", result.getRol());
        assertEquals("Calle Wallaby 42 Sydney", result.getDireccion());
        verify(usuarioRepository, times(1)).findById(1L);
        verify(usuarioRepository, times(1)).save(any(Usuario.class));
    }


    @Test
    void testUpdateUsuarioNotExists() {
        Long id = 1L;
        Usuario updatedUsuario = new Usuario();
        updatedUsuario.setN_usuario("Usuario Actualizado");
        updatedUsuario.setRol("user");
        updatedUsuario.setDireccion("Calle Wallaby 42 Sydney");

        when(usuarioRepository.findById(id))
            .thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(
            RuntimeException.class,
            () -> service.updateUsuario(id, updatedUsuario)
        );

        assertEquals("ID de Usuario no encontrado: 1", exception.getMessage());

        verify(usuarioRepository, times(1)).findById(1L);
    }

    @Test 
    void testDeleteUsuario() {
        doNothing().when(usuarioRepository).deleteById(1L);

        service.deleteUsuario(1L);

        verify(usuarioRepository, times(1)).deleteById(1L);
    }


    @AfterEach
    void tearDown() {
        usuario1 = null;
        usuario2 = null;
    }


}


