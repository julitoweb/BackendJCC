package ar.gob.argentinaprograma.julioc.dto;

public class Mensaje {
    private String mensaje;
    private String estado;

    public Mensaje() {
    }

    public Mensaje(String mensaje, String estado) {
        this.mensaje = mensaje;
        this.estado = estado;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
