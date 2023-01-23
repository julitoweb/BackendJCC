package ar.gob.argentinaprograma.julioc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo;
    private String contenido;
    private String imagenUrl;

    public Educacion() {
    }

    public Educacion(int id, String titulo, String contenido, String imagenUrl) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.imagenUrl = imagenUrl;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return this.contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Educacion id(int id) {
        setId(id);
        return this;
    }

    public Educacion titulo(String titulo) {
        setTitulo(titulo);
        return this;
    }

    public Educacion contenido(String contenido) {
        setContenido(contenido);
        return this;
    }


    public String getImagenUrl() {
        return this.imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

}
