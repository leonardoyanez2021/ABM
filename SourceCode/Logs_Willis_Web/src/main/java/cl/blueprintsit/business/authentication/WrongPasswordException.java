package cl.blueprintsit.business.authentication;

/**
 * Created by Blueprints on 2/19/2015.
 */
public class WrongPasswordException extends Exception {

    public WrongPasswordException(String message) {
        super(message);
    }
}
