package ar.gob.argentinaprograma.julioc.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.gob.argentinaprograma.julioc.dto.Mensaje;
import ar.gob.argentinaprograma.julioc.entity.Habilidades;
import ar.gob.argentinaprograma.julioc.service.HabilidadesService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/habilidades")
public class HabilidadesController {

    @Autowired
    HabilidadesService habilidadesService;

    @GetMapping("/listado")
    public ResponseEntity obtenerTodos() {

        return new ResponseEntity(habilidadesService.list(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity creacionExp(@RequestBody Habilidades exper) {
        try {
            if (exper.getNombre() == null || exper.getPorcentaje() == null) {
                return new ResponseEntity(new Mensaje("Datos inválidos.","MAL"), HttpStatus.OK);
            }
            habilidadesService.save(exper);
        } catch (Exception ex) {
            return new ResponseEntity(new Mensaje("ERROR: " + ex.getMessage(),"MAL"), HttpStatus.OK);
        }

        return new ResponseEntity(new Mensaje("Creado con éxito.","OK"), HttpStatus.OK);
    }

    @PostMapping("/borrar")
    public ResponseEntity logearUsuario(@RequestBody Integer id) {
        try {
           
            habilidadesService.delete(id);
            return new ResponseEntity(new Mensaje("Borrado con éxito.","OK"), HttpStatus.OK);

            
        } catch (Exception ex) {
            return new ResponseEntity("ERROR: " + ex.getMessage(), HttpStatus.OK);
        }

        
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity creacionExp(@PathVariable("id") Integer id) {
        try {
            Optional<Habilidades> edu = habilidadesService.getOne(id);
            return new ResponseEntity(edu, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(new Mensaje("ERROR: " + ex.getMessage(),"MAL"), HttpStatus.OK);
        }

        //return new ResponseEntity(new Mensaje("Algo salió mal.","MAL"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity actualizar(@PathVariable("id") Integer id,@RequestBody Habilidades expe) {
        try {
            //aca la ID viene directamente en el objeto del body
            habilidadesService.save(expe);

            return new ResponseEntity(new Mensaje("Modificado", "OK"), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(new Mensaje("ERROR: " + ex.getMessage(), "MAL"), HttpStatus.OK);
        }

    }

}
