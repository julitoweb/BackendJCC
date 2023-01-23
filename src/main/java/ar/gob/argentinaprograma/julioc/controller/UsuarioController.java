package ar.gob.argentinaprograma.julioc.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.gob.argentinaprograma.julioc.dto.Mensaje;
import ar.gob.argentinaprograma.julioc.entity.Producto;
import ar.gob.argentinaprograma.julioc.entity.Usuario;
import ar.gob.argentinaprograma.julioc.service.UsuarioService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/listado")
    public ResponseEntity obtenerUsuarios() {

        return new ResponseEntity(usuarioService.list(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity obtenerUsuarios(@RequestBody Usuario usuario) {
        try {
            if (usuario.getNombre() == null || usuario.getContrasenia() == null) {
                return new ResponseEntity(new Mensaje("Datos inválidos.","MAL"), HttpStatus.OK);
            }
            if (usuarioService.existsByNombre(usuario.getNombre())) {
                return new ResponseEntity(new Mensaje("El usuario ya existe","MAL"), HttpStatus.OK);
            }
            usuarioService.save(usuario);
        } catch (Exception ex) {
            return new ResponseEntity(new Mensaje("ERROR: " + ex.getMessage(),"MAL"), HttpStatus.OK);
        }

        return new ResponseEntity(new Mensaje("Usuario creado con éxito.","OK"), HttpStatus.OK);
    }

    @PostMapping("/ingresar")
    public ResponseEntity logearUsuario(@RequestBody Usuario usuario) {
        try {
            if (usuario.getNombre() == null || usuario.getContrasenia() == null) {
                return new ResponseEntity(new Mensaje("Datos inválidos.","MAL"), HttpStatus.OK);
            }
            if (!usuarioService.existsByNombre(usuario.getNombre())) {
                return new ResponseEntity(new Mensaje("El usuario no existe","MAL"), HttpStatus.OK);
            }
            
            Usuario userExistente = usuarioService.getByNombre(usuario.getNombre());

            if(userExistente.getContrasenia().equalsIgnoreCase(usuario.getContrasenia()) ){
                System.out.println(userExistente.getContrasenia() + " " + usuario.getContrasenia());
                return new ResponseEntity(new Mensaje("Ingresaste con éxito.","OK"), HttpStatus.OK);
            }else{
                return new ResponseEntity(new Mensaje("Contraseña incorrecta","MAL"), HttpStatus.OK);
            }

        } catch (Exception ex) {
            return new ResponseEntity(new Mensaje("Error inesperado: " + ex.getMessage(),"MAL"), HttpStatus.OK);
        }

        
    }

}
