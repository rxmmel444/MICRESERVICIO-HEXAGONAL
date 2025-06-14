package com.arqhexagonal.microservicio.usuarios.application.port.in;

import com.arqhexagonal.microservicio.usuarios.application.dto.UsuarioDTO;
import com.arqhexagonal.microservicio.usuarios.domain.models.Usuario;

public interface CreateUsuarioCase {

  //  Usuario crearUsuario(Usuario usuario);

    UsuarioDTO crearUsuario(UsuarioDTO UsuarioDTO);
}
