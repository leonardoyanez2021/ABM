package cl.metlife.abm.ws.domain;

import cl.metlife.abm.domain.EInfoResult;
import cl.metlife.abm.mappers.MapperInfo;

public class InfoResult {
    // La estructura del XML response se define de la siguiente manera:


    // Numero = código de error. Cero indica correcto procesamiento de la búsqueda.
   private int numero;
    // Descripción = descripción del error en caso de existir.
    private String descripcion;
    //CantidadMovimientos = Cantidad de movimientos de la carga masiva.
    private int cantidadMovimientos;
    // MovimientosError = Cantidad de Movimientos con error.
    private int movimientosError;
    // MovimientosOk = Cantidad de Movimientos sin error.
    private int movimientosOk;
    // Solicitud = Solicitud asociada a la carga masiva. Siempre es una solicitud por carga masiva
    private Solicitud solicitud;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidadMovimientos() {
        return cantidadMovimientos;
    }

    public void setCantidadMovimientos(int cantidadMovimientos) {
        this.cantidadMovimientos = cantidadMovimientos;
    }

    public int getMovimientosError() {
        return movimientosError;
    }

    public void setMovimientosError(int movimientosError) {
        this.movimientosError = movimientosError;
    }

    public int getMovimientosOk() {
        return movimientosOk;
    }

    public void setMovimientosOk(int movimientosOk) {
        this.movimientosOk = movimientosOk;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }
// Solicitud.Id = Número de la solicitud.


    public InfoResult() {
        this.numero=0;
        this.descripcion="";
        this.cantidadMovimientos=0; //Cantidad de movimientos de la carga masiva.
        this.solicitud=new Solicitud();
        this.cantidadMovimientos=0; //Cantidad de movimientos de la carga masiva.
        this.movimientosError=0; //Cantidad de Movimientos con error.
        this.movimientosOk=0; //Cantidad de Movimientos sin error.
    }

    public InfoResult(ErrorNums numero, Solicitud s) {
        this.numero = numero.getId();
        this.descripcion = numero.getNameError();
        this.solicitud=new Solicitud(s);
        this.cantidadMovimientos=0; //Cantidad de movimientos de la carga masiva.
        this.movimientosError=0; //Cantidad de Movimientos con error.
        this.movimientosOk=0; //Cantidad de Movimientos sin error.

    }
    public InfoResult(EInfoResult e){

       this.copyObject(MapperInfo.mapperInfoResult(e));

    }
    private void copyObject(InfoResult i){
        this.numero=i.getNumero();
        this.descripcion=i.getDescripcion();
        this.cantidadMovimientos=i.getCantidadMovimientos();
        this.movimientosError=i.getMovimientosError();
        this.movimientosOk=i.getMovimientosOk();
        this.solicitud=i.getSolicitud();
    }

    @Override
    public String toString() {
        return "InfoResult{" +
                "numero=" + numero +
                ", descripcion='" + descripcion + '\'' +
                ", cantidadMovimientos=" + cantidadMovimientos +
                ", movimientosError=" + movimientosError +
                ", movimientosOk=" + movimientosOk +
                ", solicitud=" + solicitud.toString() +
                '}';
    }
}
