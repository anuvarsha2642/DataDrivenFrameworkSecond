package com.w2a.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public  String path;
	public  FileInputStream fis = null;
	public  FileOutputStream fileOut =null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row   =null;
	private XSSFCell cell = null;

public ExcelReader(String path) {
		
		this.path=path;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		
	}




public int getRowCount(String sheetName)
{
	int index=workbook.getSheetIndex(sheetName);
	if(index==-1)
		return 0;
	else
	{
	int rowCount=sheet.getLastRowNum();
	return rowCount;
	}
	
}

public int getColumnCount(String sheetName)
{
	int index=workbook.getSheetIndex(sheetName);
	if(index==-1)
		return 0;
	else
	{
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);
		if(row==null)
			return -1;
		else
		{
			int colCount=row.getLastCellNum();
			return colCount;
		}
	}
	

}

	public String getCellData(String sheetName,int rowNum,int colNum) throws IOException
	{
	
			if(rowNum <=0)
					return "" ;
			int index = workbook.getSheetIndex(sheetName);
			if(index==-1)
				return "";
			sheet = workbook.getSheetAt(index);
			
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
			
			
			
	

