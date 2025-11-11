package cl.metlife.abm.business.managers;

import cl.metlife.abm.business.managers.localfolder.LocalFolderManager;
import cl.metlife.abm.domain.*;
import cl.metlife.abm.domain.Process;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.*;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import static javax.mail.Message.RecipientType.TO;

/**
 * Created by BluePrints Developer on 05-10-2016.
 */
@Stateless
public class MailSendlManager {

    @EJB
    private ABMConfigurationManager abmConfigurationManager;

    @EJB
    private LocalFolderManager localFolderManager;

    @EJB
    private ProcessManager processManager;
    private static final Logger LOGGER = LoggerFactory.getLogger(MailSendlManager.class);
    public MailSendlManager(){}

    public boolean sendMail(Lot lot, List<Log> logs, Process process, SmbFile file) throws MalformedURLException, UnknownHostException, SmbException, UnsupportedEncodingException, MessagingException {

        Multipart multipart = new MimeMultipart();
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        Properties smtpProperties;

        /* The messages are sent to the mail address found on the first document. In the same way,
        the SMTP used to create the message is obtained from the business line of such a message */
        try {
            smtpProperties = getMetlifeParameters();

            Authenticator authenticator = new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(abmConfigurationManager.getByKey(ABMConfiguration.ERROR_MAIL_MAILFROM).getValor(), abmConfigurationManager.getByKey(ABMConfiguration.ERROR_MAIL_MAILPASS).getValor());
                }
            };

            Session smtpSession = Session.getInstance(smtpProperties, authenticator);
            MimeMessage mimeMessage = new MimeMessage(smtpSession);
            try {
                mimeMessage.setFrom(new InternetAddress(abmConfigurationManager.getByKey(ABMConfiguration.ERROR_MAIL_MAILFROM).getValor(),
                        abmConfigurationManager.getByKey(ABMConfiguration.ERROR_MAIL_MAILNAME).getValor(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                LOGGER.info("Error en SendManager: "+e.getMessage() );
                throw e;
            }

            List<InternetAddress> addresses = new ArrayList<InternetAddress>();

            addresses.add(new InternetAddress(process.getErrorMail()));

            //TODO: agregar varios destinatarios
            mimeMessage.setRecipients(TO, addresses.toArray(new InternetAddress[addresses.size()]));

            String html = getHtml();

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

            html = html.replace("${corredor}", process.getBrokerName());
            html = html.replace("${rut}", process.getBrokerRut());
            html = html.replace("${fecha_finalizacion}", dateFormat.format(new Date()));

            String boletaHtml = "";
            boletaHtml += "<tr>\n" +
                        "            <td><table align=\"center\" width=\"91%\" border=\"0\" cellspacing=\"3\" cellpadding=\"1\">\n" +
                        "                <tbody>\n" +
                        "                  <tr>\n" +
                        "                    <td height=\"25\" width=\"12.5%\" align=\"center\" style=\"font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#ffffff; text-align:center; background-color:#1095d3; padding:5px 10px 5px 10px; border:solid 3px #ffffff;\"><strong>Fecha</strong></td>\n" +
                        "                    <td height=\"25\" width=\"12.5%\" align=\"center\" style=\"font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#ffffff; text-align:center; background-color:#1095d3; padding:5px 10px 5px 10px; border:solid 3px #ffffff;\"><strong>Lote</strong></td>\n" +
                        "                    <td height=\"25\" width=\"12.5%\" align=\"center\" style=\"font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#ffffff; text-align:center; background-color:#1095d3; padding:5px 10px 5px 10px; border:solid 3px #ffffff;\"><strong>Rut Corredor</strong></td>\n" +
                        "                    <td height=\"25\" width=\"12.5%\" align=\"center\" style=\"font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#ffffff; text-align:center; background-color:#1095d3; padding:5px 10px 5px 10px; border:solid 3px #ffffff;\"><strong>Paso</strong></td>\n" +
                        "                    <td height=\"25\" width=\"50%\" align=\"center\" style=\"font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#ffffff; text-align:center; background-color:#1095d3; padding:5px 10px 5px 10px; border:solid 3px #ffffff;\"><strong>Comentario</strong></td>\n" +
                        "                  </tr>\n";

            for (Log log : logs) {

                boletaHtml += "        <tr>\n" +
                        "                    <td height=\"25\" width=\"12.5%\" align=\"center\" style=\"font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#000000; text-align:center; background-color:#daeff9; padding:5px 10px 5px 10px; border:solid 3px #ffffff;\"><strong>";
                boletaHtml += dateFormat.format(log.getDate());
                boletaHtml += "</strong></td>\n" +
                        "                    <td height=\"25\" width=\"12.5%\" align=\"center\" style=\"font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#000000; text-align:center; background-color:#daeff9; padding:5px 10px 5px 10px; border:solid 3px #ffffff;\"><strong>";
                boletaHtml += lot.getNumber();
                boletaHtml += "</strong></td>\n" +
                        "                    <td height=\"25\" width=\"12.5%\" align=\"center\" style=\"font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#000000; text-align:center; background-color:#daeff9; padding:5px 10px 5px 10px; border:solid 3px #ffffff;\"><strong>";
                boletaHtml += process.getBrokerRut();
                boletaHtml += "</strong></td>\n";
                boletaHtml += "<td height=\"25\" width=\"12.5%\" align=\"center\" style=\"font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#000000; text-align:center; background-color:#edeceb;; padding:5px 10px 5px 10px; border:solid 3px #ffffff;\"><strong>";
                boletaHtml += log.getStep();
                boletaHtml += "</strong></td>\n" +
                              "<td height=\"25\" width=\"50%\" align=\"center\" style=\"font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#000000; text-align:center; background-color:#daeff9; padding:5px 10px 5px 10px; border:solid 3px #ffffff;\"><strong>";
                boletaHtml += log.getComment();
                boletaHtml += "</strong></td>\n";
            }

            boletaHtml += "                </tbody>\n" +
                    "              </table></td>\n" +
                    "          </tr>";


            html = html.replace("${boletas}", boletaHtml);

            mimeBodyPart.setContent(html, "text/html");
            multipart.addBodyPart(mimeBodyPart);
            try {
                if (file != null) {
                    //attachedFile1.attachFile(file);
                    attachFile(file, multipart);
                    file.close();
                }
                SmbFile logFileError = localFolderManager.getLogFileError(process.getBrokerRut(), lot);
                if(logFileError != null){
                    //attachedFile2.attachFile(logFileError);
                    attachFile(logFileError, multipart);
                    logFileError.close();
                }

            }catch(Exception e){

                LOGGER.info("No se logró adjuntar el excel con errrores : ");
                LOGGER.info("Error en SendManager: "+e.getMessage() );
                throw e;

            }

            mimeMessage.setContent(multipart);

            mimeMessage.setSubject("Reporte de errores ABM " + process.getBrokerName() + " (" + process.getBrokerRut() + ")");

            mimeMessage.saveChanges();

            InternetAddress internetAddress;
            try {
                String mail_from = abmConfigurationManager.getByKey(ABMConfiguration.ERROR_MAIL_MAILFROM).getValor();//"Metlife.Seguros@metlife.cl"
                String mail_name = abmConfigurationManager.getByKey(ABMConfiguration.ERROR_MAIL_MAILNAME).getValor();//"MetLife Seguros"
                mimeMessage.setFrom(new InternetAddress(mail_from, mail_name, "UTF-8"));

                Transport.send(mimeMessage);
            } catch (Exception e) {

                LOGGER.info("Error en SendManager: "+e.getMessage() );
                throw e;

            }

        } catch (MessagingException e) {
            LOGGER.info("Error en SendManager: "+e.getMessage() );
            try {
                throw e;
            } catch (MessagingException e1) {
                LOGGER.info("Error en SendManager: "+e.getMessage() );
                throw e;
            }
        }catch(Exception e){
            LOGGER.info("Error en SendManager: "+e.getMessage() );
            throw e;
        }


        return true;
    }

    private void attachFile(SmbFile file, Multipart multipart) throws MessagingException {
        //System.out.println("Adjuntando archivo " + file.getPath());
        MimeBodyPart mimeBodyPart;
        mimeBodyPart = new MimeBodyPart();

        DataSource source = new SmbFileDataSource(file);

        mimeBodyPart.setDataHandler(new DataHandler(source));
        mimeBodyPart.setFileName(file.getName());
        mimeBodyPart.setHeader("Content-Type", "application/vnd.ms-excel; charset=\"UTF-8\"; name=\"" + file.getName() + "\"");
        multipart.addBodyPart(mimeBodyPart);
    }

    public String getHtml(){
        StringBuilder contentBuilder = new StringBuilder();
        BufferedReader in = null;
        try {


            InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("format_error_mail.html");
            in = new BufferedReader(new InputStreamReader(resourceAsStream));

            String str;

            while ((str = in.readLine()) != null) {
                contentBuilder.append(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return contentBuilder.toString();
    }

    public Properties getMetlifeParameters() {
        Properties smtpProperties = new Properties();

        /* SMTP Properties */
        smtpProperties.setProperty("mail.smtp.host", abmConfigurationManager.getByKey(ABMConfiguration.ERROR_MAIL_HOST).getValor());
        smtpProperties.setProperty("mail.smtp.auth", Boolean.toString(true));
        smtpProperties.setProperty("mail.smtp.connectiontimeout", "120000");
        String theMailFrom = abmConfigurationManager.getByKey(ABMConfiguration.ERROR_MAIL_MAILFROM).getValor();
        smtpProperties.setProperty("mailFrom", theMailFrom);

        smtpProperties.setProperty("mail.imap.auth.ntlm.disable", "true");
        smtpProperties.setProperty("mail.imaps.port", "993");
        smtpProperties.setProperty("mail.smtp.writetimeout", "120000");
        smtpProperties.setProperty("mail.imap.port", "993");
        smtpProperties.setProperty("mail.imaps.auth.plain.disable", "true");
        smtpProperties.setProperty("mail.imaps.ssl.enable", "true");
        smtpProperties.setProperty("mail.imap.ssl.enable", "true");
        smtpProperties.setProperty("mail.imap.auth.plain.disable", "true");
        smtpProperties.setProperty("mail.imap.auth.gssapi.disable", "true");
        smtpProperties.setProperty("mail.imaps.auth.ntlm.disable", "true");

        return smtpProperties;
    }
}
