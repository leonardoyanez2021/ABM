package cl.blueprintsit.business.authentication;

import java.net.MalformedURLException;

/**
 * Created by Blueprints on 2/19/2015.
 */
public class LoginException extends Throwable {
    public LoginException(String message, MalformedURLException e) {
        super(message, e);
    }
}
