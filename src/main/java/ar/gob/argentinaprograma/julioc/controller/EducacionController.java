package ar.gob.argentinaprograma.julioc.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.gob.argentinaprograma.julioc.dto.Mensaje;
import ar.gob.argentinaprograma.julioc.entity.Educacion;
import ar.gob.argentinaprograma.julioc.service.EducacionService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/educacion")
public class EducacionController {

    @Autowired
    EducacionService educacionService;

    @GetMapping("/listado")
    public ResponseEntity obtenerTodos() {

        return new ResponseEntity(educacionService.list(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity creacionExp(@RequestBody Educacion exper) {
        try {
            if (exper.getContenido() == null || exper.getTitulo() == null) {
                return new ResponseEntity(new Mensaje("Datos inválidos.","MAL"), HttpStatus.OK);
            }
            educacionService.save(exper);
        } catch (Exception ex) {
            return new ResponseEntity(new Mensaje("ERROR: " + ex.getMessage(),"MAL"), HttpStatus.OK);
        }

        return new ResponseEntity(new Mensaje("Creado con éxito.","OK"), HttpStatus.OK);
    }

    @PostMapping("/borrar")
    public ResponseEntity logearUsuario(@RequestBody Integer id) {
        try {
           
            educacionService.delete(id);
            return new ResponseEntity(new Mensaje("Borrado con éxito.","OK"), HttpStatus.OK);

            
        } catch (Exception ex) {
            return new ResponseEntity("ERROR: " + ex.getMessage(), HttpStatus.OK);
        }

    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity creacionExp(@PathVariable("id") Integer id) {
        try {
            Optional<Educacion> edu = educacionService.getOne(id);
            return new ResponseEntity(edu, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(new Mensaje("ERROR: " + ex.getMessage(),"MAL"), HttpStatus.OK);
        }

        //return new ResponseEntity(new Mensaje("Algo salió mal.","MAL"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity actualizar(@PathVariable("id") Integer id,@RequestBody Educacion expe) {
        try {
            //aca la ID viene directamente en el objeto del body
            educacionService.save(expe);

            return new ResponseEntity(new Mensaje("Modificado", "OK"), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(new Mensaje("ERROR: " + ex.getMessage(), "MAL"), HttpStatus.OK);
        }

    }


}
