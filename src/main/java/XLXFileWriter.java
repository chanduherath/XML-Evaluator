import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by Chandu Herath on 20/1/2019.
 */
public class XLXFileWriter {

    public static final String DILE_WRITE_PATH = "D:\\ExcelOutput";
    public static final String WIDE_SEARCH_CRITERIA = "WideSearchCriteria";
    public static final String OUTPUT_FILE_NAME = "output_results.xlsx";

    private static String[] columns = {"ID", "Description", "Image URL", "Price" , "Created By"};


    public void createXLXFile(List<Product> objectList)
    {
        Workbook workbook = new XSSFWorkbook();
        CreationHelper createHelper = workbook.getCreationHelper();
        Sheet sheet = workbook.createSheet(WIDE_SEARCH_CRITERIA);

        createHeader(workbook, sheet);

        writeContent(objectList, sheet);

        resizeColumns(sheet);

        writeToTheFile(workbook);

    }

    private void writeContent(List<Product> products, Sheet sheet) {
        // Create Other rows and cells with employees data
        int rowNum = 1;
        for(Product product: products) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0).setCellValue(product.getProductId());

            row.createCell(1).setCellValue(product.getDescription());

            row.createCell(2).setCellValue(product.getImageUrl());
//            Cell dateOfBirthCell = row.createCell(2);
//            dateOfBirthCell.setCellValue(employee.getDateOfBirth());
//            dateOfBirthCell.setCellStyle(dateCellStyle);

            row.createCell(3).setCellValue( String.valueOf(product.getPrice()) );

            row.createCell(4).setCellValue(product.getCreatedBy().getName());
        }
    }

    private void resizeColumns(Sheet sheet) {
        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }
    }

    private void writeToTheFile(Workbook workbook) {
        // Write the output to a file
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream(DILE_WRITE_PATH + "\\" + OUTPUT_FILE_NAME);
            workbook.write(fileOut);
            fileOut.close();

            // Closing the workbook
            workbook.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileOut.close();
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void createHeader(Workbook workbook, Sheet sheet) {

        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.BLACK.getIndex());


        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        Row headerRow = sheet.createRow(0);

        // Create cells
        for(int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }
    }


}
