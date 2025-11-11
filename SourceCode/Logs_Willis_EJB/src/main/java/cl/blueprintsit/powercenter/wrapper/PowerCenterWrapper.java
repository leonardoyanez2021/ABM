package cl.blueprintsit.powercenter.wrapper;

import cl.blueprintsit.powercenter.wrapper.exception.PowerCenterServiceException;
import cl.blueprintsit.powercenter.wrapper.pwrc.DataIntegrationServiceStub;
import com.informatica.wsh.*;
import javax.xml.ws.BindingProvider;
import java.rmi.RemoteException;
import java.util.Map;

/**
 * Created by Ivan on 02-02-2016.
 */
public class PowerCenterWrapper {


    private String token;


     private static void setEndpointAddress(Object port, String newAddress) {

        BindingProvider bp = (BindingProvider) port;
        Map<String, Object> context = bp.getRequestContext();
        context.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, newAddress);
    }


   /* private DataIntegrationServiceStub getWSReference(String wsdlUrl, String endpointAddress) throws Exception {
        String wsdlLocation = wsdlUrl;
        URL baseUrl;
        baseUrl = DataIntegrationServiceStub.class.getResource(".");

        //DataIntegrationServiceStub locator = null;
        URL url = null;

        try {
            url = new URL(baseUrl, wsdlLocation);
            String protocol = url.getProtocol();
            String userInfo = url.getUserInfo();
            DataIntegrationServiceStub locator = new DataIntegrationServiceStub();

             port = locator.getDataIntegration();
            setEndpointAddress(port, endpointAddress);

            return port;
        } catch (Exception e) {
            throw new Exception("Can't get DataIntegration WS reference");
        }

    }*/

/*    @WebMethod(operationName = "RunWorflow", action = "RunWorkflow")
    public void runWorkflow(@WebParam(name = "LoginDetails") LoginDetails loginDetails, @WebParam(name = "WorkflowDetails") WorkflowStartReqDetails wfDet) throws Exception{
        String wsdl = "http://MLFPWCDEV01.alico.corp:7333/wsh/services/BatchServices/DataIntegration?wsdl";
        String endpointAddress = "http://MLFPWCDEV01.alico.corp:7333/wsh/services/BatchServices/DataIntegration";
        DataIntegrationInterface wsRef = getWSReference(wsdl, endpointAddress);
        try {
            String sessionToken = getSessionToken(loginDetails, wsRef);
            startWorkflow(wfDet, sessionToken, wsRef);

            WorkflowRequest sWfReq = this.buildWorkflowRequest(wfDet);

            ////
            wsRef.waitTillWorkflowComplete(sWfReq);

            WorkflowDetails wsDetails = wsRef.getWorkflowDetails(sWfReq);

            if (wsDetails.getWorkflowRunStatus().compareTo(EWorkflowRunStatus.FAILED) == 0) {
                TaskRequest sTReq = new TaskRequest();

                DIServiceInfo dISI = new DIServiceInfo();
                dISI.setDomainName(wfDet.getDomainName());
                dISI.setServiceName(wfDet.getServiceName());
                sTReq.setDIServiceInfo(dISI);

                sTReq.setFolderName(wfDet.getFolderName());
                sTReq.setWorkflowName(wfDet.getWorkflowName());

                sTReq.setTaskInstancePath(wfDet.getTaskPath());
                TaskDetails taskDetails = wsRef.getTaskDetails(sTReq);

                taskDetails.getRunErrorMessage();
            } else {
                return;
            }
        }catch (Exception e) {
            throw e;
        }

    }*/



    /*private void startWorkflow(WorkflowStartReqDetails wfDet, String sessionToken, DataIntegrationInterface wsRef) throws Fault {
        WorkflowRequest sWfReq = buildWorkflowRequest(wfDet);
        VoidResponse sWfResp = wsRef.startWorkflow(sWfReq);
    }*/

/*
    private WorkflowRequest buildWorkflowRequest(WorkflowStartReqDetails wfDet) {
        WorkflowRequest sWfReq = new WorkflowRequest();

        DIServiceInfo dISI = new DIServiceInfo();
        dISI.setDomainName(wfDet.getDomainName());
        dISI.setServiceName(wfDet.getServiceName());
        sWfReq.setDIServiceInfo(dISI);

        sWfReq.setFolderName(wfDet.getFolderName());
        sWfReq.setWorkflowName(wfDet.getWorkflowName());

        sWfReq.setRequestMode(ETaskRunMode.NORMAL);
        sWfReq.setIsAbort(false);
        return sWfReq;

    }
    */


   /* private String getSessionToken(LoginDetails loginDetails, DataIntegrationInterface wsRef) throws Fault {
        LoginRequest loginData = new LoginRequest();
        loginData.setUserName(loginDetails.getUsername());
        loginData.setPassword(loginDetails.getPassword());
        loginData.setRepositoryDomainName(loginDetails.getRepoDomainName());
        loginData.setRepositoryName(loginDetails.getRepoName());

        String sessionToken = wsRef.login(loginData);
        return sessionToken;
    }
*/
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public String runWorkflow(String folderName, String workflowName, String domainName,
                              String serviceName,String repositoryDomainName,String repositoryName,
                              String username,String password, String endpoint) throws PowerCenterServiceException {
        try {
            //endpoint = "http://MLFPWCDEV01.alico.corp:7333/wsh/services/BatchServices/DataIntegration";
            DataIntegrationServiceStub dataIntegrationServiceStub = new DataIntegrationServiceStub(endpoint);
            String sessionId = getSessionId(dataIntegrationServiceStub, repositoryDomainName, repositoryName, username, password);

            ObjectFactory of = new ObjectFactory();
            WorkflowRequest workflowRequest = of.createWorkflowRequest();

            workflowRequest.setFolderName(folderName);
            workflowRequest.setWorkflowName(workflowName);

            DIServiceInfo diServiceInfo = of.createDIServiceInfo();
            diServiceInfo.setDomainName(domainName);
            diServiceInfo.setServiceName(serviceName);

            workflowRequest.setDIServiceInfo(diServiceInfo);

            workflowRequest.setRequestMode(ETaskRunMode.NORMAL);

            SessionHeader header = of.createSessionHeader();
            header.setSessionId(sessionId);

            dataIntegrationServiceStub.startWorkflow(workflowRequest,header);

            return "OK";

        }catch (Exception e){
            throw new PowerCenterServiceException(e.getMessage(),e);
        }
    }

    public String waitTillWorkflowComplete(String folderName, String workflowName, String domainName,
                              String serviceName,String repositoryDomainName,String repositoryName,
                              String username,String password, String endpoint) throws PowerCenterServiceException {
        try {
            // endpoint = "http://MLFPWCDEV01.alico.corp:7333/wsh/services/BatchServices/DataIntegration";
            DataIntegrationServiceStub dataIntegrationServiceStub = new DataIntegrationServiceStub(endpoint);
            String sessionId = getSessionId(dataIntegrationServiceStub, repositoryDomainName, repositoryName, username, password);

            ObjectFactory of = new ObjectFactory();
            WorkflowRequest workflowRequest = of.createWorkflowRequest();

            workflowRequest.setFolderName(folderName);
            workflowRequest.setWorkflowName(workflowName);

            DIServiceInfo diServiceInfo = of.createDIServiceInfo();
            diServiceInfo.setDomainName(domainName);
            diServiceInfo.setServiceName(serviceName);

            workflowRequest.setDIServiceInfo(diServiceInfo);

            workflowRequest.setRequestMode(ETaskRunMode.NORMAL);

            SessionHeader header = of.createSessionHeader();
            header.setSessionId(sessionId);

            VoidResponse response = dataIntegrationServiceStub.waitTillWorkflowComplete(workflowRequest,header);

            return "YES";

        } catch (Exception e){
            return "NO";
        }
    }

    public String workflowStatus(String folderName, String workflowName, String domainName,
                                           String serviceName,String repositoryDomainName,String repositoryName,
                                           String username,String password, String endpoint) throws PowerCenterServiceException {
        try {
            DataIntegrationServiceStub dataIntegrationServiceStub = new DataIntegrationServiceStub(endpoint);
            String sessionId = getSessionId(dataIntegrationServiceStub, repositoryDomainName, repositoryName, username, password);

            ObjectFactory of = new ObjectFactory();
            WorkflowRequest workflowRequest = of.createWorkflowRequest();

            workflowRequest.setFolderName(folderName);
            workflowRequest.setWorkflowName(workflowName);

            DIServiceInfo diServiceInfo = of.createDIServiceInfo();
            diServiceInfo.setDomainName(domainName);
            diServiceInfo.setServiceName(serviceName);

            workflowRequest.setDIServiceInfo(diServiceInfo);

            workflowRequest.setRequestMode(ETaskRunMode.NORMAL);

            SessionHeader header = of.createSessionHeader();
            header.setSessionId(sessionId);

            WorkflowDetails response = dataIntegrationServiceStub.getWorkflowDetails(workflowRequest,header);

            if(response.getWorkflowRunStatus().value().equals("SUCCEEDED")){
                return "success";
            } else if (response.getWorkflowRunStatus().value().equals("FAILED")){
                return "fail";
            } else {
                return "unnamed";
            }

        } catch (Exception e){
            return "exception";
        }
    }

    private String getSessionId(DataIntegrationServiceStub dataIntegrationServiceStub, String repositoryDomainName, String repositoryName, String username, String password)
            throws cl.blueprintsit.powercenter.wrapper.pwrc.Fault, PowerCenterServiceException {
        ObjectFactory of = new ObjectFactory();

        LoginRequest loginRequest = of.createLoginRequest();
        loginRequest.setRepositoryDomainName(repositoryDomainName);
        loginRequest.setRepositoryName(repositoryName);
        loginRequest.setUserName(username);
        loginRequest.setPassword(password);


        try {
            return dataIntegrationServiceStub.login(loginRequest);
        } catch (RemoteException e) {
            throw new PowerCenterServiceException("Excepcion remota"+e.getMessage(),e);
        }
    }

    public static void main(String[] args) {
        String name = "Lion";
        int score = 100;
        if(name.equals("Lion"))
            score = 200;
            name = "Larry";
    }


}
