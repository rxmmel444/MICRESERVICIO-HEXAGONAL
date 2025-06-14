package com.arqhexagonal.microservicio.usuarios.application.port.in;

import com.arqhexagonal.microservicio.usuarios.application.dto.UsuarioDTO;
import com.arqhexagonal.microservicio.usuarios.domain.models.Usuario;

public interface UpdateUsuarioCase {

  //  Usuario usuarioActualizar (Long id, Usuario usuario);

    UsuarioDTO usuarioActualizar(Long id, UsuarioDTO usuarioDTO);
}
