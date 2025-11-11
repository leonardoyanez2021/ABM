package cl.metlife.abm.ws.domain;

public class Movimiento {
    Long id;
    int fila;
    int idError;
    String descripcion;
    long folio;

    public Movimiento(int fila, int id, String descripcion, int folio) {
        this.fila = fila;
        this.idError = id;
        this.descripcion = descripcion;
        this.folio = folio;
    }

    public Movimiento() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getIdError() {
        return idError;
    }

    public void setIdError(int idError) {
        this.idError = idError;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getFolio() {
        return folio;
    }

    public void setFolio(long folio) {
        this.folio = folio;
    }

    @Override
    public String toString() {
        return "Movimiento{" +
                "fila=" + fila +
                ", id=" + idError +
                ", descripcion='" + descripcion + '\'' +
                ", folio=" + folio +
                '}';
    }
}
