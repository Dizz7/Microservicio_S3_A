package cl.duoc.micro_a.service;

import org.springframework.stereotype.Service;
import cl.duoc.micro_a.model.Usuario;
import java.util.List;
import java.util.Optional;



// Lógica del negocio relacionada con los usuarios, como obtener la lista de usuarios, buscar por ID, etc.


@Service
public interface UsuarioService {
    // Métodos para acceder a los usuarios
        List<Usuario> getAllUsuarios();

    // Método para obtener un usuario por su ID
        Optional<Usuario> getUsuarioById(Long id);

    // Métodos para Crear, Actualizar y Eliminar usuarios
        Usuario createUsuario(Usuario usuario);
        Usuario updateUsuario(Long id, Usuario usuario);
        void deleteUsuario(Long id);

}


