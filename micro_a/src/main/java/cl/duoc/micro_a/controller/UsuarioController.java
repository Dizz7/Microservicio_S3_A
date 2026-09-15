package cl.duoc.micro_a.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.micro_a.model.Usuario;
import cl.duoc.micro_a.service.UsuarioService;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



// Controlador para manejar las solicitudes relacionadas con los usuarios


@RestController
@RequestMapping ("/usuarios")
public class UsuarioController {



    @Autowired
    // Inyección de dependencias del servicio de usuarios
    private UsuarioService usuarioService;
 
    // Constructor para la inyección de dependencias
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    // Endpoint GET para obtener todos los usuarios
    @GetMapping({"", "/"})
    public List<Usuario> getUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    // Endpoint GET para buscar un usuario por su ID
    @GetMapping("/{id}")
    public Optional<Usuario> getUsuarioById(@PathVariable Long id) {
        return usuarioService.getUsuarioById(id);
    }

    // Controlador para crear, actualizar y eliminar usuarios
    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioService.createUsuario(usuario);
    }
    
    @PutMapping("/{id}")
    public Usuario updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioService.updateUsuario(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
    }

}
    

    
