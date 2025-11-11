package cl.blueprintsit.dao;

import javax.persistence.Query;
import java.security.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;

/**
 * Created by BlueprintsIT on 6/21/2016.
 */
public class UtilsLike {

    public static void setFilterParams(Map<String, Object> filters, Query query) throws ParseException {

        if ( filters != null ) {
            for ( String field : filters.keySet() ) {
                setParameter(query, field, filters.get(field));
            }
        }
    }

    public static void setParameter(Query query, String field, Object value) throws ParseException {

        if(field.equals("lote")){
            query.setParameter(field,  "%" + Integer.valueOf(value.toString()) + "%" );
            return;
        }

        if(field.equals("tipo")){
            query.setParameter(field,   "%" + value.toString()+ "%" );
            return;
        }

        if(field.equals("proceso")){
            query.setParameter(field, "%" + value+ "%" );
            return;
        }

        if(field.equals("rutCorredor")){
            query.setParameter(field,"%" +  value+ "%" );
            return;
        }

        if(field.equals("fecha")){
            String[] arr = value.toString().split("-");
            if(arr.length == 1){
                DateFormat format = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
                Date fe = format.parse(arr[0]);
                Calendar calendar =  new GregorianCalendar();
                calendar.setTimeInMillis(fe.getTime());
                query.setParameter("fechaInicial", calendar.getTime());
            } else if(arr.length == 2) {
                DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                query.setParameter("fechaInicial", format.parse(arr[0]));
                query.setParameter("fechaFinal", format.parse(arr[1]));
            }
            return;
        }

    }



    public static Object formattedValue(String fieldName, Object fieldValue) {
        if (fieldValue == null || "".equals(fieldValue))
            return null;

        if ( isLikeField(fieldName) )
            return fieldValue + "%";

        if ( fieldName.toLowerCase().endsWith("id") )
            return Long.parseLong(String.valueOf(fieldValue));

        return fieldValue;
    }

    public static Boolean isDateField(String field) {
        if(field.equals("fechaInicio") || field.equals("fechaFin")){
            return true;
        }
        return field.toLowerCase().indexOf("date") >= 0;
    }

    public static Boolean isLikeField(String field) {
        return field.contains(".id");
    }

    public static String buildWhereClauses(Map<String, Object> filters) {

        StringBuilder whereClauses = new StringBuilder();

        if (filters != null) {
            for (String field : filters.keySet()){
                appendFieldClause(whereClauses, field,filters);
            }
        }

        //System.out.println(whereClauses.toString());
        return whereClauses.toString();
    }

    public static void appendFieldClause(StringBuilder whereClauses, String field,Map<String, Object> filters) {

        if(field.equals("lote")){
            whereClauses.append(whereClauses.length() <= 0 ? " where l." : " and l.");
            whereClauses.append("lote");
            whereClauses.append(" like :");
            whereClauses.append(field);
            return;
        }

        if(field.equals("tipo")){
            whereClauses.append(whereClauses.length() <= 0 ? " where l." : " and l.");
            whereClauses.append("tipo");
            whereClauses.append(" like :");
            whereClauses.append(field);
            return;
        }

        if(field.equals("proceso")){
            whereClauses.append(whereClauses.length() <= 0 ? " where l." : " and l.");
            whereClauses.append("proceso");
            whereClauses.append(" like :");
            whereClauses.append(field);
            return;
        }
        if(field.equals("rutCorredor")){
            whereClauses.append(whereClauses.length() <= 0 ? " where l." : " and l.");
            whereClauses.append("rutCorredor");
            whereClauses.append(" like :");
            whereClauses.append(field);
            return;
        }


        if(field.equals("fecha")){
            String test = filters.get("fecha").toString();
            String[] array = test.split("-");
            if(array.length == 1){
                whereClauses.append(whereClauses.length() <= 0 ? " where l." : " and l.");
                whereClauses.append("fecha >= :fechaInicial");
            }

            if(array.length == 2){
                whereClauses.append(whereClauses.length() <= 0 ? " where l." : " and l.");
                whereClauses.append("fecha BETWEEN :fechaInicial AND :fechaFinal");
            }
        }

    }

    public static String dateFieldFrom(String field) {
        return formattedField(field) + "_from";
    }

    public static String dateFieldTo(String field) {
        return formattedField(field) + "_to";
    }

    public static String formattedField(String field) {
        return field.replaceAll("\\.", "_");
    }

}
