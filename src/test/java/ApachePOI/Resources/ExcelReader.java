package ApachePOI.Resources;

import Utils.BaseDriver;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;


public class ExcelReader {

    public static List<String> loginCredentials(String sheetName, int rowNumber) {

        List<String> list = new ArrayList<>();
        String path = "src/test/java/ApachePOI/Resources/ExcelLoginData.xlsx";

        FileInputStream inputStream;

        Workbook workbook;
        try {
            inputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNumber);
        int cellCount = row.getPhysicalNumberOfCells();

        for (int j = 0; j < cellCount; j++) {
            Cell cell = row.getCell(j);
            list.add(cell.getStringCellValue());

        }
        return list;
    }

}
