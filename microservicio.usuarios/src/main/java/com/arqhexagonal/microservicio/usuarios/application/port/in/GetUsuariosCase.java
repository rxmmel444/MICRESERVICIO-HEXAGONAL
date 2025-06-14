package com.arqhexagonal.microservicio.usuarios.application.port.in;

import com.arqhexagonal.microservicio.usuarios.application.dto.UsuarioDTO;

import java.util.List;

public interface GetUsuariosCase {

    UsuarioDTO obtenerPorId(Long id);

   abstract List<UsuarioDTO> obtenerUsuarios();
}
