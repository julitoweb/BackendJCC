package ar.gob.argentinaprograma.julioc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Habilidades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private Integer porcentaje;


    public Habilidades() {
    }

    public Habilidades(int id, String titulo, int porcentaje) {
        this.id = id;
        this.nombre = titulo;
        this.porcentaje = porcentaje;
    }


    public Habilidades(int id, String nombre, Integer porcentaje) {
        this.id = id;
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPorcentaje() {
        return this.porcentaje;
    }

    public void setPorcentaje(Integer porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Habilidades id(int id) {
        setId(id);
        return this;
    }

    public Habilidades nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Habilidades porcentaje(Integer porcentaje) {
        setPorcentaje(porcentaje);
        return this;
    }



}
