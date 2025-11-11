package cl.blueprintsit.type;

import cl.blueprintsit.process.AccessParameters;
import cl.blueprintsit.ws.bulkPreingreso.WsBulk;
import cl.blueprintsit.ws.sesionPreingreso.SesionBo;
import cl.blueprintsit.ws.sesionPreingreso.WsSesion;
import cl.blueprintsit.ws.sesionPreingreso.WsSesionSoap;

import org.slf4j.LoggerFactory;

import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.naming.Context;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.namespace.QName;

/**
 * Created by BlueprintsIT on 5/25/2016.
 */
public class ConnectionBD {

    static private final org.slf4j.Logger log = LoggerFactory.getLogger(ConnectionBD.class);

    Context ctx ;
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    Calendar calendar = Calendar.getInstance();

    public Connection getConnectionPipeSponsor() {
    	  //NRA Conexion de prueba para pipe
//        Connection connection = null;
//
//        try {
//    Class.forName("oracle.jdbc.driver.OracleDriver");
//    connection = DriverManager.getConnection(
   // "jdbc:oracle:thin:@192.168.1.54:1521:xe", "willis","willis1");
//    	"jdbc:oracle:thin:@mlfpcbddes:1525:metlifqc", "CANALESN","prueba");
//    	log.info("Conexion Exitosa a pipe");
//    } catch (Exception e) {
//    // TODO Auto-generated catch block
//    log.error(e.getMessage());
//    log.info("Error de conexion");
//    }

            

    
        Connection connectionPipeSponsor = null;
        DataSource ds = null;

        try {

            ctx = new InitialContext();
            ds = (javax.sql.DataSource) ctx.lookup("jdbc/logPipeSponsor");
            connectionPipeSponsor = ds.getConnection();

        } catch (NamingException e){
            log.error("BD PIPE SPONSOR" + e.getMessage());
            registerLog("NO HAY CONEXION CON LA BD DE PIPESPONSOR, ERROR: "+e.getMessage(), AccessParameters.logTypeERROR, "EJECUCION GENERAL",null,0);
        }finally {

            return connectionPipeSponsor;
        }
    }
    public Connection getConnectionPreIngreso() {

        Connection connectionPreIngreso = null;
        PreparedStatement ps = null;
        Connection connection = null;
        DataSource ds = null;
        try {
            ctx = new InitialContext();
            ds = (javax.sql.DataSource) ctx.lookup("jdbc/logPreIngreso");
            //ds = (DataSource) ctx.lookup("jdbc/preIngresoDS");
       
            connectionPreIngreso = ds.getConnection();
        } catch (NamingException e){
            log.error("No se ha conectado a la DB: " + e);

        }finally {
            return connectionPreIngreso;
        }
    }

    public void updateCodFileNetPreIngreso(List<ParameterFilenet> list, String user, String pass, String rutArchivoCorredor, URL url) throws SQLException {
        try {
            if (list.size()==0)
                return;

            WsSesion wsSesion = new WsSesion(url,new QName("http://preingreso.metlife.cl/", "WsSesion"));

            WsSesionSoap wsSesionSoap = wsSesion.getWsSesionSoap();
            SesionBo sesionBo = wsSesionSoap.logon(user, pass);
            if (sesionBo.getId()!=null){
                for (ParameterFilenet a: list){
                    WsBulk wsBulk = new WsBulk();
                    String sesionId = sesionBo.getId();

                    wsBulk.getWsBulkSoap().fileNetCodigoGrabar(sesionId,
                            Integer.valueOf(a.getIdCarga()),
                            Integer.valueOf(a.getPoliza()),
                            Integer.valueOf(a.getNumgrup()),
                            Integer.valueOf(a.getRuttitular()) ,
                            Integer.valueOf(a.getDvtitutar()) ,
                            Integer.valueOf(a.getRutcarga()),
                            Integer.valueOf(a.getDvcarga()),
                            a.getCodigoFileNet(),null,null, null);
                }
                wsSesionSoap.logout(sesionBo.getId());
            }
        }catch (Exception e){
            log.error(e.getMessage());
            registerLog("WS SERVICE BULK, ERROR: "+e.getMessage(),AccessParameters.logTypeERROR,"FILENET", rutArchivoCorredor,0);
        }
    }

    public List<ParameterFilenet> generateListFileNet( ResultSet rs, boolean isExcluirTitular) throws SQLException {
        List<ParameterFilenet> filenetList = new ArrayList<ParameterFilenet>();
        while (rs.next()){
            ParameterFilenet parameterFilenet =  new ParameterFilenet();
            parameterFilenet.setPoliza(isNull(rs.getString("POLIZA")));
            parameterFilenet.setNumgrup(isNull(rs.getString("NUMGRUP")));
            parameterFilenet.setLote(isNull(rs.getString("LOTE")));
            parameterFilenet.setRuttitular(isNull(rs.getString("RUTTITULAR")));
            parameterFilenet.setDvtitutar(isNull(rs.getString("DVTITUTAR")));
            if (!isExcluirTitular){
                parameterFilenet.setRutcarga(isNull(rs.getString("RUTCARGA")));
                parameterFilenet.setDvcarga(isNull(rs.getString("DVCARGA")));
            }
            parameterFilenet.setCodigoFileNet(isNull(rs.getString("CODIGOFILENET")));
            parameterFilenet.setIdCarga(isNull(rs.getString("IDCARGA")));
            filenetList.add(parameterFilenet);
        }
        return filenetList;
    }

    public int updateCodFileNet(int typeProceso, String file,String codFileNet) throws SQLException {
        String query= null;
        PreparedStatement ps = null;
        int result = -1;
        switch (typeProceso){
            case 1:{
                query = "UPDATE COLALTATITCAR SET CODIGOFILENET = ? where CODBARRA = ?  ";
                break;
            }
            case 2:{
                query = "UPDATE COLALTACARGAS SET CODIGOFILENET = ?  where CODBARRA = ?  ";
                break;
            }
            case 3:{
                query = "UPDATE COLEXCLUIRTITULAR SET CODIGOFILENET = ? where CODBARRA = ?  ";
                break;
            }
            case 4:{
                query = "UPDATE COLEXCLUIRCARGA SET CODIGOFILENET = ? where CODBARRA = ?  ";
                break;
            }
        }

        try(Connection con = new ConnectionBD().getConnectionPipeSponsor()) {

            if (con != null) {
                ps = con.prepareStatement(query);
                ps.setString(1,codFileNet);
                ps.setString(2,file.replace(".pdf",""));
                result = ps.executeUpdate();
            }
        } catch (SQLException e) {
            log.error("PROBLEMAS EN BD, ERROR: "+e.getMessage());
            registerLog("PROBLEMAS EN BD, ERROR: "+e.getMessage(),AccessParameters.logTypeERROR,"PIPE SPONSOR", null,0);
        }finally {
            assert ps != null;
            ps.close();
        }
        return result;
    }

    public List<ParameterFilenet> findDateUpdated(int typeProceso, String file,String codFileNet) throws SQLException {
        String query= null;
        PreparedStatement ps = null;
        Connection connection = null;

        List<ParameterFilenet> filenetList=new ArrayList<>();
        int result = -1;
        switch (typeProceso){
            case 1:{
                query = "SELECT POLIZA,NUMGRUP,LOTE,RUTTITULAR, DVTITUTAR,RUTCARGA,DVCARGA, CODIGOFILENET, IDCARGA  from COLALTATITCAR  " +
                        " where CODBARRA = ?  AND CODIGOFILENET = ? ";
                break;
            }
            case 2:{
                query = "SELECT POLIZA,NUMGRUP,LOTE,RUTTITULAR, DVTITUTAR,RUTCARGA,DVCARGA, CODIGOFILENET , IDCARGA from COLALTACARGAS  " +
                        " where CODBARRA = ?  AND CODIGOFILENET = ? ";
                break;
            }
            case 3:{
                query = "select poliza, NUMGRUP,LOTE,RUTTITULAR, DVTITUTAR, CODIGOFILENET , IDCARGA from colexcluirtitular " +
                        " where CODBARRA = ?  AND CODIGOFILENET = ? ";
                break;
            }
            case 4:{
                query = "select poliza, NUMGRUP,LOTE,RUTTITULAR, DVTITUTAR, RUTCARGA,DVCARGA, IDCARGA from COLEXCLUIRCARGA " +
                        " where CODBARRA = ?  AND CODIGOFILENET = ? ";
                break;
            }
        }
        try {
            connection = new ConnectionBD().getConnectionPipeSponsor();
            if (connection!=null){
                ps =  connection.prepareStatement(query);
                ps.setString(1,file.replace(".pdf",""));
                ps.setString(2,codFileNet);
                ResultSet rs = ps.executeQuery();
                filenetList = generateListFileNet(rs,false);
            }
            connection.close();
        } catch (SQLException e) {
            connection.close();
            log.error("PROBLEMAS EN BD, ERROR: "+e.getMessage());
            registerLog("PROBLEMAS EN BD, ERROR: "+e.getMessage(),AccessParameters.logTypeERROR,"PIPE SPONSOR", null,0);
        }
        return filenetList;
    }

    private String isNull(String valor) {

        if (valor==null)
            return "";
        else
            return valor;

    }

    public void processRegister(int typeProceso, String rutCorredor, String lote) throws SQLException {
        String query= null;
        PreparedStatement ps = null;
        Connection connection = null;
        DataSource ds = null;
        int result = -1;
        switch (typeProceso){
            case 1:{
                query = "UPDATE COLALTATITCAR SET PROCESADO = 0 ,FECHAHORACARGA = ? where PROCESADO is null and RUTCORREDOR = ? and lote = ? ";
                break;
            }
            case 2:{
                query = "UPDATE COLALTACARGAS SET  PROCESADO = 0  ,FECHAHORACARGA = ? where PROCESADO is null and RUTCORREDOR = ? and lote = ?  ";
                break;
            }
            case 3:{
                query = "UPDATE COLEXCLUIRTITULAR SET  PROCESADO = 0 ,FECHAHORACARGA = ? where PROCESADO is null and RUTCORREDOR = ? and lote = ? ";
                break;
            }
            case 4:{
                query = "UPDATE COLEXCLUIRCARGA SET  PROCESADO = 0 ,FECHAHORACARGA = ? where PROCESADO is null and RUTCORREDOR = ? and lote = ? ";
                break;
            }
            default:
                log.error("case out of logic");
        }
        try {
            connection = new ConnectionBD().getConnectionPipeSponsor();
            if (connection != null && query!=null) {
                ps = connection.prepareStatement(query);
                Calendar calendar = Calendar.getInstance();
                String dateStr = formatter.format(calendar.getTime());
                ps.setString(1,dateStr);

                ps.setString(2, rutCorredor);
                ps.setString(3, lote);
                ps.executeUpdate();
            }
            connection.close();
        } catch (SQLException e) {
            connection.close();
            log.error("PROBLEMAS EN BD, ERROR: " + e.getMessage());
            registerLog("PROBLEMAS EN BD, ERROR: " + e.getMessage(),AccessParameters.logTypeERROR,"PIPE SPONSOR", rutCorredor,Integer.valueOf(lote));
        }

    }

    public String findTimeEje() throws SQLException {
        String result = "24:00";
        PreparedStatement ps = null;
        Connection connection = null;
        DataSource ds = null;
        try {
            connection = new ConnectionBD().getConnectionPreIngreso();
            if (connection != null) {
                String query = "select valor from PREWEB_CONFIGURACION where PARAMETRO ='TIME_EJE'";
                ps = connection.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while (rs.next()){                
                    result = rs.getString("valor");
                }
            }
            connection.close();
        } catch (SQLException e) {
            connection.close();
            log.error("PROBLEMAS EN BD PREINGRESO, ERROR: " + e.getMessage());
        }
        return result;
    }

    /* metodo sobrecargado RRG agibiz */
    public String findTimeEje(String strEntidad ) throws SQLException {
    	//strEntidad = "BCO_CHILE";
        String result = "24:00";
        PreparedStatement ps = null;
        Connection connection = null;
        DataSource ds = null;
        try {
            connection = new ConnectionBD().getConnectionPreIngreso();
            if (connection != null) {
            	
            	                                                                                                                                                                       /* NRA  se modifica a id_entidad */
                	String query = "select valor from PREWEB_CONFIGURACION where PARAMETRO ='TIME_EJE' and identidad = '"+  strEntidad +"' ";
                ps = connection.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    result = rs.getString("valor");
                }
            }
            connection.close();
        } catch (SQLException e) {
            connection.close();
            log.error("PROBLEMAS EN BD PREINGRESO, ERROR: " + e.getMessage());
        }
        return result;
    }

    /* NRA  Se agrega query al metodo getEntidades */
    public ArrayList<String>  getEntidades() throws SQLException {
        String result = "24:00";
        ArrayList<String> arrResult = new ArrayList();
        PreparedStatement ps = null;
        Connection connection = null;
        DataSource ds = null;
        try {
            connection = new ConnectionBD().getConnectionPreIngreso();

            if (connection != null) {
            		//variable de pruebba para el nombre del banco
            		//String _bco = "BCO_CHILE";            		
            		//constante con valor 1 = true
            		int _true =1;            	                                                                                                             //NRA - 0 = False  ,  1 = True 	
                	String query = "select distinct identidad  from preweb_configuracion where procesarentidad = "+_true+"" ;
                ps = connection.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    result = rs.getString("identidad");
                    arrResult.add(result);	
                }
            }
            connection.close();
        } catch (SQLException e) {
            connection.close();
            log.error("PROBLEMAS EN BD PREINGRESO, ERROR: " + e.getMessage());
        }
        return arrResult;
    }
    /* fin cambio agibiz*/    
    public void registerLog(String menssage, String type,  String proceso,String rutCorredor,int lote) throws SQLException {

        Calendar calendar = Calendar.getInstance();
        String dateStr = formatter.format(calendar.getTime());
        PreparedStatement ps = null;
        Connection connection = null;
        DataSource ds = null;

        if (rutCorredor==null)
            rutCorredor = "0";

        try {
            connection= new ConnectionBD().getConnectionPreIngreso();
            if (connection!=null){
                String query ="Insert into PREWEB_LOG (id, MENSAJE,FECHA,TIPO, PROCESO, RUT_CORREDOR ,LOTE) values" +
                        " (PREWEB_LOGSEQUENCE.nextval,?,TO_TIMESTAMP(?,'DD-MM-YYYY HH24:MI:SS'),?, ?, ?,?)";

                ps = connection.prepareStatement(query);
                ps.setString(1, menssage);
                ps.setString(2,dateStr);
                ps.setString(3,type);
                ps.setString(4, proceso  );
                ps.setString(5,rutCorredor);
                ps.setInt(6,lote);
                ps.executeUpdate();
            }
            connection.close();
        } catch (SQLException e) {
            connection.close();
            log.error("PROBLEMAS EN BD PREINGRESO, ERROR: " + e.getMessage());
        }
    }

    public boolean findIfExistRegisters(String archivo, int typeProceso) throws SQLException {

        PreparedStatement ps = null;
        Connection connection = null;
        DataSource ds = null;

        String query= null;
        switch (typeProceso){
            case 1:{
                query = "select count(*) from COLALTATITCAR where CODBARRA = ? and IDCARGA is not null ";
                break;
            }
            case 2:{
                query = "select count(*) from  COLALTACARGAS  where CODBARRA = ? and IDCARGA is not null ";
                break;
            }
            case 3:{
                query = "select count(*) from  COLEXCLUIRTITULAR  where CODBARRA = ? and IDCARGA is not null ";
                break;
            }
            case 4:{
                query = "select count(*) from  COLEXCLUIRCARGA  where CODBARRA = ? and IDCARGA is not null ";
                break;
            }
        }
        try {
            connection = new ConnectionBD().getConnectionPipeSponsor();
            if (connection != null && query!=null) {
                ps = connection.prepareStatement(query);
                ps.setString(1, archivo.replace(".pdf",""));
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                  return true;
                }
            }
            connection.close();
        } catch (SQLException e) {
            log.error("PROBLEMAS EN BD, ERROR: " + e.getMessage());
            registerLog("PROBLEMAS EN BD, ERROR: " + e.getMessage(),AccessParameters.logTypeERROR,"PIPE SPONSOR", null,0);
            connection.close();
        }
        return false;
    }

    public   List<UpdateCodeFileNet>  getCodigoBarra(String rutArchivoCorredor, int loteArchivo, int typeFile,String fileExcelProcessing) throws SQLException {

        PreparedStatement ps = null;
        Connection connection = null;
        DataSource ds = null;

        List<UpdateCodeFileNet> stringList =  new ArrayList<UpdateCodeFileNet>();
        String query = null;
        switch (typeFile){
            case 1:{
                query = "select POLIZA, CODBARRA from COLALTATITCAR  where RUTCORREDOR = ? and lote= ? and procesado is null";
                break;
            }
            case 2:{
                query = "select POLIZA, CODBARRA from COLALTACARGAS  where RUTCORREDOR = ? and lote= ? and procesado is null ";
                break;
            }
            case 3:{
                query = "select POLIZA, CODBARRA from COLEXCLUIRTITULAR  where RUTCORREDOR = ? and lote= ? and procesado is null ";
                break;
            }
            case 4:{
                query = "select POLIZA, CODBARRA from COLEXCLUIRCARGA  where RUTCORREDOR = ? and lote= ? and procesado is null ";
                break;
            }

        }
        try {
            connection = new ConnectionBD().getConnectionPipeSponsor();
            if (connection != null) {
                ps = connection.prepareStatement(query);
                ps.setString(1, rutArchivoCorredor);
                ps.setInt(2, loteArchivo);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    stringList.add(new UpdateCodeFileNet(rs.getString("POLIZA"), rs.getString("CODBARRA")));
                }
            }

        } catch (SQLException e) {

            log.error("PROBLEMAS EN BD, "+ fileExcelProcessing + " ERROR: " + e.getMessage(),e);
            registerLog("PROBLEMAS EN BD, "+ fileExcelProcessing + " ERROR: " + e.getMessage(),AccessParameters.logTypeERROR,"PIPE SPONSOR", rutArchivoCorredor,loteArchivo);
        }finally {
            try{
                connection.close();
            }catch (Throwable t){

            }
        }
        return stringList;
    }

    
    public void statusProcess(int idProces, String status, String name) throws SQLException {
        PreparedStatement ps = null;
        Connection connection = null;
        DataSource ds = null;

        String query=null;
        try {
            connection = new ConnectionBD().getConnectionPreIngreso();
            if (connection!=null){
                if (name==null)
                    query = "UPDATE PREWEB_ESTADO_PROCESO SET ESTADO = ? WHERE ID = ? ";
                else
                    query = "UPDATE PREWEB_ESTADO_PROCESO SET NOMBRE = '"+name+"', ESTADO = ? WHERE ID = ? ";

                ps = connection.prepareStatement(query);
                ps.setInt(2,idProces);
                ps.setString(1, status);
                ps.executeQuery();
            }

        } catch (SQLException e) {
            //connection.close();
            log.error("no se ha conectado a la DB: " +e.getMessage(),e);
       }finally {
            try{
                connection.close();
            }catch (Throwable t){}
        }
    }

    /* rrg sobrecarga agibiz*/
    public boolean searchParameterConfSFTP(String strEntidad) {
    	
    	 PreparedStatement ps = null;
         Connection connection = null;
         DataSource ds = null;

         boolean enableSFTP= false;
         try {
             connection = new ConnectionBD().getConnectionPreIngreso();

        	  if (connection != null) {
                 String query = "select valor from PREWEB_CONFIGURACION where PARAMETRO ='SFTP_ENABLE' and identidad ='"+  strEntidad +"' ";
                 ps = connection.prepareStatement(query);
                 ResultSet rs = ps.executeQuery();
                 
                 while (rs.next()) {
                	 
                     enableSFTP = Boolean.parseBoolean(rs.getString("VALOR"));

                 } 
             }

         //} catch (SQLException e) {
         } catch (Exception e) {
             log.error("PROBLEMAS AL LEER LAS VARIABLES DE CONFIGURACION EN BD - TABLA:PREWEB_CONFIGURACION",e);
         }finally {
             try{
                 connection.close();
             }catch (Throwable t){}
         }
         return enableSFTP;
     }
    
    public boolean searchParameterConfSFTP() {
        PreparedStatement ps = null;
        Connection connection = null;
        DataSource ds = null;

        boolean enableSFTP= false;
        try {
            connection = new ConnectionBD().getConnectionPreIngreso();
            if (connection != null) {
                String query = "select valor from PREWEB_CONFIGURACION where PARAMETRO ='SFTP_ENABLE'";
                ps = connection.prepareStatement(query);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    enableSFTP = Boolean.parseBoolean(rs.getString("VALOR"));

                }
            }

        } catch (SQLException e) {
            log.error("PROBLEMAS AL LEER LAS VARIABLES DE CONFIGURACION EN BD - TABLA:PREWEB_CONFIGURACION",e);
        }finally {
            try{
                connection.close();
            }catch (Throwable t){}
        }
        return enableSFTP;
    }

    public boolean checkIfExistRunningProcess(){
        PreparedStatement ps = null;
        Connection connection = null;
        DataSource ds = null;

        String query1, query2, query3, query4;
        query1 = "select POLIZA from COLALTATITCAR  where procesado = 2 ";
        query2 = "select POLIZA from COLALTACARGAS where procesado = 2 ";
        query3 = "select POLIZA from COLEXCLUIRTITULAR where procesado = 2 ";
        query4 = "select POLIZA from COLEXCLUIRCARGA where procesado = 2 ";

        try {
            connection = new ConnectionBD().getConnectionPipeSponsor();

            if (connection != null) {
                ps = connection.prepareStatement(query1);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    return true;
                }

                ps = connection.prepareStatement(query2);
                ResultSet rs2 = ps.executeQuery();

                while (rs2.next()) {
                    return true;
                }

                ps = connection.prepareStatement(query3);
                ResultSet rs3 = ps.executeQuery();

                while (rs3.next()) {
                    return true;
                }

                ps = connection.prepareStatement(query4);
                ResultSet rs4 = ps.executeQuery();

                while (rs4.next()) {
                    return true;
                }

            }
        } catch (SQLException e) {
            log.error("Error al obtener los procesado en 2, para mostrar botón iniciar");
        }finally {
            try{
                connection.close();
            }catch (Throwable t){}
        }

        return false;
    }

    //RRG Metodo de conexion de pruebas
    public Connection getConnectionJDBC() {
        
        Connection connection = null;
        
        try {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    connection = DriverManager.getConnection(
   // "jdbc:oracle:thin:@192.168.1.54:1521:xe", "willis","willis1");
    	"jdbc:oracle:thin:@mlfdesa02:1532:metrcsd", "salud","desarrollo");
    	log.info("Conexion Exitosa a bd desarrollo ");
    } catch (Exception e) {
    // TODO Auto-generated catch block
    log.error(e.getMessage());
    log.info("Error de conexion a d desarrollo");
    }

            
        return connection;

        }

}
