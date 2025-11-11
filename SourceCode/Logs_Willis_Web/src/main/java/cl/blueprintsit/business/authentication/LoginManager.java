package cl.blueprintsit.business.authentication;

import cl.blueprintsit.business.authentication.types.AuthenticationWsException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Singleton;
import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Blueprints on 2/19/2015.
 */
@Singleton
public class LoginManager {

    public LoginManager() {
    }

    private static final Logger logger = LogManager.getLogger(LoginManager.class);
    /**
     *
     * @param username
     * @param password
     * @return
     * @throws InvalidUserNameException
     * @throws WrongPasswordException
     */
    public User login(String username, String password) throws InvalidUserNameException, WrongPasswordException, LoginException {

        /* pre-condiciones */
        if (username == null || username.trim().equals("")){
            throw new InvalidUserNameException("Nombre de usuario");
        }

        /* Se invoca el web-service */
        User user = null; // TODO: invocar ws.
        try {
            user = invokeLoginWebService(username, password);
        } catch (MalformedURLException e) {
            logger.error(e);
            throw new LoginException(e.getMessage(), e);
        }


        /* TODO: Here */
        return user;
    }

    private User invokeLoginWebService(String username, String password) throws WrongPasswordException, MalformedURLException {
        Properties prop = new Properties();
        InputStream input = null;
        String url="";
        try {
            input = new FileInputStream("config.properties");
            // load a properties file
            prop.load(input);
            url=prop.getProperty("AuthService");
            System.out.println("LoginManager AuthService="+url);
        } catch(Exception e){
            System.out.println("LoginManager.invokeLoginWebService() No se encuentra configurado el servicio de autentificacion");
        }

        try {
            // AuthenticationManager authenticationManager = new AuthenticationManager("http://mlfprodcp02.metlife.cl:302/WS_AUTENTIFICA.asmx?WSDL",
            //            																																				 "http://mlfprodcp02.metlife.cl:302/WS_AUTENTIFICA.asmx");
            //AuthenticationManager authenticationManager = new AuthenticationManager("http://webdesacp01:302/WS_AUTENTIFICA.asmx?WSDL");
            System.out.println(url);
            System.out.println(url+"?WSDL");

            AuthenticationManager authenticationManager = new AuthenticationManager(url+"?WSDL",url);
            RUT r = new RUT(15842225, '5');
            authenticationManager.isUserPasswordValid(r, password);

        } catch (ServiceException e) {
            logger.error(e);
        } catch (AuthenticationWsException e) {
            logger.error(e);
            throw new WrongPasswordException(e.getMessage());
        }

        return new User();
    }
}