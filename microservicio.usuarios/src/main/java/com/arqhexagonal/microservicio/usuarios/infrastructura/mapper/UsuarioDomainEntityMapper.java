package com.arqhexagonal.microservicio.usuarios.infrastructura.mapper;

import com.arqhexagonal.microservicio.usuarios.domain.models.Usuario;
import com.arqhexagonal.microservicio.usuarios.infrastructura.entity.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class UsuarioDomainEntityMapper {

    public UsuarioEntity domainToEntity(Usuario domain){

        UsuarioEntity entity = new UsuarioEntity();

        entity.setId(domain.getId());
        entity.setNombre(domain.getNombre());
        entity.setEmail(domain.getEmail());
        return entity;
    }


    public Usuario entityToDomain(UsuarioEntity entity){

        Usuario domain = new Usuario();
        domain.setId(entity.getId());
        domain.setNombre(entity.getNombre());
        domain.setEmail(entity.getEmail());

        return domain;
    }
}
