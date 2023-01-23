package ar.gob.argentinaprograma.julioc.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.gob.argentinaprograma.julioc.dto.Mensaje;
import ar.gob.argentinaprograma.julioc.entity.Experiencia;
import ar.gob.argentinaprograma.julioc.entity.Producto;
import ar.gob.argentinaprograma.julioc.service.ExperienciaService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/experiencia")
public class ExperienciaController {

    @Autowired
    ExperienciaService experienciaService;

    @GetMapping("/listado")
    public ResponseEntity obtenerTodos() {

        return new ResponseEntity(experienciaService.list(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity creacionExp(@RequestBody Experiencia exper) {
        try {
            if (exper.getContenido() == null || exper.getTitulo() == null) {
                return new ResponseEntity(new Mensaje("Datos incompletos.", "MAL"), HttpStatus.OK);
            }
            experienciaService.save(exper);
        } catch (Exception ex) {
            return new ResponseEntity(new Mensaje("ERROR: " + ex.getMessage(), "MAL"), HttpStatus.OK);
        }

        return new ResponseEntity(new Mensaje("Creado con éxito.", "OK"), HttpStatus.OK);
    }

    @PostMapping("/borrar")
    public ResponseEntity borrarExp(@RequestBody Integer id) {
        try {

            experienciaService.delete(id);
            return new ResponseEntity(new Mensaje("Borrado con éxito.", "OK"), HttpStatus.OK);

        } catch (Exception ex) {
            return new ResponseEntity("ERROR: " + ex.getMessage(), HttpStatus.OK);
        }

    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity creacionExp(@PathVariable("id") Integer id) {
        try {
            Optional<Experiencia> edu = experienciaService.getOne(id);
            return new ResponseEntity(edu, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(new Mensaje("ERROR: " + ex.getMessage(), "MAL"), HttpStatus.OK);
        }

        // return new ResponseEntity(new Mensaje("Algo salió mal.","MAL"),
        // HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity actualizar(@PathVariable("id") Integer id,@RequestBody Experiencia expe) {
        try {
            //aca la ID viene directamente en el objeto del body
            experienciaService.save(expe);

            return new ResponseEntity(new Mensaje("Modificado", "OK"), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(new Mensaje("ERROR: " + ex.getMessage(), "MAL"), HttpStatus.OK);
        }

    }

}
