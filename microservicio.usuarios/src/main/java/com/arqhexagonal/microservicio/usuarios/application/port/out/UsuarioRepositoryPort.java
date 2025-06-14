package com.arqhexagonal.microservicio.usuarios.application.port.out;

import com.arqhexagonal.microservicio.usuarios.domain.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepositoryPort {
    Usuario crear(Usuario usuario);
    List<Usuario>  obtenerUsuarios();
    Optional<Usuario> usuarioPorId (Long id);
    void eliminar(Long id);
}
