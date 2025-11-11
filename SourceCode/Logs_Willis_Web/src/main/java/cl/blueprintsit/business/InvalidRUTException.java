package cl.blueprintsit.business;

public class InvalidRUTException extends Exception {

    private static final long serialVersionUID = -8025216612842742607L;
    private String rut;

    public InvalidRUTException(String errorMessage, String aRUT) {
        super(errorMessage);
        this.rut = aRUT;
    }

    public InvalidRUTException(String errorMessage) {
        super(errorMessage);
    }

    public String getRut() {
        return rut;
    }
}