package com.arqhexagonal.microservicio.usuarios.infrastructura.controllers;


import com.arqhexagonal.microservicio.usuarios.application.dto.UsuarioDTO;
import com.arqhexagonal.microservicio.usuarios.application.port.in.CreateUsuarioCase;
import com.arqhexagonal.microservicio.usuarios.application.port.in.DeleteUsuarioCase;
import com.arqhexagonal.microservicio.usuarios.application.port.in.GetUsuariosCase;
import com.arqhexagonal.microservicio.usuarios.application.port.in.UpdateUsuarioCase;
import com.arqhexagonal.microservicio.usuarios.infrastructura.controllers.request.UsuarioRequest;
import com.arqhexagonal.microservicio.usuarios.infrastructura.controllers.response.UsuarioResponse;
import com.arqhexagonal.microservicio.usuarios.infrastructura.mapper.UsuarioRequestResponseMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "USUARIOS" ,description = "permite realzar operaciones CRUD para los usuarios")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

private final GetUsuariosCase getUsuariosCase;
private final CreateUsuarioCase createUsuarioCase;
private final DeleteUsuarioCase deleteUsuarioCase;
private final UpdateUsuarioCase updateUsuarioCase;
private final UsuarioRequestResponseMapper requestResponseMapper;


    public UsuarioController(CreateUsuarioCase createUsuarioCase, GetUsuariosCase getUsuariosCase, DeleteUsuarioCase deleteUsuarioCase, UpdateUsuarioCase updateUsuarioCase, UsuarioRequestResponseMapper requestResponseMapper) {
        this.createUsuarioCase = createUsuarioCase;
        this.getUsuariosCase = getUsuariosCase;
        this.deleteUsuarioCase = deleteUsuarioCase;
        this.updateUsuarioCase = updateUsuarioCase;
        this.requestResponseMapper = requestResponseMapper;
    }

    @Operation (
            summary ="Obtiene por ID a los usuarios",

                    description = "Retorna al usuario por medio de su ID unico en el Sistema",
            responses = {

                    @ApiResponse (responseCode = "200", description = "usuario por ID obtenido Correctamente"),
                    @ApiResponse (responseCode = "400", description = "el usuario no fue encontrado por el ID")

            }

    )
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse>obtenerPorId(@PathVariable Long id ){

        UsuarioDTO usuariodto = getUsuariosCase.obtenerPorId(id);

        if (usuariodto == null) {
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }else{
            UsuarioResponse response = requestResponseMapper.toResponse(usuariodto);
         return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        }
        @Operation
                (summary = "Lista los Usuarios del Sistema",
                        description = "obtiene la lista de usuarios del sistema",
                        responses =
                                {
                                        @ApiResponse (responseCode = "200" , description ="lista obtenida correctamente"),
                                        @ApiResponse (responseCode = "400" , description = "lista No obtenida con exito")
                                }
                 )

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> listar(){
        List<UsuarioDTO> lista = getUsuariosCase.obtenerUsuarios();
        List<UsuarioResponse> respuesta = lista.stream()
                .map(requestResponseMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }

    @Operation(
            summary = "Actualiza al usuario por ID",
            description = "Actualiza la informacion del usuario en el sistema",
            responses = {
                    @ApiResponse (responseCode = "200", description = "la informacion del usuario se actualizo con exito"),
                    @ApiResponse (responseCode = "400", description = "No se actualizo la informacion del usuario")
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse>actualizar(@PathVariable Long id, @RequestBody UsuarioRequest request){
        UsuarioDTO usuarioDTO = requestResponseMapper.requesttoDto(request);
   UsuarioDTO actualizado = updateUsuarioCase.usuarioActualizar(id , usuarioDTO);
   UsuarioResponse response = requestResponseMapper.toResponse(actualizado);
   return  ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Crea Un usuario el Sistema",
            description = "Se guarda un usuario nuevo en el sistema con su identificador unico",
            responses = {
                    @ApiResponse(responseCode = "200", description = "El usuario se creo con exito"),
                    @ApiResponse(responseCode = "400",  description = "El usuario no pudo ser creado")
            }
    )


    @PostMapping
    public ResponseEntity<UsuarioResponse> crear(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "pasamos el objecto usuario a crear",required = true)
                                                     @RequestBody UsuarioRequest request){

        UsuarioDTO dto = requestResponseMapper.requesttoDto(request);
        UsuarioDTO creado = createUsuarioCase.crearUsuario(dto);
        UsuarioResponse response = requestResponseMapper.toResponse(creado);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @Operation(
            summary = "Elimina un Usuario por su ID",
            description = "Elimina a un usuario en el sistema por medio de su ID",
            responses = {

                    @ApiResponse(responseCode = "200", description = "el usuario se elimino con exito"),
                    @ApiResponse(responseCode = "400", description = "el usuario no fue eliminado")
            }
    )

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@Parameter (description = "ID del usuario",required = true) @PathVariable Long id){

        deleteUsuarioCase.eliminarUsuari(id);
        return ResponseEntity.noContent().build();
    }
}
