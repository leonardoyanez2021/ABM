	package cl.blueprintsit.business.authentication;

import cl.blueprintsit.business.authentication.auth.*;
import cl.blueprintsit.business.authentication.types.AuthenticationWsException;
import cl.blueprintsit.business.authentication.types.Person;
import org.w3c.dom.NodeList;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import javax.xml.ws.BindingProvider;
import javax.xml.xpath.*;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Ivan on 12-02-2015.
 */
public class AuthenticationManager {
    private final QName qname;
    private String wsdlUrl;
    ServiceSoap autPort;

    public AuthenticationManager(String wsdlUrl, String endpointUrl) throws MalformedURLException, ServiceException {
        this.wsdlUrl = wsdlUrl;
        this.qname = new QName("http://tempuri.org/", "Service");

        Service service = new Service();
        autPort = service.getServiceSoap();
        setEndpointAddress(autPort, endpointUrl);

        return;
    }



    private static void setEndpointAddress(Object port, String newAddress) {
        BindingProvider bp = (BindingProvider) port;
        Map<String, Object> context = bp.getRequestContext();
        context.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, newAddress);
    }

    public boolean isUserPasswordValid(RUT rut, String password) throws AuthenticationWsException {

        CheckClaveResponse.CheckClaveResult checkClaveResult = autPort.checkClave(rut.getNumber() + "", password, "1", "");


        try {

            String resultString = ((org.w3c.dom.Element) (checkClaveResult.getContent().get(0))).getFirstChild().getTextContent();

            if ("OK".equals(resultString))
                return true;

            if ("NOK".equals(resultString))
                return false;

        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthenticationWsException("Can't parse response. " + e.getMessage());
        }


        throw new AuthenticationWsException("Error desconocido");
    }

    public List<String> getUsersPersmissions(RUT rut) throws AuthenticationWsException {
        String idApp = "INT";
        String rutStr = rut.getNumber().toString() + rut.getVerifierNumber();
        ROLESPERSONARUTAPLICResponse.ROLESPERSONARUTAPLICResult result;
        try {
            result = autPort.rolesPERSONARUTAPLIC(idApp, rutStr);
            return  getGroupsFromResponse(result);
        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthenticationWsException("Remote Exception while executing remote method ROLES_PERSONA_RUT_APLIC. " + e.getMessage());
        }


    }
    private List<String> getGroupsFromResponse(ROLESPERSONARUTAPLICResponse.ROLESPERSONARUTAPLICResult result) throws XPathExpressionException {

        return xpathListExtractor(result.getContent().get(0), "/NewDataSet/Table/ROL_CODIGO/text()");
    }



    private String xpathExtractor(Object xml, String xpathStr) throws XPathExpressionException{

        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        XPathExpression expr = xpath.compile(xpathStr);

        return (String) expr.evaluate(xml, XPathConstants.STRING);

    }


    private List<String> xpathListExtractor(Object xml, String xpathStr) throws XPathExpressionException {


        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        XPathExpression expr = xpath.compile(xpathStr);

        NodeList nodes = (NodeList) expr.evaluate(xml, XPathConstants.NODESET);
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < nodes.getLength(); i++) {
            list.add(nodes.item(i).getNodeValue());
        }

        return list;

    }



    public boolean rutHasPermission(RUT rut, String permissionName) throws AuthenticationWsException {
        List<String> permissions = this.getUsersPersmissions(rut);
        for(String p : permissions) {
            if(p.equals(permissionName)){
                return true;
            }
        }
        return false;
    }

    public Person getPerson(RUT rut) throws AuthenticationWsException, InvalidRUTException {
        SpInfoPersonaResponse.SpInfoPersonaResult result = null;
        try {
            result = autPort.spInfoPersona(rut.getNumber().toString());
        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthenticationWsException("Remote Exception while executing remote method. sp_info_persona" + e.getMessage());
        }


        return makePersonFromResponse(result);

    }


    private Person makePersonFromResponse( SpInfoPersonaResponse.SpInfoPersonaResult result){

        try {
            String nombre = xpathExtractor(result.getAny(), "//NOMBRES/text()");
            String apaterno = xpathExtractor(result.getAny(), "//APPAT/text()");
            String amaterno = xpathExtractor(result.getAny(), "//APMAT/text()");
            String email = xpathExtractor(result.getAny(), "//CORREOELECTRONICO/text()");

            Person person = new Person();
            person.setName(nombre + " " + apaterno + " " +  amaterno);
            person.setEmail(email);


            String rutnumber = xpathExtractor(result.getAny(), "//RUT/text()");
            String rutDV = xpathExtractor(result.getAny(), "//DVRUT/text()");

            RUT rut2 = RUT.parseRUT( rutnumber + "-" + rutDV);
            person.setRut(rut2);
            person.setUsername(person.getEmail().split("@")[0]);


            return person;
        }catch (Exception e){
            return null;
        }

    }
}
