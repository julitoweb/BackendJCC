package ar.gob.argentinaprograma.julioc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.gob.argentinaprograma.julioc.entity.Educacion;
import ar.gob.argentinaprograma.julioc.entity.Usuario;
import ar.gob.argentinaprograma.julioc.repository.EducacionRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EducacionService {

    @Autowired
    EducacionRepository educacionRepository;

    public List<Educacion> list(){
        return educacionRepository.findAll();
    }

    public Optional<Educacion> getOne(int id){
        return educacionRepository.findById(id);
    }


    public void  save(Educacion producto){
        educacionRepository.save(producto);
    }

    public void delete(int id){
        educacionRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return educacionRepository.existsById(id);
    }




}
