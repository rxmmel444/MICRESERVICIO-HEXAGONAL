package com.arqhexagonal.microservicio.usuarios.application.usecases;

import com.arqhexagonal.microservicio.usuarios.application.port.in.DeleteUsuarioCase;
import com.arqhexagonal.microservicio.usuarios.application.port.out.UsuarioRepositoryPort;
import com.arqhexagonal.microservicio.usuarios.domain.models.Usuario;
import com.arqhexagonal.microservicio.usuarios.infrastructura.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUsuarioCaseImpl implements DeleteUsuarioCase {


   private final UsuarioRepositoryPort repository;

    public DeleteUsuarioCaseImpl(UsuarioRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public void eliminarUsuari(Long id) {
                repository.eliminar(id);

    }
}
