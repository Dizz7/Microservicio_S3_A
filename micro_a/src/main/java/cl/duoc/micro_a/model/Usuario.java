package cl.duoc.micro_a.model;

/**
 * Clase que representa un usuario en el sistema.
 * Sin @Entity ni @Table porque no se está usando base de datos aún.
 */

public class Usuario {

    private int id; // ID del Usuario
    private String n_usuario; // Nombre de Usuario
    private String rol; // Rol del Usuario
    private String direccion; // Dirección de despacho del Usuario

    // Constructor

    public Usuario(int id,String n_usuario, String rol, String direccion) {
        this.id = id;
        this.n_usuario = n_usuario;
        this.rol = rol;
        this.direccion = direccion;
    }

    // Getters and Setters
    public int getId() {
            return id;
    }

    public void setId(int id) {
            this.id = id;
    }

    public String getN_usuario() {
        return n_usuario;
    }

    public void setN_usuario(String n_usuario) {
        this.n_usuario = n_usuario;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


}
