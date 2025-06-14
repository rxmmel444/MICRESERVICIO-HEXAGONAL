package com.arqhexagonal.microservicio.usuarios.infrastructura.repository;

import com.arqhexagonal.microservicio.usuarios.application.port.out.UsuarioRepositoryPort;
import com.arqhexagonal.microservicio.usuarios.domain.models.Usuario;
import com.arqhexagonal.microservicio.usuarios.infrastructura.entity.UsuarioEntity;
import com.arqhexagonal.microservicio.usuarios.infrastructura.mapper.UsuarioDomainEntityMapper;
import com.arqhexagonal.microservicio.usuarios.infrastructura.mapper.UsuarioMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class JpaUsuarioRepositoryPortAdapter implements UsuarioRepositoryPort {

    private final SpringDataBaseUsuarioRepository springDataBaseUsuarioRepository;
    private final UsuarioDomainEntityMapper usuarioDomainEntityMapper;


    public JpaUsuarioRepositoryPortAdapter(SpringDataBaseUsuarioRepository springDataBaseUsuarioRepository, UsuarioDomainEntityMapper usuarioDomainEntityMapper) {
        this.springDataBaseUsuarioRepository = springDataBaseUsuarioRepository;
        this.usuarioDomainEntityMapper = usuarioDomainEntityMapper;
    }

    @Override
    public Usuario crear(Usuario usuario) {
        UsuarioEntity usuarioEntity = usuarioDomainEntityMapper.domainToEntity(usuario);
        UsuarioEntity crear =  springDataBaseUsuarioRepository.save(usuarioEntity);
        return usuarioDomainEntityMapper.entityToDomain(crear);
    }

    @Override
    public void eliminar(Long id) {

        springDataBaseUsuarioRepository.deleteById(id);
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return springDataBaseUsuarioRepository.findAll()
                .stream()
                .map(usuarioDomainEntityMapper::entityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Usuario> usuarioPorId(Long id) {
        return springDataBaseUsuarioRepository.findById(id)
                .map(usuarioDomainEntityMapper::entityToDomain);
    }
}


/*
*     @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
   public UsuarioDTO crear(UsuarioDTO usuarioDTO){

        Usuario usuario1 = usuarioMapper.dtoToEntity(usuarioDTO);
        Usuario usuarioNuevo = springDataBaseUsuarioRepository.save(usuario1);

        return usuarioMapper.entityToDto(usuarioNuevo);
    }

    @Override
    public List<UsuarioDTO> obtenerUsuarios() {

       List<Usuario> usuarios = springDataBaseUsuarioRepository.findAll();
       return usuarios.stream()
               .map(usuarioMapper::entityToDto)
               .collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO usuarioPorId(Long id) {
        Usuario usuario = springDataBaseUsuarioRepository.findById(id)
                .orElse(null);
        return usuarioMapper.entityToDto(usuario);
    }

    @Override
    public UsuarioDTO actualizar(Long id, UsuarioDTO usuarioDTO) {
   Usuario actual = springDataBaseUsuarioRepository.findById(id).orElse(null);
   Usuario usuario1 = usuarioMapper.dtoToEntity(usuarioDTO);

   actual.setNombre(usuarioDTO.getNombre());
   actual.setEmail(usuarioDTO.getEmail());

   Usuario usuarioActualizado = springDataBaseUsuarioRepository.save(actual);
   return usuarioMapper.entityToDto(usuarioActualizado);
    }

    @Override
    public void eliminar(Long id) {
       if (!springDataBaseUsuarioRepository.existsById(id)){
             throw new RuntimeException();
        }else {
            springDataBaseUsuarioRepository.deleteById(id);
       }
    }
* */