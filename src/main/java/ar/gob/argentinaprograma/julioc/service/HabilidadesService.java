package ar.gob.argentinaprograma.julioc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.gob.argentinaprograma.julioc.entity.Habilidades;
import ar.gob.argentinaprograma.julioc.entity.Usuario;
import ar.gob.argentinaprograma.julioc.repository.HabilidadesRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HabilidadesService {

    @Autowired
    HabilidadesRepository habRepository;

    public List<Habilidades> list(){
        return habRepository.findAll();
    }

    public Optional<Habilidades> getOne(int id){
        return habRepository.findById(id);
    }



    public void  save(Habilidades producto){
        habRepository.save(producto);
    }

    public void delete(int id){
        habRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return habRepository.existsById(id);
    }



}
