package com.w2a.Rough;
//TODO Auto-generated method stub
	

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.firefox.FirefoxDriver;
		import org.openqa.selenium.ie.InternetExplorerDriver;
		import org.testng.annotations.AfterSuite;
		import org.testng.annotations.BeforeSuite;
public class PropertiesSettingUp {
	public static WebDriver driver=null;
	
	public static 	Properties configProp=new Properties();
	public static 	Properties pageObjectsProp=new Properties();
	public static FileInputStream fis;

	static FileInputStream excelfile;
	static Workbook wkbook;
	public static void main(String[] args) throws IOException {
	
			int rowCount=5;
			int colCount=3;
			System.out.println("the row count is"+rowCount);
			System.out.println("the row count is"+colCount);
			Object[][] data=new Object[rowCount-1][colCount];
			for(int row=1;row<rowCount;row++)
			{
				for(int col=0;col<colCount;col++)
				{
					System.out.println(data[row-1][col]=readExcel("C:\\Users\\anuva\\eclipse\\DataDrivenFramework\\src\\test\\resources\\excel\\testData.xlsx", row, col));
					
				}
			}
					
				

			
			/*
			 * }
			 * 
			 * 
			 * System.out.println(readExcel(
			 * "C:\\Users\\anuva\\eclipse\\DataDrivenFramework\\src\\test\\resources\\excel\\testData.xlsx"
			 * ,3,2));
			 */
			
	
	}
			
			public static String readExcel(String file,int rowNum,int colNum) throws IOException
			{
				
			
					excelfile=new FileInputStream(file);
					wkbook=new XSSFWorkbook(excelfile);
					org.apache.poi.ss.usermodel.Sheet sheet=wkbook.getSheetAt(0);
					
				
			Cell cellValue=	sheet.getRow(rowNum).getCell(colNum);
			if(cellValue.getCellType()==CellType.STRING)
				  return cellValue.getStringCellValue();
			else if(cellValue.getCellType()==CellType.NUMERIC || cellValue.getCellType()==CellType.FORMULA ){
				  
				
				  String cellText = NumberToTextConverter.toText(cellValue.getNumericCellValue());
				  return cellText;

			         }

				   else if(cellValue.getCellType()==CellType.BLANK)
			      return ""; 
			  else 
				  return String.valueOf(cellValue.getBooleanCellValue());
			
			}
			
				}
			

				
					
		

	

