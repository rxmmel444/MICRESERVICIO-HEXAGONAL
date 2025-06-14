package com.arqhexagonal.microservicio.usuarios.application.usecases;

import com.arqhexagonal.microservicio.usuarios.application.dto.UsuarioDTO;
import com.arqhexagonal.microservicio.usuarios.application.port.in.UpdateUsuarioCase;
import com.arqhexagonal.microservicio.usuarios.application.port.out.UsuarioRepositoryPort;
import com.arqhexagonal.microservicio.usuarios.domain.models.Usuario;
import com.arqhexagonal.microservicio.usuarios.infrastructura.mapper.UsuarioMapper;
import org.springframework.stereotype.Service;

@Service
public class UpdateUsuarioCaseImpl implements UpdateUsuarioCase {

    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepositoryPort repositoryPort;

    public UpdateUsuarioCaseImpl(UsuarioRepositoryPort repositoryPort, UsuarioMapper usuarioMapper) {
        this.repositoryPort = repositoryPort;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public UsuarioDTO usuarioActualizar(Long id, UsuarioDTO usuarioDTO) {


        Usuario usuario = repositoryPort.usuarioPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("no hagarra pa"));

     //   Usuario usuario = usuarioMapper.dtoToEntity(usuarioDTO);
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setEmail(usuarioDTO.getEmail());
        Usuario usuarioActualizado = repositoryPort.crear(usuario);
        return usuarioMapper.domainToDto(usuarioActualizado);
    }


}
