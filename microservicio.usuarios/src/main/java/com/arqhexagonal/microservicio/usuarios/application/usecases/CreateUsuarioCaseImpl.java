package com.arqhexagonal.microservicio.usuarios.application.usecases;

import com.arqhexagonal.microservicio.usuarios.application.dto.UsuarioDTO;
import com.arqhexagonal.microservicio.usuarios.application.port.in.CreateUsuarioCase;
import com.arqhexagonal.microservicio.usuarios.application.port.out.UsuarioRepositoryPort;
import com.arqhexagonal.microservicio.usuarios.domain.models.Usuario;
import com.arqhexagonal.microservicio.usuarios.infrastructura.mapper.UsuarioMapper;
import org.springframework.stereotype.Service;

@Service
public class CreateUsuarioCaseImpl implements CreateUsuarioCase {


    private final UsuarioRepositoryPort repository;

    public CreateUsuarioCaseImpl(UsuarioRepositoryPort repository, UsuarioMapper usuarioMapper) {
        this.repository = repository;
        this.usuarioMapper = usuarioMapper;
    }

    private final UsuarioMapper usuarioMapper;

    @Override
    public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.dtoToDomain(usuarioDTO);
        Usuario usuarioNuevo = repository.crear(usuario);

        return usuarioMapper.domainToDto(usuarioNuevo);
    }
}
