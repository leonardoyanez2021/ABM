package cl.metlife.abm.business.managers.localfolder;

import cl.metlife.abm.business.managers.ABMConfigurationManager;
import cl.metlife.abm.business.managers.sftp.SFTPManager;
import cl.metlife.abm.business.utils.SMBUtils;
import cl.metlife.abm.domain.ABMConfiguration;
import cl.metlife.abm.domain.Lot;
import jcifs.smb.*;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import java.io.*;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class LocalFolderManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocalFolderManager.class);

    @EJB
    private ABMConfigurationManager configurationManager;

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    private SmbFile getSmbFile(String filepath, boolean r) throws MalformedURLException, SmbException, UnknownHostException {
        SmbFile smbFile = null;

        try {
            //users y pass:
            //default
            String user=configurationManager.getByKey(ABMConfiguration.SMB_USER).getValor();
            String pass=configurationManager.getByKey(ABMConfiguration.SMB_PSS).getValor();
            LOGGER.debug("filePath :" +filepath);
            String url = "smb:" + filepath;
            System.out.println("la url de " + url);
            LOGGER.debug("URL DE ACCESO: "+url);
            String url2=url;
            url2=url2.replace("\\","/");
            url2=url2.replace("\\","/");
            url2=url2.replace("\\","/");
            url2=url2.replace("\\","/");
            url2=url2.replace("\\","/");
            url2=url2.replace("\\","/");
            url2=url2.replace("\\","/");
            url2=url2.replace("\\","/");
            url2=url2.replace("\\","/");

            LOGGER.debug(String.format("URL DE ACCESO2: %s",url2));
            smbFile = new SmbFile(url2, SMBUtils.getBaseContext(user,pass));
            LOGGER.debug(String.format("path de smbFile: %s", smbFile.getPath()));

        }catch (Exception e){
            LOGGER.debug(String.format("ERROR!!!!->:%s", e.getMessage()));
        }

        return smbFile;
    }
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public String checkFoldersAndReturnLocalPath(String rut) throws Exception {

        try {

            String localFolderRoot = configurationManager.getByKey(ABMConfiguration.LOCAL_FOLDER_ROOT).getValor();
            System.out.println("localfolderRoot"+ localFolderRoot);
            SmbFile localFolderRootFile = getSmbFile(localFolderRoot,false);
            LOGGER.debug(localFolderRootFile.getPath());


            LOGGER.debug("RUT: " +rut+ " --");
            LOGGER.debug("localFolderRoot: " +localFolderRoot+ " --");

            LOGGER.debug(localFolderRoot + rut + "\\");


            String a= ABMConfiguration.EXECUTION_ENVIRONMENT_FOLDER;
            LOGGER.debug(a);


            String environmentFolder = configurationManager.getByKey(ABMConfiguration.EXECUTION_ENVIRONMENT_FOLDER).getValor();


            LOGGER.debug(localFolderRoot + rut + "\\" + environmentFolder + "\\" + SFTPManager.EXCEL_FOLDER_NAME + "\\");
            SmbFile excelFolder = getSmbFile(localFolderRoot + rut + "\\" + environmentFolder + "\\" + SFTPManager.EXCEL_FOLDER_NAME + "\\", true);

            LOGGER.debug(localFolderRoot + rut + "\\" + environmentFolder + "\\" + SFTPManager.PDF_FOLDER_NAME + "\\");
            SmbFile pdfFolder = getSmbFile(localFolderRoot + rut + "\\" + environmentFolder + "\\" + SFTPManager.PDF_FOLDER_NAME + "\\", true);


            localFolderRootFile.close();
            excelFolder.close();
            pdfFolder.close();

            return localFolderRoot + rut + "\\" + environmentFolder + "\\";
        } catch (Exception e) {
            System.out.println("Hubo un error al checkear las carpetas locales");
            LOGGER.error("Hubo un error al checkear las carpetas locales", e);
            LOGGER.error(e.getMessage());

            throw e;
        }
    }

    /**
     * This method return a list of .csv files, from @rut/EXCEL/ folder in local.
     * @param rut
     * @return list of .csv in rut/excel folder.
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<String> listCSVFilesByRut(String rut) throws UnknownHostException {


        List<String> returnList = new ArrayList<String>();

        try {
            String localFolderRoot = configurationManager.getByKey(ABMConfiguration.LOCAL_FOLDER_ROOT).getValor();

            String environmentFolder = configurationManager.getByKey(ABMConfiguration.EXECUTION_ENVIRONMENT_FOLDER).getValor();
            String user=configurationManager.getByKey(ABMConfiguration.SMB_USER).getValor();
            String pass=configurationManager.getByKey(ABMConfiguration.SMB_PSS).getValor();
            LOGGER.debug(localFolderRoot + rut + "\\" + environmentFolder + "\\" + SFTPManager.EXCEL_FOLDER_NAME + "\\");
            String context=localFolderRoot + rut + "\\" + environmentFolder + "\\" + SFTPManager.EXCEL_FOLDER_NAME + "\\";
            String name=localFolderRoot.replace("\\","/");

             name=name+ rut + "/" + environmentFolder + "/" + SFTPManager.EXCEL_FOLDER_NAME + "/";
             name=name.replace("\\","/");
            name=name.replace("\\","/");
            name=name.replace("\\","/");
            name=name.replace("\\","/");
            String smb="smb:";
            LOGGER.debug(smb+context);
            LOGGER.debug(smb+name);

            //seteo de la ruta segun configuración global:

            SmbFile excelFolder = new SmbFile(smb+name, SMBUtils.getBaseContext(user,pass));


            if(excelFolder.exists()) {
                String[] list= excelFolder.list();
                System.out.println(list.length);
                if(list!=null){
                    for (int i=0;i<list.length;i++) {
                            LOGGER.info("Archivo "+i+ " :"+list[i]);
                               if(list[i].toLowerCase().contains(".csv") ||list[i].toLowerCase().contains(".pdf")){
                                   LOGGER.info(list[i]);
                                   returnList.add(list[i]);
                               }
                    }
                }
            }
            excelFolder.close();
            return returnList;
        } catch (Exception e) {
            String ExceptionMessage=e.getMessage();
            LOGGER.error("Hubo un error al listar los archivos csv.", e);
            LOGGER.error(ExceptionMessage);
            return null;
        }


    }

    public byte[] getFile(String brokerRut, String currentExcelFile, String fileTypeFolder) {

        InputStream stream = null;

        try {
            String localFolderRoot = configurationManager.getByKey(ABMConfiguration.LOCAL_FOLDER_ROOT).getValor();
            String environmentFolder = configurationManager.getByKey(ABMConfiguration.EXECUTION_ENVIRONMENT_FOLDER).getValor();
            String user=configurationManager.getByKey(ABMConfiguration.SMB_USER).getValor();
            String pass=configurationManager.getByKey(ABMConfiguration.SMB_PSS).getValor();

            String contextBase=localFolderRoot;
            String namebBase=localFolderRoot.replace("\\","/");
            namebBase=namebBase.replace("\\","/");
            namebBase=namebBase.replace("\\","/");
            namebBase=namebBase.replace("\\","/");
            namebBase=namebBase.replace("\\","/");
            namebBase=namebBase.replace("\\","/");
            namebBase=namebBase.replace("\\","/");
            namebBase=namebBase.replace("\\","/");
            contextBase=contextBase+brokerRut + "\\" + environmentFolder + "\\" + fileTypeFolder + "\\";
            namebBase=namebBase+brokerRut + "/" + environmentFolder + "/" + fileTypeFolder + "/";
            String smb= "smb:";

            SmbFile file = new SmbFile(smb+namebBase+currentExcelFile,SMBUtils.getBaseContext(user,pass));
            SmbFile file2 = new SmbFile(smb+namebBase+Lot.PROCESSING_SUFFIX + currentExcelFile,SMBUtils.getBaseContext(user,pass));


            try{
               if( !file2.exists()){
                    file2.createNewFile();

                }
            }catch (Exception e){
                System.out.println("archivo no se pudo crear localfolderManager");
            }
            System.out.println("moviendo archivo");
            LOGGER.debug("moviendo archivo");
            stream=file.getInputStream();
            byte[] a=IOUtils.toByteArray(stream);
            stream.close();

            OutputStream outputStream = file2.getOutputStream();
            outputStream.write(a);
            outputStream.close();
            file2.close();
            file.delete();
            LOGGER.debug("archivo movido con exito");
            return a;
        } catch (Exception e) {

            LOGGER.error("Hubo un error al obtener archivo csv y cambiar nombre.", e);
            return null;
        }

    }

    public SmbFile getLogFileError(String brokerRut, Lot lot) throws SmbException, UnknownHostException, MalformedURLException {

        String localFolderRoot = configurationManager.getByKey(ABMConfiguration.LOCAL_FOLDER_ROOT).getValor();
        String environmentFolder = configurationManager.getByKey(ABMConfiguration.EXECUTION_ENVIRONMENT_FOLDER).getValor();

        SmbFile file = getSmbFile(localFolderRoot + brokerRut + "\\" + environmentFolder + "\\" + SFTPManager.RESULTS_FOLDER_NAME + "\\" +  lot.getNumber() + "_logs_ejecucion.xls",false);

        if(file!=null) {
            if(file.exists()){
                System.out.println("No existe el archivo de log de errores para ser enviado por correo: " +lot.getId() + "_logs_ejecucion.xls [" + file.getPath() + "]");
                file = null;
            }

        }
        return file;
    }

    public String saveFileAsExcel(String brokerRut, String currentExcelFile, String fileTypeFolder, Lot lot) {

        SmbFileInputStream stream = null;
        SmbFile file;
        SmbFile fileToSave;
        try {
            String entrypath="";
            String localFolderRoot = configurationManager.getByKey(ABMConfiguration.LOCAL_FOLDER_ROOT).getValor();

            String environmentFolder = configurationManager.getByKey(ABMConfiguration.EXECUTION_ENVIRONMENT_FOLDER).getValor();
            String user=configurationManager.getByKey(ABMConfiguration.SMB_USER).getValor();
            String pass=configurationManager.getByKey(ABMConfiguration.SMB_PSS).getValor();
            LOGGER.debug(localFolderRoot + brokerRut + "\\" + environmentFolder + "\\" + SFTPManager.EXCEL_FOLDER_NAME + "\\");
            String context=localFolderRoot + brokerRut + "\\" + environmentFolder + "\\" + SFTPManager.EXCEL_FOLDER_NAME + "\\";
            String contextR=localFolderRoot + brokerRut + "\\" + environmentFolder + "\\" + SFTPManager.RESULTS_FOLDER_NAME + "\\";
            String name=localFolderRoot.replace("\\","/");
            String nameR=name;
            nameR=nameR.replace("\\","/");
            nameR=nameR.replace("\\","/");
            nameR=nameR.replace("\\","/");
            nameR=nameR.replace("\\","/");
            name=name+ brokerRut + "/" + environmentFolder + "/" + SFTPManager.EXCEL_FOLDER_NAME + "/";
            nameR=nameR+ brokerRut + "/" + environmentFolder + "/" + SFTPManager.RESULTS_FOLDER_NAME + "/";
            name=name.replace("\\","/");
            name=name.replace("\\","/");
            name=name.replace("\\","/");
            name=name.replace("\\","/");
            String smb="smb:";
            LOGGER.debug(String.format("%s%s", smb, context));
            LOGGER.debug(String.format("%s%s", smb, name));

            file = new SmbFile(smb+name+currentExcelFile, SMBUtils.getBaseContext(user,pass));

            fileToSave= new SmbFile(smb+nameR+lot.getFilename(), SMBUtils.getBaseContext(user,pass));
            String fileName = fileToSave.getName();
            fileToSave.close();
            String pathExcel = FilenameUtils.removeExtension(fileName);
            pathExcel += ".xls";
            SmbFileInputStream sfis=new SmbFileInputStream(file);
            InputStreamReader isr=new InputStreamReader(sfis);
            BufferedReader reader = new BufferedReader(isr);
            LOGGER.debug("Creando Archivo Excel");
            HSSFWorkbook workBook = new HSSFWorkbook();

            LOGGER.info("salida Excel context: "+smb+contextR+pathExcel);
            LOGGER.info("salida Excel name: "+smb+nameR+pathExcel);

            OutputStream writer = new SmbFile(smb+nameR+pathExcel,SMBUtils.getBaseContext(user,pass)).getOutputStream();

            HSSFSheet mySheet = workBook.createSheet();

            String line = "";

            int rowNo = 0;
            boolean estaVacio = true;

            while ((line = reader.readLine()) != null){
                String[] columns = line.split(";");
                estaVacio = true;
                HSSFRow  row = mySheet.createRow(rowNo);
                for (int i=0;i<columns.length;i++){
                    HSSFCell cell = row.createCell(i);
                    cell.setCellValue(columns[i]);
                    if(!columns[i].trim().isEmpty())
                        estaVacio = false;
                }
                if(estaVacio){
                    mySheet.removeRow(row);
                    continue;
                }
                rowNo++;
            }
            workBook.write(writer);
            writer.close();
            reader.close();
            isr.close();
            sfis.close();

            LOGGER.debug("Archivo excel creado con exito");
            file.close();
            return file.getName();

        } catch (Exception e) {
            LOGGER.error("Hubo un error al obtener archivo csv y guardar como excel.", e);
            return "";
        }

    }

    public SmbFile getErrorFile(String brokerRut, String fileTypeFolder, String currentExcelFile) {
        SmbFile adjunto = null;
        try{
            String localFolderRoot = configurationManager.getByKey(ABMConfiguration.LOCAL_FOLDER_ROOT).getValor();
            String environmentFolder = configurationManager.getByKey(ABMConfiguration.EXECUTION_ENVIRONMENT_FOLDER).getValor();

            String newFilePath = localFolderRoot + brokerRut + "\\" + environmentFolder + "\\" + fileTypeFolder + "\\"  + currentExcelFile;
            newFilePath = newFilePath.toLowerCase().replace(".csv",".xls");
            adjunto = getSmbFile(newFilePath, false);
            if(!adjunto.exists())
                return null;

        }catch(Exception e){
            System.out.println("Error al obtener archivo adjunto");
            e.printStackTrace();
            adjunto = null;
        }
        return adjunto;
    }
    //TODO fix this...
    public void moveFile(String brokerRut, String currentExcelFile) throws IOException {
        SmbFileInputStream stream = null;
        String localFolderRoot = configurationManager.getByKey(ABMConfiguration.LOCAL_FOLDER_ROOT).getValor();
        String environmentFolder = configurationManager.getByKey(ABMConfiguration.EXECUTION_ENVIRONMENT_FOLDER).getValor();


        SmbFile file = getSmbFile(localFolderRoot + brokerRut + "\\" + environmentFolder + "\\" + SFTPManager.RESULTS_FOLDER_NAME + "\\" + currentExcelFile, false);

        String fileName = file.getCanonicalPath();
        String pathExcel = FilenameUtils.removeExtension(fileName);
        file.close();
        pathExcel += ".xls";
        file = getSmbFile(pathExcel, false);

        String newFilePath = localFolderRoot + "\\" + brokerRut + "\\" + environmentFolder + "\\" + SFTPManager.EXCEL_FOLDER_NAME   ;
        newFilePath = newFilePath.toLowerCase().replace(".csv",".xls");
        int copycont = 1;
        SmbFile dest = getSmbFile(newFilePath+ currentExcelFile, false);

        while(dest.exists()) {
            dest = getSmbFile(newFilePath+"("+copycont+")"+ currentExcelFile, false);
            copycont++;
        }

        stream = new SmbFileInputStream(file);
        LOGGER.debug("leyendo bytes");

        byte[] bytes = IOUtils.toByteArray(stream);
        stream.close();
        dest.getOutputStream().write(bytes);
        dest.getOutputStream().close();
        dest.close();
        file.delete();
        LOGGER.debug("moviendo archivo");
        // file.renameTo(file2);
    }

    public void renameFile(String brokerRut, String fromFileName, String toFileNAme, String folderTypeName) {
        InputStream stream = null;
        SmbFile file=null;
        SmbFile dest=null;

        try {
            String localFolderRoot = configurationManager.getByKey(ABMConfiguration.LOCAL_FOLDER_ROOT).getValor();
            String environmentFolder = configurationManager.getByKey(ABMConfiguration.EXECUTION_ENVIRONMENT_FOLDER).getValor();
            file = getSmbFile(localFolderRoot + brokerRut + "\\" + environmentFolder + "\\" + folderTypeName + "\\" + fromFileName, false);
            String finalpath = localFolderRoot + brokerRut + "\\" + environmentFolder + "\\" + folderTypeName + "\\" + toFileNAme;
            String finalpath2 = localFolderRoot + brokerRut + "\\" + environmentFolder + "\\" + folderTypeName + "\\";
            dest = getSmbFile(finalpath, false);
            if(dest!=null)
            {   if(dest.exists()){
                dest.delete();
                dest = getSmbFile(finalpath2 + toFileNAme,false);
                }
            }else{
                dest = getSmbFile(finalpath2 + toFileNAme, false);
            }
            byte[] a;
            if(file!=null){
                stream=file.getInputStream();
                a=  IOUtils.toByteArray(stream);
                stream.close();
                dest.getOutputStream().write(a);
                dest.close();
            }

        } catch (Exception e) {
            System.out.println("Hubo un error al renombrar el archivo a ERROR_."+e.getMessage());
            e.printStackTrace();
            LOGGER.error("Hubo un error al renombrar el archivo a ERROR_.", e);
        }finally {
            if(dest!=null){
                dest.close();
            }
            if(file!=null){
                try {
                    if(stream!=null){
                        stream.close();
                    }
                    file.delete();
                } catch (SmbException e) {
                    LOGGER.info("error al borrar el archivo: "+e.getMessage());
                }catch (IOException ex){
                    System.out.println("ERROR con imput stream reader");
                }
            }
        }
    }

    public boolean existPDFFile(String brokerRut, String pdfPath){
        boolean exist=false;
        try {
            String localFolderRoot = configurationManager.getByKey(ABMConfiguration.LOCAL_FOLDER_ROOT).getValor();
            String environmentFolder = configurationManager.getByKey(ABMConfiguration.EXECUTION_ENVIRONMENT_FOLDER).getValor();

            SmbFile file = getSmbFile(localFolderRoot + brokerRut + "\\" + environmentFolder + "\\" + SFTPManager.PDF_FOLDER_NAME + "\\" + pdfPath, false);

            if(file!=null){
                if(file.exists()){
                    exist=true;
                }
            }
            file.close();
            return exist;
        } catch (Exception e) {
            System.out.println("Hubo un error al conocer si un PDF existe en la carpeta local."+ e.getMessage());
            LOGGER.error("Hubo un error al conocer si un PDF existe en la carpeta local.", e);
        }

        return false;
    }

    public void moveFileToResultFolder(String brokerRut, String folder, String fileName){
            String smb="smb:";
        SmbFileInputStream stream = null;

        try {
            String localFolderRoot = configurationManager.getByKey(ABMConfiguration.LOCAL_FOLDER_ROOT).getValor();
            String environmentFolder = configurationManager.getByKey(ABMConfiguration.EXECUTION_ENVIRONMENT_FOLDER).getValor();
            String context=localFolderRoot + brokerRut + "\\" + environmentFolder + "\\" + SFTPManager.EXCEL_FOLDER_NAME + "\\";
            String name=localFolderRoot.replace("\\","/") + brokerRut + "/" + environmentFolder + "/" + SFTPManager.EXCEL_FOLDER_NAME + "/" ;
            String context2=context;
            String name2= name;
             context2=context2+ folder + "\\";
             name2=name+ folder + "/";
            String user=configurationManager.getByKey(ABMConfiguration.SMB_USER).getValor();
            String pass=configurationManager.getByKey(ABMConfiguration.SMB_PSS).getValor();

            String q=smb+context+ folder + fileName;
            String q2=smb+name+ folder + fileName;
            System.out.println("Q+Q1:/"+q +"\n" +q2);

            String p=smb+context2+ folder + fileName;
            String p2=smb+name2+folder + fileName;
            LOGGER.info("p/p1: "+p +"\n" +p2);

            String n=smb+name+ folder + fileName;

            System.out.println("archivo de entrada:"+n);
            SmbFile file = new SmbFile(n,SMBUtils.getBaseContext(user,pass));

            String n2=smb+name2+folder + fileName;

            System.out.println("archivo de salida:"+n2);

            SmbFile dest = new SmbFile(n2,SMBUtils.getBaseContext(user,pass));

            int copycont = 1;

            if(dest.exists()) {
                dest.delete();
                dest = new SmbFile(n2,SMBUtils.getBaseContext(user,pass));
                copycont++;
            }
            System.out.println("Separando archivo desde " + file.getPath() + " a " + dest.getPath());
            stream = new SmbFileInputStream(file);
            LOGGER.debug("leyendo bytes");
            byte[] bytes = IOUtils.toByteArray(stream);
            LOGGER.debug("Creando inputreader");
            stream.close();
            LOGGER.debug("extrayendo output");
            OutputStream outputStream = dest.getOutputStream();
            LOGGER.debug("escribiendo bytes");
            outputStream.write(bytes);
            LOGGER.debug("Cerrando output");
            outputStream.close();
            LOGGER.debug("Cerrando destino");
            dest.close();
            LOGGER.debug("Cerrando File");
            file.close();

            System.out.println("archivo separado");
        } catch (Exception e) {
            System.out.println("Hubo un error al renombrar el archivo a ERROR_."+ e.getMessage());
            LOGGER.error("Hubo un error al renombrar el archivo a ERROR_.", e);
        }
    }
}
