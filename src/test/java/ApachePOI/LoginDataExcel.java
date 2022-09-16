package ApachePOI;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.FileOutputStream;
import java.io.IOException;

public class LoginDataExcel {

    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook(); //created new workbook in memory
        XSSFSheet sheet = workbook.createSheet("Login"); // created new sheet in workbook

        Object emptyData[][] = { {"username","password"},
                                 {"richfield.edu","Richfield2020!"},
                                 {"richfield","Richfield2020!"},
                                 {"richfield.edu","Richfield20"},
                                 {"richfield","Richfield20"}
                               };


        int rows = emptyData.length;
        int cells = emptyData[0].length;

        System.out.println(rows); //4
        System.out.println(cells); //3

        for (int i = 0; i < rows; i++) { // i represent to row

           XSSFRow row = sheet.createRow(i); // 0 row created

            for (int j = 0; j < cells; j++) { // j represent to cell

                XSSFCell cell = row.createCell(j); //0 cell  created
                Object value = emptyData[i][j];

               if (value instanceof String) // if the value is instanceof String, Integer, Boolean
                   cell.setCellValue((String) value);
                if (value instanceof Integer)
                    cell.setCellValue((Integer) value);
                if (value instanceof Boolean)
                    cell.setCellValue((Boolean) value);
            }
        }

        /** for each loop */
//        int rowCount = 0;
//
//        for (Object emp[] : emptyData){ // store emptyData single dimensional data
//          XSSFRow row = sheet.createRow(rowCount++);
//
//          int columnCount =0;
//            for (Object value : emp){
//             XSSFCell cell = row.createCell(columnCount++);
//
//                if (value instanceof String) // if the value is instanceof String, Integer, Boolean
//                    cell.setCellValue((String) value);
//                if (value instanceof Integer)
//                    cell.setCellValue((Integer) value);
//                if (value instanceof Boolean)
//                    cell.setCellValue((Boolean) value);
//            }
//        }

        String newExcelPath = "src/test/java/ApachePOI/Resources/ExcelLoginData.xlsx";
        FileOutputStream outputStream = new FileOutputStream(newExcelPath);
        workbook.write(outputStream); //workbook attached to the file
        //workbook.close(); // memory cleared
        outputStream.close();
        System.out.println("Process completed!");


    }
}
