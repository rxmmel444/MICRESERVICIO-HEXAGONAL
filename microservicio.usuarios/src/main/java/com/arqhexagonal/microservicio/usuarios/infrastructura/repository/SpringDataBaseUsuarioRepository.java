package com.arqhexagonal.microservicio.usuarios.infrastructura.repository;

import com.arqhexagonal.microservicio.usuarios.domain.models.Usuario;
import com.arqhexagonal.microservicio.usuarios.infrastructura.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataBaseUsuarioRepository extends JpaRepository<UsuarioEntity,Long>
{
}
