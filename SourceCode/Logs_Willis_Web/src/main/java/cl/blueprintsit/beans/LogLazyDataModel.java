package cl.blueprintsit.beans;

import cl.blueprintsit.dao.LogsDAO;
import cl.blueprintsit.entity.Logs;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by BlueprintsIT on 6/21/2016.
 */
public class LogLazyDataModel extends LazyDataModel<Logs> {

    private LogsDAO logsDAO;

    public LogLazyDataModel(LogsDAO logsDAO) {
        this.logsDAO = logsDAO;
    }

    @Override
    public List<Logs> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {

        List<Logs> list = new ArrayList<Logs>();
        try {
            int rows = logsDAO.countFiltered(filters).intValue();
            this.setRowCount(rows);
            list = logsDAO.findFiltered(first, pageSize, sortField, SortOrder.ASCENDING.equals(sortOrder), filters);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Logs getRowData(String rowKey) {
        return logsDAO.getById(Long.parseLong(rowKey));
    }

    @Override
    public Object getRowKey(Logs object) {
        return object.getId();
    }
}
