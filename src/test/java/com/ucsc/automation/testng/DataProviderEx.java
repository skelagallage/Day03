package com.ucsc.automation.testng;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderEx {

    private static final String FILE_NAME = "peopleData.xlsx";

    @Test(dataProvider = "studentDetailsProvider")
    public void displayStudentDetails(String name, int age){
        System.out.printf("Student name is %s and age is %d. \n", name, age);
    }

    @DataProvider
    public Object[][] studentDetailsProvider() throws IOException {
        /**
         * You can provide hard coded data as below.
         */
//        Object[][] studentsDetailsArr = new Object[][]{{"Sanath", 35}, {"Rasara", 25}};
//        return studentsDetailsArr;

        List<Object[]> objectListArr = new ArrayList<>();
        InputStream inputStream = new FileInputStream(FILE_NAME);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
        XSSFSheet xssfSheet = xssfWorkbook.getSheet("Sheet1");

        Iterator<Row> rowIterator = xssfSheet.rowIterator();
        int rowIndex = 0;
        while (rowIterator.hasNext()){
            if(rowIndex == 0){
                rowIterator.next();
                rowIndex++;
                continue;
            }
            List<Object> rowObject = new ArrayList<>();
            Row row = rowIterator.next();
            for(int i = 0; i<row.getLastCellNum(); i++){
                Cell cell = row.getCell(i);
                switch (cell.getCellType()){
                    case STRING:
                        rowObject.add((String)cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        rowObject.add((int)cell.getNumericCellValue());
                        break;
                    default:
                        throw new RuntimeException("Wrong value type");
                }
            }
            objectListArr.add(rowObject.toArray());
            rowIndex++;
        }
        return objectListArr.toArray(new Object[0][]);
    }
}
