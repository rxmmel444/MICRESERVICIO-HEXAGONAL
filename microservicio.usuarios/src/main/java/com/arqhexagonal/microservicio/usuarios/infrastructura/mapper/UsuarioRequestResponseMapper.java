package com.arqhexagonal.microservicio.usuarios.infrastructura.mapper;

import com.arqhexagonal.microservicio.usuarios.application.dto.UsuarioDTO;
import com.arqhexagonal.microservicio.usuarios.infrastructura.controllers.request.UsuarioRequest;
import com.arqhexagonal.microservicio.usuarios.infrastructura.controllers.response.UsuarioResponse;
import org.springframework.stereotype.Component;


@Component
public class UsuarioRequestResponseMapper {

    public UsuarioDTO requesttoDto(UsuarioRequest request){
        if(request == null){
            return null;
        }

        UsuarioDTO dto = new UsuarioDTO();
        dto.setNombre(request.getNombre());
        dto.setEmail(request.getEmail());
        return dto;

    }

    public UsuarioResponse toResponse(UsuarioDTO dto){
        UsuarioResponse res = new UsuarioResponse();

        res.setId(dto.getId());
        res.setNombre(dto.getNombre());
        res.setEmail(dto.getEmail());

        return res;

    }
}
