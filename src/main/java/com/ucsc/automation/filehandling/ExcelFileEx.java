package com.ucsc.automation.filehandling;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class ExcelFileEx {

    private Map<Integer, Object[]> map = new HashMap<>();

    private static final String FILE_NAME = "peopleData.xlsx";

    {
        map.put(0, new Object[]{"Name", "Age"});
        map.put(1, new Object[]{"Sanath", 35});
        map.put(2, new Object[]{"Rasara", 25});
        map.put(3, new Object[]{"Siyathma", 24});
    }

    public void writePersonDataExcel() throws IOException {

        OutputStream outputStream = new FileOutputStream(FILE_NAME);

        try (XSSFWorkbook xssfWorkbook = new XSSFWorkbook()) {
            XSSFSheet xssfSheet = xssfWorkbook.createSheet("Sheet1");

            for (Map.Entry<Integer, Object[]> rowData : map.entrySet()) {

                XSSFRow row = xssfSheet.createRow(rowData.getKey());

                Object[] objArr = rowData.getValue();
                for (int i = 0; i < objArr.length; i++) {
                    XSSFCell xssfCell;
                    if (objArr[i] instanceof String) {
                        xssfCell = row.createCell(i, CellType.STRING);
                        xssfCell.setCellValue((String) objArr[i]);
                    } else if (objArr[i] instanceof Integer) {
                        xssfCell = row.createCell(i, CellType.NUMERIC);
                        xssfCell.setCellValue((int) objArr[i]);
                    }

                }
            }

            xssfWorkbook.write(outputStream);
        }
    }

    public void readPersonDataExcel() throws IOException {
        InputStream inputStream = new FileInputStream(FILE_NAME);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
        XSSFSheet xssfSheet = xssfWorkbook.getSheet("Sheet1");

        Iterator<Row> rowIterator = xssfSheet.rowIterator();
        while (rowIterator.hasNext()){
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
//        new ExcelFileEx().writePersonDataExcel();
        new ExcelFileEx().readPersonDataExcel();
    }

}
