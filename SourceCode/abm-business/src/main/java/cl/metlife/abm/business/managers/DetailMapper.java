package cl.metlife.abm.business.managers;

import cl.metlife.abm.domain.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DetailMapper {

    public Detail map(AltaTitular altaTitular, Lot persistedLot, boolean considerBarcodes, int index) {
        Detail detail = new Detail();

        detail.setColumn1(String.valueOf(altaTitular.getId()));
        detail.setColumn2(altaTitular.getNumGru());
        detail.setColumn3(altaTitular.getFechaDesde());
        detail.setColumn4(altaTitular.getFechaHasta());
        detail.setColumn5(altaTitular.getRutTit());
        detail.setColumn6(altaTitular.getDvTit());
        detail.setColumn7((altaTitular.getRutCar()));
        detail.setColumn8((altaTitular.getDvCar()));
        detail.setColumn9((altaTitular.getPat()));
        detail.setColumn10((altaTitular.getMat()));
        detail.setColumn11((altaTitular.getNom()));
        detail.setColumn12(altaTitular.getFechaNacimiento());
        detail.setColumn13((altaTitular.getRel()));
        detail.setColumn14((altaTitular.getSex()));
        detail.setColumn15((altaTitular.getRenta()));
        detail.setColumn16((altaTitular.getCapital()));
        detail.setColumn17((altaTitular.getPeso()));
        detail.setColumn18((altaTitular.getEstatura()));
        detail.setColumn19((altaTitular.getPreExistencia()));
        detail.setColumn20((altaTitular.getBanco()));
        detail.setColumn21((altaTitular.getTipoCuenta()));
        detail.setColumn22((altaTitular.getNumeroCuenta()));
        detail.setColumn23((altaTitular.getEmail()));
        detail.setColumn24((altaTitular.getCelular()));
        detail.setColumn25(String.valueOf(altaTitular.getLote()));
        detail.setColumn26((altaTitular.getCodigoBarra()));
        detail.setColumn27((altaTitular.getRutCorredor()));
        detail.setColumn28((altaTitular.getNombreCorredor()));
        detail.setIndex(index);

        detail.setStatusId(((considerBarcodes) ? DetailsStatus.CREATED: DetailsStatus.FINALIZED));

        detail.setLotId(persistedLot.getId());

        return detail;
    }

    public Detail map(AltaCarga altaCarga, Lot persistedLot, boolean considerBarcodes, int index) {
        Detail detail = new Detail();

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        detail.setColumn1(String.valueOf(altaCarga.getId()));
        detail.setColumn2((altaCarga.getNumGru()));
        detail.setColumn3(altaCarga.getFechaDesde());
        detail.setColumn4(altaCarga.getFechaHasta());
        detail.setColumn5((altaCarga.getRutTit()));
        detail.setColumn6((altaCarga.getDvTit()));
        detail.setColumn7((altaCarga.getRutCar()));
        detail.setColumn8((altaCarga.getDvCar()));
        detail.setColumn9((altaCarga.getPat()));
        detail.setColumn10((altaCarga.getMat()));
        detail.setColumn11((altaCarga.getNom()));
        detail.setColumn12(altaCarga.getFechaNacimiento());
        detail.setColumn13((altaCarga.getRel()));
        detail.setColumn14((altaCarga.getSex()));
        detail.setColumn15((altaCarga.getPeso()));
        detail.setColumn16((altaCarga.getEstatura()));
        detail.setColumn17((altaCarga.getPreExistencia()));
        detail.setColumn18(String.valueOf(altaCarga.getLote()));
        detail.setColumn19((altaCarga.getCodigoBarra()));
        detail.setColumn20((altaCarga.getRutCorredor()));
        detail.setColumn21((altaCarga.getNombreCorredor()));
        detail.setIndex(index);

        detail.setRutaPdf((altaCarga.getCodigoBarra()));
        detail.setStatusId(((considerBarcodes) ? DetailsStatus.CREATED: DetailsStatus.FINALIZED));

        detail.setLotId(persistedLot.getId());

        return detail;
    }

    public Detail map(ExclusionTitular exclusionTitular, Lot persistedLot, boolean considerBarcodes, int index) {
        Detail detail = new Detail();

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        detail.setColumn1(String.valueOf(exclusionTitular.getId()));
        detail.setColumn2((exclusionTitular.getNumGru()));
        detail.setColumn3((exclusionTitular.getRutTit()));
        detail.setColumn4((exclusionTitular.getDvTit()));
        detail.setColumn5(exclusionTitular.getFechaHasta());
        detail.setColumn6(String.valueOf(exclusionTitular.getLote()));
        detail.setColumn7((exclusionTitular.getCodigoBarra()));
        detail.setColumn8((exclusionTitular.getRutCorredor()));
        detail.setColumn9((exclusionTitular.getNombreCorredor()));
        detail.setIndex(index);

        detail.setRutaPdf((exclusionTitular.getCodigoBarra()));
        detail.setStatusId(((considerBarcodes) ? DetailsStatus.CREATED: DetailsStatus.FINALIZED));

        detail.setLotId(persistedLot.getId());

        return detail;
    }

    public Detail map(ExclusionCarga exclusionCarga, Lot persistedLot, boolean considerBarcodes, int index) {
        Detail detail = new Detail();

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        detail.setColumn1(String.valueOf(exclusionCarga.getId()));
        detail.setColumn2((exclusionCarga.getNumGru()));
        detail.setColumn3((exclusionCarga.getRutTit()));
        detail.setColumn4((exclusionCarga.getDvTit()));
        detail.setColumn5((exclusionCarga.getRutCarga()));
        detail.setColumn6((exclusionCarga.getDvCarga()));
        detail.setColumn7(exclusionCarga.getFechaHasta());
        detail.setColumn8(exclusionCarga.getPaterno());
        detail.setColumn9((exclusionCarga.getMaterno()));
        detail.setColumn10((exclusionCarga.getNombre()));
        detail.setColumn11(String.valueOf(exclusionCarga.getLote()));
        detail.setColumn12((exclusionCarga.getCodigoBarra()));
        detail.setColumn13((exclusionCarga.getRutCorredor()));
        detail.setColumn14((exclusionCarga.getNombreCorredor()));
        detail.setIndex(index);

        detail.setRutaPdf((exclusionCarga.getCodigoBarra()));
        detail.setStatusId(((considerBarcodes) ? DetailsStatus.CREATED: DetailsStatus.FINALIZED));

        detail.setLotId(persistedLot.getId());

        System.out.println("persisted Lot");
        System.out.println(persistedLot.toString());

        System.out.println("Detail manager");
        System.out.println(detail.toString());

        return detail;
    }
    public Detail map(DesignacionBeneficiario db, Lot persistedLot, boolean considerBarcodes, int index) {
        Detail de = new Detail();

        de.setColumn1(String.valueOf(db.getId()));
        de.setColumn2(String.valueOf(db.getNumgrupo()));
        de.setColumn3(db.getVigDesde());
        de.setColumn4(db.getVigHasta());

        de.setColumn5(String.valueOf(db.getRutTitular()));
        de.setColumn6(db.getDvTitular());
        de.setColumn7(String.valueOf(db.getRutCarga()));
        de.setColumn8(db.getDvCarga());

        de.setColumn9(db.getApPat());
        de.setColumn10(db.getApMat());
        de.setColumn11(db.getNombre());
        de.setColumn12(db.getFechaAC());
        de.setColumn13(db.getRelacion());
        de.setColumn14(db.getSexo());
        de.setColumn15(String.valueOf(db.getRenta()));
        de.setColumn16(db.getTipoPersona());
        de.setColumn17(db.getTipoB() );
        de.setColumn18(String.valueOf(db.getPorcentaje()));
        de.setColumn19(String.valueOf(db.getLotID()));
        de.setIndex(index);
        if(considerBarcodes){
            de.setRutaPdf((db.getCodigoBarra()));

        }

        de.setStatusId(((considerBarcodes) ? DetailsStatus.CREATED: DetailsStatus.FINALIZED));

        de.setLotId(persistedLot.getId());

        return de;
    }

    public Detail map(TraspasoTitular traspasoTitular, Lot persistedLot, boolean considerBarcodes, int index) {
        Detail detail = new Detail();

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        detail.setColumn1(String.valueOf(traspasoTitular.getId()));
        detail.setColumn2((traspasoTitular.getNumGru()));
        detail.setColumn3((traspasoTitular.getRutTit()));
        detail.setColumn4((traspasoTitular.getDvTit()));

        detail.setColumn5((traspasoTitular.getPolizaDest()));
        detail.setColumn6((traspasoTitular.getNumGruDest()));
        detail.setColumn7((traspasoTitular.getFechaDesde()));
        detail.setColumn8((traspasoTitular.getHistorialTopeLiquidaciones()));

        detail.setColumn9(String.valueOf(traspasoTitular.getLote()));
        detail.setColumn10((traspasoTitular.getCodigoBarra()));
        detail.setColumn11((traspasoTitular.getRutCorredor()));
        detail.setColumn12((traspasoTitular.getNombreCorredor()));
        detail.setIndex(index);

        detail.setRutaPdf((traspasoTitular.getCodigoBarra()));
        detail.setStatusId(((considerBarcodes) ? DetailsStatus.CREATED: DetailsStatus.FINALIZED));

        detail.setLotId(persistedLot.getId());

        return detail;
    }
}
