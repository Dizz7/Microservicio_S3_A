package cl.duoc.micro_a.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.micro_a.model.Usuario;
import cl.duoc.micro_a.service.UsuarioService;

import java.util.List;

// Controlador para manejar las solicitudes relacionadas con los usuarios

@RestController
@RequestMapping("/usuarios") // Ruta base para las solicitudes de usuarios
public class UsuarioController {
    

    // Inyección de dependencias del servicio de usuarios
    private final UsuarioService usuarioService;

    // Constructor para la inyección de dependencias
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Endpoint GET para obtener todos los usuarios
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    // Endpoint GET para buscar un usuario por su ID
    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable int id) {
        return usuarioService.getUsuarioById(id);
    }
}