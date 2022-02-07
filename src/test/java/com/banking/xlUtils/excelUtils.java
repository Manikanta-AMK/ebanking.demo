package com.banking.xlUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class excelUtils {

//	public static void main(String[] args) throws IOException {
//		
//		FileInputStream fis = new FileInputStream("C:\\Users\\Windows 10\\git\\ebanking.demo\\src\\test\\java\\com\\banking\\xlUtils\\inputdata.xlsx");
//		XSSFWorkbook wb = new XSSFWorkbook(fis);
//		XSSFSheet sheet = wb.getSheet("Sheet1");
//		String cellvalue = sheet.getRow(1).getCell(0).getStringCellValue();
//		System.out.println(cellvalue);
//	}
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String xlfile,String xlsheet) throws IOException 
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		int rowcount=ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;		
	}
	
	
	public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		int cellcount=row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}
	
	
	public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		try 
		{
			DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
		}
		catch (Exception e) 
		{
			data="";
		}
		wb.close();
		fi.close();
		return data;
	}
	
	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);		
		wb.close();
		fi.close();
		fo.close();
	}
	
//	
//	public static FileInputStream fis;   
//	public static Workbook wb1;
//	public static Sheet s;
//	public static Row r;
//	public static String c;
//	
//	public static String getCellData1(String excelpath, String sheet, int row, int cell) throws Throwable
//	{
//	    fis  = new FileInputStream(excelpath);
//		wb1 = WorkbookFactory.create(fis);
//	    s = wb.getSheet(sheet);
//		r = s.getRow(row);
//		c = r.getCell(cell).getStringCellValue();
//		return c;
//	}
//	
//	public static int rowCount(String excelpath, String sheet) throws Throwable
//	{
//		fis  = new FileInputStream(excelpath);
//		wb1 = WorkbookFactory.create(fis);
//		int rc = wb.getSheet(sheet).getLastRowNum();
//		return rc;
//	}
//	
//	@Test
//	public void ma() throws Throwable {
//		
//	    int rc = rowCount("C:\\Users\\Windows 10\\git\\ebanking.demo\\src\\test\\java\\com\\banking\\xlUtils\\inputdata.xlsx", "Sheet1");
//	    System.out.println(rc);
//	    for(int i=1;i<=rc;i++)
//	    {
//	    	String val = getCellData1("C:\\Users\\Windows 10\\git\\ebanking.demo\\src\\test\\java\\com\\banking\\xlUtils\\inputdata.xlsx", "Sheet1", i, i);
//	    	System.out.println(val);
//	    }
//	}
}
