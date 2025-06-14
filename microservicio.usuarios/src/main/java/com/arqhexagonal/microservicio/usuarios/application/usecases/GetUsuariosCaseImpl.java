package com.arqhexagonal.microservicio.usuarios.application.usecases;

import com.arqhexagonal.microservicio.usuarios.application.dto.UsuarioDTO;
import com.arqhexagonal.microservicio.usuarios.application.port.in.GetUsuariosCase;
import com.arqhexagonal.microservicio.usuarios.application.port.out.UsuarioRepositoryPort;
import com.arqhexagonal.microservicio.usuarios.domain.models.Usuario;
import com.arqhexagonal.microservicio.usuarios.infrastructura.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetUsuariosCaseImpl implements GetUsuariosCase {

    private final UsuarioMapper usuarioMapper;

    private final UsuarioRepositoryPort repository;

    public GetUsuariosCaseImpl(UsuarioRepositoryPort repository, UsuarioMapper usuarioMapper) {
        this.repository = repository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public List<UsuarioDTO> obtenerUsuarios() {

List<Usuario>listaUsuario = repository.obtenerUsuarios();
        return listaUsuario.stream()
                .map(usuarioMapper::domainToDto)
                .collect(Collectors.toList());
    }

    @Override //aqui estamos regresando el OPTIONAL SI NO HAY UN ID CON ESE USUARIO
    public UsuarioDTO obtenerPorId(Long id) {
       Usuario usuario = repository.usuarioPorId(id)
               .orElseThrow(()-> new IllegalArgumentException("sdsadsa"));
                 return  usuarioMapper.domainToDto(usuario);
    }
}
