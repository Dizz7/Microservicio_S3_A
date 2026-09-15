package cl.duoc.micro_a.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;




@Entity
@Table(name = "usuario")
public class Usuario {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    // Validaciones de los campos de la tabla usuario
    @Pattern (regexp = "^[a-zA-Z0-9]+$", message = "El nombre de usuario solo puede contener letras y números")
    @Size (min = 3, max = 20, message = "El nombre de usuario debe tener entre 3 y 20 caracteres")
    @NotBlank (message = "El nombre de usuario no puede estar vacío")
    @Column(name = "n_usuario")
    private String n_usuario;
    
    // Rol
    @Pattern (regexp = "^[a-zA-Z]+$", message = "El rol solo puede contener letras y números")
    @Size (min = 3, max = 20, message = "El rol debe tener entre 3 y 20 caracteres")
    @NotBlank (message = "El rol no puede estar vacío")
    @Column(name = "rol")
    private String rol;


    // Dirección
    @Pattern(
    regexp = "^[a-zA-Z0-9. ]+$",
    message = "La dirección solo puede contener letras, números, puntos y espacios")
    @Size (min = 3, max = 40, message = "La dirección debe tener entre 3 y 40 caracteres")
    @NotBlank (message = "La dirección no puede estar vacía")
    @Column(name = "direccion")
    private String direccion;




    // Constructor vacío requerido por JPA
    public Usuario() {
    }



    // Constructor

    public Usuario(Long id,String n_usuario, String rol, String direccion) {
        this.id = id;
        this.n_usuario = n_usuario;
        this.rol = rol;
        this.direccion = direccion;
    }

    // Getters y Setters
    
    public Long getId() { return id;}
    public void setId(Long id) { this.id = id;}

    public String getN_usuario() { return n_usuario;}
    public void setN_usuario(String n_usuario) { this.n_usuario = n_usuario; }

    public String getRol() { return rol;}
    public void setRol(String rol) { this.rol = rol;}

    public String getDireccion() { return direccion;}
    public void setDireccion(String direccion) { this.direccion = direccion;}

}
