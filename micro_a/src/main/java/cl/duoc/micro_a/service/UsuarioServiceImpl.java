package cl.duoc.micro_a.service;


import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import cl.duoc.micro_a.model.Usuario;
import cl.duoc.micro_a.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    
        private final UsuarioRepository usuarioRepository;

        UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
                this.usuarioRepository = usuarioRepository;
        }

        @Override
        public List<Usuario> getAllUsuarios() {
            return usuarioRepository.findAll();
        }
   
        @Override
        public Optional<Usuario> getUsuarioById(Long id) {
            return usuarioRepository.findById(id);
        }
   

        // Lógica del CRUD para crear, actualizar y eliminar usuarios
        @Override
        public Usuario createUsuario(Usuario usuario) {
            return usuarioRepository.save(usuario);
        }

        @Override
        public Usuario updateUsuario(Long id, Usuario usuario) {
            Optional<Usuario> existingUsuario = usuarioRepository.findById(id);
            if (existingUsuario.isPresent()) {
                Usuario updatedUsuario = existingUsuario.get();
                updatedUsuario.setN_usuario(usuario.getN_usuario());
                updatedUsuario.setRol(usuario.getRol());
                updatedUsuario.setDireccion(usuario.getDireccion());

                return usuarioRepository.save(updatedUsuario);
            } else {
                throw new RuntimeException("ID de Usuario no encontrado: " + id);
            }

        }
              
                
        @Override
        public void deleteUsuario(Long id) {
             usuarioRepository.deleteById(id);
            }
}








