/**
 * DataIntegrationServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */
package cl.blueprintsit.powercenter.wrapper.pwrc;

/**
 * DataIntegrationServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */

import org.apache.axis2.AxisFault;
import org.apache.axis2.client.FaultMapKey;
import org.apache.axis2.client.Stub;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.description.AxisOperation;
import org.apache.axis2.description.AxisService;
import org.apache.axis2.description.OutInAxisOperation;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/*
 *  DataIntegrationServiceStub java implementation
 */
public class DataIntegrationServiceStub extends Stub {
    private static int counter = 0;
    private static String DataIntegrationWS;

    //http://MLFPWCDEV01:7333/wsh/services/BatchServices/DataIntegration
    private static final javax.xml.bind.JAXBContext wsContext;

    static {
        javax.xml.bind.JAXBContext jc;
        jc = null;

        try {
            jc = javax.xml.bind.JAXBContext.newInstance(com.informatica.wsh.VoidRequest.class,
                    com.informatica.wsh.VoidResponse.class,
                    com.informatica.wsh.FaultDetails.class,
                    com.informatica.wsh.SessionHeader.class,
                    com.informatica.wsh.GetNextLogSegmentRequest.class,
                    com.informatica.wsh.LogSegment.class,
                    com.informatica.wsh.InitializeDIServerConnectionRequest.class,
                    com.informatica.wsh.PingDIServerRequest.class,
                    com.informatica.wsh.EPingState.class,
                    com.informatica.wsh.StartWorkflowLogFetchRequest.class,
                    int.class, com.informatica.wsh.GetSessionLogRequest.class,
                    com.informatica.wsh.Log.class,
                    com.informatica.wsh.WorkflowRequest.class,
                    com.informatica.wsh.GetSessionStatisticsRequest.class,
                    com.informatica.wsh.SessionStatistics.class,
                    com.informatica.wsh.WorkflowDetails.class,
                    com.informatica.wsh.LoginRequest.class,
                    String.class,
                    com.informatica.wsh.StartSessionLogFetchRequest.class,
                    com.informatica.wsh.GetWorkflowLogRequest.class,
                    com.informatica.wsh.TaskRequest.class,
                    com.informatica.wsh.GetSessionPerformanceDataRequest.class,
                    com.informatica.wsh.SessionPerformanceData.class,
                    com.informatica.wsh.TypeStartWorkflowExRequest.class,
                    com.informatica.wsh.TypeStartWorkflowExResponse.class,
                    com.informatica.wsh.TypeGetTaskDetailsExRequest.class,
                    com.informatica.wsh.DIServerDetails.class,
                    com.informatica.wsh.TypeGetWorkflowDetailsExRequest.class,
                    com.informatica.wsh.MonitorDIServerRequest.class,
                    com.informatica.wsh.TaskDetails.class,
                    com.informatica.wsh.DIServiceInfo.class,
                    com.informatica.wsh.DIServerProperties.class);
        } catch (javax.xml.bind.JAXBException ex) {
            System.err.println("Unable to create JAXBContext: " +
                    ex.getMessage());
            ex.printStackTrace(System.err);
            Runtime.getRuntime().exit(-1);
        } finally {
            wsContext = jc;
        }

        Properties prop = new Properties();
        InputStream input = null;
        String url="";
        try {
            input = new FileInputStream("config.properties");
            // load a properties file
            prop.load(input);
            url=prop.getProperty("WsDataIntegration");
            System.out.println("DataIntegrationServiceStub WsDataIntegration="+url);
        } catch(Exception e){
            System.out.println("DataIntegrationServiceStub.Static() No se encuentra configurado el servicio de autentificacion");
        }
        DataIntegrationWS=url;
    }

    protected AxisOperation[] _operations;

    //hashmaps to keep the fault mapping
    private java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
    private java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
    private java.util.HashMap faultMessageMap = new java.util.HashMap();
    private javax.xml.namespace.QName[] opNameArray = null;

    /**
     *Constructor that takes in a configContext
     */
    public DataIntegrationServiceStub(
            ConfigurationContext configurationContext,
            String targetEndpoint) throws AxisFault {
        this(configurationContext, targetEndpoint, false);
    }

    /**
     * Constructor that takes in a configContext  and useseperate listner
     */
    public DataIntegrationServiceStub(
            ConfigurationContext configurationContext,
            String targetEndpoint, boolean useSeparateListener)
            throws AxisFault {
        //To populate AxisService
        populateAxisService();
        populateFaults();

        _serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext,
                _service);

        _serviceClient.getOptions()
                .setTo(new org.apache.axis2.addressing.EndpointReference(
                        targetEndpoint));
        _serviceClient.getOptions().setUseSeparateListener(useSeparateListener);
    }

    /**
     * Default Constructor
     */
    public DataIntegrationServiceStub(
            ConfigurationContext configurationContext)
            throws AxisFault {
        //this(configurationContext,"http://MLFPWCDEV01:7333/wsh/services/BatchServices/DataIntegration");
        this(configurationContext, DataIntegrationWS);
    }

    /**
     * Default Constructor
     */
    public DataIntegrationServiceStub() throws AxisFault {
        //this("http://MLFPWCDEV01:7333/wsh/services/BatchServices/DataIntegration");
        this(DataIntegrationWS);
    }

    /**
     * Constructor taking the target endpoint
     */
    public DataIntegrationServiceStub(String targetEndpoint)
            throws AxisFault {
        this(null, targetEndpoint);
    }

    private static synchronized String getUniqueSuffix() {
        // reset the counter if it is greater than 99999
        if (counter > 99999) {
            counter = 0;
        }

        counter = counter + 1;

        return Long.toString(System.currentTimeMillis()) +
                "_" + counter;
    }

    private void populateAxisService() throws AxisFault {
        //creating the Service with a unique name
        _service = new AxisService(
                "DataIntegrationService" + getUniqueSuffix());
        addAnonymousOperations();

        //creating the operations
        AxisOperation __operation;

        _operations = new AxisOperation[30];

        __operation = new OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://www.informatica.com/wsh",
                "deinitializeDIServerConnection"));
        _service.addOperation(__operation);

        _operations[0] = __operation;

        __operation = new OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://www.informatica.com/wsh", "getNextLogSegment"));
        _service.addOperation(__operation);

        _operations[1] = __operation;

        __operation = new OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://www.informatica.com/wsh", "initializeDIServerConnection"));
        _service.addOperation(__operation);

        _operations[2] = __operation;

        __operation = new OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://www.informatica.com/wsh", "pingDIServer"));
        _service.addOperation(__operation);

        _operations[3] = __operation;

        __operation = new OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://www.informatica.com/wsh", "startWorkflowLogFetch"));
        _service.addOperation(__operation);

        _operations[4] = __operation;

        __operation = new OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://www.informatica.com/wsh", "getSessionLog"));
        _service.addOperation(__operation);

        _operations[5] = __operation;

        __operation = new OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://www.informatica.com/wsh", "stopWorkflow"));
        _service.addOperation(__operation);

        _operations[6] = __operation;

        __operation = new OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://www.informatica.com/wsh", "waitTillWorkflowComplete"));
        _service.addOperation(__operation);

        _operations[7] = __operation;

        __operation = new OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://www.informatica.com/wsh", "recoverWorkflow"));
        _service.addOperation(__operation);

        _operations[8] = __operation;

        __operation = new OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://www.informatica.com/wsh", "getSessionStatistics"));
        _service.addOperation(__operation);

        _operations[9] = __operation;

        __operation = new OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://www.informatica.com/wsh", "getWorkflowDetails"));
        _service.addOperation(__operation);

        _operations[10] = __operation;

        __operation = new OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://www.informatica.com/wsh", "login"));
        _service.addOperation(__operation);

        _operations[11] = __operation;

        __operation = new OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://www.informatica.com/wsh", "scheduleWorkflow"));
        _service.addOperation(__operation);

        _operations[12] = __operation;

        __operation = new OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://www.informatica.com/wsh", "resumeWorkflow"));
        _service.addOperation(__operation);

        _operations[13] = __operation;

        __operation = new OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://www.informatica.com/wsh", "startSessionLogFetch"));
        _service.addOperation(__operation);

        _operations[14] = __operation;

        __operation = new OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://www.informatica.com/wsh", "getWorkflowLog"));
        _service.addOperation(__operation);

        _operations[15] = __operation;

        __operation = new OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://www.informatica.com/wsh", "startWorkflow"));
        _service.addOperation(__operation);

        _operations[16] = __operation;

        __operation = new OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://www.informatica.com/wsh", "stopTask"));
        _service.addOperation(__operation);

        _operations[17] = __operation;

        __operation = new OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://www.informatica.com/wsh", "startTask"));
        _service.addOperation(__operation);

        _operations[18] = __operation;

        __operation = new OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://www.informatica.com/wsh", "getSessionPerformanceData"));
        _service.addOperation(__operation);

        _operations[19] = __operation;

        __operation = new OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://www.informatica.com/wsh", "startWorkflowEx"));
        _service.addOperation(__operation);

        _operations[20] = __operation;

        __operation = new OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://www.informatica.com/wsh", "getTaskDetailsEx"));
        _service.addOperation(__operation);

        _operations[21] = __operation;

        __operation = new OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://www.informatica.com/wsh", "startWorkflowFromTask"));
        _service.addOperation(__operation);

        _operations[22] = __operation;

        __operation = new OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://www.informatica.com/wsh", "logout"));
        _service.addOperation(__operation);

        _operations[23] = __operation;

        __operation = new OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://www.informatica.com/wsh", "getWorkflowDetailsEx"));
        _service.addOperation(__operation);

        _operations[24] = __operation;

        __operation = new OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://www.informatica.com/wsh", "monitorDIServer"));
        _service.addOperation(__operation);

        _operations[25] = __operation;

        __operation = new OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://www.informatica.com/wsh", "waitTillTaskComplete"));
        _service.addOperation(__operation);

        _operations[26] = __operation;

        __operation = new OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://www.informatica.com/wsh", "getTaskDetails"));
        _service.addOperation(__operation);

        _operations[27] = __operation;

        __operation = new OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://www.informatica.com/wsh", "getDIServerProperties"));
        _service.addOperation(__operation);

        _operations[28] = __operation;

        __operation = new OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://www.informatica.com/wsh", "unscheduleWorkflow"));
        _service.addOperation(__operation);

        _operations[29] = __operation;
    }

    //populates the faults
    private void populateFaults() {
        faultExceptionNameMap.put(new FaultMapKey(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh", "WSHFaultDetails"),
                        "deinitializeDIServerConnection"),
                "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultExceptionClassNameMap.put(new FaultMapKey(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh", "WSHFaultDetails"),
                        "deinitializeDIServerConnection"),
                "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultMessageMap.put(new FaultMapKey(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh", "WSHFaultDetails"),
                        "deinitializeDIServerConnection"),
                "com.informatica.wsh.FaultDetails");

        faultExceptionNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "getNextLogSegment"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultExceptionClassNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "getNextLogSegment"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultMessageMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "getNextLogSegment"), "com.informatica.wsh.FaultDetails");

        faultExceptionNameMap.put(new FaultMapKey(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh", "WSHFaultDetails"),
                        "initializeDIServerConnection"),
                "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultExceptionClassNameMap.put(new FaultMapKey(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh", "WSHFaultDetails"),
                        "initializeDIServerConnection"),
                "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultMessageMap.put(new FaultMapKey(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh", "WSHFaultDetails"),
                        "initializeDIServerConnection"),
                "com.informatica.wsh.FaultDetails");

        faultExceptionNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "pingDIServer"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultExceptionClassNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "pingDIServer"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultMessageMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "pingDIServer"), "com.informatica.wsh.FaultDetails");

        faultExceptionNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "startWorkflowLogFetch"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultExceptionClassNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "startWorkflowLogFetch"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultMessageMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "startWorkflowLogFetch"), "com.informatica.wsh.FaultDetails");

        faultExceptionNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "getSessionLog"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultExceptionClassNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "getSessionLog"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultMessageMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "getSessionLog"), "com.informatica.wsh.FaultDetails");

        faultExceptionNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "stopWorkflow"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultExceptionClassNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "stopWorkflow"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultMessageMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "stopWorkflow"), "com.informatica.wsh.FaultDetails");

        faultExceptionNameMap.put(new FaultMapKey(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh", "WSHFaultDetails"),
                        "waitTillWorkflowComplete"),
                "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultExceptionClassNameMap.put(new FaultMapKey(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh", "WSHFaultDetails"),
                        "waitTillWorkflowComplete"),
                "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultMessageMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "waitTillWorkflowComplete"), "com.informatica.wsh.FaultDetails");

        faultExceptionNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "recoverWorkflow"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultExceptionClassNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "recoverWorkflow"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultMessageMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "recoverWorkflow"), "com.informatica.wsh.FaultDetails");

        faultExceptionNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "getSessionStatistics"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultExceptionClassNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "getSessionStatistics"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultMessageMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "getSessionStatistics"), "com.informatica.wsh.FaultDetails");

        faultExceptionNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "getWorkflowDetails"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultExceptionClassNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "getWorkflowDetails"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultMessageMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "getWorkflowDetails"), "com.informatica.wsh.FaultDetails");

        faultExceptionNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "login"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultExceptionClassNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "login"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultMessageMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "login"), "com.informatica.wsh.FaultDetails");

        faultExceptionNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "scheduleWorkflow"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultExceptionClassNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "scheduleWorkflow"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultMessageMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "scheduleWorkflow"), "com.informatica.wsh.FaultDetails");

        faultExceptionNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "resumeWorkflow"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultExceptionClassNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "resumeWorkflow"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultMessageMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "resumeWorkflow"), "com.informatica.wsh.FaultDetails");

        faultExceptionNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "startSessionLogFetch"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultExceptionClassNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "startSessionLogFetch"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultMessageMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "startSessionLogFetch"), "com.informatica.wsh.FaultDetails");

        faultExceptionNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "getWorkflowLog"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultExceptionClassNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "getWorkflowLog"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultMessageMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "getWorkflowLog"), "com.informatica.wsh.FaultDetails");

        faultExceptionNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "startWorkflow"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultExceptionClassNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "startWorkflow"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultMessageMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "startWorkflow"), "com.informatica.wsh.FaultDetails");

        faultExceptionNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "stopTask"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultExceptionClassNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "stopTask"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultMessageMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "stopTask"), "com.informatica.wsh.FaultDetails");

        faultExceptionNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "startTask"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultExceptionClassNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "startTask"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultMessageMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "startTask"), "com.informatica.wsh.FaultDetails");

        faultExceptionNameMap.put(new FaultMapKey(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh", "WSHFaultDetails"),
                        "getSessionPerformanceData"),
                "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultExceptionClassNameMap.put(new FaultMapKey(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh", "WSHFaultDetails"),
                        "getSessionPerformanceData"),
                "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultMessageMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "getSessionPerformanceData"), "com.informatica.wsh.FaultDetails");

        faultExceptionNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "startWorkflowEx"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultExceptionClassNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "startWorkflowEx"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultMessageMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "startWorkflowEx"), "com.informatica.wsh.FaultDetails");

        faultExceptionNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "getTaskDetailsEx"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultExceptionClassNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "getTaskDetailsEx"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultMessageMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "getTaskDetailsEx"), "com.informatica.wsh.FaultDetails");

        faultExceptionNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "startWorkflowFromTask"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultExceptionClassNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "startWorkflowFromTask"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultMessageMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "startWorkflowFromTask"), "com.informatica.wsh.FaultDetails");

        faultExceptionNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "logout"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultExceptionClassNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "logout"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultMessageMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "logout"), "com.informatica.wsh.FaultDetails");

        faultExceptionNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "getWorkflowDetailsEx"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultExceptionClassNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "getWorkflowDetailsEx"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultMessageMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "getWorkflowDetailsEx"), "com.informatica.wsh.FaultDetails");

        faultExceptionNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "monitorDIServer"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultExceptionClassNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "monitorDIServer"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultMessageMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "monitorDIServer"), "com.informatica.wsh.FaultDetails");

        faultExceptionNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "waitTillTaskComplete"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultExceptionClassNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "waitTillTaskComplete"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultMessageMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "waitTillTaskComplete"), "com.informatica.wsh.FaultDetails");

        faultExceptionNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "getTaskDetails"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultExceptionClassNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "getTaskDetails"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultMessageMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "getTaskDetails"), "com.informatica.wsh.FaultDetails");

        faultExceptionNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "getDIServerProperties"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultExceptionClassNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "getDIServerProperties"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultMessageMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "getDIServerProperties"), "com.informatica.wsh.FaultDetails");

        faultExceptionNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "unscheduleWorkflow"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultExceptionClassNameMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "unscheduleWorkflow"), "cl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault");
        faultMessageMap.put(new FaultMapKey(
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "WSHFaultDetails"),
                "unscheduleWorkflow"), "com.informatica.wsh.FaultDetails");
    }

    /**
     * Auto generated method signature
     *
     * @see DataIntegrationService#deinitializeDIServerConnection
     * @param deinitializeDIServerConnection28
     * @param context29
     * @throwscl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault :
     */
    public com.informatica.wsh.VoidResponse deinitializeDIServerConnection(
            com.informatica.wsh.VoidRequest deinitializeDIServerConnection28,
            com.informatica.wsh.SessionHeader context29)
            throws java.rmi.RemoteException, Fault {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
            _operationClient.getOptions()
                    .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/DeinitializeDIServerConnectionRequest");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                    "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                            .getSoapVersionURI()),
                    deinitializeDIServerConnection28,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh",
                                    "deinitializeDIServerConnection")),
                    new javax.xml.namespace.QName(
                            "http://www.informatica.com/wsh",
                            "deinitializeDIServerConnection"));

            env.build();

            // add the children only if the parameter is not null
            if (context29 != null) {
                org.apache.axiom.om.OMElement omElementcontext29 = toOM(context29,
                        optimizeContent(
                                new javax.xml.namespace.QName(
                                        "http://www.informatica.com/wsh",
                                        "deinitializeDIServerConnection")));
                addHeader(omElementcontext29, env);
            }

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            Object object = fromOM(_returnEnv.getBody()
                            .getFirstElement(),
                    com.informatica.wsh.VoidResponse.class,
                    getEnvelopeNamespaces(_returnEnv));

            return (com.informatica.wsh.VoidResponse) object;
        } catch (AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                        new FaultMapKey(
                                faultElt.getQName(),
                                "deinitializeDIServerConnection"))) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                faultElt.getQName(),
                                "deinitializeDIServerConnection"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        Exception ex = (Exception) constructor.newInstance(f.getMessage());

                        //message class
                        String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                faultElt.getQName(),
                                "deinitializeDIServerConnection"));
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        if (ex instanceof Fault) {
                            throw (Fault) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                        .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see DataIntegrationService#startdeinitializeDIServerConnection
     * @param deinitializeDIServerConnection28
     * @param context29
     */
    public void startdeinitializeDIServerConnection(
            com.informatica.wsh.VoidRequest deinitializeDIServerConnection28,
            com.informatica.wsh.SessionHeader context29,
            final DataIntegrationServiceCallbackHandler callback)
            throws java.rmi.RemoteException {
        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
        _operationClient.getOptions()
                .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/DeinitializeDIServerConnectionRequest");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(_operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        //Style is Doc.
        env = toEnvelope(getFactory(_operationClient.getOptions()
                        .getSoapVersionURI()),
                deinitializeDIServerConnection28,
                optimizeContent(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh",
                                "deinitializeDIServerConnection")),
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh",
                        "deinitializeDIServerConnection"));

        // add the soap_headers only if they are not null
        if (context29 != null) {
            org.apache.axiom.om.OMElement omElementcontext29 = toOM(context29,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh",
                                    "deinitializeDIServerConnection")));
            addHeader(omElementcontext29, env);
        }

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(
                    org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    Object object = fromOM(resultEnv.getBody()
                                    .getFirstElement(),
                            com.informatica.wsh.VoidResponse.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultdeinitializeDIServerConnection((com.informatica.wsh.VoidResponse) object);
                } catch (AxisFault e) {
                    callback.receiveErrordeinitializeDIServerConnection(e);
                }
            }

            public void onError(Exception error) {
                if (error instanceof AxisFault) {
                    AxisFault f = (AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();

                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(
                                new FaultMapKey(
                                        faultElt.getQName(),
                                        "deinitializeDIServerConnection"))) {
                            //make the fault by reflection
                            try {
                                String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "deinitializeDIServerConnection"));
                                Class exceptionClass = Class.forName(exceptionClassName);
                                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                Exception ex = (Exception) constructor.newInstance(f.getMessage());

                                //message class
                                String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "deinitializeDIServerConnection"));
                                Class messageClass = Class.forName(messageClassName);
                                Object messageObject = fromOM(faultElt,
                                        messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new Class[] { messageClass });
                                m.invoke(ex,
                                        new Object[] { messageObject });

                                if (ex instanceof Fault) {
                                    callback.receiveErrordeinitializeDIServerConnection((Fault) ex);

                                    return;
                                }

                                callback.receiveErrordeinitializeDIServerConnection(new java.rmi.RemoteException(
                                        ex.getMessage(), ex));
                            } catch (ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrordeinitializeDIServerConnection(f);
                            } catch (ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrordeinitializeDIServerConnection(f);
                            } catch (NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrordeinitializeDIServerConnection(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrordeinitializeDIServerConnection(f);
                            } catch (IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrordeinitializeDIServerConnection(f);
                            } catch (InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrordeinitializeDIServerConnection(f);
                            } catch (AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrordeinitializeDIServerConnection(f);
                            }
                        } else {
                            callback.receiveErrordeinitializeDIServerConnection(f);
                        }
                    } else {
                        callback.receiveErrordeinitializeDIServerConnection(f);
                    }
                } else {
                    callback.receiveErrordeinitializeDIServerConnection(error);
                }
            }

            public void onFault(
                    org.apache.axis2.context.MessageContext faultContext) {
                AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender()
                            .cleanup(_messageContext);
                } catch (AxisFault axisFault) {
                    callback.receiveErrordeinitializeDIServerConnection(axisFault);
                }
            }
        });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

        if ((_operations[0].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[0].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);
    }

    /**
     * Auto generated method signature
     *
     * @see DataIntegrationService#getNextLogSegment
     * @param getNextLogSegment31
     * @param context32
     * @throws Fault :
     */
    public com.informatica.wsh.LogSegment getNextLogSegment(
            com.informatica.wsh.GetNextLogSegmentRequest getNextLogSegment31,
            com.informatica.wsh.SessionHeader context32)
            throws java.rmi.RemoteException,Fault {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
            _operationClient.getOptions()
                    .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/GetNextLogSegmentRequest");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                    "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                            .getSoapVersionURI()),
                    getNextLogSegment31,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh",
                                    "getNextLogSegment")),
                    new javax.xml.namespace.QName(
                            "http://www.informatica.com/wsh", "getNextLogSegment"));

            env.build();

            // add the children only if the parameter is not null
            if (context32 != null) {
                org.apache.axiom.om.OMElement omElementcontext32 = toOM(context32,
                        optimizeContent(
                                new javax.xml.namespace.QName(
                                        "http://www.informatica.com/wsh",
                                        "getNextLogSegment")));
                addHeader(omElementcontext32, env);
            }

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            Object object = fromOM(_returnEnv.getBody()
                            .getFirstElement(),
                    com.informatica.wsh.LogSegment.class,
                    getEnvelopeNamespaces(_returnEnv));

            return (com.informatica.wsh.LogSegment) object;
        } catch (AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                        new FaultMapKey(
                                faultElt.getQName(), "getNextLogSegment"))) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                faultElt.getQName(), "getNextLogSegment"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        Exception ex = (Exception) constructor.newInstance(f.getMessage());

                        //message class
                        String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                faultElt.getQName(), "getNextLogSegment"));
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        if (ex instanceof Fault) {
                            throw (Fault) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                        .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see DataIntegrationService#startgetNextLogSegment
     * @param getNextLogSegment31
     * @param context32
     */
    public void startgetNextLogSegment(
            com.informatica.wsh.GetNextLogSegmentRequest getNextLogSegment31,
            com.informatica.wsh.SessionHeader context32,
            final DataIntegrationServiceCallbackHandler callback)
            throws java.rmi.RemoteException {
        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
        _operationClient.getOptions()
                .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/GetNextLogSegmentRequest");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(_operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        //Style is Doc.
        env = toEnvelope(getFactory(_operationClient.getOptions()
                        .getSoapVersionURI()),
                getNextLogSegment31,
                optimizeContent(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh", "getNextLogSegment")),
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "getNextLogSegment"));

        // add the soap_headers only if they are not null
        if (context32 != null) {
            org.apache.axiom.om.OMElement omElementcontext32 = toOM(context32,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh",
                                    "getNextLogSegment")));
            addHeader(omElementcontext32, env);
        }

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(
                    org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    Object object = fromOM(resultEnv.getBody()
                                    .getFirstElement(),
                            com.informatica.wsh.LogSegment.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultgetNextLogSegment((com.informatica.wsh.LogSegment) object);
                } catch (AxisFault e) {
                    callback.receiveErrorgetNextLogSegment(e);
                }
            }

            public void onError(Exception error) {
                if (error instanceof AxisFault) {
                    AxisFault f = (AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();

                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(
                                new FaultMapKey(
                                        faultElt.getQName(),
                                        "getNextLogSegment"))) {
                            //make the fault by reflection
                            try {
                                String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "getNextLogSegment"));
                                Class exceptionClass = Class.forName(exceptionClassName);
                                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                Exception ex = (Exception) constructor.newInstance(f.getMessage());

                                //message class
                                String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "getNextLogSegment"));
                                Class messageClass = Class.forName(messageClassName);
                                Object messageObject = fromOM(faultElt,
                                        messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new Class[] { messageClass });
                                m.invoke(ex,
                                        new Object[] { messageObject });

                                if (ex instanceof Fault) {
                                    callback.receiveErrorgetNextLogSegment((Fault) ex);

                                    return;
                                }

                                callback.receiveErrorgetNextLogSegment(new java.rmi.RemoteException(
                                        ex.getMessage(), ex));
                            } catch (ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetNextLogSegment(f);
                            } catch (ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetNextLogSegment(f);
                            } catch (NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetNextLogSegment(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetNextLogSegment(f);
                            } catch (IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetNextLogSegment(f);
                            } catch (InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetNextLogSegment(f);
                            } catch (AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetNextLogSegment(f);
                            }
                        } else {
                            callback.receiveErrorgetNextLogSegment(f);
                        }
                    } else {
                        callback.receiveErrorgetNextLogSegment(f);
                    }
                } else {
                    callback.receiveErrorgetNextLogSegment(error);
                }
            }

            public void onFault(
                    org.apache.axis2.context.MessageContext faultContext) {
                AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender()
                            .cleanup(_messageContext);
                } catch (AxisFault axisFault) {
                    callback.receiveErrorgetNextLogSegment(axisFault);
                }
            }
        });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

        if ((_operations[1].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[1].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);
    }

    /**
     * Auto generated method signature
     *
     * @see DataIntegrationService#initializeDIServerConnection
     * @param initializeDIServerConnection34
     * @param context35
     * @throwscl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault :
     */
    public com.informatica.wsh.VoidResponse initializeDIServerConnection(
            com.informatica.wsh.InitializeDIServerConnectionRequest initializeDIServerConnection34,
            com.informatica.wsh.SessionHeader context35)
            throws java.rmi.RemoteException,Fault {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[2].getName());
            _operationClient.getOptions()
                    .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/InitializeDIServerConnectionRequest");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                    "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                            .getSoapVersionURI()),
                    initializeDIServerConnection34,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh",
                                    "initializeDIServerConnection")),
                    new javax.xml.namespace.QName(
                            "http://www.informatica.com/wsh",
                            "initializeDIServerConnection"));

            env.build();

            // add the children only if the parameter is not null
            if (context35 != null) {
                org.apache.axiom.om.OMElement omElementcontext35 = toOM(context35,
                        optimizeContent(
                                new javax.xml.namespace.QName(
                                        "http://www.informatica.com/wsh",
                                        "initializeDIServerConnection")));
                addHeader(omElementcontext35, env);
            }

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            Object object = fromOM(_returnEnv.getBody()
                            .getFirstElement(),
                    com.informatica.wsh.VoidResponse.class,
                    getEnvelopeNamespaces(_returnEnv));

            return (com.informatica.wsh.VoidResponse) object;
        } catch (AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                        new FaultMapKey(
                                faultElt.getQName(),
                                "initializeDIServerConnection"))) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                faultElt.getQName(),
                                "initializeDIServerConnection"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        Exception ex = (Exception) constructor.newInstance(f.getMessage());

                        //message class
                        String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                faultElt.getQName(),
                                "initializeDIServerConnection"));
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        if (ex instanceof Fault) {
                            throw (Fault) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                        .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see DataIntegrationService#startinitializeDIServerConnection
     * @param initializeDIServerConnection34
     * @param context35
     */
    public void startinitializeDIServerConnection(
            com.informatica.wsh.InitializeDIServerConnectionRequest initializeDIServerConnection34,
            com.informatica.wsh.SessionHeader context35,
            final DataIntegrationServiceCallbackHandler callback)
            throws java.rmi.RemoteException {
        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[2].getName());
        _operationClient.getOptions()
                .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/InitializeDIServerConnectionRequest");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(_operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        //Style is Doc.
        env = toEnvelope(getFactory(_operationClient.getOptions()
                        .getSoapVersionURI()),
                initializeDIServerConnection34,
                optimizeContent(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh",
                                "initializeDIServerConnection")),
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh",
                        "initializeDIServerConnection"));

        // add the soap_headers only if they are not null
        if (context35 != null) {
            org.apache.axiom.om.OMElement omElementcontext35 = toOM(context35,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh",
                                    "initializeDIServerConnection")));
            addHeader(omElementcontext35, env);
        }

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(
                    org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    Object object = fromOM(resultEnv.getBody()
                                    .getFirstElement(),
                            com.informatica.wsh.VoidResponse.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultinitializeDIServerConnection((com.informatica.wsh.VoidResponse) object);
                } catch (AxisFault e) {
                    callback.receiveErrorinitializeDIServerConnection(e);
                }
            }

            public void onError(Exception error) {
                if (error instanceof AxisFault) {
                    AxisFault f = (AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();

                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(
                                new FaultMapKey(
                                        faultElt.getQName(),
                                        "initializeDIServerConnection"))) {
                            //make the fault by reflection
                            try {
                                String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "initializeDIServerConnection"));
                                Class exceptionClass = Class.forName(exceptionClassName);
                                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                Exception ex = (Exception) constructor.newInstance(f.getMessage());

                                //message class
                                String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "initializeDIServerConnection"));
                                Class messageClass = Class.forName(messageClassName);
                                Object messageObject = fromOM(faultElt,
                                        messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new Class[] { messageClass });
                                m.invoke(ex,
                                        new Object[] { messageObject });

                                if (ex instanceof Fault) {
                                    callback.receiveErrorinitializeDIServerConnection((Fault) ex);

                                    return;
                                }

                                callback.receiveErrorinitializeDIServerConnection(new java.rmi.RemoteException(
                                        ex.getMessage(), ex));
                            } catch (ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorinitializeDIServerConnection(f);
                            } catch (ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorinitializeDIServerConnection(f);
                            } catch (NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorinitializeDIServerConnection(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorinitializeDIServerConnection(f);
                            } catch (IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorinitializeDIServerConnection(f);
                            } catch (InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorinitializeDIServerConnection(f);
                            } catch (AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorinitializeDIServerConnection(f);
                            }
                        } else {
                            callback.receiveErrorinitializeDIServerConnection(f);
                        }
                    } else {
                        callback.receiveErrorinitializeDIServerConnection(f);
                    }
                } else {
                    callback.receiveErrorinitializeDIServerConnection(error);
                }
            }

            public void onFault(
                    org.apache.axis2.context.MessageContext faultContext) {
                AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender()
                            .cleanup(_messageContext);
                } catch (AxisFault axisFault) {
                    callback.receiveErrorinitializeDIServerConnection(axisFault);
                }
            }
        });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

        if ((_operations[2].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[2].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);
    }

    /**
     * Auto generated method signature
     *
     * @see DataIntegrationService#pingDIServer
     * @param pingDIServer37
     * @param context38
     * @throwscl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault :
     */
    public com.informatica.wsh.EPingState pingDIServer(
            com.informatica.wsh.PingDIServerRequest pingDIServer37,
            com.informatica.wsh.SessionHeader context38)
            throws java.rmi.RemoteException,Fault {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[3].getName());
            _operationClient.getOptions()
                    .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/pingDIServerRequest");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                    "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                            .getSoapVersionURI()),
                    pingDIServer37,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh", "pingDIServer")),
                    new javax.xml.namespace.QName(
                            "http://www.informatica.com/wsh", "pingDIServer"));

            env.build();

            // add the children only if the parameter is not null
            if (context38 != null) {
                org.apache.axiom.om.OMElement omElementcontext38 = toOM(context38,
                        optimizeContent(
                                new javax.xml.namespace.QName(
                                        "http://www.informatica.com/wsh", "pingDIServer")));
                addHeader(omElementcontext38, env);
            }

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            Object object = fromOM(_returnEnv.getBody()
                            .getFirstElement(),
                    com.informatica.wsh.EPingState.class,
                    getEnvelopeNamespaces(_returnEnv));

            return (com.informatica.wsh.EPingState) object;
        } catch (AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                        new FaultMapKey(
                                faultElt.getQName(), "pingDIServer"))) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                faultElt.getQName(), "pingDIServer"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        Exception ex = (Exception) constructor.newInstance(f.getMessage());

                        //message class
                        String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                faultElt.getQName(), "pingDIServer"));
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        if (ex instanceof Fault) {
                            throw (Fault) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                        .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see DataIntegrationService#startpingDIServer
     * @param pingDIServer37
     * @param context38
     */
    public void startpingDIServer(
            com.informatica.wsh.PingDIServerRequest pingDIServer37,
            com.informatica.wsh.SessionHeader context38,
            final DataIntegrationServiceCallbackHandler callback)
            throws java.rmi.RemoteException {
        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[3].getName());
        _operationClient.getOptions()
                .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/pingDIServerRequest");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(_operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        //Style is Doc.
        env = toEnvelope(getFactory(_operationClient.getOptions()
                        .getSoapVersionURI()),
                pingDIServer37,
                optimizeContent(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh", "pingDIServer")),
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "pingDIServer"));

        // add the soap_headers only if they are not null
        if (context38 != null) {
            org.apache.axiom.om.OMElement omElementcontext38 = toOM(context38,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh", "pingDIServer")));
            addHeader(omElementcontext38, env);
        }

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(
                    org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    Object object = fromOM(resultEnv.getBody()
                                    .getFirstElement(),
                            com.informatica.wsh.EPingState.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultpingDIServer((com.informatica.wsh.EPingState) object);
                } catch (AxisFault e) {
                    callback.receiveErrorpingDIServer(e);
                }
            }

            public void onError(Exception error) {
                if (error instanceof AxisFault) {
                    AxisFault f = (AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();

                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(
                                new FaultMapKey(
                                        faultElt.getQName(), "pingDIServer"))) {
                            //make the fault by reflection
                            try {
                                String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "pingDIServer"));
                                Class exceptionClass = Class.forName(exceptionClassName);
                                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                Exception ex = (Exception) constructor.newInstance(f.getMessage());

                                //message class
                                String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "pingDIServer"));
                                Class messageClass = Class.forName(messageClassName);
                                Object messageObject = fromOM(faultElt,
                                        messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new Class[] { messageClass });
                                m.invoke(ex,
                                        new Object[] { messageObject });

                                if (ex instanceof Fault) {
                                    callback.receiveErrorpingDIServer((Fault) ex);

                                    return;
                                }

                                callback.receiveErrorpingDIServer(new java.rmi.RemoteException(
                                        ex.getMessage(), ex));
                            } catch (ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorpingDIServer(f);
                            } catch (ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorpingDIServer(f);
                            } catch (NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorpingDIServer(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorpingDIServer(f);
                            } catch (IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorpingDIServer(f);
                            } catch (InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorpingDIServer(f);
                            } catch (AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorpingDIServer(f);
                            }
                        } else {
                            callback.receiveErrorpingDIServer(f);
                        }
                    } else {
                        callback.receiveErrorpingDIServer(f);
                    }
                } else {
                    callback.receiveErrorpingDIServer(error);
                }
            }

            public void onFault(
                    org.apache.axis2.context.MessageContext faultContext) {
                AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender()
                            .cleanup(_messageContext);
                } catch (AxisFault axisFault) {
                    callback.receiveErrorpingDIServer(axisFault);
                }
            }
        });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

        if ((_operations[3].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[3].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);
    }

    /**
     * Auto generated method signature
     *
     * @see DataIntegrationService#startWorkflowLogFetch
     * @param startWorkflowLogFetch40
     * @param context41
     * @throwscl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault :
     */
    public int startWorkflowLogFetch(
            com.informatica.wsh.StartWorkflowLogFetchRequest startWorkflowLogFetch40,
            com.informatica.wsh.SessionHeader context41)
            throws java.rmi.RemoteException,Fault {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[4].getName());
            _operationClient.getOptions()
                    .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/StartWorkflowLogFetchRequest");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                    "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                            .getSoapVersionURI()),
                    startWorkflowLogFetch40,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh",
                                    "startWorkflowLogFetch")),
                    new javax.xml.namespace.QName(
                            "http://www.informatica.com/wsh",
                            "startWorkflowLogFetch"));

            env.build();

            // add the children only if the parameter is not null
            if (context41 != null) {
                org.apache.axiom.om.OMElement omElementcontext41 = toOM(context41,
                        optimizeContent(
                                new javax.xml.namespace.QName(
                                        "http://www.informatica.com/wsh",
                                        "startWorkflowLogFetch")));
                addHeader(omElementcontext41, env);
            }

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            return toInt(_returnEnv.getBody().getFirstElement(),
                    getEnvelopeNamespaces(_returnEnv));
        } catch (AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                        new FaultMapKey(
                                faultElt.getQName(), "startWorkflowLogFetch"))) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                faultElt.getQName(), "startWorkflowLogFetch"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        Exception ex = (Exception) constructor.newInstance(f.getMessage());

                        //message class
                        String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                faultElt.getQName(), "startWorkflowLogFetch"));
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        if (ex instanceof Fault) {
                            throw (Fault) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                        .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see DataIntegrationService#startstartWorkflowLogFetch
     * @param startWorkflowLogFetch40
     * @param context41
     */
    public void startstartWorkflowLogFetch(
            com.informatica.wsh.StartWorkflowLogFetchRequest startWorkflowLogFetch40,
            com.informatica.wsh.SessionHeader context41,
            final DataIntegrationServiceCallbackHandler callback)
            throws java.rmi.RemoteException {
        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[4].getName());
        _operationClient.getOptions()
                .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/StartWorkflowLogFetchRequest");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(_operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        //Style is Doc.
        env = toEnvelope(getFactory(_operationClient.getOptions()
                        .getSoapVersionURI()),
                startWorkflowLogFetch40,
                optimizeContent(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh",
                                "startWorkflowLogFetch")),
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "startWorkflowLogFetch"));

        // add the soap_headers only if they are not null
        if (context41 != null) {
            org.apache.axiom.om.OMElement omElementcontext41 = toOM(context41,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh",
                                    "startWorkflowLogFetch")));
            addHeader(omElementcontext41, env);
        }

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(
                    org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    callback.receiveResultstartWorkflowLogFetch(toInt(resultEnv.getBody()
                                    .getFirstElement(),
                            getEnvelopeNamespaces(resultEnv)));
                } catch (AxisFault e) {
                    callback.receiveErrorstartWorkflowLogFetch(e);
                }
            }

            public void onError(Exception error) {
                if (error instanceof AxisFault) {
                    AxisFault f = (AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();

                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(
                                new FaultMapKey(
                                        faultElt.getQName(),
                                        "startWorkflowLogFetch"))) {
                            //make the fault by reflection
                            try {
                                String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "startWorkflowLogFetch"));
                                Class exceptionClass = Class.forName(exceptionClassName);
                                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                Exception ex = (Exception) constructor.newInstance(f.getMessage());

                                //message class
                                String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "startWorkflowLogFetch"));
                                Class messageClass = Class.forName(messageClassName);
                                Object messageObject = fromOM(faultElt,
                                        messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new Class[] { messageClass });
                                m.invoke(ex,
                                        new Object[] { messageObject });

                                if (ex instanceof Fault) {
                                    callback.receiveErrorstartWorkflowLogFetch((Fault) ex);

                                    return;
                                }

                                callback.receiveErrorstartWorkflowLogFetch(new java.rmi.RemoteException(
                                        ex.getMessage(), ex));
                            } catch (ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartWorkflowLogFetch(f);
                            } catch (ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartWorkflowLogFetch(f);
                            } catch (NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartWorkflowLogFetch(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartWorkflowLogFetch(f);
                            } catch (IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartWorkflowLogFetch(f);
                            } catch (InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartWorkflowLogFetch(f);
                            } catch (AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartWorkflowLogFetch(f);
                            }
                        } else {
                            callback.receiveErrorstartWorkflowLogFetch(f);
                        }
                    } else {
                        callback.receiveErrorstartWorkflowLogFetch(f);
                    }
                } else {
                    callback.receiveErrorstartWorkflowLogFetch(error);
                }
            }

            public void onFault(
                    org.apache.axis2.context.MessageContext faultContext) {
                AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender()
                            .cleanup(_messageContext);
                } catch (AxisFault axisFault) {
                    callback.receiveErrorstartWorkflowLogFetch(axisFault);
                }
            }
        });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

        if ((_operations[4].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[4].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);
    }

    /**
     * Auto generated method signature
     *
     * @see DataIntegrationService#getSessionLog
     * @param getSessionLog43
     * @param context44
     * @throwscl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault :
     */
    public com.informatica.wsh.Log getSessionLog(
            com.informatica.wsh.GetSessionLogRequest getSessionLog43,
            com.informatica.wsh.SessionHeader context44)
            throws java.rmi.RemoteException,Fault {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[5].getName());
            _operationClient.getOptions()
                    .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/getSessionLogRequest");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                    "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                            .getSoapVersionURI()),
                    getSessionLog43,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh", "getSessionLog")),
                    new javax.xml.namespace.QName(
                            "http://www.informatica.com/wsh", "getSessionLog"));

            env.build();

            // add the children only if the parameter is not null
            if (context44 != null) {
                org.apache.axiom.om.OMElement omElementcontext44 = toOM(context44,
                        optimizeContent(
                                new javax.xml.namespace.QName(
                                        "http://www.informatica.com/wsh",
                                        "getSessionLog")));
                addHeader(omElementcontext44, env);
            }

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            Object object = fromOM(_returnEnv.getBody()
                            .getFirstElement(),
                    com.informatica.wsh.Log.class,
                    getEnvelopeNamespaces(_returnEnv));

            return (com.informatica.wsh.Log) object;
        } catch (AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                        new FaultMapKey(
                                faultElt.getQName(), "getSessionLog"))) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                faultElt.getQName(), "getSessionLog"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        Exception ex = (Exception) constructor.newInstance(f.getMessage());

                        //message class
                        String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                faultElt.getQName(), "getSessionLog"));
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        if (ex instanceof Fault) {
                            throw (Fault) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                        .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see DataIntegrationService#startgetSessionLog
     * @param getSessionLog43
     * @param context44
     */
    public void startgetSessionLog(
            com.informatica.wsh.GetSessionLogRequest getSessionLog43,
            com.informatica.wsh.SessionHeader context44,
            final DataIntegrationServiceCallbackHandler callback)
            throws java.rmi.RemoteException {
        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[5].getName());
        _operationClient.getOptions()
                .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/getSessionLogRequest");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(_operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        //Style is Doc.
        env = toEnvelope(getFactory(_operationClient.getOptions()
                        .getSoapVersionURI()),
                getSessionLog43,
                optimizeContent(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh", "getSessionLog")),
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "getSessionLog"));

        // add the soap_headers only if they are not null
        if (context44 != null) {
            org.apache.axiom.om.OMElement omElementcontext44 = toOM(context44,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh", "getSessionLog")));
            addHeader(omElementcontext44, env);
        }

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(
                    org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    Object object = fromOM(resultEnv.getBody()
                                    .getFirstElement(),
                            com.informatica.wsh.Log.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultgetSessionLog((com.informatica.wsh.Log) object);
                } catch (AxisFault e) {
                    callback.receiveErrorgetSessionLog(e);
                }
            }

            public void onError(Exception error) {
                if (error instanceof AxisFault) {
                    AxisFault f = (AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();

                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(
                                new FaultMapKey(
                                        faultElt.getQName(), "getSessionLog"))) {
                            //make the fault by reflection
                            try {
                                String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "getSessionLog"));
                                Class exceptionClass = Class.forName(exceptionClassName);
                                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                Exception ex = (Exception) constructor.newInstance(f.getMessage());

                                //message class
                                String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "getSessionLog"));
                                Class messageClass = Class.forName(messageClassName);
                                Object messageObject = fromOM(faultElt,
                                        messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new Class[] { messageClass });
                                m.invoke(ex,
                                        new Object[] { messageObject });

                                if (ex instanceof Fault) {
                                    callback.receiveErrorgetSessionLog((Fault) ex);

                                    return;
                                }

                                callback.receiveErrorgetSessionLog(new java.rmi.RemoteException(
                                        ex.getMessage(), ex));
                            } catch (ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetSessionLog(f);
                            } catch (ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetSessionLog(f);
                            } catch (NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetSessionLog(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetSessionLog(f);
                            } catch (IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetSessionLog(f);
                            } catch (InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetSessionLog(f);
                            } catch (AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetSessionLog(f);
                            }
                        } else {
                            callback.receiveErrorgetSessionLog(f);
                        }
                    } else {
                        callback.receiveErrorgetSessionLog(f);
                    }
                } else {
                    callback.receiveErrorgetSessionLog(error);
                }
            }

            public void onFault(
                    org.apache.axis2.context.MessageContext faultContext) {
                AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender()
                            .cleanup(_messageContext);
                } catch (AxisFault axisFault) {
                    callback.receiveErrorgetSessionLog(axisFault);
                }
            }
        });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

        if ((_operations[5].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[5].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);
    }

    /**
     * Auto generated method signature
     *
     * @see DataIntegrationService#stopWorkflow
     * @param stopWorkflow46
     * @param context47
     * @throwscl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault :
     */
    public com.informatica.wsh.VoidResponse stopWorkflow(
            com.informatica.wsh.WorkflowRequest stopWorkflow46,
            com.informatica.wsh.SessionHeader context47)
            throws java.rmi.RemoteException,Fault {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[6].getName());
            _operationClient.getOptions()
                    .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/stopWorkflowRequest");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                    "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                            .getSoapVersionURI()),
                    stopWorkflow46,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh", "stopWorkflow")),
                    new javax.xml.namespace.QName(
                            "http://www.informatica.com/wsh", "stopWorkflow"));

            env.build();

            // add the children only if the parameter is not null
            if (context47 != null) {
                org.apache.axiom.om.OMElement omElementcontext47 = toOM(context47,
                        optimizeContent(
                                new javax.xml.namespace.QName(
                                        "http://www.informatica.com/wsh", "stopWorkflow")));
                addHeader(omElementcontext47, env);
            }

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            Object object = fromOM(_returnEnv.getBody()
                            .getFirstElement(),
                    com.informatica.wsh.VoidResponse.class,
                    getEnvelopeNamespaces(_returnEnv));

            return (com.informatica.wsh.VoidResponse) object;
        } catch (AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                        new FaultMapKey(
                                faultElt.getQName(), "stopWorkflow"))) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                faultElt.getQName(), "stopWorkflow"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        Exception ex = (Exception) constructor.newInstance(f.getMessage());

                        //message class
                        String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                faultElt.getQName(), "stopWorkflow"));
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        if (ex instanceof Fault) {
                            throw (Fault) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                        .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see DataIntegrationService#startstopWorkflow
     * @param stopWorkflow46
     * @param context47
     */
    public void startstopWorkflow(
            com.informatica.wsh.WorkflowRequest stopWorkflow46,
            com.informatica.wsh.SessionHeader context47,
            final DataIntegrationServiceCallbackHandler callback)
            throws java.rmi.RemoteException {
        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[6].getName());
        _operationClient.getOptions()
                .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/stopWorkflowRequest");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(_operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        //Style is Doc.
        env = toEnvelope(getFactory(_operationClient.getOptions()
                        .getSoapVersionURI()),
                stopWorkflow46,
                optimizeContent(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh", "stopWorkflow")),
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "stopWorkflow"));

        // add the soap_headers only if they are not null
        if (context47 != null) {
            org.apache.axiom.om.OMElement omElementcontext47 = toOM(context47,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh", "stopWorkflow")));
            addHeader(omElementcontext47, env);
        }

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(
                    org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    Object object = fromOM(resultEnv.getBody()
                                    .getFirstElement(),
                            com.informatica.wsh.VoidResponse.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultstopWorkflow((com.informatica.wsh.VoidResponse) object);
                } catch (AxisFault e) {
                    callback.receiveErrorstopWorkflow(e);
                }
            }

            public void onError(Exception error) {
                if (error instanceof AxisFault) {
                    AxisFault f = (AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();

                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(
                                new FaultMapKey(
                                        faultElt.getQName(), "stopWorkflow"))) {
                            //make the fault by reflection
                            try {
                                String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "stopWorkflow"));
                                Class exceptionClass = Class.forName(exceptionClassName);
                                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                Exception ex = (Exception) constructor.newInstance(f.getMessage());

                                //message class
                                String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "stopWorkflow"));
                                Class messageClass = Class.forName(messageClassName);
                                Object messageObject = fromOM(faultElt,
                                        messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new Class[] { messageClass });
                                m.invoke(ex,
                                        new Object[] { messageObject });

                                if (ex instanceof Fault) {
                                    callback.receiveErrorstopWorkflow((Fault) ex);

                                    return;
                                }

                                callback.receiveErrorstopWorkflow(new java.rmi.RemoteException(
                                        ex.getMessage(), ex));
                            } catch (ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstopWorkflow(f);
                            } catch (ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstopWorkflow(f);
                            } catch (NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstopWorkflow(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstopWorkflow(f);
                            } catch (IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstopWorkflow(f);
                            } catch (InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstopWorkflow(f);
                            } catch (AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstopWorkflow(f);
                            }
                        } else {
                            callback.receiveErrorstopWorkflow(f);
                        }
                    } else {
                        callback.receiveErrorstopWorkflow(f);
                    }
                } else {
                    callback.receiveErrorstopWorkflow(error);
                }
            }

            public void onFault(
                    org.apache.axis2.context.MessageContext faultContext) {
                AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender()
                            .cleanup(_messageContext);
                } catch (AxisFault axisFault) {
                    callback.receiveErrorstopWorkflow(axisFault);
                }
            }
        });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

        if ((_operations[6].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[6].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);
    }

    /**
     * Auto generated method signature
     *
     * @see DataIntegrationService#waitTillWorkflowComplete
     * @param waitTillWorkflowComplete49
     * @param context50
     * @throwscl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault :
     */
    public com.informatica.wsh.VoidResponse waitTillWorkflowComplete(
            com.informatica.wsh.WorkflowRequest waitTillWorkflowComplete49,
            com.informatica.wsh.SessionHeader context50)
            throws java.rmi.RemoteException,Fault {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[7].getName());
            _operationClient.getOptions()
                    .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/waitTillWorkflowCompleteRequest");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                    "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                            .getSoapVersionURI()),
                    waitTillWorkflowComplete49,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh",
                                    "waitTillWorkflowComplete")),
                    new javax.xml.namespace.QName(
                            "http://www.informatica.com/wsh",
                            "waitTillWorkflowComplete"));

            env.build();

            // add the children only if the parameter is not null
            if (context50 != null) {
                org.apache.axiom.om.OMElement omElementcontext50 = toOM(context50,
                        optimizeContent(
                                new javax.xml.namespace.QName(
                                        "http://www.informatica.com/wsh",
                                        "waitTillWorkflowComplete")));
                addHeader(omElementcontext50, env);
            }

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            Object object = fromOM(_returnEnv.getBody()
                            .getFirstElement(),
                    com.informatica.wsh.VoidResponse.class,
                    getEnvelopeNamespaces(_returnEnv));

            return (com.informatica.wsh.VoidResponse) object;
        } catch (AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                        new FaultMapKey(
                                faultElt.getQName(), "waitTillWorkflowComplete"))) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                faultElt.getQName(),
                                "waitTillWorkflowComplete"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        Exception ex = (Exception) constructor.newInstance(f.getMessage());

                        //message class
                        String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                faultElt.getQName(),
                                "waitTillWorkflowComplete"));
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        if (ex instanceof Fault) {
                            throw (Fault) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                        .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see DataIntegrationService#startwaitTillWorkflowComplete
     * @param waitTillWorkflowComplete49
     * @param context50
     */
    public void startwaitTillWorkflowComplete(
            com.informatica.wsh.WorkflowRequest waitTillWorkflowComplete49,
            com.informatica.wsh.SessionHeader context50,
            final DataIntegrationServiceCallbackHandler callback)
            throws java.rmi.RemoteException {
        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[7].getName());
        _operationClient.getOptions()
                .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/waitTillWorkflowCompleteRequest");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(_operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        //Style is Doc.
        env = toEnvelope(getFactory(_operationClient.getOptions()
                        .getSoapVersionURI()),
                waitTillWorkflowComplete49,
                optimizeContent(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh",
                                "waitTillWorkflowComplete")),
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "waitTillWorkflowComplete"));

        // add the soap_headers only if they are not null
        if (context50 != null) {
            org.apache.axiom.om.OMElement omElementcontext50 = toOM(context50,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh",
                                    "waitTillWorkflowComplete")));
            addHeader(omElementcontext50, env);
        }

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(
                    org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    Object object = fromOM(resultEnv.getBody()
                                    .getFirstElement(),
                            com.informatica.wsh.VoidResponse.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultwaitTillWorkflowComplete((com.informatica.wsh.VoidResponse) object);
                } catch (AxisFault e) {
                    callback.receiveErrorwaitTillWorkflowComplete(e);
                }
            }

            public void onError(Exception error) {
                if (error instanceof AxisFault) {
                    AxisFault f = (AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();

                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(
                                new FaultMapKey(
                                        faultElt.getQName(),
                                        "waitTillWorkflowComplete"))) {
                            //make the fault by reflection
                            try {
                                String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "waitTillWorkflowComplete"));
                                Class exceptionClass = Class.forName(exceptionClassName);
                                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                Exception ex = (Exception) constructor.newInstance(f.getMessage());

                                //message class
                                String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "waitTillWorkflowComplete"));
                                Class messageClass = Class.forName(messageClassName);
                                Object messageObject = fromOM(faultElt,
                                        messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new Class[] { messageClass });
                                m.invoke(ex,
                                        new Object[] { messageObject });

                                if (ex instanceof Fault) {
                                    callback.receiveErrorwaitTillWorkflowComplete((Fault) ex);

                                    return;
                                }

                                callback.receiveErrorwaitTillWorkflowComplete(new java.rmi.RemoteException(
                                        ex.getMessage(), ex));
                            } catch (ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorwaitTillWorkflowComplete(f);
                            } catch (ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorwaitTillWorkflowComplete(f);
                            } catch (NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorwaitTillWorkflowComplete(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorwaitTillWorkflowComplete(f);
                            } catch (IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorwaitTillWorkflowComplete(f);
                            } catch (InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorwaitTillWorkflowComplete(f);
                            } catch (AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorwaitTillWorkflowComplete(f);
                            }
                        } else {
                            callback.receiveErrorwaitTillWorkflowComplete(f);
                        }
                    } else {
                        callback.receiveErrorwaitTillWorkflowComplete(f);
                    }
                } else {
                    callback.receiveErrorwaitTillWorkflowComplete(error);
                }
            }

            public void onFault(
                    org.apache.axis2.context.MessageContext faultContext) {
                AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender()
                            .cleanup(_messageContext);
                } catch (AxisFault axisFault) {
                    callback.receiveErrorwaitTillWorkflowComplete(axisFault);
                }
            }
        });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

        if ((_operations[7].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[7].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);
    }

    /**
     * Auto generated method signature
     *
     * @see DataIntegrationService#recoverWorkflow
     * @param recoverWorkflow52
     * @param context53
     * @throwscl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault :
     */
    public com.informatica.wsh.VoidResponse recoverWorkflow(
            com.informatica.wsh.WorkflowRequest recoverWorkflow52,
            com.informatica.wsh.SessionHeader context53)
            throws java.rmi.RemoteException,Fault {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[8].getName());
            _operationClient.getOptions()
                    .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/recoverWorkflowRequest");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                    "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                            .getSoapVersionURI()),
                    recoverWorkflow52,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh", "recoverWorkflow")),
                    new javax.xml.namespace.QName(
                            "http://www.informatica.com/wsh", "recoverWorkflow"));

            env.build();

            // add the children only if the parameter is not null
            if (context53 != null) {
                org.apache.axiom.om.OMElement omElementcontext53 = toOM(context53,
                        optimizeContent(
                                new javax.xml.namespace.QName(
                                        "http://www.informatica.com/wsh",
                                        "recoverWorkflow")));
                addHeader(omElementcontext53, env);
            }

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            Object object = fromOM(_returnEnv.getBody()
                            .getFirstElement(),
                    com.informatica.wsh.VoidResponse.class,
                    getEnvelopeNamespaces(_returnEnv));

            return (com.informatica.wsh.VoidResponse) object;
        } catch (AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                        new FaultMapKey(
                                faultElt.getQName(), "recoverWorkflow"))) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                faultElt.getQName(), "recoverWorkflow"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        Exception ex = (Exception) constructor.newInstance(f.getMessage());

                        //message class
                        String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                faultElt.getQName(), "recoverWorkflow"));
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        if (ex instanceof Fault) {
                            throw (Fault) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                        .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see DataIntegrationService#startrecoverWorkflow
     * @param recoverWorkflow52
     * @param context53
     */
    public void startrecoverWorkflow(
            com.informatica.wsh.WorkflowRequest recoverWorkflow52,
            com.informatica.wsh.SessionHeader context53,
            final DataIntegrationServiceCallbackHandler callback)
            throws java.rmi.RemoteException {
        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[8].getName());
        _operationClient.getOptions()
                .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/recoverWorkflowRequest");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(_operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        //Style is Doc.
        env = toEnvelope(getFactory(_operationClient.getOptions()
                        .getSoapVersionURI()),
                recoverWorkflow52,
                optimizeContent(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh", "recoverWorkflow")),
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "recoverWorkflow"));

        // add the soap_headers only if they are not null
        if (context53 != null) {
            org.apache.axiom.om.OMElement omElementcontext53 = toOM(context53,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh", "recoverWorkflow")));
            addHeader(omElementcontext53, env);
        }

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(
                    org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    Object object = fromOM(resultEnv.getBody()
                                    .getFirstElement(),
                            com.informatica.wsh.VoidResponse.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultrecoverWorkflow((com.informatica.wsh.VoidResponse) object);
                } catch (AxisFault e) {
                    callback.receiveErrorrecoverWorkflow(e);
                }
            }

            public void onError(Exception error) {
                if (error instanceof AxisFault) {
                    AxisFault f = (AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();

                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(
                                new FaultMapKey(
                                        faultElt.getQName(),
                                        "recoverWorkflow"))) {
                            //make the fault by reflection
                            try {
                                String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "recoverWorkflow"));
                                Class exceptionClass = Class.forName(exceptionClassName);
                                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                Exception ex = (Exception) constructor.newInstance(f.getMessage());

                                //message class
                                String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "recoverWorkflow"));
                                Class messageClass = Class.forName(messageClassName);
                                Object messageObject = fromOM(faultElt,
                                        messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new Class[] { messageClass });
                                m.invoke(ex,
                                        new Object[] { messageObject });

                                if (ex instanceof Fault) {
                                    callback.receiveErrorrecoverWorkflow((Fault) ex);

                                    return;
                                }

                                callback.receiveErrorrecoverWorkflow(new java.rmi.RemoteException(
                                        ex.getMessage(), ex));
                            } catch (ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorrecoverWorkflow(f);
                            } catch (ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorrecoverWorkflow(f);
                            } catch (NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorrecoverWorkflow(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorrecoverWorkflow(f);
                            } catch (IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorrecoverWorkflow(f);
                            } catch (InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorrecoverWorkflow(f);
                            } catch (AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorrecoverWorkflow(f);
                            }
                        } else {
                            callback.receiveErrorrecoverWorkflow(f);
                        }
                    } else {
                        callback.receiveErrorrecoverWorkflow(f);
                    }
                } else {
                    callback.receiveErrorrecoverWorkflow(error);
                }
            }

            public void onFault(
                    org.apache.axis2.context.MessageContext faultContext) {
                AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender()
                            .cleanup(_messageContext);
                } catch (AxisFault axisFault) {
                    callback.receiveErrorrecoverWorkflow(axisFault);
                }
            }
        });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

        if ((_operations[8].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[8].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);
    }

    /**
     * Auto generated method signature
     *
     * @see DataIntegrationService#getSessionStatistics
     * @param getSessionStatistics55
     * @param context56
     * @throwscl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault :
     */
    public com.informatica.wsh.SessionStatistics getSessionStatistics(
            com.informatica.wsh.GetSessionStatisticsRequest getSessionStatistics55,
            com.informatica.wsh.SessionHeader context56)
            throws java.rmi.RemoteException,Fault {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[9].getName());
            _operationClient.getOptions()
                    .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/getSessionStatisticsRequest");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                    "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                            .getSoapVersionURI()),
                    getSessionStatistics55,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh",
                                    "getSessionStatistics")),
                    new javax.xml.namespace.QName(
                            "http://www.informatica.com/wsh", "getSessionStatistics"));

            env.build();

            // add the children only if the parameter is not null
            if (context56 != null) {
                org.apache.axiom.om.OMElement omElementcontext56 = toOM(context56,
                        optimizeContent(
                                new javax.xml.namespace.QName(
                                        "http://www.informatica.com/wsh",
                                        "getSessionStatistics")));
                addHeader(omElementcontext56, env);
            }

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            Object object = fromOM(_returnEnv.getBody()
                            .getFirstElement(),
                    com.informatica.wsh.SessionStatistics.class,
                    getEnvelopeNamespaces(_returnEnv));

            return (com.informatica.wsh.SessionStatistics) object;
        } catch (AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                        new FaultMapKey(
                                faultElt.getQName(), "getSessionStatistics"))) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                faultElt.getQName(), "getSessionStatistics"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        Exception ex = (Exception) constructor.newInstance(f.getMessage());

                        //message class
                        String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                faultElt.getQName(), "getSessionStatistics"));
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        if (ex instanceof Fault) {
                            throw (Fault) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                        .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see DataIntegrationService#startgetSessionStatistics
     * @param getSessionStatistics55
     * @param context56
     */
    public void startgetSessionStatistics(
            com.informatica.wsh.GetSessionStatisticsRequest getSessionStatistics55,
            com.informatica.wsh.SessionHeader context56,
            final DataIntegrationServiceCallbackHandler callback)
            throws java.rmi.RemoteException {
        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[9].getName());
        _operationClient.getOptions()
                .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/getSessionStatisticsRequest");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(_operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        //Style is Doc.
        env = toEnvelope(getFactory(_operationClient.getOptions()
                        .getSoapVersionURI()),
                getSessionStatistics55,
                optimizeContent(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh", "getSessionStatistics")),
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "getSessionStatistics"));

        // add the soap_headers only if they are not null
        if (context56 != null) {
            org.apache.axiom.om.OMElement omElementcontext56 = toOM(context56,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh",
                                    "getSessionStatistics")));
            addHeader(omElementcontext56, env);
        }

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(
                    org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    Object object = fromOM(resultEnv.getBody()
                                    .getFirstElement(),
                            com.informatica.wsh.SessionStatistics.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultgetSessionStatistics((com.informatica.wsh.SessionStatistics) object);
                } catch (AxisFault e) {
                    callback.receiveErrorgetSessionStatistics(e);
                }
            }

            public void onError(Exception error) {
                if (error instanceof AxisFault) {
                    AxisFault f = (AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();

                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(
                                new FaultMapKey(
                                        faultElt.getQName(),
                                        "getSessionStatistics"))) {
                            //make the fault by reflection
                            try {
                                String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "getSessionStatistics"));
                                Class exceptionClass = Class.forName(exceptionClassName);
                                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                Exception ex = (Exception) constructor.newInstance(f.getMessage());

                                //message class
                                String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "getSessionStatistics"));
                                Class messageClass = Class.forName(messageClassName);
                                Object messageObject = fromOM(faultElt,
                                        messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new Class[] { messageClass });
                                m.invoke(ex,
                                        new Object[] { messageObject });

                                if (ex instanceof Fault) {
                                    callback.receiveErrorgetSessionStatistics((Fault) ex);

                                    return;
                                }

                                callback.receiveErrorgetSessionStatistics(new java.rmi.RemoteException(
                                        ex.getMessage(), ex));
                            } catch (ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetSessionStatistics(f);
                            } catch (ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetSessionStatistics(f);
                            } catch (NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetSessionStatistics(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetSessionStatistics(f);
                            } catch (IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetSessionStatistics(f);
                            } catch (InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetSessionStatistics(f);
                            } catch (AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetSessionStatistics(f);
                            }
                        } else {
                            callback.receiveErrorgetSessionStatistics(f);
                        }
                    } else {
                        callback.receiveErrorgetSessionStatistics(f);
                    }
                } else {
                    callback.receiveErrorgetSessionStatistics(error);
                }
            }

            public void onFault(
                    org.apache.axis2.context.MessageContext faultContext) {
                AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender()
                            .cleanup(_messageContext);
                } catch (AxisFault axisFault) {
                    callback.receiveErrorgetSessionStatistics(axisFault);
                }
            }
        });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

        if ((_operations[9].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[9].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);
    }

    /**
     * Auto generated method signature
     *
     * @see DataIntegrationService#getWorkflowDetails
     * @param getWorkflowDetails58
     * @param context59
     * @throwscl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault :
     */
    public com.informatica.wsh.WorkflowDetails getWorkflowDetails(
            com.informatica.wsh.WorkflowRequest getWorkflowDetails58,
            com.informatica.wsh.SessionHeader context59)
            throws java.rmi.RemoteException,Fault {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[10].getName());
            _operationClient.getOptions()
                    .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/getWorkflowDetailsRequest");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                    "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                            .getSoapVersionURI()),
                    getWorkflowDetails58,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh",
                                    "getWorkflowDetails")),
                    new javax.xml.namespace.QName(
                            "http://www.informatica.com/wsh", "getWorkflowDetails"));

            env.build();

            // add the children only if the parameter is not null
            if (context59 != null) {
                org.apache.axiom.om.OMElement omElementcontext59 = toOM(context59,
                        optimizeContent(
                                new javax.xml.namespace.QName(
                                        "http://www.informatica.com/wsh",
                                        "getWorkflowDetails")));
                addHeader(omElementcontext59, env);
            }

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            Object object = fromOM(_returnEnv.getBody()
                            .getFirstElement(),
                    com.informatica.wsh.WorkflowDetails.class,
                    getEnvelopeNamespaces(_returnEnv));

            return (com.informatica.wsh.WorkflowDetails) object;
        } catch (AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                        new FaultMapKey(
                                faultElt.getQName(), "getWorkflowDetails"))) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                faultElt.getQName(), "getWorkflowDetails"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        Exception ex = (Exception) constructor.newInstance(f.getMessage());

                        //message class
                        String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                faultElt.getQName(), "getWorkflowDetails"));
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        if (ex instanceof Fault) {
                            throw (Fault) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                        .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see DataIntegrationService#startgetWorkflowDetails
     * @param getWorkflowDetails58
     * @param context59
     */
    public void startgetWorkflowDetails(
            com.informatica.wsh.WorkflowRequest getWorkflowDetails58,
            com.informatica.wsh.SessionHeader context59,
            final DataIntegrationServiceCallbackHandler callback)
            throws java.rmi.RemoteException {
        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[10].getName());
        _operationClient.getOptions()
                .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/getWorkflowDetailsRequest");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(_operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        //Style is Doc.
        env = toEnvelope(getFactory(_operationClient.getOptions()
                        .getSoapVersionURI()),
                getWorkflowDetails58,
                optimizeContent(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh", "getWorkflowDetails")),
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "getWorkflowDetails"));

        // add the soap_headers only if they are not null
        if (context59 != null) {
            org.apache.axiom.om.OMElement omElementcontext59 = toOM(context59,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh",
                                    "getWorkflowDetails")));
            addHeader(omElementcontext59, env);
        }

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(
                    org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    Object object = fromOM(resultEnv.getBody()
                                    .getFirstElement(),
                            com.informatica.wsh.WorkflowDetails.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultgetWorkflowDetails((com.informatica.wsh.WorkflowDetails) object);
                } catch (AxisFault e) {
                    callback.receiveErrorgetWorkflowDetails(e);
                }
            }

            public void onError(Exception error) {
                if (error instanceof AxisFault) {
                    AxisFault f = (AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();

                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(
                                new FaultMapKey(
                                        faultElt.getQName(),
                                        "getWorkflowDetails"))) {
                            //make the fault by reflection
                            try {
                                String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "getWorkflowDetails"));
                                Class exceptionClass = Class.forName(exceptionClassName);
                                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                Exception ex = (Exception) constructor.newInstance(f.getMessage());

                                //message class
                                String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "getWorkflowDetails"));
                                Class messageClass = Class.forName(messageClassName);
                                Object messageObject = fromOM(faultElt,
                                        messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new Class[] { messageClass });
                                m.invoke(ex,
                                        new Object[] { messageObject });

                                if (ex instanceof Fault) {
                                    callback.receiveErrorgetWorkflowDetails((Fault) ex);

                                    return;
                                }

                                callback.receiveErrorgetWorkflowDetails(new java.rmi.RemoteException(
                                        ex.getMessage(), ex));
                            } catch (ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetWorkflowDetails(f);
                            } catch (ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetWorkflowDetails(f);
                            } catch (NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetWorkflowDetails(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetWorkflowDetails(f);
                            } catch (IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetWorkflowDetails(f);
                            } catch (InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetWorkflowDetails(f);
                            } catch (AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetWorkflowDetails(f);
                            }
                        } else {
                            callback.receiveErrorgetWorkflowDetails(f);
                        }
                    } else {
                        callback.receiveErrorgetWorkflowDetails(f);
                    }
                } else {
                    callback.receiveErrorgetWorkflowDetails(error);
                }
            }

            public void onFault(
                    org.apache.axis2.context.MessageContext faultContext) {
                AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender()
                            .cleanup(_messageContext);
                } catch (AxisFault axisFault) {
                    callback.receiveErrorgetWorkflowDetails(axisFault);
                }
            }
        });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

        if ((_operations[10].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[10].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);
    }

    /**
     * Auto generated method signature
     *
     * @see DataIntegrationService#login
     * @param login61
     * @throwscl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault :
     */
    public String login(com.informatica.wsh.LoginRequest login61)
            throws java.rmi.RemoteException,Fault {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[11].getName());
            _operationClient.getOptions()
                    .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/LoginRequest");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                    "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                            .getSoapVersionURI()),
                    login61,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh", "login")),
                    new javax.xml.namespace.QName(
                            "http://www.informatica.com/wsh", "login"));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            Object object = fromOM(_returnEnv.getBody()
                            .getFirstElement(),
                    String.class, getEnvelopeNamespaces(_returnEnv));

            return (String) object;
        } catch (AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                        new FaultMapKey(
                                faultElt.getQName(), "login"))) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                faultElt.getQName(), "login"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        Exception ex = (Exception) constructor.newInstance(f.getMessage());

                        //message class
                        String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                faultElt.getQName(), "login"));
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        if (ex instanceof Fault) {
                            throw (Fault) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                        .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see DataIntegrationService#startlogin
     * @param login61
     */
    public void startlogin(com.informatica.wsh.LoginRequest login61,
                           final DataIntegrationServiceCallbackHandler callback)
            throws java.rmi.RemoteException {
        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[11].getName());
        _operationClient.getOptions()
                .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/LoginRequest");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(_operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        //Style is Doc.
        env = toEnvelope(getFactory(_operationClient.getOptions()
                        .getSoapVersionURI()),
                login61,
                optimizeContent(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh", "login")),
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "login"));

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(
                    org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    Object object = fromOM(resultEnv.getBody()
                                    .getFirstElement(),
                            String.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultlogin((String) object);
                } catch (AxisFault e) {
                    callback.receiveErrorlogin(e);
                }
            }

            public void onError(Exception error) {
                if (error instanceof AxisFault) {
                    AxisFault f = (AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();

                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(
                                new FaultMapKey(
                                        faultElt.getQName(), "login"))) {
                            //make the fault by reflection
                            try {
                                String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                        faultElt.getQName(), "login"));
                                Class exceptionClass = Class.forName(exceptionClassName);
                                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                Exception ex = (Exception) constructor.newInstance(f.getMessage());

                                //message class
                                String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                        faultElt.getQName(), "login"));
                                Class messageClass = Class.forName(messageClassName);
                                Object messageObject = fromOM(faultElt,
                                        messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new Class[] { messageClass });
                                m.invoke(ex,
                                        new Object[] { messageObject });

                                if (ex instanceof Fault) {
                                    callback.receiveErrorlogin((Fault) ex);

                                    return;
                                }

                                callback.receiveErrorlogin(new java.rmi.RemoteException(
                                        ex.getMessage(), ex));
                            } catch (ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorlogin(f);
                            } catch (ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorlogin(f);
                            } catch (NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorlogin(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorlogin(f);
                            } catch (IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorlogin(f);
                            } catch (InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorlogin(f);
                            } catch (AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorlogin(f);
                            }
                        } else {
                            callback.receiveErrorlogin(f);
                        }
                    } else {
                        callback.receiveErrorlogin(f);
                    }
                } else {
                    callback.receiveErrorlogin(error);
                }
            }

            public void onFault(
                    org.apache.axis2.context.MessageContext faultContext) {
                AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender()
                            .cleanup(_messageContext);
                } catch (AxisFault axisFault) {
                    callback.receiveErrorlogin(axisFault);
                }
            }
        });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

        if ((_operations[11].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[11].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);
    }

    /**
     * Auto generated method signature
     *
     * @see DataIntegrationService#scheduleWorkflow
     * @param scheduleWorkflow63
     * @param context64
     * @throwscl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault :
     */
    public com.informatica.wsh.VoidResponse scheduleWorkflow(
            com.informatica.wsh.WorkflowRequest scheduleWorkflow63,
            com.informatica.wsh.SessionHeader context64)
            throws java.rmi.RemoteException,Fault {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[12].getName());
            _operationClient.getOptions()
                    .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/scheduleWorkflowRequest");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                    "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                            .getSoapVersionURI()),
                    scheduleWorkflow63,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh", "scheduleWorkflow")),
                    new javax.xml.namespace.QName(
                            "http://www.informatica.com/wsh", "scheduleWorkflow"));

            env.build();

            // add the children only if the parameter is not null
            if (context64 != null) {
                org.apache.axiom.om.OMElement omElementcontext64 = toOM(context64,
                        optimizeContent(
                                new javax.xml.namespace.QName(
                                        "http://www.informatica.com/wsh",
                                        "scheduleWorkflow")));
                addHeader(omElementcontext64, env);
            }

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            Object object = fromOM(_returnEnv.getBody()
                            .getFirstElement(),
                    com.informatica.wsh.VoidResponse.class,
                    getEnvelopeNamespaces(_returnEnv));

            return (com.informatica.wsh.VoidResponse) object;
        } catch (AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                        new FaultMapKey(
                                faultElt.getQName(), "scheduleWorkflow"))) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                faultElt.getQName(), "scheduleWorkflow"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        Exception ex = (Exception) constructor.newInstance(f.getMessage());

                        //message class
                        String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                faultElt.getQName(), "scheduleWorkflow"));
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        if (ex instanceof Fault) {
                            throw (Fault) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                        .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see DataIntegrationService#startscheduleWorkflow
     * @param scheduleWorkflow63
     * @param context64
     */
    public void startscheduleWorkflow(
            com.informatica.wsh.WorkflowRequest scheduleWorkflow63,
            com.informatica.wsh.SessionHeader context64,
            final DataIntegrationServiceCallbackHandler callback)
            throws java.rmi.RemoteException {
        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[12].getName());
        _operationClient.getOptions()
                .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/scheduleWorkflowRequest");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(_operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        //Style is Doc.
        env = toEnvelope(getFactory(_operationClient.getOptions()
                        .getSoapVersionURI()),
                scheduleWorkflow63,
                optimizeContent(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh", "scheduleWorkflow")),
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "scheduleWorkflow"));

        // add the soap_headers only if they are not null
        if (context64 != null) {
            org.apache.axiom.om.OMElement omElementcontext64 = toOM(context64,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh", "scheduleWorkflow")));
            addHeader(omElementcontext64, env);
        }

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(
                    org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    Object object = fromOM(resultEnv.getBody()
                                    .getFirstElement(),
                            com.informatica.wsh.VoidResponse.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultscheduleWorkflow((com.informatica.wsh.VoidResponse) object);
                } catch (AxisFault e) {
                    callback.receiveErrorscheduleWorkflow(e);
                }
            }

            public void onError(Exception error) {
                if (error instanceof AxisFault) {
                    AxisFault f = (AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();

                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(
                                new FaultMapKey(
                                        faultElt.getQName(),
                                        "scheduleWorkflow"))) {
                            //make the fault by reflection
                            try {
                                String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "scheduleWorkflow"));
                                Class exceptionClass = Class.forName(exceptionClassName);
                                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                Exception ex = (Exception) constructor.newInstance(f.getMessage());

                                //message class
                                String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "scheduleWorkflow"));
                                Class messageClass = Class.forName(messageClassName);
                                Object messageObject = fromOM(faultElt,
                                        messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new Class[] { messageClass });
                                m.invoke(ex,
                                        new Object[] { messageObject });

                                if (ex instanceof Fault) {
                                    callback.receiveErrorscheduleWorkflow((Fault) ex);

                                    return;
                                }

                                callback.receiveErrorscheduleWorkflow(new java.rmi.RemoteException(
                                        ex.getMessage(), ex));
                            } catch (ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorscheduleWorkflow(f);
                            } catch (ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorscheduleWorkflow(f);
                            } catch (NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorscheduleWorkflow(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorscheduleWorkflow(f);
                            } catch (IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorscheduleWorkflow(f);
                            } catch (InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorscheduleWorkflow(f);
                            } catch (AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorscheduleWorkflow(f);
                            }
                        } else {
                            callback.receiveErrorscheduleWorkflow(f);
                        }
                    } else {
                        callback.receiveErrorscheduleWorkflow(f);
                    }
                } else {
                    callback.receiveErrorscheduleWorkflow(error);
                }
            }

            public void onFault(
                    org.apache.axis2.context.MessageContext faultContext) {
                AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender()
                            .cleanup(_messageContext);
                } catch (AxisFault axisFault) {
                    callback.receiveErrorscheduleWorkflow(axisFault);
                }
            }
        });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

        if ((_operations[12].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[12].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);
    }

    /**
     * Auto generated method signature
     *
     * @see DataIntegrationService#resumeWorkflow
     * @param resumeWorkflow66
     * @param context67
     * @throwscl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault :
     */
    public com.informatica.wsh.VoidResponse resumeWorkflow(
            com.informatica.wsh.WorkflowRequest resumeWorkflow66,
            com.informatica.wsh.SessionHeader context67)
            throws java.rmi.RemoteException,Fault {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[13].getName());
            _operationClient.getOptions()
                    .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/resumeWorkflowRequest");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                    "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                            .getSoapVersionURI()),
                    resumeWorkflow66,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh", "resumeWorkflow")),
                    new javax.xml.namespace.QName(
                            "http://www.informatica.com/wsh", "resumeWorkflow"));

            env.build();

            // add the children only if the parameter is not null
            if (context67 != null) {
                org.apache.axiom.om.OMElement omElementcontext67 = toOM(context67,
                        optimizeContent(
                                new javax.xml.namespace.QName(
                                        "http://www.informatica.com/wsh",
                                        "resumeWorkflow")));
                addHeader(omElementcontext67, env);
            }

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            Object object = fromOM(_returnEnv.getBody()
                            .getFirstElement(),
                    com.informatica.wsh.VoidResponse.class,
                    getEnvelopeNamespaces(_returnEnv));

            return (com.informatica.wsh.VoidResponse) object;
        } catch (AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                        new FaultMapKey(
                                faultElt.getQName(), "resumeWorkflow"))) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                faultElt.getQName(), "resumeWorkflow"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        Exception ex = (Exception) constructor.newInstance(f.getMessage());

                        //message class
                        String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                faultElt.getQName(), "resumeWorkflow"));
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        if (ex instanceof Fault) {
                            throw (Fault) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                        .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see DataIntegrationService#startresumeWorkflow
     * @param resumeWorkflow66
     * @param context67
     */
    public void startresumeWorkflow(
            com.informatica.wsh.WorkflowRequest resumeWorkflow66,
            com.informatica.wsh.SessionHeader context67,
            final DataIntegrationServiceCallbackHandler callback)
            throws java.rmi.RemoteException {
        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[13].getName());
        _operationClient.getOptions()
                .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/resumeWorkflowRequest");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(_operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        //Style is Doc.
        env = toEnvelope(getFactory(_operationClient.getOptions()
                        .getSoapVersionURI()),
                resumeWorkflow66,
                optimizeContent(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh", "resumeWorkflow")),
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "resumeWorkflow"));

        // add the soap_headers only if they are not null
        if (context67 != null) {
            org.apache.axiom.om.OMElement omElementcontext67 = toOM(context67,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh", "resumeWorkflow")));
            addHeader(omElementcontext67, env);
        }

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(
                    org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    Object object = fromOM(resultEnv.getBody()
                                    .getFirstElement(),
                            com.informatica.wsh.VoidResponse.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultresumeWorkflow((com.informatica.wsh.VoidResponse) object);
                } catch (AxisFault e) {
                    callback.receiveErrorresumeWorkflow(e);
                }
            }

            public void onError(Exception error) {
                if (error instanceof AxisFault) {
                    AxisFault f = (AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();

                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(
                                new FaultMapKey(
                                        faultElt.getQName(),
                                        "resumeWorkflow"))) {
                            //make the fault by reflection
                            try {
                                String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "resumeWorkflow"));
                                Class exceptionClass = Class.forName(exceptionClassName);
                                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                Exception ex = (Exception) constructor.newInstance(f.getMessage());

                                //message class
                                String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "resumeWorkflow"));
                                Class messageClass = Class.forName(messageClassName);
                                Object messageObject = fromOM(faultElt,
                                        messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new Class[] { messageClass });
                                m.invoke(ex,
                                        new Object[] { messageObject });

                                if (ex instanceof Fault) {
                                    callback.receiveErrorresumeWorkflow((Fault) ex);

                                    return;
                                }

                                callback.receiveErrorresumeWorkflow(new java.rmi.RemoteException(
                                        ex.getMessage(), ex));
                            } catch (ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorresumeWorkflow(f);
                            } catch (ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorresumeWorkflow(f);
                            } catch (NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorresumeWorkflow(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorresumeWorkflow(f);
                            } catch (IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorresumeWorkflow(f);
                            } catch (InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorresumeWorkflow(f);
                            } catch (AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorresumeWorkflow(f);
                            }
                        } else {
                            callback.receiveErrorresumeWorkflow(f);
                        }
                    } else {
                        callback.receiveErrorresumeWorkflow(f);
                    }
                } else {
                    callback.receiveErrorresumeWorkflow(error);
                }
            }

            public void onFault(
                    org.apache.axis2.context.MessageContext faultContext) {
                AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender()
                            .cleanup(_messageContext);
                } catch (AxisFault axisFault) {
                    callback.receiveErrorresumeWorkflow(axisFault);
                }
            }
        });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

        if ((_operations[13].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[13].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);
    }

    /**
     * Auto generated method signature
     *
     * @see DataIntegrationService#startSessionLogFetch
     * @param startSessionLogFetch69
     * @param context70
     * @throwscl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault :
     */
    public int startSessionLogFetch(
            com.informatica.wsh.StartSessionLogFetchRequest startSessionLogFetch69,
            com.informatica.wsh.SessionHeader context70)
            throws java.rmi.RemoteException,Fault {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[14].getName());
            _operationClient.getOptions()
                    .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/StartSessionLogFetchRequest");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                    "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                            .getSoapVersionURI()),
                    startSessionLogFetch69,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh",
                                    "startSessionLogFetch")),
                    new javax.xml.namespace.QName(
                            "http://www.informatica.com/wsh", "startSessionLogFetch"));

            env.build();

            // add the children only if the parameter is not null
            if (context70 != null) {
                org.apache.axiom.om.OMElement omElementcontext70 = toOM(context70,
                        optimizeContent(
                                new javax.xml.namespace.QName(
                                        "http://www.informatica.com/wsh",
                                        "startSessionLogFetch")));
                addHeader(omElementcontext70, env);
            }

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            return toInt(_returnEnv.getBody().getFirstElement(),
                    getEnvelopeNamespaces(_returnEnv));
        } catch (AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                        new FaultMapKey(
                                faultElt.getQName(), "startSessionLogFetch"))) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                faultElt.getQName(), "startSessionLogFetch"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        Exception ex = (Exception) constructor.newInstance(f.getMessage());

                        //message class
                        String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                faultElt.getQName(), "startSessionLogFetch"));
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        if (ex instanceof Fault) {
                            throw (Fault) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                        .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see DataIntegrationService#startstartSessionLogFetch
     * @param startSessionLogFetch69
     * @param context70
     */
    public void startstartSessionLogFetch(
            com.informatica.wsh.StartSessionLogFetchRequest startSessionLogFetch69,
            com.informatica.wsh.SessionHeader context70,
            final DataIntegrationServiceCallbackHandler callback)
            throws java.rmi.RemoteException {
        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[14].getName());
        _operationClient.getOptions()
                .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/StartSessionLogFetchRequest");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(_operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        //Style is Doc.
        env = toEnvelope(getFactory(_operationClient.getOptions()
                        .getSoapVersionURI()),
                startSessionLogFetch69,
                optimizeContent(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh", "startSessionLogFetch")),
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "startSessionLogFetch"));

        // add the soap_headers only if they are not null
        if (context70 != null) {
            org.apache.axiom.om.OMElement omElementcontext70 = toOM(context70,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh",
                                    "startSessionLogFetch")));
            addHeader(omElementcontext70, env);
        }

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(
                    org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    callback.receiveResultstartSessionLogFetch(toInt(resultEnv.getBody()
                                    .getFirstElement(),
                            getEnvelopeNamespaces(resultEnv)));
                } catch (AxisFault e) {
                    callback.receiveErrorstartSessionLogFetch(e);
                }
            }

            public void onError(Exception error) {
                if (error instanceof AxisFault) {
                    AxisFault f = (AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();

                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(
                                new FaultMapKey(
                                        faultElt.getQName(),
                                        "startSessionLogFetch"))) {
                            //make the fault by reflection
                            try {
                                String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "startSessionLogFetch"));
                                Class exceptionClass = Class.forName(exceptionClassName);
                                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                Exception ex = (Exception) constructor.newInstance(f.getMessage());

                                //message class
                                String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "startSessionLogFetch"));
                                Class messageClass = Class.forName(messageClassName);
                                Object messageObject = fromOM(faultElt,
                                        messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new Class[] { messageClass });
                                m.invoke(ex,
                                        new Object[] { messageObject });

                                if (ex instanceof Fault) {
                                    callback.receiveErrorstartSessionLogFetch((Fault) ex);

                                    return;
                                }

                                callback.receiveErrorstartSessionLogFetch(new java.rmi.RemoteException(
                                        ex.getMessage(), ex));
                            } catch (ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartSessionLogFetch(f);
                            } catch (ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartSessionLogFetch(f);
                            } catch (NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartSessionLogFetch(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartSessionLogFetch(f);
                            } catch (IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartSessionLogFetch(f);
                            } catch (InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartSessionLogFetch(f);
                            } catch (AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartSessionLogFetch(f);
                            }
                        } else {
                            callback.receiveErrorstartSessionLogFetch(f);
                        }
                    } else {
                        callback.receiveErrorstartSessionLogFetch(f);
                    }
                } else {
                    callback.receiveErrorstartSessionLogFetch(error);
                }
            }

            public void onFault(
                    org.apache.axis2.context.MessageContext faultContext) {
                AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender()
                            .cleanup(_messageContext);
                } catch (AxisFault axisFault) {
                    callback.receiveErrorstartSessionLogFetch(axisFault);
                }
            }
        });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

        if ((_operations[14].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[14].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);
    }

    /**
     * Auto generated method signature
     *
     * @see DataIntegrationService#getWorkflowLog
     * @param getWorkflowLog72
     * @param context73
     * @throwscl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault :
     */
    public com.informatica.wsh.Log getWorkflowLog(
            com.informatica.wsh.GetWorkflowLogRequest getWorkflowLog72,
            com.informatica.wsh.SessionHeader context73)
            throws java.rmi.RemoteException,Fault {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[15].getName());
            _operationClient.getOptions()
                    .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/getWorkflowLogRequest");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                    "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                            .getSoapVersionURI()),
                    getWorkflowLog72,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh", "getWorkflowLog")),
                    new javax.xml.namespace.QName(
                            "http://www.informatica.com/wsh", "getWorkflowLog"));

            env.build();

            // add the children only if the parameter is not null
            if (context73 != null) {
                org.apache.axiom.om.OMElement omElementcontext73 = toOM(context73,
                        optimizeContent(
                                new javax.xml.namespace.QName(
                                        "http://www.informatica.com/wsh",
                                        "getWorkflowLog")));
                addHeader(omElementcontext73, env);
            }

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            Object object = fromOM(_returnEnv.getBody()
                            .getFirstElement(),
                    com.informatica.wsh.Log.class,
                    getEnvelopeNamespaces(_returnEnv));

            return (com.informatica.wsh.Log) object;
        } catch (AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                        new FaultMapKey(
                                faultElt.getQName(), "getWorkflowLog"))) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                faultElt.getQName(), "getWorkflowLog"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        Exception ex = (Exception) constructor.newInstance(f.getMessage());

                        //message class
                        String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                faultElt.getQName(), "getWorkflowLog"));
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        if (ex instanceof Fault) {
                            throw (Fault) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                        .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see DataIntegrationService#startgetWorkflowLog
     * @param getWorkflowLog72
     * @param context73
     */
    public void startgetWorkflowLog(
            com.informatica.wsh.GetWorkflowLogRequest getWorkflowLog72,
            com.informatica.wsh.SessionHeader context73,
            final DataIntegrationServiceCallbackHandler callback)
            throws java.rmi.RemoteException {
        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[15].getName());
        _operationClient.getOptions()
                .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/getWorkflowLogRequest");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(_operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        //Style is Doc.
        env = toEnvelope(getFactory(_operationClient.getOptions()
                        .getSoapVersionURI()),
                getWorkflowLog72,
                optimizeContent(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh", "getWorkflowLog")),
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "getWorkflowLog"));

        // add the soap_headers only if they are not null
        if (context73 != null) {
            org.apache.axiom.om.OMElement omElementcontext73 = toOM(context73,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh", "getWorkflowLog")));
            addHeader(omElementcontext73, env);
        }

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(
                    org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    Object object = fromOM(resultEnv.getBody()
                                    .getFirstElement(),
                            com.informatica.wsh.Log.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultgetWorkflowLog((com.informatica.wsh.Log) object);
                } catch (AxisFault e) {
                    callback.receiveErrorgetWorkflowLog(e);
                }
            }

            public void onError(Exception error) {
                if (error instanceof AxisFault) {
                    AxisFault f = (AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();

                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(
                                new FaultMapKey(
                                        faultElt.getQName(),
                                        "getWorkflowLog"))) {
                            //make the fault by reflection
                            try {
                                String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "getWorkflowLog"));
                                Class exceptionClass = Class.forName(exceptionClassName);
                                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                Exception ex = (Exception) constructor.newInstance(f.getMessage());

                                //message class
                                String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "getWorkflowLog"));
                                Class messageClass = Class.forName(messageClassName);
                                Object messageObject = fromOM(faultElt,
                                        messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new Class[] { messageClass });
                                m.invoke(ex,
                                        new Object[] { messageObject });

                                if (ex instanceof Fault) {
                                    callback.receiveErrorgetWorkflowLog((Fault) ex);

                                    return;
                                }

                                callback.receiveErrorgetWorkflowLog(new java.rmi.RemoteException(
                                        ex.getMessage(), ex));
                            } catch (ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetWorkflowLog(f);
                            } catch (ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetWorkflowLog(f);
                            } catch (NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetWorkflowLog(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetWorkflowLog(f);
                            } catch (IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetWorkflowLog(f);
                            } catch (InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetWorkflowLog(f);
                            } catch (AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetWorkflowLog(f);
                            }
                        } else {
                            callback.receiveErrorgetWorkflowLog(f);
                        }
                    } else {
                        callback.receiveErrorgetWorkflowLog(f);
                    }
                } else {
                    callback.receiveErrorgetWorkflowLog(error);
                }
            }

            public void onFault(
                    org.apache.axis2.context.MessageContext faultContext) {
                AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender()
                            .cleanup(_messageContext);
                } catch (AxisFault axisFault) {
                    callback.receiveErrorgetWorkflowLog(axisFault);
                }
            }
        });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

        if ((_operations[15].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[15].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);
    }

    /**
     * Auto generated method signature
     *
     * @see DataIntegrationService#startWorkflow
     * @param startWorkflow75
     * @param context76
     * @throwscl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault :
     */
    public com.informatica.wsh.VoidResponse startWorkflow(
            com.informatica.wsh.WorkflowRequest startWorkflow75,
            com.informatica.wsh.SessionHeader context76)
            throws java.rmi.RemoteException,Fault {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[16].getName());
            _operationClient.getOptions()
                    .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/startWorkflowRequest");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                    "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                            .getSoapVersionURI()),
                    startWorkflow75,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh", "startWorkflow")),
                    new javax.xml.namespace.QName(
                            "http://www.informatica.com/wsh", "startWorkflow"));

            env.build();

            // add the children only if the parameter is not null
            if (context76 != null) {
                org.apache.axiom.om.OMElement omElementcontext76 = toOM(context76,
                        optimizeContent(
                                new javax.xml.namespace.QName(
                                        "http://www.informatica.com/wsh",
                                        "startWorkflow")));
                addHeader(omElementcontext76, env);
            }

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            Object object = fromOM(_returnEnv.getBody()
                            .getFirstElement(),
                    com.informatica.wsh.VoidResponse.class,
                    getEnvelopeNamespaces(_returnEnv));

            return (com.informatica.wsh.VoidResponse) object;
        } catch (AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                        new FaultMapKey(
                                faultElt.getQName(), "startWorkflow"))) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                faultElt.getQName(), "startWorkflow"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        Exception ex = (Exception) constructor.newInstance(f.getMessage());

                        //message class
                        String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                faultElt.getQName(), "startWorkflow"));
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        if (ex instanceof Fault) {
                            throw (Fault) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                        .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see DataIntegrationService#startstartWorkflow
     * @param startWorkflow75
     * @param context76
     */
    public void startstartWorkflow(
            com.informatica.wsh.WorkflowRequest startWorkflow75,
            com.informatica.wsh.SessionHeader context76,
            final DataIntegrationServiceCallbackHandler callback)
            throws java.rmi.RemoteException {
        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[16].getName());
        _operationClient.getOptions()
                .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/startWorkflowRequest");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(_operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        //Style is Doc.
        env = toEnvelope(getFactory(_operationClient.getOptions()
                        .getSoapVersionURI()),
                startWorkflow75,
                optimizeContent(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh", "startWorkflow")),
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "startWorkflow"));

        // add the soap_headers only if they are not null
        if (context76 != null) {
            org.apache.axiom.om.OMElement omElementcontext76 = toOM(context76,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh", "startWorkflow")));
            addHeader(omElementcontext76, env);
        }

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(
                    org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    Object object = fromOM(resultEnv.getBody()
                                    .getFirstElement(),
                            com.informatica.wsh.VoidResponse.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultstartWorkflow((com.informatica.wsh.VoidResponse) object);
                } catch (AxisFault e) {
                    callback.receiveErrorstartWorkflow(e);
                }
            }

            public void onError(Exception error) {
                if (error instanceof AxisFault) {
                    AxisFault f = (AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();

                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(
                                new FaultMapKey(
                                        faultElt.getQName(), "startWorkflow"))) {
                            //make the fault by reflection
                            try {
                                String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "startWorkflow"));
                                Class exceptionClass = Class.forName(exceptionClassName);
                                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                Exception ex = (Exception) constructor.newInstance(f.getMessage());

                                //message class
                                String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "startWorkflow"));
                                Class messageClass = Class.forName(messageClassName);
                                Object messageObject = fromOM(faultElt,
                                        messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new Class[] { messageClass });
                                m.invoke(ex,
                                        new Object[] { messageObject });

                                if (ex instanceof Fault) {
                                    callback.receiveErrorstartWorkflow((Fault) ex);

                                    return;
                                }

                                callback.receiveErrorstartWorkflow(new java.rmi.RemoteException(
                                        ex.getMessage(), ex));
                            } catch (ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartWorkflow(f);
                            } catch (ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartWorkflow(f);
                            } catch (NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartWorkflow(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartWorkflow(f);
                            } catch (IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartWorkflow(f);
                            } catch (InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartWorkflow(f);
                            } catch (AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartWorkflow(f);
                            }
                        } else {
                            callback.receiveErrorstartWorkflow(f);
                        }
                    } else {
                        callback.receiveErrorstartWorkflow(f);
                    }
                } else {
                    callback.receiveErrorstartWorkflow(error);
                }
            }

            public void onFault(
                    org.apache.axis2.context.MessageContext faultContext) {
                AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender()
                            .cleanup(_messageContext);
                } catch (AxisFault axisFault) {
                    callback.receiveErrorstartWorkflow(axisFault);
                }
            }
        });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

        if ((_operations[16].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[16].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);
    }

    /**
     * Auto generated method signature
     *
     * @see DataIntegrationService#stopTask
     * @param stopTask78
     * @param context79
     * @throwscl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault :
     */
    public com.informatica.wsh.VoidResponse stopTask(
            com.informatica.wsh.TaskRequest stopTask78,
            com.informatica.wsh.SessionHeader context79)
            throws java.rmi.RemoteException,Fault {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[17].getName());
            _operationClient.getOptions()
                    .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/stopTaskRequest");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                    "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                            .getSoapVersionURI()),
                    stopTask78,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh", "stopTask")),
                    new javax.xml.namespace.QName(
                            "http://www.informatica.com/wsh", "stopTask"));

            env.build();

            // add the children only if the parameter is not null
            if (context79 != null) {
                org.apache.axiom.om.OMElement omElementcontext79 = toOM(context79,
                        optimizeContent(
                                new javax.xml.namespace.QName(
                                        "http://www.informatica.com/wsh", "stopTask")));
                addHeader(omElementcontext79, env);
            }

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            Object object = fromOM(_returnEnv.getBody()
                            .getFirstElement(),
                    com.informatica.wsh.VoidResponse.class,
                    getEnvelopeNamespaces(_returnEnv));

            return (com.informatica.wsh.VoidResponse) object;
        } catch (AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                        new FaultMapKey(
                                faultElt.getQName(), "stopTask"))) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                faultElt.getQName(), "stopTask"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        Exception ex = (Exception) constructor.newInstance(f.getMessage());

                        //message class
                        String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                faultElt.getQName(), "stopTask"));
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        if (ex instanceof Fault) {
                            throw (Fault) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                        .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see DataIntegrationService#startstopTask
     * @param stopTask78
     * @param context79
     */
    public void startstopTask(com.informatica.wsh.TaskRequest stopTask78,
                              com.informatica.wsh.SessionHeader context79,
                              final DataIntegrationServiceCallbackHandler callback)
            throws java.rmi.RemoteException {
        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[17].getName());
        _operationClient.getOptions()
                .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/stopTaskRequest");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(_operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        //Style is Doc.
        env = toEnvelope(getFactory(_operationClient.getOptions()
                        .getSoapVersionURI()),
                stopTask78,
                optimizeContent(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh", "stopTask")),
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "stopTask"));

        // add the soap_headers only if they are not null
        if (context79 != null) {
            org.apache.axiom.om.OMElement omElementcontext79 = toOM(context79,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh", "stopTask")));
            addHeader(omElementcontext79, env);
        }

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(
                    org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    Object object = fromOM(resultEnv.getBody()
                                    .getFirstElement(),
                            com.informatica.wsh.VoidResponse.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultstopTask((com.informatica.wsh.VoidResponse) object);
                } catch (AxisFault e) {
                    callback.receiveErrorstopTask(e);
                }
            }

            public void onError(Exception error) {
                if (error instanceof AxisFault) {
                    AxisFault f = (AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();

                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(
                                new FaultMapKey(
                                        faultElt.getQName(), "stopTask"))) {
                            //make the fault by reflection
                            try {
                                String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                        faultElt.getQName(), "stopTask"));
                                Class exceptionClass = Class.forName(exceptionClassName);
                                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                Exception ex = (Exception) constructor.newInstance(f.getMessage());

                                //message class
                                String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                        faultElt.getQName(), "stopTask"));
                                Class messageClass = Class.forName(messageClassName);
                                Object messageObject = fromOM(faultElt,
                                        messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new Class[] { messageClass });
                                m.invoke(ex,
                                        new Object[] { messageObject });

                                if (ex instanceof Fault) {
                                    callback.receiveErrorstopTask((Fault) ex);

                                    return;
                                }

                                callback.receiveErrorstopTask(new java.rmi.RemoteException(
                                        ex.getMessage(), ex));
                            } catch (ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstopTask(f);
                            } catch (ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstopTask(f);
                            } catch (NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstopTask(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstopTask(f);
                            } catch (IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstopTask(f);
                            } catch (InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstopTask(f);
                            } catch (AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstopTask(f);
                            }
                        } else {
                            callback.receiveErrorstopTask(f);
                        }
                    } else {
                        callback.receiveErrorstopTask(f);
                    }
                } else {
                    callback.receiveErrorstopTask(error);
                }
            }

            public void onFault(
                    org.apache.axis2.context.MessageContext faultContext) {
                AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender()
                            .cleanup(_messageContext);
                } catch (AxisFault axisFault) {
                    callback.receiveErrorstopTask(axisFault);
                }
            }
        });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

        if ((_operations[17].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[17].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);
    }

    /**
     * Auto generated method signature
     *
     * @see DataIntegrationService#startTask
     * @param startTask81
     * @param context82
     * @throwscl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault :
     */
    public com.informatica.wsh.VoidResponse startTask(
            com.informatica.wsh.TaskRequest startTask81,
            com.informatica.wsh.SessionHeader context82)
            throws java.rmi.RemoteException,Fault {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[18].getName());
            _operationClient.getOptions()
                    .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/startTaskRequest");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                    "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                            .getSoapVersionURI()),
                    startTask81,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh", "startTask")),
                    new javax.xml.namespace.QName(
                            "http://www.informatica.com/wsh", "startTask"));

            env.build();

            // add the children only if the parameter is not null
            if (context82 != null) {
                org.apache.axiom.om.OMElement omElementcontext82 = toOM(context82,
                        optimizeContent(
                                new javax.xml.namespace.QName(
                                        "http://www.informatica.com/wsh", "startTask")));
                addHeader(omElementcontext82, env);
            }

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            Object object = fromOM(_returnEnv.getBody()
                            .getFirstElement(),
                    com.informatica.wsh.VoidResponse.class,
                    getEnvelopeNamespaces(_returnEnv));

            return (com.informatica.wsh.VoidResponse) object;
        } catch (AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                        new FaultMapKey(
                                faultElt.getQName(), "startTask"))) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                faultElt.getQName(), "startTask"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        Exception ex = (Exception) constructor.newInstance(f.getMessage());

                        //message class
                        String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                faultElt.getQName(), "startTask"));
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        if (ex instanceof Fault) {
                            throw (Fault) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                        .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see DataIntegrationService#startstartTask
     * @param startTask81
     * @param context82
     */
    public void startstartTask(com.informatica.wsh.TaskRequest startTask81,
                               com.informatica.wsh.SessionHeader context82,
                               final DataIntegrationServiceCallbackHandler callback)
            throws java.rmi.RemoteException {
        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[18].getName());
        _operationClient.getOptions()
                .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/startTaskRequest");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(_operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        //Style is Doc.
        env = toEnvelope(getFactory(_operationClient.getOptions()
                        .getSoapVersionURI()),
                startTask81,
                optimizeContent(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh", "startTask")),
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "startTask"));

        // add the soap_headers only if they are not null
        if (context82 != null) {
            org.apache.axiom.om.OMElement omElementcontext82 = toOM(context82,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh", "startTask")));
            addHeader(omElementcontext82, env);
        }

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(
                    org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    Object object = fromOM(resultEnv.getBody()
                                    .getFirstElement(),
                            com.informatica.wsh.VoidResponse.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultstartTask((com.informatica.wsh.VoidResponse) object);
                } catch (AxisFault e) {
                    callback.receiveErrorstartTask(e);
                }
            }

            public void onError(Exception error) {
                if (error instanceof AxisFault) {
                    AxisFault f = (AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();

                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(
                                new FaultMapKey(
                                        faultElt.getQName(), "startTask"))) {
                            //make the fault by reflection
                            try {
                                String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                        faultElt.getQName(), "startTask"));
                                Class exceptionClass = Class.forName(exceptionClassName);
                                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                Exception ex = (Exception) constructor.newInstance(f.getMessage());

                                //message class
                                String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                        faultElt.getQName(), "startTask"));
                                Class messageClass = Class.forName(messageClassName);
                                Object messageObject = fromOM(faultElt,
                                        messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new Class[] { messageClass });
                                m.invoke(ex,
                                        new Object[] { messageObject });

                                if (ex instanceof Fault) {
                                    callback.receiveErrorstartTask((Fault) ex);

                                    return;
                                }

                                callback.receiveErrorstartTask(new java.rmi.RemoteException(
                                        ex.getMessage(), ex));
                            } catch (ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartTask(f);
                            } catch (ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartTask(f);
                            } catch (NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartTask(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartTask(f);
                            } catch (IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartTask(f);
                            } catch (InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartTask(f);
                            } catch (AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartTask(f);
                            }
                        } else {
                            callback.receiveErrorstartTask(f);
                        }
                    } else {
                        callback.receiveErrorstartTask(f);
                    }
                } else {
                    callback.receiveErrorstartTask(error);
                }
            }

            public void onFault(
                    org.apache.axis2.context.MessageContext faultContext) {
                AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender()
                            .cleanup(_messageContext);
                } catch (AxisFault axisFault) {
                    callback.receiveErrorstartTask(axisFault);
                }
            }
        });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

        if ((_operations[18].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[18].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);
    }

    /**
     * Auto generated method signature
     *
     * @see DataIntegrationService#getSessionPerformanceData
     * @param getSessionPerformanceData84
     * @param context85
     * @throwscl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault :
     */
    public com.informatica.wsh.SessionPerformanceData getSessionPerformanceData(
            com.informatica.wsh.GetSessionPerformanceDataRequest getSessionPerformanceData84,
            com.informatica.wsh.SessionHeader context85)
            throws java.rmi.RemoteException,Fault {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[19].getName());
            _operationClient.getOptions()
                    .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/getSessionPerformanceDataRequest");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                    "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                            .getSoapVersionURI()),
                    getSessionPerformanceData84,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh",
                                    "getSessionPerformanceData")),
                    new javax.xml.namespace.QName(
                            "http://www.informatica.com/wsh",
                            "getSessionPerformanceData"));

            env.build();

            // add the children only if the parameter is not null
            if (context85 != null) {
                org.apache.axiom.om.OMElement omElementcontext85 = toOM(context85,
                        optimizeContent(
                                new javax.xml.namespace.QName(
                                        "http://www.informatica.com/wsh",
                                        "getSessionPerformanceData")));
                addHeader(omElementcontext85, env);
            }

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            Object object = fromOM(_returnEnv.getBody()
                            .getFirstElement(),
                    com.informatica.wsh.SessionPerformanceData.class,
                    getEnvelopeNamespaces(_returnEnv));

            return (com.informatica.wsh.SessionPerformanceData) object;
        } catch (AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                        new FaultMapKey(
                                faultElt.getQName(), "getSessionPerformanceData"))) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                faultElt.getQName(),
                                "getSessionPerformanceData"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        Exception ex = (Exception) constructor.newInstance(f.getMessage());

                        //message class
                        String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                faultElt.getQName(),
                                "getSessionPerformanceData"));
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        if (ex instanceof Fault) {
                            throw (Fault) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                        .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see DataIntegrationService#startgetSessionPerformanceData
     * @param getSessionPerformanceData84
     * @param context85
     */
    public void startgetSessionPerformanceData(
            com.informatica.wsh.GetSessionPerformanceDataRequest getSessionPerformanceData84,
            com.informatica.wsh.SessionHeader context85,
            final DataIntegrationServiceCallbackHandler callback)
            throws java.rmi.RemoteException {
        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[19].getName());
        _operationClient.getOptions()
                .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/getSessionPerformanceDataRequest");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(_operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        //Style is Doc.
        env = toEnvelope(getFactory(_operationClient.getOptions()
                        .getSoapVersionURI()),
                getSessionPerformanceData84,
                optimizeContent(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh",
                                "getSessionPerformanceData")),
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh",
                        "getSessionPerformanceData"));

        // add the soap_headers only if they are not null
        if (context85 != null) {
            org.apache.axiom.om.OMElement omElementcontext85 = toOM(context85,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh",
                                    "getSessionPerformanceData")));
            addHeader(omElementcontext85, env);
        }

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(
                    org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    Object object = fromOM(resultEnv.getBody()
                                    .getFirstElement(),
                            com.informatica.wsh.SessionPerformanceData.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultgetSessionPerformanceData((com.informatica.wsh.SessionPerformanceData) object);
                } catch (AxisFault e) {
                    callback.receiveErrorgetSessionPerformanceData(e);
                }
            }

            public void onError(Exception error) {
                if (error instanceof AxisFault) {
                    AxisFault f = (AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();

                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(
                                new FaultMapKey(
                                        faultElt.getQName(),
                                        "getSessionPerformanceData"))) {
                            //make the fault by reflection
                            try {
                                String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "getSessionPerformanceData"));
                                Class exceptionClass = Class.forName(exceptionClassName);
                                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                Exception ex = (Exception) constructor.newInstance(f.getMessage());

                                //message class
                                String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "getSessionPerformanceData"));
                                Class messageClass = Class.forName(messageClassName);
                                Object messageObject = fromOM(faultElt,
                                        messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new Class[] { messageClass });
                                m.invoke(ex,
                                        new Object[] { messageObject });

                                if (ex instanceof Fault) {
                                    callback.receiveErrorgetSessionPerformanceData((Fault) ex);

                                    return;
                                }

                                callback.receiveErrorgetSessionPerformanceData(new java.rmi.RemoteException(
                                        ex.getMessage(), ex));
                            } catch (ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetSessionPerformanceData(f);
                            } catch (ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetSessionPerformanceData(f);
                            } catch (NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetSessionPerformanceData(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetSessionPerformanceData(f);
                            } catch (IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetSessionPerformanceData(f);
                            } catch (InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetSessionPerformanceData(f);
                            } catch (AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetSessionPerformanceData(f);
                            }
                        } else {
                            callback.receiveErrorgetSessionPerformanceData(f);
                        }
                    } else {
                        callback.receiveErrorgetSessionPerformanceData(f);
                    }
                } else {
                    callback.receiveErrorgetSessionPerformanceData(error);
                }
            }

            public void onFault(
                    org.apache.axis2.context.MessageContext faultContext) {
                AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender()
                            .cleanup(_messageContext);
                } catch (AxisFault axisFault) {
                    callback.receiveErrorgetSessionPerformanceData(axisFault);
                }
            }
        });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

        if ((_operations[19].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[19].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);
    }

    /**
     * Auto generated method signature
     *
     * @see DataIntegrationService#startWorkflowEx
     * @param startWorkflowEx87
     * @param context88
     * @throwscl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault :
     */
    public com.informatica.wsh.TypeStartWorkflowExResponse startWorkflowEx(
            com.informatica.wsh.TypeStartWorkflowExRequest startWorkflowEx87,
            com.informatica.wsh.SessionHeader context88)
            throws java.rmi.RemoteException,Fault {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[20].getName());
            _operationClient.getOptions()
                    .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/startWorkflowExRequest");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                    "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                            .getSoapVersionURI()),
                    startWorkflowEx87,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh", "startWorkflowEx")),
                    new javax.xml.namespace.QName(
                            "http://www.informatica.com/wsh", "startWorkflowEx"));

            env.build();

            // add the children only if the parameter is not null
            if (context88 != null) {
                org.apache.axiom.om.OMElement omElementcontext88 = toOM(context88,
                        optimizeContent(
                                new javax.xml.namespace.QName(
                                        "http://www.informatica.com/wsh",
                                        "startWorkflowEx")));
                addHeader(omElementcontext88, env);
            }

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            Object object = fromOM(_returnEnv.getBody()
                            .getFirstElement(),
                    com.informatica.wsh.TypeStartWorkflowExResponse.class,
                    getEnvelopeNamespaces(_returnEnv));

            return (com.informatica.wsh.TypeStartWorkflowExResponse) object;
        } catch (AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                        new FaultMapKey(
                                faultElt.getQName(), "startWorkflowEx"))) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                faultElt.getQName(), "startWorkflowEx"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        Exception ex = (Exception) constructor.newInstance(f.getMessage());

                        //message class
                        String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                faultElt.getQName(), "startWorkflowEx"));
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        if (ex instanceof Fault) {
                            throw (Fault) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                        .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see DataIntegrationService#startstartWorkflowEx
     * @param startWorkflowEx87
     * @param context88
     */
    public void startstartWorkflowEx(
            com.informatica.wsh.TypeStartWorkflowExRequest startWorkflowEx87,
            com.informatica.wsh.SessionHeader context88,
            final DataIntegrationServiceCallbackHandler callback)
            throws java.rmi.RemoteException {
        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[20].getName());
        _operationClient.getOptions()
                .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/startWorkflowExRequest");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(_operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        //Style is Doc.
        env = toEnvelope(getFactory(_operationClient.getOptions()
                        .getSoapVersionURI()),
                startWorkflowEx87,
                optimizeContent(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh", "startWorkflowEx")),
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "startWorkflowEx"));

        // add the soap_headers only if they are not null
        if (context88 != null) {
            org.apache.axiom.om.OMElement omElementcontext88 = toOM(context88,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh", "startWorkflowEx")));
            addHeader(omElementcontext88, env);
        }

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(
                    org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    Object object = fromOM(resultEnv.getBody()
                                    .getFirstElement(),
                            com.informatica.wsh.TypeStartWorkflowExResponse.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultstartWorkflowEx((com.informatica.wsh.TypeStartWorkflowExResponse) object);
                } catch (AxisFault e) {
                    callback.receiveErrorstartWorkflowEx(e);
                }
            }

            public void onError(Exception error) {
                if (error instanceof AxisFault) {
                    AxisFault f = (AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();

                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(
                                new FaultMapKey(
                                        faultElt.getQName(),
                                        "startWorkflowEx"))) {
                            //make the fault by reflection
                            try {
                                String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "startWorkflowEx"));
                                Class exceptionClass = Class.forName(exceptionClassName);
                                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                Exception ex = (Exception) constructor.newInstance(f.getMessage());

                                //message class
                                String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "startWorkflowEx"));
                                Class messageClass = Class.forName(messageClassName);
                                Object messageObject = fromOM(faultElt,
                                        messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new Class[] { messageClass });
                                m.invoke(ex,
                                        new Object[] { messageObject });

                                if (ex instanceof Fault) {
                                    callback.receiveErrorstartWorkflowEx((Fault) ex);

                                    return;
                                }

                                callback.receiveErrorstartWorkflowEx(new java.rmi.RemoteException(
                                        ex.getMessage(), ex));
                            } catch (ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartWorkflowEx(f);
                            } catch (ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartWorkflowEx(f);
                            } catch (NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartWorkflowEx(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartWorkflowEx(f);
                            } catch (IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartWorkflowEx(f);
                            } catch (InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartWorkflowEx(f);
                            } catch (AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartWorkflowEx(f);
                            }
                        } else {
                            callback.receiveErrorstartWorkflowEx(f);
                        }
                    } else {
                        callback.receiveErrorstartWorkflowEx(f);
                    }
                } else {
                    callback.receiveErrorstartWorkflowEx(error);
                }
            }

            public void onFault(
                    org.apache.axis2.context.MessageContext faultContext) {
                AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender()
                            .cleanup(_messageContext);
                } catch (AxisFault axisFault) {
                    callback.receiveErrorstartWorkflowEx(axisFault);
                }
            }
        });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

        if ((_operations[20].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[20].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);
    }

    /**
     * Auto generated method signature
     *
     * @see DataIntegrationService#getTaskDetailsEx
     * @param getTaskDetailsEx90
     * @param context91
     * @throwscl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault :
     */
    public com.informatica.wsh.DIServerDetails getTaskDetailsEx(
            com.informatica.wsh.TypeGetTaskDetailsExRequest getTaskDetailsEx90,
            com.informatica.wsh.SessionHeader context91)
            throws java.rmi.RemoteException,Fault {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[21].getName());
            _operationClient.getOptions()
                    .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/getTaskDetailsExRequest");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                    "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                            .getSoapVersionURI()),
                    getTaskDetailsEx90,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh", "getTaskDetailsEx")),
                    new javax.xml.namespace.QName(
                            "http://www.informatica.com/wsh", "getTaskDetailsEx"));

            env.build();

            // add the children only if the parameter is not null
            if (context91 != null) {
                org.apache.axiom.om.OMElement omElementcontext91 = toOM(context91,
                        optimizeContent(
                                new javax.xml.namespace.QName(
                                        "http://www.informatica.com/wsh",
                                        "getTaskDetailsEx")));
                addHeader(omElementcontext91, env);
            }

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            Object object = fromOM(_returnEnv.getBody()
                            .getFirstElement(),
                    com.informatica.wsh.DIServerDetails.class,
                    getEnvelopeNamespaces(_returnEnv));

            return (com.informatica.wsh.DIServerDetails) object;
        } catch (AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                        new FaultMapKey(
                                faultElt.getQName(), "getTaskDetailsEx"))) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                faultElt.getQName(), "getTaskDetailsEx"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        Exception ex = (Exception) constructor.newInstance(f.getMessage());

                        //message class
                        String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                faultElt.getQName(), "getTaskDetailsEx"));
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        if (ex instanceof Fault) {
                            throw (Fault) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                        .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see DataIntegrationService#startgetTaskDetailsEx
     * @param getTaskDetailsEx90
     * @param context91
     */
    public void startgetTaskDetailsEx(
            com.informatica.wsh.TypeGetTaskDetailsExRequest getTaskDetailsEx90,
            com.informatica.wsh.SessionHeader context91,
            final DataIntegrationServiceCallbackHandler callback)
            throws java.rmi.RemoteException {
        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[21].getName());
        _operationClient.getOptions()
                .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/getTaskDetailsExRequest");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(_operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        //Style is Doc.
        env = toEnvelope(getFactory(_operationClient.getOptions()
                        .getSoapVersionURI()),
                getTaskDetailsEx90,
                optimizeContent(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh", "getTaskDetailsEx")),
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "getTaskDetailsEx"));

        // add the soap_headers only if they are not null
        if (context91 != null) {
            org.apache.axiom.om.OMElement omElementcontext91 = toOM(context91,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh", "getTaskDetailsEx")));
            addHeader(omElementcontext91, env);
        }

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(
                    org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    Object object = fromOM(resultEnv.getBody()
                                    .getFirstElement(),
                            com.informatica.wsh.DIServerDetails.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultgetTaskDetailsEx((com.informatica.wsh.DIServerDetails) object);
                } catch (AxisFault e) {
                    callback.receiveErrorgetTaskDetailsEx(e);
                }
            }

            public void onError(Exception error) {
                if (error instanceof AxisFault) {
                    AxisFault f = (AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();

                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(
                                new FaultMapKey(
                                        faultElt.getQName(),
                                        "getTaskDetailsEx"))) {
                            //make the fault by reflection
                            try {
                                String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "getTaskDetailsEx"));
                                Class exceptionClass = Class.forName(exceptionClassName);
                                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                Exception ex = (Exception) constructor.newInstance(f.getMessage());

                                //message class
                                String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "getTaskDetailsEx"));
                                Class messageClass = Class.forName(messageClassName);
                                Object messageObject = fromOM(faultElt,
                                        messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new Class[] { messageClass });
                                m.invoke(ex,
                                        new Object[] { messageObject });

                                if (ex instanceof Fault) {
                                    callback.receiveErrorgetTaskDetailsEx((Fault) ex);

                                    return;
                                }

                                callback.receiveErrorgetTaskDetailsEx(new java.rmi.RemoteException(
                                        ex.getMessage(), ex));
                            } catch (ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetTaskDetailsEx(f);
                            } catch (ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetTaskDetailsEx(f);
                            } catch (NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetTaskDetailsEx(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetTaskDetailsEx(f);
                            } catch (IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetTaskDetailsEx(f);
                            } catch (InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetTaskDetailsEx(f);
                            } catch (AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetTaskDetailsEx(f);
                            }
                        } else {
                            callback.receiveErrorgetTaskDetailsEx(f);
                        }
                    } else {
                        callback.receiveErrorgetTaskDetailsEx(f);
                    }
                } else {
                    callback.receiveErrorgetTaskDetailsEx(error);
                }
            }

            public void onFault(
                    org.apache.axis2.context.MessageContext faultContext) {
                AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender()
                            .cleanup(_messageContext);
                } catch (AxisFault axisFault) {
                    callback.receiveErrorgetTaskDetailsEx(axisFault);
                }
            }
        });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

        if ((_operations[21].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[21].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);
    }

    /**
     * Auto generated method signature
     *
     * @see DataIntegrationService#startWorkflowFromTask
     * @param startWorkflowFromTask93
     * @param context94
     * @throwscl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault :
     */
    public com.informatica.wsh.VoidResponse startWorkflowFromTask(
            com.informatica.wsh.WorkflowRequest startWorkflowFromTask93,
            com.informatica.wsh.SessionHeader context94)
            throws java.rmi.RemoteException,Fault {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[22].getName());
            _operationClient.getOptions()
                    .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/startWorkflowFromTaskRequest");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                    "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                            .getSoapVersionURI()),
                    startWorkflowFromTask93,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh",
                                    "startWorkflowFromTask")),
                    new javax.xml.namespace.QName(
                            "http://www.informatica.com/wsh",
                            "startWorkflowFromTask"));

            env.build();

            // add the children only if the parameter is not null
            if (context94 != null) {
                org.apache.axiom.om.OMElement omElementcontext94 = toOM(context94,
                        optimizeContent(
                                new javax.xml.namespace.QName(
                                        "http://www.informatica.com/wsh",
                                        "startWorkflowFromTask")));
                addHeader(omElementcontext94, env);
            }

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            Object object = fromOM(_returnEnv.getBody()
                            .getFirstElement(),
                    com.informatica.wsh.VoidResponse.class,
                    getEnvelopeNamespaces(_returnEnv));

            return (com.informatica.wsh.VoidResponse) object;
        } catch (AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                        new FaultMapKey(
                                faultElt.getQName(), "startWorkflowFromTask"))) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                faultElt.getQName(), "startWorkflowFromTask"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        Exception ex = (Exception) constructor.newInstance(f.getMessage());

                        //message class
                        String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                faultElt.getQName(), "startWorkflowFromTask"));
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        if (ex instanceof Fault) {
                            throw (Fault) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                        .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see DataIntegrationService#startstartWorkflowFromTask
     * @param startWorkflowFromTask93
     * @param context94
     */
    public void startstartWorkflowFromTask(
            com.informatica.wsh.WorkflowRequest startWorkflowFromTask93,
            com.informatica.wsh.SessionHeader context94,
            final DataIntegrationServiceCallbackHandler callback)
            throws java.rmi.RemoteException {
        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[22].getName());
        _operationClient.getOptions()
                .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/startWorkflowFromTaskRequest");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(_operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        //Style is Doc.
        env = toEnvelope(getFactory(_operationClient.getOptions()
                        .getSoapVersionURI()),
                startWorkflowFromTask93,
                optimizeContent(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh",
                                "startWorkflowFromTask")),
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "startWorkflowFromTask"));

        // add the soap_headers only if they are not null
        if (context94 != null) {
            org.apache.axiom.om.OMElement omElementcontext94 = toOM(context94,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh",
                                    "startWorkflowFromTask")));
            addHeader(omElementcontext94, env);
        }

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(
                    org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    Object object = fromOM(resultEnv.getBody()
                                    .getFirstElement(),
                            com.informatica.wsh.VoidResponse.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultstartWorkflowFromTask((com.informatica.wsh.VoidResponse) object);
                } catch (AxisFault e) {
                    callback.receiveErrorstartWorkflowFromTask(e);
                }
            }

            public void onError(Exception error) {
                if (error instanceof AxisFault) {
                    AxisFault f = (AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();

                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(
                                new FaultMapKey(
                                        faultElt.getQName(),
                                        "startWorkflowFromTask"))) {
                            //make the fault by reflection
                            try {
                                String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "startWorkflowFromTask"));
                                Class exceptionClass = Class.forName(exceptionClassName);
                                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                Exception ex = (Exception) constructor.newInstance(f.getMessage());

                                //message class
                                String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "startWorkflowFromTask"));
                                Class messageClass = Class.forName(messageClassName);
                                Object messageObject = fromOM(faultElt,
                                        messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new Class[] { messageClass });
                                m.invoke(ex,
                                        new Object[] { messageObject });

                                if (ex instanceof Fault) {
                                    callback.receiveErrorstartWorkflowFromTask((Fault) ex);

                                    return;
                                }

                                callback.receiveErrorstartWorkflowFromTask(new java.rmi.RemoteException(
                                        ex.getMessage(), ex));
                            } catch (ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartWorkflowFromTask(f);
                            } catch (ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartWorkflowFromTask(f);
                            } catch (NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartWorkflowFromTask(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartWorkflowFromTask(f);
                            } catch (IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartWorkflowFromTask(f);
                            } catch (InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartWorkflowFromTask(f);
                            } catch (AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorstartWorkflowFromTask(f);
                            }
                        } else {
                            callback.receiveErrorstartWorkflowFromTask(f);
                        }
                    } else {
                        callback.receiveErrorstartWorkflowFromTask(f);
                    }
                } else {
                    callback.receiveErrorstartWorkflowFromTask(error);
                }
            }

            public void onFault(
                    org.apache.axis2.context.MessageContext faultContext) {
                AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender()
                            .cleanup(_messageContext);
                } catch (AxisFault axisFault) {
                    callback.receiveErrorstartWorkflowFromTask(axisFault);
                }
            }
        });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

        if ((_operations[22].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[22].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);
    }

    /**
     * Auto generated method signature
     *
     * @see DataIntegrationService#logout
     * @param logout96
     * @param context97
     * @throwscl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault :
     */
    public com.informatica.wsh.VoidResponse logout(
            com.informatica.wsh.VoidRequest logout96,
            com.informatica.wsh.SessionHeader context97)
            throws java.rmi.RemoteException,Fault {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[23].getName());
            _operationClient.getOptions()
                    .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/LogoutRequest");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                    "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                            .getSoapVersionURI()),
                    logout96,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh", "logout")),
                    new javax.xml.namespace.QName(
                            "http://www.informatica.com/wsh", "logout"));

            env.build();

            // add the children only if the parameter is not null
            if (context97 != null) {
                org.apache.axiom.om.OMElement omElementcontext97 = toOM(context97,
                        optimizeContent(
                                new javax.xml.namespace.QName(
                                        "http://www.informatica.com/wsh", "logout")));
                addHeader(omElementcontext97, env);
            }

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            Object object = fromOM(_returnEnv.getBody()
                            .getFirstElement(),
                    com.informatica.wsh.VoidResponse.class,
                    getEnvelopeNamespaces(_returnEnv));

            return (com.informatica.wsh.VoidResponse) object;
        } catch (AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                        new FaultMapKey(
                                faultElt.getQName(), "logout"))) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                faultElt.getQName(), "logout"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        Exception ex = (Exception) constructor.newInstance(f.getMessage());

                        //message class
                        String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                faultElt.getQName(), "logout"));
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        if (ex instanceof Fault) {
                            throw (Fault) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                        .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see DataIntegrationService#startlogout
     * @param logout96
     * @param context97
     */
    public void startlogout(com.informatica.wsh.VoidRequest logout96,
                            com.informatica.wsh.SessionHeader context97,
                            final DataIntegrationServiceCallbackHandler callback)
            throws java.rmi.RemoteException {
        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[23].getName());
        _operationClient.getOptions()
                .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/LogoutRequest");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(_operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        //Style is Doc.
        env = toEnvelope(getFactory(_operationClient.getOptions()
                        .getSoapVersionURI()),
                logout96,
                optimizeContent(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh", "logout")),
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "logout"));

        // add the soap_headers only if they are not null
        if (context97 != null) {
            org.apache.axiom.om.OMElement omElementcontext97 = toOM(context97,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh", "logout")));
            addHeader(omElementcontext97, env);
        }

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(
                    org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    Object object = fromOM(resultEnv.getBody()
                                    .getFirstElement(),
                            com.informatica.wsh.VoidResponse.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultlogout((com.informatica.wsh.VoidResponse) object);
                } catch (AxisFault e) {
                    callback.receiveErrorlogout(e);
                }
            }

            public void onError(Exception error) {
                if (error instanceof AxisFault) {
                    AxisFault f = (AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();

                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(
                                new FaultMapKey(
                                        faultElt.getQName(), "logout"))) {
                            //make the fault by reflection
                            try {
                                String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                        faultElt.getQName(), "logout"));
                                Class exceptionClass = Class.forName(exceptionClassName);
                                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                Exception ex = (Exception) constructor.newInstance(f.getMessage());

                                //message class
                                String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                        faultElt.getQName(), "logout"));
                                Class messageClass = Class.forName(messageClassName);
                                Object messageObject = fromOM(faultElt,
                                        messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new Class[] { messageClass });
                                m.invoke(ex,
                                        new Object[] { messageObject });

                                if (ex instanceof Fault) {
                                    callback.receiveErrorlogout((Fault) ex);

                                    return;
                                }

                                callback.receiveErrorlogout(new java.rmi.RemoteException(
                                        ex.getMessage(), ex));
                            } catch (ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorlogout(f);
                            } catch (ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorlogout(f);
                            } catch (NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorlogout(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorlogout(f);
                            } catch (IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorlogout(f);
                            } catch (InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorlogout(f);
                            } catch (AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorlogout(f);
                            }
                        } else {
                            callback.receiveErrorlogout(f);
                        }
                    } else {
                        callback.receiveErrorlogout(f);
                    }
                } else {
                    callback.receiveErrorlogout(error);
                }
            }

            public void onFault(
                    org.apache.axis2.context.MessageContext faultContext) {
                AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender()
                            .cleanup(_messageContext);
                } catch (AxisFault axisFault) {
                    callback.receiveErrorlogout(axisFault);
                }
            }
        });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

        if ((_operations[23].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[23].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);
    }

    /**
     * Auto generated method signature
     *
     * @see DataIntegrationService#getWorkflowDetailsEx
     * @param getWorkflowDetailsEx99
     * @param context100
     * @throwscl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault :
     */
    public com.informatica.wsh.DIServerDetails getWorkflowDetailsEx(
            com.informatica.wsh.TypeGetWorkflowDetailsExRequest getWorkflowDetailsEx99,
            com.informatica.wsh.SessionHeader context100)
            throws java.rmi.RemoteException,Fault {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[24].getName());
            _operationClient.getOptions()
                    .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/getWorkflowDetailsExRequest");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                    "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                            .getSoapVersionURI()),
                    getWorkflowDetailsEx99,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh",
                                    "getWorkflowDetailsEx")),
                    new javax.xml.namespace.QName(
                            "http://www.informatica.com/wsh", "getWorkflowDetailsEx"));

            env.build();

            // add the children only if the parameter is not null
            if (context100 != null) {
                org.apache.axiom.om.OMElement omElementcontext100 = toOM(context100,
                        optimizeContent(
                                new javax.xml.namespace.QName(
                                        "http://www.informatica.com/wsh",
                                        "getWorkflowDetailsEx")));
                addHeader(omElementcontext100, env);
            }

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            Object object = fromOM(_returnEnv.getBody()
                            .getFirstElement(),
                    com.informatica.wsh.DIServerDetails.class,
                    getEnvelopeNamespaces(_returnEnv));

            return (com.informatica.wsh.DIServerDetails) object;
        } catch (AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                        new FaultMapKey(
                                faultElt.getQName(), "getWorkflowDetailsEx"))) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                faultElt.getQName(), "getWorkflowDetailsEx"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        Exception ex = (Exception) constructor.newInstance(f.getMessage());

                        //message class
                        String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                faultElt.getQName(), "getWorkflowDetailsEx"));
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        if (ex instanceof Fault) {
                            throw (Fault) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                        .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see DataIntegrationService#startgetWorkflowDetailsEx
     * @param getWorkflowDetailsEx99
     * @param context100
     */
    public void startgetWorkflowDetailsEx(
            com.informatica.wsh.TypeGetWorkflowDetailsExRequest getWorkflowDetailsEx99,
            com.informatica.wsh.SessionHeader context100,
            final DataIntegrationServiceCallbackHandler callback)
            throws java.rmi.RemoteException {
        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[24].getName());
        _operationClient.getOptions()
                .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/getWorkflowDetailsExRequest");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(_operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        //Style is Doc.
        env = toEnvelope(getFactory(_operationClient.getOptions()
                        .getSoapVersionURI()),
                getWorkflowDetailsEx99,
                optimizeContent(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh", "getWorkflowDetailsEx")),
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "getWorkflowDetailsEx"));

        // add the soap_headers only if they are not null
        if (context100 != null) {
            org.apache.axiom.om.OMElement omElementcontext100 = toOM(context100,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh",
                                    "getWorkflowDetailsEx")));
            addHeader(omElementcontext100, env);
        }

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(
                    org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    Object object = fromOM(resultEnv.getBody()
                                    .getFirstElement(),
                            com.informatica.wsh.DIServerDetails.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultgetWorkflowDetailsEx((com.informatica.wsh.DIServerDetails) object);
                } catch (AxisFault e) {
                    callback.receiveErrorgetWorkflowDetailsEx(e);
                }
            }

            public void onError(Exception error) {
                if (error instanceof AxisFault) {
                    AxisFault f = (AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();

                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(
                                new FaultMapKey(
                                        faultElt.getQName(),
                                        "getWorkflowDetailsEx"))) {
                            //make the fault by reflection
                            try {
                                String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "getWorkflowDetailsEx"));
                                Class exceptionClass = Class.forName(exceptionClassName);
                                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                Exception ex = (Exception) constructor.newInstance(f.getMessage());

                                //message class
                                String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "getWorkflowDetailsEx"));
                                Class messageClass = Class.forName(messageClassName);
                                Object messageObject = fromOM(faultElt,
                                        messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new Class[] { messageClass });
                                m.invoke(ex,
                                        new Object[] { messageObject });

                                if (ex instanceof Fault) {
                                    callback.receiveErrorgetWorkflowDetailsEx((Fault) ex);

                                    return;
                                }

                                callback.receiveErrorgetWorkflowDetailsEx(new java.rmi.RemoteException(
                                        ex.getMessage(), ex));
                            } catch (ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetWorkflowDetailsEx(f);
                            } catch (ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetWorkflowDetailsEx(f);
                            } catch (NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetWorkflowDetailsEx(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetWorkflowDetailsEx(f);
                            } catch (IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetWorkflowDetailsEx(f);
                            } catch (InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetWorkflowDetailsEx(f);
                            } catch (AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetWorkflowDetailsEx(f);
                            }
                        } else {
                            callback.receiveErrorgetWorkflowDetailsEx(f);
                        }
                    } else {
                        callback.receiveErrorgetWorkflowDetailsEx(f);
                    }
                } else {
                    callback.receiveErrorgetWorkflowDetailsEx(error);
                }
            }

            public void onFault(
                    org.apache.axis2.context.MessageContext faultContext) {
                AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender()
                            .cleanup(_messageContext);
                } catch (AxisFault axisFault) {
                    callback.receiveErrorgetWorkflowDetailsEx(axisFault);
                }
            }
        });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

        if ((_operations[24].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[24].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);
    }

    /**
     * Auto generated method signature
     *
     * @see DataIntegrationService#monitorDIServer
     * @param monitorDIServer102
     * @param context103
     * @throwscl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault :
     */
    public com.informatica.wsh.DIServerDetails monitorDIServer(
            com.informatica.wsh.MonitorDIServerRequest monitorDIServer102,
            com.informatica.wsh.SessionHeader context103)
            throws java.rmi.RemoteException,Fault {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[25].getName());
            _operationClient.getOptions()
                    .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/monitorDIServerRequest");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                    "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                            .getSoapVersionURI()),
                    monitorDIServer102,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh", "monitorDIServer")),
                    new javax.xml.namespace.QName(
                            "http://www.informatica.com/wsh", "monitorDIServer"));

            env.build();

            // add the children only if the parameter is not null
            if (context103 != null) {
                org.apache.axiom.om.OMElement omElementcontext103 = toOM(context103,
                        optimizeContent(
                                new javax.xml.namespace.QName(
                                        "http://www.informatica.com/wsh",
                                        "monitorDIServer")));
                addHeader(omElementcontext103, env);
            }

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            Object object = fromOM(_returnEnv.getBody()
                            .getFirstElement(),
                    com.informatica.wsh.DIServerDetails.class,
                    getEnvelopeNamespaces(_returnEnv));

            return (com.informatica.wsh.DIServerDetails) object;
        } catch (AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                        new FaultMapKey(
                                faultElt.getQName(), "monitorDIServer"))) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                faultElt.getQName(), "monitorDIServer"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        Exception ex = (Exception) constructor.newInstance(f.getMessage());

                        //message class
                        String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                faultElt.getQName(), "monitorDIServer"));
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        if (ex instanceof Fault) {
                            throw (Fault) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                        .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see DataIntegrationService#startmonitorDIServer
     * @param monitorDIServer102
     * @param context103
     */
    public void startmonitorDIServer(
            com.informatica.wsh.MonitorDIServerRequest monitorDIServer102,
            com.informatica.wsh.SessionHeader context103,
            final DataIntegrationServiceCallbackHandler callback)
            throws java.rmi.RemoteException {
        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[25].getName());
        _operationClient.getOptions()
                .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/monitorDIServerRequest");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(_operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        //Style is Doc.
        env = toEnvelope(getFactory(_operationClient.getOptions()
                        .getSoapVersionURI()),
                monitorDIServer102,
                optimizeContent(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh", "monitorDIServer")),
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "monitorDIServer"));

        // add the soap_headers only if they are not null
        if (context103 != null) {
            org.apache.axiom.om.OMElement omElementcontext103 = toOM(context103,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh", "monitorDIServer")));
            addHeader(omElementcontext103, env);
        }

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(
                    org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    Object object = fromOM(resultEnv.getBody()
                                    .getFirstElement(),
                            com.informatica.wsh.DIServerDetails.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultmonitorDIServer((com.informatica.wsh.DIServerDetails) object);
                } catch (AxisFault e) {
                    callback.receiveErrormonitorDIServer(e);
                }
            }

            public void onError(Exception error) {
                if (error instanceof AxisFault) {
                    AxisFault f = (AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();

                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(
                                new FaultMapKey(
                                        faultElt.getQName(),
                                        "monitorDIServer"))) {
                            //make the fault by reflection
                            try {
                                String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "monitorDIServer"));
                                Class exceptionClass = Class.forName(exceptionClassName);
                                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                Exception ex = (Exception) constructor.newInstance(f.getMessage());

                                //message class
                                String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "monitorDIServer"));
                                Class messageClass = Class.forName(messageClassName);
                                Object messageObject = fromOM(faultElt,
                                        messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new Class[] { messageClass });
                                m.invoke(ex,
                                        new Object[] { messageObject });

                                if (ex instanceof Fault) {
                                    callback.receiveErrormonitorDIServer((Fault) ex);

                                    return;
                                }

                                callback.receiveErrormonitorDIServer(new java.rmi.RemoteException(
                                        ex.getMessage(), ex));
                            } catch (ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrormonitorDIServer(f);
                            } catch (ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrormonitorDIServer(f);
                            } catch (NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrormonitorDIServer(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrormonitorDIServer(f);
                            } catch (IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrormonitorDIServer(f);
                            } catch (InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrormonitorDIServer(f);
                            } catch (AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrormonitorDIServer(f);
                            }
                        } else {
                            callback.receiveErrormonitorDIServer(f);
                        }
                    } else {
                        callback.receiveErrormonitorDIServer(f);
                    }
                } else {
                    callback.receiveErrormonitorDIServer(error);
                }
            }

            public void onFault(
                    org.apache.axis2.context.MessageContext faultContext) {
                AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender()
                            .cleanup(_messageContext);
                } catch (AxisFault axisFault) {
                    callback.receiveErrormonitorDIServer(axisFault);
                }
            }
        });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

        if ((_operations[25].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[25].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);
    }

    /**
     * Auto generated method signature
     *
     * @see DataIntegrationService#waitTillTaskComplete
     * @param waitTillTaskComplete105
     * @param context106
     * @throwscl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault :
     */
    public com.informatica.wsh.VoidResponse waitTillTaskComplete(
            com.informatica.wsh.TaskRequest waitTillTaskComplete105,
            com.informatica.wsh.SessionHeader context106)
            throws java.rmi.RemoteException,Fault {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[26].getName());
            _operationClient.getOptions()
                    .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/waitTillTaskCompleteRequest");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                    "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                            .getSoapVersionURI()),
                    waitTillTaskComplete105,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh",
                                    "waitTillTaskComplete")),
                    new javax.xml.namespace.QName(
                            "http://www.informatica.com/wsh", "waitTillTaskComplete"));

            env.build();

            // add the children only if the parameter is not null
            if (context106 != null) {
                org.apache.axiom.om.OMElement omElementcontext106 = toOM(context106,
                        optimizeContent(
                                new javax.xml.namespace.QName(
                                        "http://www.informatica.com/wsh",
                                        "waitTillTaskComplete")));
                addHeader(omElementcontext106, env);
            }

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            Object object = fromOM(_returnEnv.getBody()
                            .getFirstElement(),
                    com.informatica.wsh.VoidResponse.class,
                    getEnvelopeNamespaces(_returnEnv));

            return (com.informatica.wsh.VoidResponse) object;
        } catch (AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                        new FaultMapKey(
                                faultElt.getQName(), "waitTillTaskComplete"))) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                faultElt.getQName(), "waitTillTaskComplete"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        Exception ex = (Exception) constructor.newInstance(f.getMessage());

                        //message class
                        String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                faultElt.getQName(), "waitTillTaskComplete"));
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        if (ex instanceof Fault) {
                            throw (Fault) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                        .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see DataIntegrationService#startwaitTillTaskComplete
     * @param waitTillTaskComplete105
     * @param context106
     */
    public void startwaitTillTaskComplete(
            com.informatica.wsh.TaskRequest waitTillTaskComplete105,
            com.informatica.wsh.SessionHeader context106,
            final DataIntegrationServiceCallbackHandler callback)
            throws java.rmi.RemoteException {
        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[26].getName());
        _operationClient.getOptions()
                .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/waitTillTaskCompleteRequest");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(_operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        //Style is Doc.
        env = toEnvelope(getFactory(_operationClient.getOptions()
                        .getSoapVersionURI()),
                waitTillTaskComplete105,
                optimizeContent(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh", "waitTillTaskComplete")),
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "waitTillTaskComplete"));

        // add the soap_headers only if they are not null
        if (context106 != null) {
            org.apache.axiom.om.OMElement omElementcontext106 = toOM(context106,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh",
                                    "waitTillTaskComplete")));
            addHeader(omElementcontext106, env);
        }

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(
                    org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    Object object = fromOM(resultEnv.getBody()
                                    .getFirstElement(),
                            com.informatica.wsh.VoidResponse.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultwaitTillTaskComplete((com.informatica.wsh.VoidResponse) object);
                } catch (AxisFault e) {
                    callback.receiveErrorwaitTillTaskComplete(e);
                }
            }

            public void onError(Exception error) {
                if (error instanceof AxisFault) {
                    AxisFault f = (AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();

                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(
                                new FaultMapKey(
                                        faultElt.getQName(),
                                        "waitTillTaskComplete"))) {
                            //make the fault by reflection
                            try {
                                String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "waitTillTaskComplete"));
                                Class exceptionClass = Class.forName(exceptionClassName);
                                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                Exception ex = (Exception) constructor.newInstance(f.getMessage());

                                //message class
                                String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "waitTillTaskComplete"));
                                Class messageClass = Class.forName(messageClassName);
                                Object messageObject = fromOM(faultElt,
                                        messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new Class[] { messageClass });
                                m.invoke(ex,
                                        new Object[] { messageObject });

                                if (ex instanceof Fault) {
                                    callback.receiveErrorwaitTillTaskComplete((Fault) ex);

                                    return;
                                }

                                callback.receiveErrorwaitTillTaskComplete(new java.rmi.RemoteException(
                                        ex.getMessage(), ex));
                            } catch (ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorwaitTillTaskComplete(f);
                            } catch (ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorwaitTillTaskComplete(f);
                            } catch (NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorwaitTillTaskComplete(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorwaitTillTaskComplete(f);
                            } catch (IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorwaitTillTaskComplete(f);
                            } catch (InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorwaitTillTaskComplete(f);
                            } catch (AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorwaitTillTaskComplete(f);
                            }
                        } else {
                            callback.receiveErrorwaitTillTaskComplete(f);
                        }
                    } else {
                        callback.receiveErrorwaitTillTaskComplete(f);
                    }
                } else {
                    callback.receiveErrorwaitTillTaskComplete(error);
                }
            }

            public void onFault(
                    org.apache.axis2.context.MessageContext faultContext) {
                AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender()
                            .cleanup(_messageContext);
                } catch (AxisFault axisFault) {
                    callback.receiveErrorwaitTillTaskComplete(axisFault);
                }
            }
        });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

        if ((_operations[26].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[26].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);
    }

    /**
     * Auto generated method signature
     *
     * @see DataIntegrationService#getTaskDetails
     * @param getTaskDetails108
     * @param context109
     * @throwscl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault :
     */
    public com.informatica.wsh.TaskDetails getTaskDetails(
            com.informatica.wsh.TaskRequest getTaskDetails108,
            com.informatica.wsh.SessionHeader context109)
            throws java.rmi.RemoteException,Fault {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[27].getName());
            _operationClient.getOptions()
                    .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/getTaskDetailsRequest");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                    "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                            .getSoapVersionURI()),
                    getTaskDetails108,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh", "getTaskDetails")),
                    new javax.xml.namespace.QName(
                            "http://www.informatica.com/wsh", "getTaskDetails"));

            env.build();

            // add the children only if the parameter is not null
            if (context109 != null) {
                org.apache.axiom.om.OMElement omElementcontext109 = toOM(context109,
                        optimizeContent(
                                new javax.xml.namespace.QName(
                                        "http://www.informatica.com/wsh",
                                        "getTaskDetails")));
                addHeader(omElementcontext109, env);
            }

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            Object object = fromOM(_returnEnv.getBody()
                            .getFirstElement(),
                    com.informatica.wsh.TaskDetails.class,
                    getEnvelopeNamespaces(_returnEnv));

            return (com.informatica.wsh.TaskDetails) object;
        } catch (AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                        new FaultMapKey(
                                faultElt.getQName(), "getTaskDetails"))) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                faultElt.getQName(), "getTaskDetails"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        Exception ex = (Exception) constructor.newInstance(f.getMessage());

                        //message class
                        String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                faultElt.getQName(), "getTaskDetails"));
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        if (ex instanceof Fault) {
                            throw (Fault) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                        .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see DataIntegrationService#startgetTaskDetails
     * @param getTaskDetails108
     * @param context109
     */
    public void startgetTaskDetails(
            com.informatica.wsh.TaskRequest getTaskDetails108,
            com.informatica.wsh.SessionHeader context109,
            final DataIntegrationServiceCallbackHandler callback)
            throws java.rmi.RemoteException {
        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[27].getName());
        _operationClient.getOptions()
                .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/getTaskDetailsRequest");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(_operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        //Style is Doc.
        env = toEnvelope(getFactory(_operationClient.getOptions()
                        .getSoapVersionURI()),
                getTaskDetails108,
                optimizeContent(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh", "getTaskDetails")),
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "getTaskDetails"));

        // add the soap_headers only if they are not null
        if (context109 != null) {
            org.apache.axiom.om.OMElement omElementcontext109 = toOM(context109,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh", "getTaskDetails")));
            addHeader(omElementcontext109, env);
        }

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(
                    org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    Object object = fromOM(resultEnv.getBody()
                                    .getFirstElement(),
                            com.informatica.wsh.TaskDetails.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultgetTaskDetails((com.informatica.wsh.TaskDetails) object);
                } catch (AxisFault e) {
                    callback.receiveErrorgetTaskDetails(e);
                }
            }

            public void onError(Exception error) {
                if (error instanceof AxisFault) {
                    AxisFault f = (AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();

                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(
                                new FaultMapKey(
                                        faultElt.getQName(),
                                        "getTaskDetails"))) {
                            //make the fault by reflection
                            try {
                                String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "getTaskDetails"));
                                Class exceptionClass = Class.forName(exceptionClassName);
                                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                Exception ex = (Exception) constructor.newInstance(f.getMessage());

                                //message class
                                String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "getTaskDetails"));
                                Class messageClass = Class.forName(messageClassName);
                                Object messageObject = fromOM(faultElt,
                                        messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new Class[] { messageClass });
                                m.invoke(ex,
                                        new Object[] { messageObject });

                                if (ex instanceof Fault) {
                                    callback.receiveErrorgetTaskDetails((Fault) ex);

                                    return;
                                }

                                callback.receiveErrorgetTaskDetails(new java.rmi.RemoteException(
                                        ex.getMessage(), ex));
                            } catch (ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetTaskDetails(f);
                            } catch (ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetTaskDetails(f);
                            } catch (NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetTaskDetails(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetTaskDetails(f);
                            } catch (IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetTaskDetails(f);
                            } catch (InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetTaskDetails(f);
                            } catch (AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetTaskDetails(f);
                            }
                        } else {
                            callback.receiveErrorgetTaskDetails(f);
                        }
                    } else {
                        callback.receiveErrorgetTaskDetails(f);
                    }
                } else {
                    callback.receiveErrorgetTaskDetails(error);
                }
            }

            public void onFault(
                    org.apache.axis2.context.MessageContext faultContext) {
                AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender()
                            .cleanup(_messageContext);
                } catch (AxisFault axisFault) {
                    callback.receiveErrorgetTaskDetails(axisFault);
                }
            }
        });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

        if ((_operations[27].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[27].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);
    }

    /**
     * Auto generated method signature
     *
     * @see DataIntegrationService#getDIServerProperties
     * @param getDIServerProperties111
     * @param context112
     * @throwscl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault :
     */
    public com.informatica.wsh.DIServerProperties getDIServerProperties(
            com.informatica.wsh.DIServiceInfo getDIServerProperties111,
            com.informatica.wsh.SessionHeader context112)
            throws java.rmi.RemoteException,Fault {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[28].getName());
            _operationClient.getOptions()
                    .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/getDIServerPropertiesRequest");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                    "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                            .getSoapVersionURI()),
                    getDIServerProperties111,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh",
                                    "getDIServerProperties")),
                    new javax.xml.namespace.QName(
                            "http://www.informatica.com/wsh",
                            "getDIServerProperties"));

            env.build();

            // add the children only if the parameter is not null
            if (context112 != null) {
                org.apache.axiom.om.OMElement omElementcontext112 = toOM(context112,
                        optimizeContent(
                                new javax.xml.namespace.QName(
                                        "http://www.informatica.com/wsh",
                                        "getDIServerProperties")));
                addHeader(omElementcontext112, env);
            }

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            Object object = fromOM(_returnEnv.getBody()
                            .getFirstElement(),
                    com.informatica.wsh.DIServerProperties.class,
                    getEnvelopeNamespaces(_returnEnv));

            return (com.informatica.wsh.DIServerProperties) object;
        } catch (AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                        new FaultMapKey(
                                faultElt.getQName(), "getDIServerProperties"))) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                faultElt.getQName(), "getDIServerProperties"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        Exception ex = (Exception) constructor.newInstance(f.getMessage());

                        //message class
                        String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                faultElt.getQName(), "getDIServerProperties"));
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        if (ex instanceof Fault) {
                            throw (Fault) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                        .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see DataIntegrationService#startgetDIServerProperties
     * @param getDIServerProperties111
     * @param context112
     */
    public void startgetDIServerProperties(
            com.informatica.wsh.DIServiceInfo getDIServerProperties111,
            com.informatica.wsh.SessionHeader context112,
            final DataIntegrationServiceCallbackHandler callback)
            throws java.rmi.RemoteException {
        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[28].getName());
        _operationClient.getOptions()
                .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/getDIServerPropertiesRequest");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(_operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        //Style is Doc.
        env = toEnvelope(getFactory(_operationClient.getOptions()
                        .getSoapVersionURI()),
                getDIServerProperties111,
                optimizeContent(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh",
                                "getDIServerProperties")),
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "getDIServerProperties"));

        // add the soap_headers only if they are not null
        if (context112 != null) {
            org.apache.axiom.om.OMElement omElementcontext112 = toOM(context112,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh",
                                    "getDIServerProperties")));
            addHeader(omElementcontext112, env);
        }

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(
                    org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    Object object = fromOM(resultEnv.getBody()
                                    .getFirstElement(),
                            com.informatica.wsh.DIServerProperties.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultgetDIServerProperties((com.informatica.wsh.DIServerProperties) object);
                } catch (AxisFault e) {
                    callback.receiveErrorgetDIServerProperties(e);
                }
            }

            public void onError(Exception error) {
                if (error instanceof AxisFault) {
                    AxisFault f = (AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();

                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(
                                new FaultMapKey(
                                        faultElt.getQName(),
                                        "getDIServerProperties"))) {
                            //make the fault by reflection
                            try {
                                String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "getDIServerProperties"));
                                Class exceptionClass = Class.forName(exceptionClassName);
                                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                Exception ex = (Exception) constructor.newInstance(f.getMessage());

                                //message class
                                String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "getDIServerProperties"));
                                Class messageClass = Class.forName(messageClassName);
                                Object messageObject = fromOM(faultElt,
                                        messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new Class[] { messageClass });
                                m.invoke(ex,
                                        new Object[] { messageObject });

                                if (ex instanceof Fault) {
                                    callback.receiveErrorgetDIServerProperties((Fault) ex);

                                    return;
                                }

                                callback.receiveErrorgetDIServerProperties(new java.rmi.RemoteException(
                                        ex.getMessage(), ex));
                            } catch (ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetDIServerProperties(f);
                            } catch (ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetDIServerProperties(f);
                            } catch (NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetDIServerProperties(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetDIServerProperties(f);
                            } catch (IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetDIServerProperties(f);
                            } catch (InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetDIServerProperties(f);
                            } catch (AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorgetDIServerProperties(f);
                            }
                        } else {
                            callback.receiveErrorgetDIServerProperties(f);
                        }
                    } else {
                        callback.receiveErrorgetDIServerProperties(f);
                    }
                } else {
                    callback.receiveErrorgetDIServerProperties(error);
                }
            }

            public void onFault(
                    org.apache.axis2.context.MessageContext faultContext) {
                AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender()
                            .cleanup(_messageContext);
                } catch (AxisFault axisFault) {
                    callback.receiveErrorgetDIServerProperties(axisFault);
                }
            }
        });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

        if ((_operations[28].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[28].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);
    }

    /**
     * Auto generated method signature
     *
     * @see DataIntegrationService#unscheduleWorkflow
     * @param unscheduleWorkflow114
     * @param context115
     * @throwscl.blueprintsit.powercenter.wrapper.ws.client.pwrc.Fault :
     */
    public com.informatica.wsh.VoidResponse unscheduleWorkflow(
            com.informatica.wsh.WorkflowRequest unscheduleWorkflow114,
            com.informatica.wsh.SessionHeader context115)
            throws java.rmi.RemoteException,Fault {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[29].getName());
            _operationClient.getOptions()
                    .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/unscheduleWorkflowRequest");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                    org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                    "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                            .getSoapVersionURI()),
                    unscheduleWorkflow114,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh",
                                    "unscheduleWorkflow")),
                    new javax.xml.namespace.QName(
                            "http://www.informatica.com/wsh", "unscheduleWorkflow"));

            env.build();

            // add the children only if the parameter is not null
            if (context115 != null) {
                org.apache.axiom.om.OMElement omElementcontext115 = toOM(context115,
                        optimizeContent(
                                new javax.xml.namespace.QName(
                                        "http://www.informatica.com/wsh",
                                        "unscheduleWorkflow")));
                addHeader(omElementcontext115, env);
            }

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            Object object = fromOM(_returnEnv.getBody()
                            .getFirstElement(),
                    com.informatica.wsh.VoidResponse.class,
                    getEnvelopeNamespaces(_returnEnv));

            return (com.informatica.wsh.VoidResponse) object;
        } catch (AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                        new FaultMapKey(
                                faultElt.getQName(), "unscheduleWorkflow"))) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                faultElt.getQName(), "unscheduleWorkflow"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        Exception ex = (Exception) constructor.newInstance(f.getMessage());

                        //message class
                        String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                faultElt.getQName(), "unscheduleWorkflow"));
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        if (ex instanceof Fault) {
                            throw (Fault) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                        .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see DataIntegrationService#startunscheduleWorkflow
     * @param unscheduleWorkflow114
     * @param context115
     */
    public void startunscheduleWorkflow(
            com.informatica.wsh.WorkflowRequest unscheduleWorkflow114,
            com.informatica.wsh.SessionHeader context115,
            final DataIntegrationServiceCallbackHandler callback)
            throws java.rmi.RemoteException {
        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[29].getName());
        _operationClient.getOptions()
                .setAction("http://www.informatica.com/wsh/DataIntegrationInterface/unscheduleWorkflowRequest");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(_operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        //Style is Doc.
        env = toEnvelope(getFactory(_operationClient.getOptions()
                        .getSoapVersionURI()),
                unscheduleWorkflow114,
                optimizeContent(
                        new javax.xml.namespace.QName(
                                "http://www.informatica.com/wsh", "unscheduleWorkflow")),
                new javax.xml.namespace.QName(
                        "http://www.informatica.com/wsh", "unscheduleWorkflow"));

        // add the soap_headers only if they are not null
        if (context115 != null) {
            org.apache.axiom.om.OMElement omElementcontext115 = toOM(context115,
                    optimizeContent(
                            new javax.xml.namespace.QName(
                                    "http://www.informatica.com/wsh",
                                    "unscheduleWorkflow")));
            addHeader(omElementcontext115, env);
        }

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(
                    org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    Object object = fromOM(resultEnv.getBody()
                                    .getFirstElement(),
                            com.informatica.wsh.VoidResponse.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultunscheduleWorkflow((com.informatica.wsh.VoidResponse) object);
                } catch (AxisFault e) {
                    callback.receiveErrorunscheduleWorkflow(e);
                }
            }

            public void onError(Exception error) {
                if (error instanceof AxisFault) {
                    AxisFault f = (AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();

                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(
                                new FaultMapKey(
                                        faultElt.getQName(),
                                        "unscheduleWorkflow"))) {
                            //make the fault by reflection
                            try {
                                String exceptionClassName = (String) faultExceptionClassNameMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "unscheduleWorkflow"));
                                Class exceptionClass = Class.forName(exceptionClassName);
                                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                Exception ex = (Exception) constructor.newInstance(f.getMessage());

                                //message class
                                String messageClassName = (String) faultMessageMap.get(new FaultMapKey(
                                        faultElt.getQName(),
                                        "unscheduleWorkflow"));
                                Class messageClass = Class.forName(messageClassName);
                                Object messageObject = fromOM(faultElt,
                                        messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new Class[] { messageClass });
                                m.invoke(ex,
                                        new Object[] { messageObject });

                                if (ex instanceof Fault) {
                                    callback.receiveErrorunscheduleWorkflow((Fault) ex);

                                    return;
                                }

                                callback.receiveErrorunscheduleWorkflow(new java.rmi.RemoteException(
                                        ex.getMessage(), ex));
                            } catch (ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorunscheduleWorkflow(f);
                            } catch (ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorunscheduleWorkflow(f);
                            } catch (NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorunscheduleWorkflow(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorunscheduleWorkflow(f);
                            } catch (IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorunscheduleWorkflow(f);
                            } catch (InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorunscheduleWorkflow(f);
                            } catch (AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorunscheduleWorkflow(f);
                            }
                        } else {
                            callback.receiveErrorunscheduleWorkflow(f);
                        }
                    } else {
                        callback.receiveErrorunscheduleWorkflow(f);
                    }
                } else {
                    callback.receiveErrorunscheduleWorkflow(error);
                }
            }

            public void onFault(
                    org.apache.axis2.context.MessageContext faultContext) {
                AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender()
                            .cleanup(_messageContext);
                } catch (AxisFault axisFault) {
                    callback.receiveErrorunscheduleWorkflow(axisFault);
                }
            }
        });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

        if ((_operations[29].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[29].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);
    }

    /**
     *  A utility method that copies the namepaces from the SOAPEnvelope
     */
    private java.util.Map getEnvelopeNamespaces(
            org.apache.axiom.soap.SOAPEnvelope env) {
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();

        while (namespaceIterator.hasNext()) {
            org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
            returnMap.put(ns.getPrefix(), ns.getNamespaceURI());
        }

        return returnMap;
    }

    private boolean optimizeContent(javax.xml.namespace.QName opName) {
        if (opNameArray == null) {
            return false;
        }

        for (int i = 0; i < opNameArray.length; i++) {
            if (opName.equals(opNameArray[i])) {
                return true;
            }
        }

        return false;
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.VoidRequest param, boolean optimizeContent,
            javax.xml.namespace.QName methodQName)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.VoidRequest.class,
                    param, marshaller, methodQName.getNamespaceURI(),
                    methodQName.getLocalPart());
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace(methodQName.getNamespaceURI(),
                    null);

            return factory.createOMElement(source, methodQName.getLocalPart(),
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.VoidRequest param, boolean optimizeContent)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.VoidRequest.class,
                    param, marshaller, "http://www.informatica.com/wsh",
                    "DeinitializeDIServerConnection");
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace("http://www.informatica.com/wsh",
                    null);

            return factory.createOMElement(source,
                    "DeinitializeDIServerConnection", namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory,
            com.informatica.wsh.VoidRequest param, boolean optimizeContent,
            javax.xml.namespace.QName methodQName)
            throws AxisFault {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        envelope.getBody().addChild(toOM(param, optimizeContent, methodQName));

        return envelope;
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.VoidResponse param, boolean optimizeContent,
            javax.xml.namespace.QName methodQName)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.VoidResponse.class,
                    param, marshaller, methodQName.getNamespaceURI(),
                    methodQName.getLocalPart());
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace(methodQName.getNamespaceURI(),
                    null);

            return factory.createOMElement(source, methodQName.getLocalPart(),
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.VoidResponse param, boolean optimizeContent)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.VoidResponse.class,
                    param, marshaller, "http://www.informatica.com/wsh",
                    "DeinitializeDIServerConnectionReturn");
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace("http://www.informatica.com/wsh",
                    null);

            return factory.createOMElement(source,
                    "DeinitializeDIServerConnectionReturn", namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory,
            com.informatica.wsh.VoidResponse param, boolean optimizeContent,
            javax.xml.namespace.QName methodQName)
            throws AxisFault {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        envelope.getBody().addChild(toOM(param, optimizeContent, methodQName));

        return envelope;
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.FaultDetails param, boolean optimizeContent,
            javax.xml.namespace.QName methodQName)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.FaultDetails.class,
                    param, marshaller, methodQName.getNamespaceURI(),
                    methodQName.getLocalPart());
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace(methodQName.getNamespaceURI(),
                    null);

            return factory.createOMElement(source, methodQName.getLocalPart(),
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.FaultDetails param, boolean optimizeContent)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.FaultDetails.class,
                    param, marshaller, "http://www.informatica.com/wsh",
                    "WSHFaultDetails");
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace("http://www.informatica.com/wsh",
                    null);

            return factory.createOMElement(source, "WSHFaultDetails", namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory,
            com.informatica.wsh.FaultDetails param, boolean optimizeContent,
            javax.xml.namespace.QName methodQName)
            throws AxisFault {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        envelope.getBody().addChild(toOM(param, optimizeContent, methodQName));

        return envelope;
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.SessionHeader param, boolean optimizeContent,
            javax.xml.namespace.QName methodQName)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.SessionHeader.class,
                    param, marshaller, methodQName.getNamespaceURI(),
                    methodQName.getLocalPart());
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace(methodQName.getNamespaceURI(),
                    null);

            return factory.createOMElement(source, methodQName.getLocalPart(),
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.SessionHeader param, boolean optimizeContent)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.SessionHeader.class,
                    param, marshaller, "http://www.informatica.com/wsh",
                    "Context");
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace("http://www.informatica.com/wsh",
                    null);

            return factory.createOMElement(source, "Context", namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory,
            com.informatica.wsh.SessionHeader param, boolean optimizeContent,
            javax.xml.namespace.QName methodQName)
            throws AxisFault {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        envelope.getBody().addChild(toOM(param, optimizeContent, methodQName));

        return envelope;
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.GetNextLogSegmentRequest param,
            boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.GetNextLogSegmentRequest.class,
                    param, marshaller, methodQName.getNamespaceURI(),
                    methodQName.getLocalPart());
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace(methodQName.getNamespaceURI(),
                    null);

            return factory.createOMElement(source, methodQName.getLocalPart(),
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.GetNextLogSegmentRequest param,
            boolean optimizeContent) throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.GetNextLogSegmentRequest.class,
                    param, marshaller, "http://www.informatica.com/wsh",
                    "GetNextLogSegment");
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace("http://www.informatica.com/wsh",
                    null);

            return factory.createOMElement(source, "GetNextLogSegment",
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory,
            com.informatica.wsh.GetNextLogSegmentRequest param,
            boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws AxisFault {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        envelope.getBody().addChild(toOM(param, optimizeContent, methodQName));

        return envelope;
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.LogSegment param, boolean optimizeContent,
            javax.xml.namespace.QName methodQName)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.LogSegment.class,
                    param, marshaller, methodQName.getNamespaceURI(),
                    methodQName.getLocalPart());
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace(methodQName.getNamespaceURI(),
                    null);

            return factory.createOMElement(source, methodQName.getLocalPart(),
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.LogSegment param, boolean optimizeContent)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.LogSegment.class,
                    param, marshaller, "http://www.informatica.com/wsh",
                    "GetNextLogSegmentReturn");
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace("http://www.informatica.com/wsh",
                    null);

            return factory.createOMElement(source, "GetNextLogSegmentReturn",
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory,
            com.informatica.wsh.LogSegment param, boolean optimizeContent,
            javax.xml.namespace.QName methodQName)
            throws AxisFault {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        envelope.getBody().addChild(toOM(param, optimizeContent, methodQName));

        return envelope;
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.InitializeDIServerConnectionRequest param,
            boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.InitializeDIServerConnectionRequest.class,
                    param, marshaller, methodQName.getNamespaceURI(),
                    methodQName.getLocalPart());
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace(methodQName.getNamespaceURI(),
                    null);

            return factory.createOMElement(source, methodQName.getLocalPart(),
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.InitializeDIServerConnectionRequest param,
            boolean optimizeContent) throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.InitializeDIServerConnectionRequest.class,
                    param, marshaller, "http://www.informatica.com/wsh",
                    "InitializeDIServerConnection");
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace("http://www.informatica.com/wsh",
                    null);

            return factory.createOMElement(source,
                    "InitializeDIServerConnection", namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory,
            com.informatica.wsh.InitializeDIServerConnectionRequest param,
            boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws AxisFault {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        envelope.getBody().addChild(toOM(param, optimizeContent, methodQName));

        return envelope;
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.PingDIServerRequest param, boolean optimizeContent,
            javax.xml.namespace.QName methodQName)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.PingDIServerRequest.class,
                    param, marshaller, methodQName.getNamespaceURI(),
                    methodQName.getLocalPart());
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace(methodQName.getNamespaceURI(),
                    null);

            return factory.createOMElement(source, methodQName.getLocalPart(),
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.PingDIServerRequest param, boolean optimizeContent)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.PingDIServerRequest.class,
                    param, marshaller, "http://www.informatica.com/wsh",
                    "PingDIServer");
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace("http://www.informatica.com/wsh",
                    null);

            return factory.createOMElement(source, "PingDIServer", namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory,
            com.informatica.wsh.PingDIServerRequest param, boolean optimizeContent,
            javax.xml.namespace.QName methodQName)
            throws AxisFault {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        envelope.getBody().addChild(toOM(param, optimizeContent, methodQName));

        return envelope;
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.EPingState param, boolean optimizeContent,
            javax.xml.namespace.QName methodQName)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.EPingState.class,
                    param, marshaller, methodQName.getNamespaceURI(),
                    methodQName.getLocalPart());
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace(methodQName.getNamespaceURI(),
                    null);

            return factory.createOMElement(source, methodQName.getLocalPart(),
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.EPingState param, boolean optimizeContent)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.EPingState.class,
                    param, marshaller, "http://www.informatica.com/wsh",
                    "PingDIServerReturn");
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace("http://www.informatica.com/wsh",
                    null);

            return factory.createOMElement(source, "PingDIServerReturn",
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory,
            com.informatica.wsh.EPingState param, boolean optimizeContent,
            javax.xml.namespace.QName methodQName)
            throws AxisFault {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        envelope.getBody().addChild(toOM(param, optimizeContent, methodQName));

        return envelope;
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.StartWorkflowLogFetchRequest param,
            boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.StartWorkflowLogFetchRequest.class,
                    param, marshaller, methodQName.getNamespaceURI(),
                    methodQName.getLocalPart());
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace(methodQName.getNamespaceURI(),
                    null);

            return factory.createOMElement(source, methodQName.getLocalPart(),
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.StartWorkflowLogFetchRequest param,
            boolean optimizeContent) throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.StartWorkflowLogFetchRequest.class,
                    param, marshaller, "http://www.informatica.com/wsh",
                    "StartWorkflowLogFetch");
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace("http://www.informatica.com/wsh",
                    null);

            return factory.createOMElement(source, "StartWorkflowLogFetch",
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory,
            com.informatica.wsh.StartWorkflowLogFetchRequest param,
            boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws AxisFault {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        envelope.getBody().addChild(toOM(param, optimizeContent, methodQName));

        return envelope;
    }

    private org.apache.axiom.om.OMElement toOM(int param,
                                               boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(int.class, param,
                    marshaller, methodQName.getNamespaceURI(),
                    methodQName.getLocalPart());
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace(methodQName.getNamespaceURI(),
                    null);

            return factory.createOMElement(source, methodQName.getLocalPart(),
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.om.OMElement toOM(int param,
                                               boolean optimizeContent) throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(int.class, param,
                    marshaller, "http://www.informatica.com/wsh",
                    "StartWorkflowLogFetchReturn");
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace("http://www.informatica.com/wsh",
                    null);

            return factory.createOMElement(source,
                    "StartWorkflowLogFetchReturn", namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory, int param,
            boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws AxisFault {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        envelope.getBody().addChild(toOM(param, optimizeContent, methodQName));

        return envelope;
    }

    private int toInt(org.apache.axiom.om.OMElement param,
                      java.util.Map extraNamespaces) throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Unmarshaller unmarshaller = context.createUnmarshaller();

            Integer ret = (Integer) unmarshaller.unmarshal(param.getXMLStreamReaderWithoutCaching(),
                    int.class).getValue();

            return ret.intValue();
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.GetSessionLogRequest param,
            boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.GetSessionLogRequest.class,
                    param, marshaller, methodQName.getNamespaceURI(),
                    methodQName.getLocalPart());
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace(methodQName.getNamespaceURI(),
                    null);

            return factory.createOMElement(source, methodQName.getLocalPart(),
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.GetSessionLogRequest param, boolean optimizeContent)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.GetSessionLogRequest.class,
                    param, marshaller, "http://www.informatica.com/wsh",
                    "GetSessionLog");
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace("http://www.informatica.com/wsh",
                    null);

            return factory.createOMElement(source, "GetSessionLog", namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory,
            com.informatica.wsh.GetSessionLogRequest param,
            boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws AxisFault {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        envelope.getBody().addChild(toOM(param, optimizeContent, methodQName));

        return envelope;
    }

    private org.apache.axiom.om.OMElement toOM(com.informatica.wsh.Log param,
                                               boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.Log.class,
                    param, marshaller, methodQName.getNamespaceURI(),
                    methodQName.getLocalPart());
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace(methodQName.getNamespaceURI(),
                    null);

            return factory.createOMElement(source, methodQName.getLocalPart(),
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.om.OMElement toOM(com.informatica.wsh.Log param,
                                               boolean optimizeContent) throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.Log.class,
                    param, marshaller, "http://www.informatica.com/wsh",
                    "GetSessionLogReturn");
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace("http://www.informatica.com/wsh",
                    null);

            return factory.createOMElement(source, "GetSessionLogReturn",
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory,
            com.informatica.wsh.Log param, boolean optimizeContent,
            javax.xml.namespace.QName methodQName)
            throws AxisFault {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        envelope.getBody().addChild(toOM(param, optimizeContent, methodQName));

        return envelope;
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.WorkflowRequest param, boolean optimizeContent,
            javax.xml.namespace.QName methodQName)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.WorkflowRequest.class,
                    param, marshaller, methodQName.getNamespaceURI(),
                    methodQName.getLocalPart());
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace(methodQName.getNamespaceURI(),
                    null);

            return factory.createOMElement(source, methodQName.getLocalPart(),
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.WorkflowRequest param, boolean optimizeContent)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.WorkflowRequest.class,
                    param, marshaller, "http://www.informatica.com/wsh",
                    "StopWorkflow");
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace("http://www.informatica.com/wsh",
                    null);

            return factory.createOMElement(source, "StopWorkflow", namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory,
            com.informatica.wsh.WorkflowRequest param, boolean optimizeContent,
            javax.xml.namespace.QName methodQName)
            throws AxisFault {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        envelope.getBody().addChild(toOM(param, optimizeContent, methodQName));

        return envelope;
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.GetSessionStatisticsRequest param,
            boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.GetSessionStatisticsRequest.class,
                    param, marshaller, methodQName.getNamespaceURI(),
                    methodQName.getLocalPart());
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace(methodQName.getNamespaceURI(),
                    null);

            return factory.createOMElement(source, methodQName.getLocalPart(),
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.GetSessionStatisticsRequest param,
            boolean optimizeContent) throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.GetSessionStatisticsRequest.class,
                    param, marshaller, "http://www.informatica.com/wsh",
                    "GetSessionStatistics");
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace("http://www.informatica.com/wsh",
                    null);

            return factory.createOMElement(source, "GetSessionStatistics",
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory,
            com.informatica.wsh.GetSessionStatisticsRequest param,
            boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws AxisFault {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        envelope.getBody().addChild(toOM(param, optimizeContent, methodQName));

        return envelope;
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.SessionStatistics param, boolean optimizeContent,
            javax.xml.namespace.QName methodQName)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.SessionStatistics.class,
                    param, marshaller, methodQName.getNamespaceURI(),
                    methodQName.getLocalPart());
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace(methodQName.getNamespaceURI(),
                    null);

            return factory.createOMElement(source, methodQName.getLocalPart(),
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.SessionStatistics param, boolean optimizeContent)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.SessionStatistics.class,
                    param, marshaller, "http://www.informatica.com/wsh",
                    "GetSessionStatisticsReturn");
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace("http://www.informatica.com/wsh",
                    null);

            return factory.createOMElement(source,
                    "GetSessionStatisticsReturn", namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory,
            com.informatica.wsh.SessionStatistics param, boolean optimizeContent,
            javax.xml.namespace.QName methodQName)
            throws AxisFault {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        envelope.getBody().addChild(toOM(param, optimizeContent, methodQName));

        return envelope;
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.WorkflowDetails param, boolean optimizeContent,
            javax.xml.namespace.QName methodQName)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.WorkflowDetails.class,
                    param, marshaller, methodQName.getNamespaceURI(),
                    methodQName.getLocalPart());
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace(methodQName.getNamespaceURI(),
                    null);

            return factory.createOMElement(source, methodQName.getLocalPart(),
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.WorkflowDetails param, boolean optimizeContent)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.WorkflowDetails.class,
                    param, marshaller, "http://www.informatica.com/wsh",
                    "GetWorkflowDetailsReturn");
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace("http://www.informatica.com/wsh",
                    null);

            return factory.createOMElement(source, "GetWorkflowDetailsReturn",
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory,
            com.informatica.wsh.WorkflowDetails param, boolean optimizeContent,
            javax.xml.namespace.QName methodQName)
            throws AxisFault {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        envelope.getBody().addChild(toOM(param, optimizeContent, methodQName));

        return envelope;
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.LoginRequest param, boolean optimizeContent,
            javax.xml.namespace.QName methodQName)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.LoginRequest.class,
                    param, marshaller, methodQName.getNamespaceURI(),
                    methodQName.getLocalPart());
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace(methodQName.getNamespaceURI(),
                    null);

            return factory.createOMElement(source, methodQName.getLocalPart(),
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.LoginRequest param, boolean optimizeContent)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.LoginRequest.class,
                    param, marshaller, "http://www.informatica.com/wsh", "Login");
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace("http://www.informatica.com/wsh",
                    null);

            return factory.createOMElement(source, "Login", namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory,
            com.informatica.wsh.LoginRequest param, boolean optimizeContent,
            javax.xml.namespace.QName methodQName)
            throws AxisFault {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        envelope.getBody().addChild(toOM(param, optimizeContent, methodQName));

        return envelope;
    }

    private org.apache.axiom.om.OMElement toOM(String param,
                                               boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(String.class,
                    param, marshaller, methodQName.getNamespaceURI(),
                    methodQName.getLocalPart());
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace(methodQName.getNamespaceURI(),
                    null);

            return factory.createOMElement(source, methodQName.getLocalPart(),
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.om.OMElement toOM(String param,
                                               boolean optimizeContent) throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(String.class,
                    param, marshaller, "http://www.informatica.com/wsh",
                    "LoginReturn");
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace("http://www.informatica.com/wsh",
                    null);

            return factory.createOMElement(source, "LoginReturn", namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory, String param,
            boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws AxisFault {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        envelope.getBody().addChild(toOM(param, optimizeContent, methodQName));

        return envelope;
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.StartSessionLogFetchRequest param,
            boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.StartSessionLogFetchRequest.class,
                    param, marshaller, methodQName.getNamespaceURI(),
                    methodQName.getLocalPart());
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace(methodQName.getNamespaceURI(),
                    null);

            return factory.createOMElement(source, methodQName.getLocalPart(),
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.StartSessionLogFetchRequest param,
            boolean optimizeContent) throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.StartSessionLogFetchRequest.class,
                    param, marshaller, "http://www.informatica.com/wsh",
                    "StartSessionLogFetch");
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace("http://www.informatica.com/wsh",
                    null);

            return factory.createOMElement(source, "StartSessionLogFetch",
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory,
            com.informatica.wsh.StartSessionLogFetchRequest param,
            boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws AxisFault {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        envelope.getBody().addChild(toOM(param, optimizeContent, methodQName));

        return envelope;
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.GetWorkflowLogRequest param,
            boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.GetWorkflowLogRequest.class,
                    param, marshaller, methodQName.getNamespaceURI(),
                    methodQName.getLocalPart());
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace(methodQName.getNamespaceURI(),
                    null);

            return factory.createOMElement(source, methodQName.getLocalPart(),
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.GetWorkflowLogRequest param, boolean optimizeContent)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.GetWorkflowLogRequest.class,
                    param, marshaller, "http://www.informatica.com/wsh",
                    "GetWorkflowLog");
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace("http://www.informatica.com/wsh",
                    null);

            return factory.createOMElement(source, "GetWorkflowLog", namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory,
            com.informatica.wsh.GetWorkflowLogRequest param,
            boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws AxisFault {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        envelope.getBody().addChild(toOM(param, optimizeContent, methodQName));

        return envelope;
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.TaskRequest param, boolean optimizeContent,
            javax.xml.namespace.QName methodQName)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.TaskRequest.class,
                    param, marshaller, methodQName.getNamespaceURI(),
                    methodQName.getLocalPart());
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace(methodQName.getNamespaceURI(),
                    null);

            return factory.createOMElement(source, methodQName.getLocalPart(),
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.TaskRequest param, boolean optimizeContent)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.TaskRequest.class,
                    param, marshaller, "http://www.informatica.com/wsh",
                    "StopTask");
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace("http://www.informatica.com/wsh",
                    null);

            return factory.createOMElement(source, "StopTask", namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory,
            com.informatica.wsh.TaskRequest param, boolean optimizeContent,
            javax.xml.namespace.QName methodQName)
            throws AxisFault {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        envelope.getBody().addChild(toOM(param, optimizeContent, methodQName));

        return envelope;
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.GetSessionPerformanceDataRequest param,
            boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.GetSessionPerformanceDataRequest.class,
                    param, marshaller, methodQName.getNamespaceURI(),
                    methodQName.getLocalPart());
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace(methodQName.getNamespaceURI(),
                    null);

            return factory.createOMElement(source, methodQName.getLocalPart(),
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.GetSessionPerformanceDataRequest param,
            boolean optimizeContent) throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.GetSessionPerformanceDataRequest.class,
                    param, marshaller, "http://www.informatica.com/wsh",
                    "GetSessionPerformanceData");
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace("http://www.informatica.com/wsh",
                    null);

            return factory.createOMElement(source, "GetSessionPerformanceData",
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory,
            com.informatica.wsh.GetSessionPerformanceDataRequest param,
            boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws AxisFault {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        envelope.getBody().addChild(toOM(param, optimizeContent, methodQName));

        return envelope;
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.SessionPerformanceData param,
            boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.SessionPerformanceData.class,
                    param, marshaller, methodQName.getNamespaceURI(),
                    methodQName.getLocalPart());
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace(methodQName.getNamespaceURI(),
                    null);

            return factory.createOMElement(source, methodQName.getLocalPart(),
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.SessionPerformanceData param,
            boolean optimizeContent) throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.SessionPerformanceData.class,
                    param, marshaller, "http://www.informatica.com/wsh",
                    "GetSessionPerformanceDataReturn");
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace("http://www.informatica.com/wsh",
                    null);

            return factory.createOMElement(source,
                    "GetSessionPerformanceDataReturn", namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory,
            com.informatica.wsh.SessionPerformanceData param,
            boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws AxisFault {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        envelope.getBody().addChild(toOM(param, optimizeContent, methodQName));

        return envelope;
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.TypeStartWorkflowExRequest param,
            boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.TypeStartWorkflowExRequest.class,
                    param, marshaller, methodQName.getNamespaceURI(),
                    methodQName.getLocalPart());
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace(methodQName.getNamespaceURI(),
                    null);

            return factory.createOMElement(source, methodQName.getLocalPart(),
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.TypeStartWorkflowExRequest param,
            boolean optimizeContent) throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.TypeStartWorkflowExRequest.class,
                    param, marshaller, "http://www.informatica.com/wsh",
                    "StartWorkflowEx");
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace("http://www.informatica.com/wsh",
                    null);

            return factory.createOMElement(source, "StartWorkflowEx", namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory,
            com.informatica.wsh.TypeStartWorkflowExRequest param,
            boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws AxisFault {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        envelope.getBody().addChild(toOM(param, optimizeContent, methodQName));

        return envelope;
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.TypeStartWorkflowExResponse param,
            boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.TypeStartWorkflowExResponse.class,
                    param, marshaller, methodQName.getNamespaceURI(),
                    methodQName.getLocalPart());
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace(methodQName.getNamespaceURI(),
                    null);

            return factory.createOMElement(source, methodQName.getLocalPart(),
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.TypeStartWorkflowExResponse param,
            boolean optimizeContent) throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.TypeStartWorkflowExResponse.class,
                    param, marshaller, "http://www.informatica.com/wsh",
                    "StartWorkflowExReturn");
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace("http://www.informatica.com/wsh",
                    null);

            return factory.createOMElement(source, "StartWorkflowExReturn",
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory,
            com.informatica.wsh.TypeStartWorkflowExResponse param,
            boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws AxisFault {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        envelope.getBody().addChild(toOM(param, optimizeContent, methodQName));

        return envelope;
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.TypeGetTaskDetailsExRequest param,
            boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.TypeGetTaskDetailsExRequest.class,
                    param, marshaller, methodQName.getNamespaceURI(),
                    methodQName.getLocalPart());
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace(methodQName.getNamespaceURI(),
                    null);

            return factory.createOMElement(source, methodQName.getLocalPart(),
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.TypeGetTaskDetailsExRequest param,
            boolean optimizeContent) throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.TypeGetTaskDetailsExRequest.class,
                    param, marshaller, "http://www.informatica.com/wsh",
                    "GetTaskDetailsEx");
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace("http://www.informatica.com/wsh",
                    null);

            return factory.createOMElement(source, "GetTaskDetailsEx", namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory,
            com.informatica.wsh.TypeGetTaskDetailsExRequest param,
            boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws AxisFault {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        envelope.getBody().addChild(toOM(param, optimizeContent, methodQName));

        return envelope;
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.DIServerDetails param, boolean optimizeContent,
            javax.xml.namespace.QName methodQName)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.DIServerDetails.class,
                    param, marshaller, methodQName.getNamespaceURI(),
                    methodQName.getLocalPart());
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace(methodQName.getNamespaceURI(),
                    null);

            return factory.createOMElement(source, methodQName.getLocalPart(),
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.DIServerDetails param, boolean optimizeContent)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.DIServerDetails.class,
                    param, marshaller, "http://www.informatica.com/wsh",
                    "GetTaskDetailsExReturn");
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace("http://www.informatica.com/wsh",
                    null);

            return factory.createOMElement(source, "GetTaskDetailsExReturn",
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory,
            com.informatica.wsh.DIServerDetails param, boolean optimizeContent,
            javax.xml.namespace.QName methodQName)
            throws AxisFault {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        envelope.getBody().addChild(toOM(param, optimizeContent, methodQName));

        return envelope;
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.TypeGetWorkflowDetailsExRequest param,
            boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.TypeGetWorkflowDetailsExRequest.class,
                    param, marshaller, methodQName.getNamespaceURI(),
                    methodQName.getLocalPart());
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace(methodQName.getNamespaceURI(),
                    null);

            return factory.createOMElement(source, methodQName.getLocalPart(),
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.TypeGetWorkflowDetailsExRequest param,
            boolean optimizeContent) throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.TypeGetWorkflowDetailsExRequest.class,
                    param, marshaller, "http://www.informatica.com/wsh",
                    "GetWorkflowDetailsEx");
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace("http://www.informatica.com/wsh",
                    null);

            return factory.createOMElement(source, "GetWorkflowDetailsEx",
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory,
            com.informatica.wsh.TypeGetWorkflowDetailsExRequest param,
            boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws AxisFault {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        envelope.getBody().addChild(toOM(param, optimizeContent, methodQName));

        return envelope;
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.MonitorDIServerRequest param,
            boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.MonitorDIServerRequest.class,
                    param, marshaller, methodQName.getNamespaceURI(),
                    methodQName.getLocalPart());
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace(methodQName.getNamespaceURI(),
                    null);

            return factory.createOMElement(source, methodQName.getLocalPart(),
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.MonitorDIServerRequest param,
            boolean optimizeContent) throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.MonitorDIServerRequest.class,
                    param, marshaller, "http://www.informatica.com/wsh",
                    "MonitorDIServer");
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace("http://www.informatica.com/wsh",
                    null);

            return factory.createOMElement(source, "MonitorDIServer", namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory,
            com.informatica.wsh.MonitorDIServerRequest param,
            boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws AxisFault {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        envelope.getBody().addChild(toOM(param, optimizeContent, methodQName));

        return envelope;
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.TaskDetails param, boolean optimizeContent,
            javax.xml.namespace.QName methodQName)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.TaskDetails.class,
                    param, marshaller, methodQName.getNamespaceURI(),
                    methodQName.getLocalPart());
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace(methodQName.getNamespaceURI(),
                    null);

            return factory.createOMElement(source, methodQName.getLocalPart(),
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.TaskDetails param, boolean optimizeContent)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.TaskDetails.class,
                    param, marshaller, "http://www.informatica.com/wsh",
                    "GetTaskDetailsReturn");
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace("http://www.informatica.com/wsh",
                    null);

            return factory.createOMElement(source, "GetTaskDetailsReturn",
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory,
            com.informatica.wsh.TaskDetails param, boolean optimizeContent,
            javax.xml.namespace.QName methodQName)
            throws AxisFault {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        envelope.getBody().addChild(toOM(param, optimizeContent, methodQName));

        return envelope;
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.DIServiceInfo param, boolean optimizeContent,
            javax.xml.namespace.QName methodQName)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.DIServiceInfo.class,
                    param, marshaller, methodQName.getNamespaceURI(),
                    methodQName.getLocalPart());
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace(methodQName.getNamespaceURI(),
                    null);

            return factory.createOMElement(source, methodQName.getLocalPart(),
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.DIServiceInfo param, boolean optimizeContent)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.DIServiceInfo.class,
                    param, marshaller, "http://www.informatica.com/wsh",
                    "GetDIServerProperties");
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace("http://www.informatica.com/wsh",
                    null);

            return factory.createOMElement(source, "GetDIServerProperties",
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory,
            com.informatica.wsh.DIServiceInfo param, boolean optimizeContent,
            javax.xml.namespace.QName methodQName)
            throws AxisFault {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        envelope.getBody().addChild(toOM(param, optimizeContent, methodQName));

        return envelope;
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.DIServerProperties param, boolean optimizeContent,
            javax.xml.namespace.QName methodQName)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.DIServerProperties.class,
                    param, marshaller, methodQName.getNamespaceURI(),
                    methodQName.getLocalPart());
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace(methodQName.getNamespaceURI(),
                    null);

            return factory.createOMElement(source, methodQName.getLocalPart(),
                    namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
            com.informatica.wsh.DIServerProperties param, boolean optimizeContent)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT,
                    Boolean.TRUE);

            org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

            JaxbRIDataSource source = new JaxbRIDataSource(com.informatica.wsh.DIServerProperties.class,
                    param, marshaller, "http://www.informatica.com/wsh",
                    "GetDIServerPropertiesReturn");
            org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace("http://www.informatica.com/wsh",
                    null);

            return factory.createOMElement(source,
                    "GetDIServerPropertiesReturn", namespace);
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory,
            com.informatica.wsh.DIServerProperties param, boolean optimizeContent,
            javax.xml.namespace.QName methodQName)
            throws AxisFault {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
        envelope.getBody().addChild(toOM(param, optimizeContent, methodQName));

        return envelope;
    }

    /**
     *  get the default envelope
     */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
            org.apache.axiom.soap.SOAPFactory factory) {
        return factory.getDefaultEnvelope();
    }

    private Object fromOM(org.apache.axiom.om.OMElement param,
                          Class type, java.util.Map extraNamespaces)
            throws AxisFault {
        try {
            javax.xml.bind.JAXBContext context = wsContext;
            javax.xml.bind.Unmarshaller unmarshaller = context.createUnmarshaller();

            return unmarshaller.unmarshal(param.getXMLStreamReaderWithoutCaching(),
                    type).getValue();
        } catch (javax.xml.bind.JAXBException bex) {
            throw AxisFault.makeFault(bex);
        }
    }

    class JaxbRIDataSource implements org.apache.axiom.om.OMDataSource {
        /**
         * Bound object for output.
         */
        private final Object outObject;

        /**
         * Bound class for output.
         */
        private final Class outClazz;

        /**
         * Marshaller.
         */
        private final javax.xml.bind.Marshaller marshaller;

        /**
         * Namespace
         */
        private String nsuri;

        /**
         * Local name
         */
        private String name;

        /**
         * Constructor from object and marshaller.
         *
         * @param obj
         * @param marshaller
         */
        public JaxbRIDataSource(Class clazz, Object obj,
                                javax.xml.bind.Marshaller marshaller, String nsuri, String name) {
            this.outClazz = clazz;
            this.outObject = obj;
            this.marshaller = marshaller;
            this.nsuri = nsuri;
            this.name = name;
        }

        public void serialize(java.io.OutputStream output,
                              org.apache.axiom.om.OMOutputFormat format)
                throws javax.xml.stream.XMLStreamException {
            try {
                marshaller.marshal(new javax.xml.bind.JAXBElement(
                        new javax.xml.namespace.QName(nsuri, name),
                        outObject.getClass(), outObject), output);
            } catch (javax.xml.bind.JAXBException e) {
                throw new javax.xml.stream.XMLStreamException("Error in JAXB marshalling",
                        e);
            }
        }

        public void serialize(java.io.Writer writer,
                              org.apache.axiom.om.OMOutputFormat format)
                throws javax.xml.stream.XMLStreamException {
            try {
                marshaller.marshal(new javax.xml.bind.JAXBElement(
                        new javax.xml.namespace.QName(nsuri, name),
                        outObject.getClass(), outObject), writer);
            } catch (javax.xml.bind.JAXBException e) {
                throw new javax.xml.stream.XMLStreamException("Error in JAXB marshalling",
                        e);
            }
        }

        public void serialize(javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException {
            try {
                marshaller.marshal(new javax.xml.bind.JAXBElement(
                        new javax.xml.namespace.QName(nsuri, name),
                        outObject.getClass(), outObject), xmlWriter);
            } catch (javax.xml.bind.JAXBException e) {
                throw new javax.xml.stream.XMLStreamException("Error in JAXB marshalling",
                        e);
            }
        }

        public javax.xml.stream.XMLStreamReader getReader()
                throws javax.xml.stream.XMLStreamException {
            try {
                javax.xml.bind.JAXBContext context = wsContext;
                org.apache.axiom.om.impl.builder.SAXOMBuilder builder = new org.apache.axiom.om.impl.builder.SAXOMBuilder();
                javax.xml.bind.Marshaller marshaller = context.createMarshaller();
                marshaller.marshal(new javax.xml.bind.JAXBElement(
                        new javax.xml.namespace.QName(nsuri, name),
                        outObject.getClass(), outObject), builder);

                return builder.getRootElement().getXMLStreamReader();
            } catch (javax.xml.bind.JAXBException e) {
                throw new javax.xml.stream.XMLStreamException("Error in JAXB marshalling",
                        e);
            }
        }
    }
}
