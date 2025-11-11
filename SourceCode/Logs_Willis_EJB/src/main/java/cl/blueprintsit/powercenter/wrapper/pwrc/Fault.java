/**
 * Fault.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */
package cl.blueprintsit.powercenter.wrapper.pwrc;

public class Fault extends Exception {
    private static final long serialVersionUID = 1438205968148L;
    private com.informatica.wsh.FaultDetails faultMessage;

    public Fault() {
        super("Fault");
    }

    public Fault(String s) {
        super(s);
    }

    public Fault(String s, Throwable ex) {
        super(s, ex);
    }

    public Fault(Throwable cause) {
        super(cause);
    }

    public void setFaultMessage(com.informatica.wsh.FaultDetails msg) {
        faultMessage = msg;
    }

    public com.informatica.wsh.FaultDetails getFaultMessage() {
        return faultMessage;
    }
}
