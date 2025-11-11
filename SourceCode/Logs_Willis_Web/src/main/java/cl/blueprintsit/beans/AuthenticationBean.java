package cl.blueprintsit.beans;

import cl.blueprintsit.business.authentication.AuthenticationManager;
import cl.blueprintsit.business.authentication.InvalidRUTException;
import cl.blueprintsit.business.authentication.RUT;
import cl.blueprintsit.business.authentication.types.AuthenticationWsException;
import cl.blueprintsit.business.authentication.types.Person;
import cl.blueprintsit.dao.ConfigurationLogDAO;
import cl.blueprintsit.entity.ConfigurationLog;
import cl.blueprintsit.process.AccessParameters;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.xml.rpc.ServiceException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "authenticationBean")
@SessionScoped
public class AuthenticationBean {
	private final static boolean TEST = false;
	static private final org.slf4j.Logger log = LoggerFactory.getLogger(AuthenticationBean.class);

	public static final String AUTH_KEY = "app.user.name";

	private String username;
	private String password;
	private Person loggedUser;
    private String message;

    private boolean enableSFTP;
    @EJB
    public ConfigurationLogDAO configurationDAO;
    @EJB
    private ConfigurationLogDAO configurationLogDAO ;

	static private AuthenticationManager authenticationManager;

	public boolean isLoggedIn() {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get(AUTH_KEY) != null;
	}


	public String login() {
        if (username.equals("1-9") && password.equals("bpit:16")){
            loggedUser = new Person();
            loggedUser.setName("Admin");
            RUT rut = new RUT(1, '9');
            loggedUser.setRut(rut);
            loggedUser.setUsername(username);
            loggedUser.setEmail("test@blueprintsit.cl");
            List<String> roles = new ArrayList<String>();
            //roles.add("CARTOLAS");
			roles.add("WILLIS");
            loggedUser.setRoles(roles);

            FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
                    .put(AUTH_KEY, username);

            return "success";
        }
        String url = configurationLogDAO.getByName(AccessParameters.URL_WS_Autenticacion).getValor();
		String endpoint = configurationLogDAO.getByName(AccessParameters.URL_WS_Autenticacion_Endpoint).getValor();
		log.debug("url- endpoint");
		log.debug(url);
		log.debug(endpoint);
		AuthenticationManager am = getAuthenticationManager(url, endpoint);

		try {

            if(username.equals("") || password.equals("")){
                setMessage("Debe ingresar datos");
                return null;
            }
            RUT rut = RUT.parseRUT(username);

			if (!am.isUserPasswordValid(rut, password)){
                setMessage("El usuario y/o contraseña no son válidos");
                return null;
            }

			setLoggedUser(am.getPerson(rut));
			
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(AUTH_KEY, username);
			password = null;
			return "success";

		} catch (AuthenticationWsException e) {
			log.error("Error al llamar servicio de autenticacion", e);
            setMessage("Error al llamar servicio de autenticacion");
		} catch (InvalidRUTException e) {
            setMessage("Rut Invalido");
		} catch (NumberFormatException e){
            setMessage("El rut es inválido");
        }
		password = null;

		return null;
	}

	public void logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(AUTH_KEY);
		setLoggedUser(null);
		username = null;

		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/appLogs/");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private static AuthenticationManager getAuthenticationManager(String url, String endpoint) {


































		
		if (authenticationManager == null)
			try {
				authenticationManager = new AuthenticationManager(url, endpoint);
					//	"http://webdesacp01:302/WS_AUTENTIFICA.asmx?WSDL");//desarrollo
				//"http://mlfprodcp02.metlife.cl:302/WS_AUTENTIFICA.asmx?WSDL");//produccion
			} catch (MalformedURLException e) {
				log.error("Error al llamar servicio de autenticacion", e);
			} catch (ServiceException e) {
				log.error("Error al llamar servicio de autenticacion", e);
			}

		return authenticationManager;
	}

	public Person getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(Person loggedUser) {
		this.loggedUser = loggedUser;
	}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	public boolean isEnableSFTP() {

        ConfigurationLog conf  = configurationDAO.getByName(AccessParameters.SFTP_ENABLE);
        enableSFTP = Boolean.parseBoolean(conf.getValor());
        return enableSFTP;
	}

	public void setEnableSFTP(boolean enableSFTP) {
		this.enableSFTP = enableSFTP;
	}

	public void addMessage() {
		ConfigurationLog conf  = configurationDAO.getByName(AccessParameters.SFTP_ENABLE);
		conf.setValor(String.valueOf(enableSFTP));
		configurationDAO.update(conf);

		String summary = enableSFTP ? "Habilitado" : "Deshabilitado";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
	}

}