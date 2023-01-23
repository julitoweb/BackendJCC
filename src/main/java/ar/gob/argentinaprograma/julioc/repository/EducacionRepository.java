package ar.gob.argentinaprograma.julioc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.gob.argentinaprograma.julioc.entity.Educacion;

import java.util.Optional;

@Repository
public interface EducacionRepository extends JpaRepository<Educacion, Integer> {

}
