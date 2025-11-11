package cl.metlife.abm.business.managers;

import cl.metlife.abm.business.managers.ABMConfigurationManager;
import cl.metlife.abm.domain.Lot;
import org.apache.commons.io.FilenameUtils;
import cl.metlife.abm.domain.ABMConfiguration;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by BluePrints Developer on 22-01-2019.
 */
@Stateless
public class FileManager {
    @EJB
    private ABMConfigurationManager configurationManager;

    public String colourErrorCell(String brokerRut, String currentExcelFile, String fileTypeFolder, int row, String cell ) throws InvalidFormatException, IOException{

        String valor ="";
        try {
            String localFolderRoot = configurationManager.getByKey(ABMConfiguration.LOCAL_FOLDER_ROOT).getValor();

            String environmentFolder = configurationManager.getByKey(ABMConfiguration.EXECUTION_ENVIRONMENT_FOLDER).getValor();

            File file = new File(localFolderRoot + brokerRut + "\\" + environmentFolder + "\\" + fileTypeFolder + "\\" + currentExcelFile);

            String fileName = file.getAbsolutePath();
            String pathExcel = FilenameUtils.removeExtension(fileName);
            pathExcel += ".xls";

            FileInputStream inputFile = new FileInputStream(pathExcel);

            HSSFWorkbook workBook = new HSSFWorkbook(inputFile);
            HSSFSheet sheet = workBook.getSheetAt(0);

            HSSFCellStyle style = workBook.createCellStyle();
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.RED.getIndex());
            style.setFillBackgroundColor(HSSFColor.HSSFColorPredefined.RED.getIndex());

            HSSFRow encabezado = sheet.getRow(0);
            Iterator cellIterator = encabezado.cellIterator();
            int cellNumber = -1;

            while (cellIterator.hasNext()) {
                HSSFCell c = (HSSFCell) (cellIterator.next());
                if (c.getStringCellValue().trim().equalsIgnoreCase(cell)) {
                    cellNumber = c.getColumnIndex();
                }
            }

            HSSFRow excelRow = sheet.getRow(row);
            HSSFCell excelCell = null;
            if (cellNumber == -1) {
                excelCell = excelRow.createCell(excelRow.getLastCellNum() + 1);
                excelCell.setCellValue(cell);
            } else
                excelCell = excelRow.getCell(cellNumber);

            excelCell.setCellStyle(style);
            try {
                valor = excelCell.getStringCellValue();
            }catch (RuntimeException e){
                valor = ""+ excelCell.getNumericCellValue();
            }

            inputFile.close();
            FileOutputStream output_file = new FileOutputStream(pathExcel);
            workBook.write(output_file);
            output_file.close();
        }catch(Exception e){
            System.out.println("Error al identificar la celda del archivo excel [col:" + cell + "], [row:" + row + "]");
            e.printStackTrace();
        }
        return valor;
    }

}
