package cl.duoc.micro_a.service;

import org.springframework.stereotype.Service;

import cl.duoc.micro_a.model.Usuario;

import java.util.ArrayList;
import java.util.List;

// Lógica del negocio relacionada con los usuarios
@Service
public class UsuarioService {
    
    private List<Usuario> usuarios = new ArrayList<>();

    public UsuarioService() {
        // Inicializar con algunos usuarios de ejemplo
        usuarios.add(new Usuario(1, "Oso", "admin", "Los Torneros 123"));
        usuarios.add(new Usuario(2, "Pelupi", "user", "Avenida Siempre Viva 456"));
        usuarios.add(new Usuario(3, "Toga", "user", "Huenteno 123"));
        usuarios.add(new Usuario(4, "Matias", "user", "Bandurrias 789"));
        usuarios.add(new Usuario(5, "Pajaro", "moderador", "Pedro de Valdivia 321"));
        usuarios.add(new Usuario(6, "Sebastian", "user", "Marchant Pereira 1400"));
        usuarios.add(new Usuario(7, "Jose", "user", "San Diego 555"));
        usuarios.add(new Usuario(8, "Marco", "admin", "Alameda 999"));
    }

    // Métodos para acceder a los usuarios

    // Obtener todos los usuarios
    public List<Usuario> getAllUsuarios() {
        return usuarios;
    }


    // Obtener un usuario por su ID
    public Usuario getUsuarioById(int id) {
        return usuarios.stream()
                .filter(usuario -> usuario.getId() == id)
                .findFirst()
                .orElse(null);
    }





}
