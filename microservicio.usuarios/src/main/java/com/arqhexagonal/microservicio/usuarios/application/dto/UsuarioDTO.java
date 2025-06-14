package com.arqhexagonal.microservicio.usuarios.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public class UsuarioDTO {

    @Schema(description = "ID del usuario Pa",example = "1")
    private Long id;
    @Schema(description = "Nombrel del Usuario", example = "Rommel Valdiviezo")
    private String nombre;
    @Schema(description = "Email del usuario" , example = "rommelkd36@gmail")
    private String email;
    @Schema(description = "Hora de la creacion del usuario")
    private LocalDateTime creationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
