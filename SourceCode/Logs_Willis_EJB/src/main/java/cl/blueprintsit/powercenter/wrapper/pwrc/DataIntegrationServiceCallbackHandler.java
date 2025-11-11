/**
 * DataIntegrationServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */
package cl.blueprintsit.powercenter.wrapper.pwrc;


/**
 *  DataIntegrationServiceCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class DataIntegrationServiceCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public DataIntegrationServiceCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public DataIntegrationServiceCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for deinitializeDIServerConnection method
     * override this method for handling normal response from deinitializeDIServerConnection operation
     */
    public void receiveResultdeinitializeDIServerConnection(
        com.informatica.wsh.VoidResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from deinitializeDIServerConnection operation
     */
    public void receiveErrordeinitializeDIServerConnection(
        Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getNextLogSegment method
     * override this method for handling normal response from getNextLogSegment operation
     */
    public void receiveResultgetNextLogSegment(
        com.informatica.wsh.LogSegment result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getNextLogSegment operation
     */
    public void receiveErrorgetNextLogSegment(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for initializeDIServerConnection method
     * override this method for handling normal response from initializeDIServerConnection operation
     */
    public void receiveResultinitializeDIServerConnection(
        com.informatica.wsh.VoidResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from initializeDIServerConnection operation
     */
    public void receiveErrorinitializeDIServerConnection(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for pingDIServer method
     * override this method for handling normal response from pingDIServer operation
     */
    public void receiveResultpingDIServer(com.informatica.wsh.EPingState result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from pingDIServer operation
     */
    public void receiveErrorpingDIServer(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for startWorkflowLogFetch method
     * override this method for handling normal response from startWorkflowLogFetch operation
     */
    public void receiveResultstartWorkflowLogFetch(int result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from startWorkflowLogFetch operation
     */
    public void receiveErrorstartWorkflowLogFetch(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getSessionLog method
     * override this method for handling normal response from getSessionLog operation
     */
    public void receiveResultgetSessionLog(com.informatica.wsh.Log result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getSessionLog operation
     */
    public void receiveErrorgetSessionLog(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for stopWorkflow method
     * override this method for handling normal response from stopWorkflow operation
     */
    public void receiveResultstopWorkflow(
        com.informatica.wsh.VoidResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from stopWorkflow operation
     */
    public void receiveErrorstopWorkflow(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for waitTillWorkflowComplete method
     * override this method for handling normal response from waitTillWorkflowComplete operation
     */
    public void receiveResultwaitTillWorkflowComplete(
        com.informatica.wsh.VoidResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from waitTillWorkflowComplete operation
     */
    public void receiveErrorwaitTillWorkflowComplete(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for recoverWorkflow method
     * override this method for handling normal response from recoverWorkflow operation
     */
    public void receiveResultrecoverWorkflow(
        com.informatica.wsh.VoidResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from recoverWorkflow operation
     */
    public void receiveErrorrecoverWorkflow(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getSessionStatistics method
     * override this method for handling normal response from getSessionStatistics operation
     */
    public void receiveResultgetSessionStatistics(
        com.informatica.wsh.SessionStatistics result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getSessionStatistics operation
     */
    public void receiveErrorgetSessionStatistics(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getWorkflowDetails method
     * override this method for handling normal response from getWorkflowDetails operation
     */
    public void receiveResultgetWorkflowDetails(
        com.informatica.wsh.WorkflowDetails result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getWorkflowDetails operation
     */
    public void receiveErrorgetWorkflowDetails(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for login method
     * override this method for handling normal response from login operation
     */
    public void receiveResultlogin(String result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from login operation
     */
    public void receiveErrorlogin(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for scheduleWorkflow method
     * override this method for handling normal response from scheduleWorkflow operation
     */
    public void receiveResultscheduleWorkflow(
        com.informatica.wsh.VoidResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from scheduleWorkflow operation
     */
    public void receiveErrorscheduleWorkflow(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for resumeWorkflow method
     * override this method for handling normal response from resumeWorkflow operation
     */
    public void receiveResultresumeWorkflow(
        com.informatica.wsh.VoidResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from resumeWorkflow operation
     */
    public void receiveErrorresumeWorkflow(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for startSessionLogFetch method
     * override this method for handling normal response from startSessionLogFetch operation
     */
    public void receiveResultstartSessionLogFetch(int result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from startSessionLogFetch operation
     */
    public void receiveErrorstartSessionLogFetch(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getWorkflowLog method
     * override this method for handling normal response from getWorkflowLog operation
     */
    public void receiveResultgetWorkflowLog(com.informatica.wsh.Log result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getWorkflowLog operation
     */
    public void receiveErrorgetWorkflowLog(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for startWorkflow method
     * override this method for handling normal response from startWorkflow operation
     */
    public void receiveResultstartWorkflow(
        com.informatica.wsh.VoidResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from startWorkflow operation
     */
    public void receiveErrorstartWorkflow(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for stopTask method
     * override this method for handling normal response from stopTask operation
     */
    public void receiveResultstopTask(com.informatica.wsh.VoidResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from stopTask operation
     */
    public void receiveErrorstopTask(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for startTask method
     * override this method for handling normal response from startTask operation
     */
    public void receiveResultstartTask(com.informatica.wsh.VoidResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from startTask operation
     */
    public void receiveErrorstartTask(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getSessionPerformanceData method
     * override this method for handling normal response from getSessionPerformanceData operation
     */
    public void receiveResultgetSessionPerformanceData(
        com.informatica.wsh.SessionPerformanceData result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getSessionPerformanceData operation
     */
    public void receiveErrorgetSessionPerformanceData(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for startWorkflowEx method
     * override this method for handling normal response from startWorkflowEx operation
     */
    public void receiveResultstartWorkflowEx(
        com.informatica.wsh.TypeStartWorkflowExResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from startWorkflowEx operation
     */
    public void receiveErrorstartWorkflowEx(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getTaskDetailsEx method
     * override this method for handling normal response from getTaskDetailsEx operation
     */
    public void receiveResultgetTaskDetailsEx(
        com.informatica.wsh.DIServerDetails result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getTaskDetailsEx operation
     */
    public void receiveErrorgetTaskDetailsEx(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for startWorkflowFromTask method
     * override this method for handling normal response from startWorkflowFromTask operation
     */
    public void receiveResultstartWorkflowFromTask(
        com.informatica.wsh.VoidResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from startWorkflowFromTask operation
     */
    public void receiveErrorstartWorkflowFromTask(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for logout method
     * override this method for handling normal response from logout operation
     */
    public void receiveResultlogout(com.informatica.wsh.VoidResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from logout operation
     */
    public void receiveErrorlogout(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getWorkflowDetailsEx method
     * override this method for handling normal response from getWorkflowDetailsEx operation
     */
    public void receiveResultgetWorkflowDetailsEx(
        com.informatica.wsh.DIServerDetails result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getWorkflowDetailsEx operation
     */
    public void receiveErrorgetWorkflowDetailsEx(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for monitorDIServer method
     * override this method for handling normal response from monitorDIServer operation
     */
    public void receiveResultmonitorDIServer(
        com.informatica.wsh.DIServerDetails result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from monitorDIServer operation
     */
    public void receiveErrormonitorDIServer(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for waitTillTaskComplete method
     * override this method for handling normal response from waitTillTaskComplete operation
     */
    public void receiveResultwaitTillTaskComplete(
        com.informatica.wsh.VoidResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from waitTillTaskComplete operation
     */
    public void receiveErrorwaitTillTaskComplete(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getTaskDetails method
     * override this method for handling normal response from getTaskDetails operation
     */
    public void receiveResultgetTaskDetails(
        com.informatica.wsh.TaskDetails result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getTaskDetails operation
     */
    public void receiveErrorgetTaskDetails(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getDIServerProperties method
     * override this method for handling normal response from getDIServerProperties operation
     */
    public void receiveResultgetDIServerProperties(
        com.informatica.wsh.DIServerProperties result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getDIServerProperties operation
     */
    public void receiveErrorgetDIServerProperties(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for unscheduleWorkflow method
     * override this method for handling normal response from unscheduleWorkflow operation
     */
    public void receiveResultunscheduleWorkflow(
        com.informatica.wsh.VoidResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from unscheduleWorkflow operation
     */
    public void receiveErrorunscheduleWorkflow(Exception e) {
    }
}
