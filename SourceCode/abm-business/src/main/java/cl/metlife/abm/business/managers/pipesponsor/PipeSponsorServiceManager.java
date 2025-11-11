package cl.metlife.abm.business.managers.pipesponsor;

import cl.blueprintsit.framework.config.ConfigurationManager;
import cl.metlife.abm.business.managers.ABMConfigurationManager;
import cl.metlife.ws.clients.filenet.ConectorFileNetWSI;
import cl.metlife.ws.clients.filenet.FileNetWS;
import cl.metlife.ws.clients.pipesponsor.ISponsorMouleService;
import cl.metlife.ws.clients.pipesponsor.LogProcessDTO;
import cl.metlife.ws.clients.pipesponsor.SponsorModuleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
public class PipeSponsorServiceManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(PipeSponsorServiceManager.class);
    private final String WSDL_CONFIG_KEY = "pipesponsor.service.wsdl";
    private final String ENDPOINT_CONFIG_KEY = "pipesponsor.service.endpoint";

    @EJB
    ABMConfigurationManager configurationManager;



    public ISponsorMouleService getService()  {

            String wsdl_url = configurationManager.getByKey(WSDL_CONFIG_KEY).getValor();
            String endpoint_url = configurationManager.getByKey(ENDPOINT_CONFIG_KEY).getValor();

            SponsorModuleService service = null;

        try {
            service = new SponsorModuleService(new URL(wsdl_url) );
        } catch (MalformedURLException e) {

            e.printStackTrace();
        }

        ISponsorMouleService basicHttpBindingISponsorMouleService = service.getBasicHttpBindingISponsorMouleService();
            setEndpointAddress(basicHttpBindingISponsorMouleService, endpoint_url);

        return basicHttpBindingISponsorMouleService;
    }


    private void setEndpointAddress(Object port, String newAddress) {
        BindingProvider bp = (BindingProvider) port;
        Map<String, Object> context = bp.getRequestContext();
        context.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, newAddress);
    }

}
