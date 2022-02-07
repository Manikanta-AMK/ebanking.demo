package com.banking.xlUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class fllelib {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Windows 10\\git\\ebanking.demo\\"
				+ "src\\test\\java\\com\\banking\\xlUtils\\inputdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis); 
		Sheet sheet = wb.getSheet("Sheet1");
		String cellvalue = sheet.getRow(1).getCell(0).getStringCellValue();
		System.out.println(cellvalue); 
	}
}
