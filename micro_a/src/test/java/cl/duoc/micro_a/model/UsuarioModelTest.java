package cl.duoc.micro_a.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;



class UsuarioModelTest {

    @Test
    void testGettersAndSetters() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setN_usuario("usuarioPrueba");
        usuario.setRol("admin");
        usuario.setDireccion("Calle Wallaby 42 Sydney");    
        

        assertEquals(1, usuario.getId());
        assertEquals("usuarioPrueba", usuario.getN_usuario());
        assertEquals("admin", usuario.getRol());
        assertEquals("Calle Wallaby 42 Sydney", usuario.getDireccion());
    }
    
    

}