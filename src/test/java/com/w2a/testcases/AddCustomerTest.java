package com.w2a.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.Base;

public class AddCustomerTest extends Base {
	
@Test(dataProvider="loginData")
public void addCustomer(String fName,String lName,String postCode) throws InterruptedException
{
	System.out.println("in add customer testcase");
	
	Thread.sleep(1000);
	driver.findElement(By.cssSelector(pageObjectsProp.getProperty("addCustomerButton"))).click();
	driver.findElement(By.cssSelector(pageObjectsProp.getProperty("custFirstName"))).sendKeys(fName);
	driver.findElement(By.cssSelector(pageObjectsProp.getProperty("custLastName"))).sendKeys(fName);
	driver.findElement(By.cssSelector(pageObjectsProp.getProperty("custPostCode"))).sendKeys(fName);
	driver.findElement(By.cssSelector(pageObjectsProp.getProperty("addCustmerSubmitButton"))).click();
	
	
}



@DataProvider(name="loginData")
public Object[][] getData() throws IOException
{
	String sheetName="AddCustomerTest";
	int rowCount=excel.getRowCount(sheetName);
	int colCount=excel.getColumnCount(sheetName);
		/*
		 * System.out.println("the row count is"+rowCount);
		 * System.out.println("the row count is"+colCount); Object[][] data=new
		 * Object[rowCount-1][colCount]; for(int row=1;row<rowCount;row++) { for(int
		 * col=0;col<colCount;col++) { data[row-1][col]=excel.getCellData(sheetName,
		 * row, col); } }
		 */
	System.out.println("the row count is"+rowCount);
	System.out.println("the row count is"+colCount);
	Object[][] data=new Object[rowCount-1][colCount];
	for(int row=1;row<rowCount;row++)
	{
		for(int col=0;col<colCount;col++)
		{
			data[row-1][col]=excel.getCellData("sheetName", row, col);
		
		}
		
	}
	return data;
	
	
	
}
	
	}
