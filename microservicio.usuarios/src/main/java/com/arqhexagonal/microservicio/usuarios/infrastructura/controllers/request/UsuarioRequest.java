package com.arqhexagonal.microservicio.usuarios.infrastructura.controllers.request;

public class UsuarioRequest {


    private String nombre;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
