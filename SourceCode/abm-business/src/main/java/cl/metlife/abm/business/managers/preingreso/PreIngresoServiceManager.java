package cl.metlife.abm.business.managers.preingreso;

import cl.metlife.abm.business.managers.ABMConfigurationManager;
import cl.metlife.ws.clients.preingreso.session.SesionBo;
import cl.metlife.ws.clients.preingreso.session.WsSesion;
import cl.metlife.ws.clients.preingreso.session.WsSesionSoap;
import cl.metlife.ws.clients.preingreso.bulk.*;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 * Created by BluePrints Developer on 13-02-2017.
 */
@Singleton
public class PreIngresoServiceManager {

    private final String WSDL_CONFIG_KEY_SESSION = "preingreso.session.service.wsdl";
    private final String ENDPOINT_CONFIG_KEY_SESSION = "preingreso.session.service.endpoint";
    private final String WSDL_CONFIG_KEY_BULK = "preingreso.bulk.service.wsdl";
    private final String ENDPOINT_CONFIG_KEY_BULK = "preingreso.bulk.service.endpoint";
    private final String PREINGRESO_USER = "preingreso.service.username";
    private final String PREINGRESO_PASS = "preingreso.service.password";

    @EJB
    ABMConfigurationManager configurationManager;


    public String getSesionId() {
        String wsdl_url_session = configurationManager.getByKey(WSDL_CONFIG_KEY_SESSION).getValor();
        String endpoint_url_session = configurationManager.getByKey(ENDPOINT_CONFIG_KEY_SESSION).getValor();
        String user = configurationManager.getByKey(PREINGRESO_USER).getValor();
        String pass = configurationManager.getByKey(PREINGRESO_PASS).getValor();

        WsSesionSoap session = null;
        WsBulkSoap wsBulk = null;
        try {
            session = new WsSesion(new URL(wsdl_url_session), new QName("http://preingreso.metlife.cl/", "WsSesion")).getWsSesionSoap12();
            setEndpointAddress(session, endpoint_url_session);
            SesionBo sesionBo = session.logon(user, pass);

            return sesionBo.getId();
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error al iniciar la sesión de PreIngreso", e);
        }
    }

    public void logout(String string) {
        String wsdl_url_session = configurationManager.getByKey(WSDL_CONFIG_KEY_SESSION).getValor();
        String endpoint_url_session = configurationManager.getByKey(ENDPOINT_CONFIG_KEY_SESSION).getValor();
        String user = configurationManager.getByKey(PREINGRESO_USER).getValor();
        String pass = configurationManager.getByKey(PREINGRESO_PASS).getValor();

        WsSesionSoap session = null;
        WsBulkSoap wsBulk = null;
        try {
            session = new WsSesion(new URL(wsdl_url_session), new QName("http://preingreso.metlife.cl/", "WsSesion")).getWsSesionSoap12();
            setEndpointAddress(session, endpoint_url_session);

            cl.metlife.ws.clients.preingreso.session.ErrorBo errorBo = session.logout(string);

            return;

        } catch (MalformedURLException e) {
            throw new RuntimeException("Error al desloguear la sesión de PreIngreso", e);
        }
    }

    public WsBulkSoap getBulkService(String id) {
        String wsdl_url_bulk = configurationManager.getByKey(WSDL_CONFIG_KEY_BULK).getValor();
        String endpoint_url_bulk = configurationManager.getByKey(ENDPOINT_CONFIG_KEY_BULK).getValor();


        WsBulkSoap wsBulk = null;
        wsBulk = new WsBulk().getWsBulkSoap12();
        setEndpointAddress(wsBulk, endpoint_url_bulk);
        return wsBulk;
    }
    public WsBulkSoap getBulkService() {
        String wsdl_url_bulk = configurationManager.getByKey(WSDL_CONFIG_KEY_BULK).getValor();
        String endpoint_url_bulk = configurationManager.getByKey(ENDPOINT_CONFIG_KEY_BULK).getValor();

        WsBulkSoap wsBulk = null;
        wsBulk = new WsBulk().getWsBulkSoap12();
        setEndpointAddress(wsBulk, endpoint_url_bulk);
        return wsBulk;
    }


    private void setEndpointAddress(Object port, String newAddress) {
        BindingProvider bp = (BindingProvider) port;
        Map<String, Object> context = bp.getRequestContext();
        context.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, newAddress);
    }

}
