package ar.gob.argentinaprograma.julioc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.gob.argentinaprograma.julioc.entity.Experiencia;
import ar.gob.argentinaprograma.julioc.entity.Usuario;
import ar.gob.argentinaprograma.julioc.repository.ExperienciaRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExperienciaService {

    @Autowired
    ExperienciaRepository expRepository;

    public List<Experiencia> list(){
        return expRepository.findAll();
    }

    public Optional<Experiencia> getOne(int id){
        return expRepository.findById(id);
    }


    public void  save(Experiencia producto){
        expRepository.save(producto);
    }

    public void delete(int id){
        expRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return expRepository.existsById(id);
    }




}
