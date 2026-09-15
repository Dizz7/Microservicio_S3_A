package cl.duoc.micro_a.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;




@Entity
@Table(name = "usuario")
public class Usuario {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "n_usuario")
    private String n_usuario;
    @Column(name = "rol")
    private String rol;
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
