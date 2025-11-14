package cl.metlife.abm.business.managers.preingreso;

import cl.metlife.abm.domain.Detail;
import cl.metlife.abm.domain.FileType;
import cl.metlife.abm.domain.Lot;
import cl.metlife.ws.clients.preingreso.Corredor;
import cl.metlife.ws.clients.preingreso.bulk.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

public class PreingresoMapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(PreingresoMapper.class);

    public MovtoAltaBo makeMovtoAltoBo(Detail detail, Lot lot, String user, int bulkId){
        if(lot.getFileTypeId().equals(FileType.ALTA_TITULAR))
            return makeMovtoAltoBoAltaTitular(detail, user, bulkId);
        else
            return makeMovtoAltoBoAltaCarga(detail, user, bulkId);
    }

    public MovtoBajaBo makeMovtoBajaBo(Detail detail, Lot lot, String user, int bulkId){
        System.out.println("28 "+"Detail list");
        System.out.println("29 "+ detail.toString());
        System.out.println("30 "+lot.getFileTypeId());
        System.out.println("31 "+ lot.getFileTypeId().equals(FileType.BAJA_TITULAR));
        System.out.println("32 " + (Objects.equals(lot.getFileTypeId(), FileType.BAJA_TITULAR)));
        System.out.println("33 "+ lot.toString());

        if(lot.getFileTypeId().equals(FileType.BAJA_TITULAR)) {
            System.out.println("Baja titular");
            return makeMovtoAltoBoBajaTitular(detail, user, bulkId);
        }else{
            System.out.println("Baja Carga");
            return makeMovtoAltoBoBajaCarga(detail, user, bulkId);
        }
    }

    public MovtoTraspasoBo makeMovtoTraspasoBoTitular(Detail detail, Lot lot, String user, int bulkId, Corredor c){
        if(lot.getFileTypeId().equals(FileType.TRASPASO_TITULAR)){
            System.out.print("lote: "+ lot.getNumber());
            MovtoTraspasoBo m= makeMovtoTraspasoBoTitular(detail, user, bulkId,c, lot);
            System.out.println(m.toString());

            m.setLote(""+ lot.getNumber());

            System.out.println(m.toString());
            return m;

        }
        else
            return null;
    }
    public RequestBeneficiarioAddBo makeMovtoBeneficiarioBo(Detail detail, Lot lot, String user, int bulkId, Corredor c){

        System.out.println(lot.getFileTypeId());
        System.out.println(FileType.DESIGNACION_BENEFICIARIO);


        if(lot.getFileTypeId().equals(FileType.DESIGNACION_BENEFICIARIO)){
            System.out.print("lote: "+ lot.getNumber());
            RequestBeneficiarioAddBo m= makeMovtoAgregarBeneficiario(detail, user, bulkId,c, lot);
            System.out.println(m.toString());
            m.setLote(""+ lot.getNumber());
            System.out.println(m.toString());
            System.out.println("es designacion de beneficiario");
            LOGGER.info(m.toString());
            return m;
        }
        else{
            System.out.println("no es designacion de beneficiario");
            LOGGER.info("no es designacion de beneficiario");
            return null;
        }
    }





    public MovtoAltaBo makeMovtoAltoBoAltaTitular(Detail detail, String user, int bulkId) {
        System.out.println("makeMovtoAltaTitular");
        String formatPattern = "dd/MM/yyyy";

        DateFormat format = new SimpleDateFormat(formatPattern);

        MovtoAltaBo movtoAltaBo = null;
        try {
            movtoAltaBo = new MovtoAltaBo();
            movtoAltaBo.setBulkId(bulkId);
            movtoAltaBo.setPolizaNumero(Integer.valueOf(detail.getColumn1()));
            movtoAltaBo.setGrupoId(Integer.valueOf(detail.getColumn2()==null?"0":detail.getColumn2()));
            if(detail.getColumn3() != null){
                if(detail.getColumn3().contains("-"))
                    detail.setColumn3(detail.getColumn3().replace("-", "/"));
                GregorianCalendar a = new GregorianCalendar();
                a.setTime(format.parse(detail.getColumn3()));
                XMLGregorianCalendar fechaDesde = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(
                    a.get(Calendar.YEAR),
                    a.get(Calendar.MONTH) + 1,
                    a.get(Calendar.DAY_OF_MONTH),
                    DatatypeConstants.FIELD_UNDEFINED
                );
                movtoAltaBo.setFechaInicioVigencia(fechaDesde);
            }

            if(detail.getColumn4() != null){
                if(detail.getColumn4().contains("-"))
                    detail.setColumn4(detail.getColumn4().replace("-", "/"));

                GregorianCalendar b = new GregorianCalendar();
                b.setTime(format.parse(detail.getColumn4()));
                XMLGregorianCalendar fechaHasta = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(
                    b.get(Calendar.YEAR),
                    b.get(Calendar.MONTH) + 1,
                    b.get(Calendar.DAY_OF_MONTH),
                    DatatypeConstants.FIELD_UNDEFINED
                );
                movtoAltaBo.setFechaTerminoVigencia(fechaHasta);
            }

            // Titular.
            movtoAltaBo.setTitular(new ObjectFactory().createTitularBo());
            String rut = detail.getColumn5();
            System.out.println("[MAPPER] >>> PROCESANDO TITULAR <<<");
            System.out.println("[MAPPER] Column5 (RUT Titular String): '" + rut + "'");
            if(rut != null && !rut.isEmpty()){
                movtoAltaBo.getTitular().setRut(Integer.valueOf(rut));
                System.out.println("[MAPPER] Titular.Rut (convertido a Integer): " + Integer.valueOf(rut));
            }


            String dvTit = detail.getColumn6();
            System.out.println("[MAPPER] Column6 (DV Titular String original): '" + detail.getColumn6() + "'");
            System.out.println("[MAPPER] DV Titular (String): '" + dvTit + "'");
            movtoAltaBo.getTitular().setDv(dvTit);

            // Carga.
            movtoAltaBo.setCarga(new ObjectFactory().createCargaBo());

            String rutCarga = detail.getColumn7();
            System.out.println("[MAPPER] >>> PROCESANDO CARGA <<<");
            System.out.println("[MAPPER] Column7 (RUT Carga String): '" + rutCarga + "'");

            movtoAltaBo.getCarga().setRut(Integer.valueOf(rutCarga));
            System.out.println("[MAPPER] Carga.Rut (convertido a Integer): " + Integer.valueOf(rutCarga));

            String dvCar = detail.getColumn8();
            System.out.println("[MAPPER] Column8 (DV Carga String original): '" + detail.getColumn8() + "'");
            System.out.println("[MAPPER] DV Carga (String): '" + dvCar + "'");
            movtoAltaBo.getCarga().setDv(dvCar);
            movtoAltaBo.getCarga().setApellidoPaterno(detail.getColumn9());
            movtoAltaBo.getCarga().setApellidoMaterno(detail.getColumn10());
            movtoAltaBo.getCarga().setNombre(detail.getColumn11());

            GregorianCalendar a = new GregorianCalendar();

            if(detail.getColumn12().contains("-"))
                detail.setColumn12(detail.getColumn12().replace("-", "/"));

            a.setTime(format.parse(detail.getColumn12()));
            XMLGregorianCalendar fechaNacimiento = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(
                a.get(Calendar.YEAR),
                a.get(Calendar.MONTH) + 1,
                a.get(Calendar.DAY_OF_MONTH),
                DatatypeConstants.FIELD_UNDEFINED
            );

            movtoAltaBo.getCarga().setFechaNacimiento((detail.getColumn12() != null) ? fechaNacimiento : null);
            movtoAltaBo.getCarga().setRelacion(detail.getColumn13());
            movtoAltaBo.getCarga().setSexo(detail.getColumn14());

            // Titular denuevo.
            movtoAltaBo.getTitular().setRenta((detail.getColumn15() != null && !detail.getColumn15().equals("null")) ? Double.valueOf(detail.getColumn15().replaceAll(",", ".")) : null);
            movtoAltaBo.getTitular().setCapital((detail.getColumn16() != null && !detail.getColumn16().equals("null") ? Double.valueOf(detail.getColumn16().replaceAll(",", ".")) : null));
            movtoAltaBo.getTitular().setPeso((detail.getColumn17() != null && !detail.getColumn17().equals("null")) ? Double.valueOf(detail.getColumn17().replaceAll(",", ".")) : null);
            movtoAltaBo.getTitular().setEstatura((detail.getColumn18() != null && !detail.getColumn18().equals("null")) ? Double.valueOf(detail.getColumn18().replaceAll(",", ".")) : null);
            movtoAltaBo.getTitular().setPreExistencia(detail.getColumn19());
            // Titular > Data banco
            movtoAltaBo.getTitular().setCuentaDeposito(new ObjectFactory().createCuentaDepositoBo());
            movtoAltaBo.getTitular().getCuentaDeposito().setBancoId((detail.getColumn20() != null && !detail.getColumn20().equals("null")) ? Integer.valueOf(detail.getColumn20()) : null);
            movtoAltaBo.getTitular().getCuentaDeposito().setTipo(detail.getColumn21());
            movtoAltaBo.getTitular().getCuentaDeposito().setNumero(detail.getColumn22());
            // Titular denuevo 2.
            movtoAltaBo.getTitular().setEmail(detail.getColumn23());
            movtoAltaBo.getTitular().setCelular(detail.getColumn24());
            movtoAltaBo.setLote(detail.getColumn25());
            movtoAltaBo.setBarcode(detail.getColumn26());

            // Corredor
            movtoAltaBo.setCorredor(new ObjectFactory().createCorredorBo());
            movtoAltaBo.getCorredor().setRutDv(detail.getColumn27());
            movtoAltaBo.getCorredor().setNombre(detail.getColumn28());

            movtoAltaBo.setPortalUsuario(user);

            return movtoAltaBo;
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
    public MovtoAltaBo makeMovtoAltoBoAltaCarga(Detail detail, String user, int bulkId) {
        String formatPattern = "dd/MM/yyyy";
        DateFormat format = new SimpleDateFormat(formatPattern);
        System.out.println("makeMovtoAltoBoAltaCarga");
        System.out.println(detail.toString());

        // Detectar si el CSV tiene estructura de 28 columnas (ALTA_TITULAR) o 21 columnas (ALTA_CARGA)
        // Si Column25 tiene valor, entonces es estructura de 28 columnas
        boolean isExtendedFormat = (detail.getColumn25() != null && !detail.getColumn25().trim().isEmpty());
        System.out.println("[MAPPER_ALTA_CARGA] Formato detectado: " + (isExtendedFormat ? "28 columnas (ALTA_TITULAR)" : "21 columnas (ALTA_CARGA)"));

        // Debug adicional para fechas
        System.out.println("[MAPPER_ALTA_CARGA] >>> DEBUG FECHAS <<<");
        System.out.println("[MAPPER_ALTA_CARGA] Column3 (FechaInicioVigencia): '" + detail.getColumn3() + "' (is null: " + (detail.getColumn3() == null) + ", is empty: " + (detail.getColumn3() != null && detail.getColumn3().trim().isEmpty()) + ")");
        System.out.println("[MAPPER_ALTA_CARGA] Column12 (FechaNacimiento): '" + detail.getColumn12() + "' (is null: " + (detail.getColumn12() == null) + ", is empty: " + (detail.getColumn12() != null && detail.getColumn12().trim().isEmpty()) + ")");

        MovtoAltaBo movtoAltaBo = null;
        try {
            movtoAltaBo = new MovtoAltaBo();

            movtoAltaBo.setBulkId(bulkId);
            movtoAltaBo.setPolizaNumero(Integer.valueOf(detail.getColumn1()));
            movtoAltaBo.setGrupoId(Integer.valueOf(detail.getColumn2()==null?"0":detail.getColumn2()));

            if(detail.getColumn3() != null && !detail.getColumn3().trim().isEmpty()){
                if(detail.getColumn3().contains("-"))
                    detail.setColumn3(detail.getColumn3().replace("-", "/"));

                GregorianCalendar a = new GregorianCalendar();
                a.setTime(format.parse(detail.getColumn3()));
                XMLGregorianCalendar fechaDesde = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(
                    a.get(Calendar.YEAR),
                    a.get(Calendar.MONTH) + 1,
                    a.get(Calendar.DAY_OF_MONTH),
                    DatatypeConstants.FIELD_UNDEFINED
                );
                movtoAltaBo.setFechaInicioVigencia(fechaDesde);
                System.out.println("[MAPPER_ALTA_CARGA] FechaInicioVigencia seteada: " + fechaDesde);
            } else {
                System.out.println("[MAPPER_ALTA_CARGA] WARNING: Column3 (FechaDesde) es null o vacio!");
            }

            if(detail.getColumn4() != null && !detail.getColumn4().trim().isEmpty()){
                if(detail.getColumn4().contains("-"))
                    detail.setColumn4(detail.getColumn4().replace("-", "/"));

                GregorianCalendar b = new GregorianCalendar();
                b.setTime(format.parse(detail.getColumn4()));
                XMLGregorianCalendar fechaHasta = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(
                    b.get(Calendar.YEAR),
                    b.get(Calendar.MONTH) + 1,
                    b.get(Calendar.DAY_OF_MONTH),
                    DatatypeConstants.FIELD_UNDEFINED
                );
                movtoAltaBo.setFechaTerminoVigencia(fechaHasta);
            }

            // Titular.
            movtoAltaBo.setTitular(new ObjectFactory().createTitularBo());
            String rut = detail.getColumn5();

            movtoAltaBo.getTitular().setRut(Integer.valueOf(rut));
            String dvTit = detail.getColumn6();
            movtoAltaBo.getTitular().setDv(dvTit);

            // Carga.
            movtoAltaBo.setCarga(new ObjectFactory().createCargaBo());

            String rutCarga = detail.getColumn7();
            movtoAltaBo.getCarga().setRut(Integer.valueOf(rutCarga));
            String dvCar = detail.getColumn8();
            movtoAltaBo.getCarga().setDv(dvCar);
            movtoAltaBo.getCarga().setApellidoPaterno(detail.getColumn9());
            movtoAltaBo.getCarga().setApellidoMaterno(detail.getColumn10());
            movtoAltaBo.getCarga().setNombre(detail.getColumn11());

            if(detail.getColumn12() != null && !detail.getColumn12().trim().isEmpty()) {
                GregorianCalendar a = new GregorianCalendar();
                if(detail.getColumn12().contains("-"))
                    detail.setColumn12(detail.getColumn12().replace("-", "/"));
                a.setTime(format.parse(detail.getColumn12()));
                XMLGregorianCalendar fechaNacimiento = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(
                    a.get(Calendar.YEAR),
                    a.get(Calendar.MONTH) + 1,
                    a.get(Calendar.DAY_OF_MONTH),
                    DatatypeConstants.FIELD_UNDEFINED
                );
                movtoAltaBo.getCarga().setFechaNacimiento(fechaNacimiento);
                System.out.println("[MAPPER_ALTA_CARGA] FechaNacimiento seteada: " + fechaNacimiento);
            } else {
                System.out.println("[MAPPER_ALTA_CARGA] WARNING: Column12 (FechaNacimiento) es null o vacio!");
            }

            movtoAltaBo.getCarga().setRelacion(detail.getColumn13());
            movtoAltaBo.getCarga().setSexo(detail.getColumn14());

            // Mapeo de columnas según formato detectado
            if(isExtendedFormat) {
                // Formato de 28 columnas (estructura ALTA_TITULAR)
                // Column15-24 contienen los campos adicionales de ALTA_TITULAR
                // Los campos que necesitamos están en Column25-28
                movtoAltaBo.getTitular().setPeso((detail.getColumn17() != null && !detail.getColumn17().equals("null") && !detail.getColumn17().trim().isEmpty()) ? Double.valueOf(detail.getColumn17().replaceAll(",", ".")) : null);
                movtoAltaBo.getTitular().setEstatura((detail.getColumn18() != null && !detail.getColumn18().equals("null") && !detail.getColumn18().trim().isEmpty()) ? Double.valueOf(detail.getColumn18().replaceAll(",", ".")) : null);
                movtoAltaBo.getTitular().setPreExistencia(detail.getColumn19());
                movtoAltaBo.setLote(detail.getColumn25());
                movtoAltaBo.setBarcode(detail.getColumn26());

                // Corredor
                movtoAltaBo.setCorredor(new ObjectFactory().createCorredorBo());
                movtoAltaBo.getCorredor().setRutDv(detail.getColumn27());
                movtoAltaBo.getCorredor().setNombre(detail.getColumn28());

                System.out.println("[MAPPER_ALTA_CARGA] Usando mapeo de 28 columnas:");
                System.out.println("  - Peso: Column17 = " + detail.getColumn17());
                System.out.println("  - Estatura: Column18 = " + detail.getColumn18());
                System.out.println("  - PreExistencia: Column19 = " + detail.getColumn19());
                System.out.println("  - Lote: Column25 = " + detail.getColumn25());
                System.out.println("  - Barcode: Column26 = " + detail.getColumn26());
                System.out.println("  - RutCorredor: Column27 = " + detail.getColumn27());
                System.out.println("  - NombreCorredor: Column28 = " + detail.getColumn28());
            } else {
                // Formato de 21 columnas (estructura ALTA_CARGA estándar)
                movtoAltaBo.getTitular().setPeso((detail.getColumn15() != null && !detail.getColumn15().equals("null") && !detail.getColumn15().trim().isEmpty()) ? Double.valueOf(detail.getColumn15().replaceAll(",", ".")) : null);
                movtoAltaBo.getTitular().setEstatura((detail.getColumn16() != null && !detail.getColumn16().equals("null") && !detail.getColumn16().trim().isEmpty()) ? Double.valueOf(detail.getColumn16().replaceAll(",", ".")) : null);
                movtoAltaBo.getTitular().setPreExistencia(detail.getColumn17());
                movtoAltaBo.setLote(detail.getColumn18());
                movtoAltaBo.setBarcode(detail.getColumn19());

                // Corredor
                movtoAltaBo.setCorredor(new ObjectFactory().createCorredorBo());
                movtoAltaBo.getCorredor().setRutDv(detail.getColumn20());
                movtoAltaBo.getCorredor().setNombre(detail.getColumn21());

                System.out.println("[MAPPER_ALTA_CARGA] Usando mapeo de 21 columnas:");
                System.out.println("  - Lote: Column18 = " + detail.getColumn18());
                System.out.println("  - Barcode: Column19 = " + detail.getColumn19());
                System.out.println("  - RutCorredor: Column20 = " + detail.getColumn20());
                System.out.println("  - NombreCorredor: Column21 = " + detail.getColumn21());
            }

            movtoAltaBo.setPortalUsuario(user);

            return movtoAltaBo;
        } catch (DatatypeConfigurationException e) {
            System.out.println("[MAPPER_ALTA_CARGA] ERROR DatatypeConfigurationException: " + e.getMessage());
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.println("[MAPPER_ALTA_CARGA] ERROR ParseException: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("[MAPPER_ALTA_CARGA] ERROR Exception: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    public MovtoBajaBo makeMovtoAltoBoBajaTitular(Detail detail, String user, int bulkId) {
        String formatPattern = "dd/MM/yyyy";
        DateFormat format = new SimpleDateFormat(formatPattern);
        System.out.println("Alta o baja Titular");
        System.out.println(detail.toString());

        MovtoBajaBo movtoBajaBo = null;
        try {
            movtoBajaBo = new MovtoBajaBo();
            movtoBajaBo.setBulkId(bulkId);
            movtoBajaBo.setPolizaNumero(Integer.valueOf(detail.getColumn1()));
            movtoBajaBo.setGrupoId(Integer.valueOf(detail.getColumn2()==null?"0":detail.getColumn2()));

            // Titular.
            movtoBajaBo.setTitular(new ObjectFactory().createTitularBo());
            String rut = detail.getColumn3();
            System.out.println("[MAPPER_BAJA] >>> PROCESANDO BAJA TITULAR <<<");
            System.out.println("[MAPPER_BAJA] Column3 (RUT Titular String): '" + rut + "'");
            movtoBajaBo.getTitular().setRut(Integer.valueOf(rut));
            System.out.println("[MAPPER_BAJA] Titular.Rut (convertido a Integer): " + Integer.valueOf(rut));

            String dvTit = detail.getColumn4();
            System.out.println("[MAPPER_BAJA] Column4 (DV Titular String original): '" + detail.getColumn4() + "'");
            System.out.println("[MAPPER_BAJA] DV Titular (String): '" + dvTit + "'");
            movtoBajaBo.getTitular().setDv(dvTit);

            GregorianCalendar a = new GregorianCalendar();

            if(detail.getColumn5().contains("-"))
                detail.setColumn5(detail.getColumn5().replace("-", "/"));

            a.setTime(format.parse(detail.getColumn5()));
            XMLGregorianCalendar fechaBaja = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(
                a.get(Calendar.YEAR),
                a.get(Calendar.MONTH) + 1,
                a.get(Calendar.DAY_OF_MONTH),
                DatatypeConstants.FIELD_UNDEFINED
            );

            movtoBajaBo.setFechaBaja((detail.getColumn5() != null) ? fechaBaja : null);
            movtoBajaBo.setLote(detail.getColumn6());
            movtoBajaBo.setBarcode(detail.getColumn7());

            // Corredor
            movtoBajaBo.setCorredor(new ObjectFactory().createCorredorBo());
            movtoBajaBo.getCorredor().setRutDv(detail.getColumn8());
            movtoBajaBo.getCorredor().setNombre(detail.getColumn9());

            movtoBajaBo.setPortalUsuario(user);

            return movtoBajaBo;
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public MovtoBajaBo makeMovtoAltoBoBajaCarga(Detail detail, String user, int bulkId) {
        String formatPattern = "dd/MM/yyyy";
        DateFormat format = new SimpleDateFormat(formatPattern);
        System.out.println("MakeMovtoAltoBoBajaCarga");
        System.out.println(detail.toString());
        MovtoBajaBo movtoBajaBo = null;
        try {
            movtoBajaBo = new MovtoBajaBo();

            movtoBajaBo.setBulkId(bulkId);
            movtoBajaBo.setPolizaNumero(Integer.valueOf(detail.getColumn1()));
            movtoBajaBo.setGrupoId(Integer.valueOf(detail.getColumn2() == null ? "0" : detail.getColumn2()));

            // Titular.
            movtoBajaBo.setTitular(new ObjectFactory().createTitularBo());

            String rut = detail.getColumn3();
            movtoBajaBo.getTitular().setRut(Integer.valueOf(rut));
            String dvTit = detail.getColumn4();
            movtoBajaBo.getTitular().setDv(dvTit);
            String rutCarga = detail.getColumn5();
            String dvCarga = detail.getColumn6();
            movtoBajaBo.setCarga(new ObjectFactory().createCargaBo());
            if (rutCarga != null && !rutCarga.isEmpty()) {
                movtoBajaBo.getCarga().setRut(Integer.parseInt(rutCarga));
            }
            movtoBajaBo.getCarga().setDv(dvCarga);
            movtoBajaBo.getCarga().setNombre(detail.getColumn10());
            movtoBajaBo.getCarga().setApellidoPaterno(detail.getColumn8());
            movtoBajaBo.getCarga().setApellidoMaterno(detail.getColumn9());
            GregorianCalendar a = new GregorianCalendar();
            if(detail.getColumn7()!=null){
                if (detail.getColumn7().contains("-")){
                    detail.setColumn7(detail.getColumn7().replace("-", "/"));
                }
                if(detail.getColumn7().contains("/")) {
                    a.setTime(format.parse(detail.getColumn7()));
                }
            }
            else{
                a.setTime(new Date());
            }
            XMLGregorianCalendar fechaBaja = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(
                a.get(Calendar.YEAR),
                a.get(Calendar.MONTH) + 1,
                a.get(Calendar.DAY_OF_MONTH),
                DatatypeConstants.FIELD_UNDEFINED
            );
            movtoBajaBo.setFechaBaja((detail.getColumn7() != null) ? fechaBaja : null);
            movtoBajaBo.setBarcode(detail.getColumn12());

            // Corredor
            movtoBajaBo.setCorredor(new ObjectFactory().createCorredorBo());
            movtoBajaBo.getCorredor().setRutDv(detail.getColumn13());
            movtoBajaBo.getCorredor().setNombre(detail.getColumn14());

            movtoBajaBo.setPortalUsuario(user);

            return movtoBajaBo;
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public MovtoTraspasoBo makeMovtoTraspasoBoTitular(Detail detail, String user, int bulkId, Corredor c, Lot lote)
    {
        String formatPattern = "dd/MM/yyyy";
        DateFormat format = new SimpleDateFormat(formatPattern);

        MovtoTraspasoBo movtoTraspasoBo = null;
        try
        {
            movtoTraspasoBo = new MovtoTraspasoBo();
            movtoTraspasoBo.setBulkId(bulkId);

            movtoTraspasoBo.setPolizaNumero(Integer.valueOf(detail.getColumn1()));
            movtoTraspasoBo.setGrupoId(Integer.valueOf(detail.getColumn2()==null?"0":detail.getColumn2()));

            String rut=detail.getColumn3();

            movtoTraspasoBo.setRut(Integer.valueOf(rut));

            movtoTraspasoBo.setDv(detail.getColumn4());

            movtoTraspasoBo.setPolizaNumeroDestino(Integer.valueOf(detail.getColumn5()));
            movtoTraspasoBo.setGrupoIdDestino(Integer.valueOf(detail.getColumn6()==null?"0":detail.getColumn6()));

            GregorianCalendar a = new GregorianCalendar();

            if(detail.getColumn7().contains("-")) {
                detail.setColumn7(detail.getColumn7().replace("-", "/"));
            }
            if(detail.getColumn7().contains("/")){
                a.setTime(format.parse(detail.getColumn7()));
            }

            XMLGregorianCalendar fecha = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(
                a.get(Calendar.YEAR),
                a.get(Calendar.MONTH) + 1,
                a.get(Calendar.DAY_OF_MONTH),
                DatatypeConstants.FIELD_UNDEFINED
            );

            movtoTraspasoBo.setFechaInicioVigencia((detail.getColumn7() != null) ? fecha : null);
            movtoTraspasoBo.setHistoriaTopesLiquidaciones(Integer.valueOf(detail.getColumn8()));
            movtoTraspasoBo.setCodigoBarraFormulario(detail.getColumn10());
            movtoTraspasoBo.setLote(lote.getNumber());
            CorredorBo cc= new CorredorBo();
            cc.setNombre(c.getNombre());
            cc.setRutDv(c.getRut());
            movtoTraspasoBo.setCorredor(cc);

            return movtoTraspasoBo;
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public RequestBeneficiarioAddBo makeMovtoAgregarBeneficiario(Detail detail, String user, int bulkId, Corredor c, Lot lote){
        String formatPattern = "dd/MM/yyyy";
        DateFormat format = new SimpleDateFormat(formatPattern);
        RequestBeneficiarioAddBo mvtoAgregarBeneficiario=null;
        try {
            LOGGER.info("Detalle DesignaciÃ³n Beneficiario");
            System.out.println("Detalle DesignaciÃ³n Beneficiario");
            LOGGER.info(detail.toString());
            System.out.println(detail.toString());
            mvtoAgregarBeneficiario= new RequestBeneficiarioAddBo();
            mvtoAgregarBeneficiario.setBulkId(bulkId);
            System.out.println("BulkId: "+bulkId);
            LOGGER.info("BulkId: "+bulkId);
            mvtoAgregarBeneficiario.setPoliza(Long.valueOf(detail.getColumn1()));
            System.out.println("Poliza: "+detail.getColumn1());
            LOGGER.info("Poliza: "+detail.getColumn1());

            mvtoAgregarBeneficiario.setGrupo(Integer.valueOf(detail.getColumn2()));
            System.out.println("Grupo: "+detail.getColumn2());
            LOGGER.info("Grupo: "+detail.getColumn2());
            GregorianCalendar gCalendarFechaVigenciaDesde = new GregorianCalendar();

            if(detail.getColumn3().contains("-")) {
                detail.setColumn3(detail.getColumn3().replace("-", "/"));
            }

            if(detail.getColumn3().contains("/")){
                gCalendarFechaVigenciaDesde.setTime(format.parse(detail.getColumn3()));
            }

            LOGGER.info(gCalendarFechaVigenciaDesde.toString());
            XMLGregorianCalendar fechaVigenciaDesde = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(
                gCalendarFechaVigenciaDesde.get(Calendar.YEAR),
                gCalendarFechaVigenciaDesde.get(Calendar.MONTH) + 1,
                gCalendarFechaVigenciaDesde.get(Calendar.DAY_OF_MONTH),
                DatatypeConstants.FIELD_UNDEFINED
            );

            mvtoAgregarBeneficiario.setFechaVigenciaDesde((detail.getColumn3() != null) ? fechaVigenciaDesde : null);
            System.out.println("Fecha Vigencia Desde: "+fechaVigenciaDesde);
            LOGGER.info("Fecha Vigencia Desde: "+fechaVigenciaDesde);
            mvtoAgregarBeneficiario.setTitularRut(Long.valueOf(detail.getColumn5()));
            mvtoAgregarBeneficiario.setTitularDv(detail.getColumn6());
            mvtoAgregarBeneficiario.setBeneficiarioRut(Long.valueOf(detail.getColumn7()));
            mvtoAgregarBeneficiario.setBeneficiarioDv(detail.getColumn8());
            mvtoAgregarBeneficiario.setBeneficiarioPaterno(detail.getColumn9());
            mvtoAgregarBeneficiario.setBeneficiarioMaterno(detail.getColumn10());
            mvtoAgregarBeneficiario.setBeneficiarioNombres(detail.getColumn11());


            GregorianCalendar a = new GregorianCalendar();

            if(detail.getColumn12().contains("-")) {
                detail.setColumn12(detail.getColumn12().replace("-", "/"));
            }
            if(detail.getColumn12().contains("/")){
                a.setTime(format.parse(detail.getColumn12()));
            }
            XMLGregorianCalendar fecha = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(
                a.get(Calendar.YEAR),
                a.get(Calendar.MONTH) + 1,
                a.get(Calendar.DAY_OF_MONTH),
                DatatypeConstants.FIELD_UNDEFINED
            );

            mvtoAgregarBeneficiario.setBeneficiarioFchNacimiento((detail.getColumn12() != null) ? fecha : null);
            mvtoAgregarBeneficiario.setBeneficiarioRelacion(detail.getColumn13());
            mvtoAgregarBeneficiario.setBeneficiarioSexo(detail.getColumn14());
            mvtoAgregarBeneficiario.setRenta(Double.valueOf(detail.getColumn15()));
            mvtoAgregarBeneficiario.setBeneficiarioTipoPersona(detail.getColumn16());
            mvtoAgregarBeneficiario.setBeneficiarioTipoB(detail.getColumn17());
            mvtoAgregarBeneficiario.setPorcentaje(Double.valueOf(detail.getColumn18()));
            mvtoAgregarBeneficiario.setLote(detail.getColumn19());

            printMovtoAgregarBeneficiario(mvtoAgregarBeneficiario, bulkId);



            return mvtoAgregarBeneficiario;
        }catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void printMovtoAgregarBeneficiario(RequestBeneficiarioAddBo mvtoAgregarBeneficiario, int session) {

        String Request= "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:pre=\"http://preingreso.metlife.cl/\"> \n"+
                "<soapenv:Header/> \n"+
                "<soapenv:Body> \n"+
                "<pre:AgregarBeneficiario> \n" +
                "<!--Optional:--> \n"+
                "<pre:sesionId"+session+"</pre:sesionId> \n"+
                "<!--Optional:--> \n"+
                "<pre:request> \n"+
                "<pre:BulkId>"+mvtoAgregarBeneficiario.getBulkId()+"</pre:BulkId> \n"+
                "<pre:Poliza>"+mvtoAgregarBeneficiario.getPoliza()+"</pre:Poliza> \n"+
                "<pre:Grupo>"+mvtoAgregarBeneficiario.getGrupo()+"</pre:Grupo> \n"+
                "<pre:TitularRut>"+mvtoAgregarBeneficiario.getTitularRut()+"</pre:TitularRut> \n"+
                "<!--Optional:--> \n"+
                "<pre:TitularDv>"+mvtoAgregarBeneficiario.getTitularDv()+"</pre:TitularDv> \n"+
                "<pre:BeneficiarioRut>"+mvtoAgregarBeneficiario.getBeneficiarioRut()+"</pre:BeneficiarioRut> \n"+
                "<!--Optional:--> \n"+
                "<pre:BeneficiarioDv>"+mvtoAgregarBeneficiario.getBeneficiarioDv()+"</pre:BeneficiarioDv> \n"+
                "<!--Optional:--> \n"+
                "<pre:BeneficiarioNombres>"+mvtoAgregarBeneficiario.getBeneficiarioNombres()+"</pre:BeneficiarioNombres> \n"+
                "<!--Optional:--> \n"+
                "<pre:BeneficiarioPaterno>"+mvtoAgregarBeneficiario.getBeneficiarioPaterno()+"</pre:BeneficiarioPaterno> \n"+
                "<!--Optional:--> \n"+
                "<pre:BeneficiarioMaterno>"+mvtoAgregarBeneficiario.getBeneficiarioMaterno()+"</pre:BeneficiarioMaterno> \n"+
                "<!--Optional:--> \n"+
                "<pre:BeneficiarioRelacion>"+mvtoAgregarBeneficiario.getBeneficiarioRelacion()+"</pre:BeneficiarioRelacion> \n"+
                "<pre:BeneficiarioFchNacimiento>"+mvtoAgregarBeneficiario.getBeneficiarioFchNacimiento()+"</pre:BeneficiarioFchNacimiento> \n"+
                "<!--Optional:--> \n"+
                "<pre:BeneficiarioSexo>"+mvtoAgregarBeneficiario.getBeneficiarioSexo()+"</pre:BeneficiarioSexo> \n"+
                "<pre:Porcentaje>"+mvtoAgregarBeneficiario.getPorcentaje()+"</pre:Porcentaje> \n"+
                "<!--Optional:--> \n"+
                "<pre:BeneficiarioTipoPersona>"+mvtoAgregarBeneficiario.getBeneficiarioTipoPersona()+"</pre:BeneficiarioTipoPersona> \n"+
                "<!--Optional:--> \n"+
                "<pre:BeneficiarioTipoB>"+mvtoAgregarBeneficiario.getBeneficiarioTipoB()+"</pre:BeneficiarioTipoB> \n"+
                "<!--Optional:--> \n"+
                "<pre:Lote>"+mvtoAgregarBeneficiario.getLote()+"</pre:Lote> \n"+
                "<!--Optional:--> \n"+
                "<pre:FechaVigenciaDesde>"+mvtoAgregarBeneficiario.getFechaVigenciaDesde()+"</pre:FechaVigenciaDesde> \n"+
                "</pre:request> \n"+
                "</pre:AgregarBeneficiario> \n"+
                "</soapenv:Body> \n"+
                "</soapenv:Envelope>";

        LOGGER.info("Request: "+Request);
        System.out.println("Request: "+Request);


    }


}