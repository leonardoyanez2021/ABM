package cl.blueprintsit.business.authentication;

/**
 * Created by Blueprints on 2/19/2015.
 */
public class InvalidUserNameException extends Throwable {
    public InvalidUserNameException(String message) {
        super(message);
    }
}
