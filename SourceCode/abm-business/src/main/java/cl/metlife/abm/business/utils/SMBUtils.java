package cl.metlife.abm.business.utils;

import jcifs.CIFSContext;
import jcifs.CIFSException;
import jcifs.config.PropertyConfiguration;
import jcifs.context.BaseContext;
import jcifs.smb.NtlmPasswordAuthenticator;

import java.util.Properties;

public class SMBUtils {


    public static CIFSContext getBaseContext(String user, String pass) throws CIFSException {
        Properties jcifsProperties  = new Properties();
        jcifsProperties.setProperty("jcifs.smb.client.enableSMB2", "true");
        jcifsProperties.setProperty("jcifs.smb.client.dfs.disabled","true");
        jcifsProperties.setProperty("jcifs.smb.client.disablePlainTextPasswords","true");
        jcifsProperties.setProperty("jcifs.smb.client.domain","");
        jcifsProperties.setProperty("jcifs.smb.client.responseTimeout","15000");
        jcifsProperties.setProperty("jcifs.smb.client.dfs.disabled","true");
        jcifsProperties.setProperty("jcifs.smb.client.soTimeout","1800000");

        System.out.println("USER-PASS");
        System.out.println(user + " - " +pass);
        PropertyConfiguration config = new PropertyConfiguration(jcifsProperties);
        BaseContext baseCxt = new BaseContext(config);
        NtlmPasswordAuthenticator ntlmPasswordAuthentication = new NtlmPasswordAuthenticator(null, user, pass);

        return baseCxt.withCredentials(ntlmPasswordAuthentication);
    }
}
