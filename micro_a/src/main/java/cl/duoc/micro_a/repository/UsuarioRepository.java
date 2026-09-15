package cl.duoc.micro_a.repository;

import org.springframework.data.jpa.repository.JpaRepository;
// Se importó el modelo Usuario para poder usarlo en el repositorio
import cl.duoc.micro_a.model.Usuario;


// Se extiende de JpaRepository para poder usar los métodos de JPA y poder hacer consultas a la base de datos
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    }
