
/*package com.arqhexagonal.microservicio.usuarios.application.service;

import com.arqhexagonal.microservicio.usuarios.application.port.in.CreateUsuarioCase;
import com.arqhexagonal.microservicio.usuarios.application.port.in.DeleteUsuarioCase;
import com.arqhexagonal.microservicio.usuarios.application.port.in.GetUsuariosCase;
import com.arqhexagonal.microservicio.usuarios.application.port.in.UpdateUsuarioCase;
import com.arqhexagonal.microservicio.usuarios.application.port.out.UsuarioRepositoryPort;
import com.arqhexagonal.microservicio.usuarios.infrastructura.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.arqhexagonal.microservicio.usuarios.application.dto.UsuarioDTO;

import java.util.List;

public class UsuarioService implements CreateUsuarioCase, DeleteUsuarioCase, UpdateUsuarioCase, GetUsuariosCase {


    private final UsuarioRepositoryPort repository;
    @Autowired
    UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) {

        return repository.crear(usuarioDTO);


    }

    @Override
    public void eliminarUsuari(Long id) {

        repository.deleteById(id);

    }

    @Override
    public UsuarioDTO obntenerPorId(Long id) {
return null;
        //  Usuario obtenerUsuario =
        //return repository.usuarioPorId(id);
        // return obtenerUsuario;
    }

    @Override
    public List<UsuarioDTO> obtenerUsuarios() {
        return //repository.obtenerUsuarios();
    }

    @Override
    public UsuarioDTO usuarioActualizar(Long id, UsuarioDTO usuarioDTO) {



        return null;
    }
}*/