package com.arqhexagonal.microservicio.usuarios.infrastructura.mapper;

import com.arqhexagonal.microservicio.usuarios.application.dto.UsuarioDTO;
import com.arqhexagonal.microservicio.usuarios.domain.models.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
// DTO A DOMAIN  = DOMAIN A DTO
    public UsuarioDTO domainToDto( Usuario usuario){

        if(usuario == null){
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setEmail(usuario.getEmail());


        return usuarioDTO;

    }

    public Usuario dtoToDomain (UsuarioDTO usuarioDTO){

        if(usuarioDTO == null){
            return null;
        }


        Usuario usuario = new  Usuario();

        usuario.setId(usuarioDTO.getId());
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setEmail(usuarioDTO.getEmail());

        return usuario;
    }


}
