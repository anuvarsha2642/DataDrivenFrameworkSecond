package com.w2a.testcases;

import java.util.Date;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.Base;

public class BankManagerLogin extends Base {
@Test
	public void loginAsManager()
	{
	Date d=new Date();
	System.setProperty("current.Date", d.toString().replace(":","_").replace(" ", "_"));
	PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\java\\log4j.properties");
		log.debug("Inside Login Test");
		driver.findElement(By.cssSelector(pageObjectsProp.getProperty("bankManagerLoginButton"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * WebElement
		 * addCustBtn=driver.findElement(By.cssSelector(pageObjectsProp.getProperty(
		 * "addCustomerButton")));
		 * //Assert.assertTrue(addCustBtn.isDisplayed(),"Login not successful");
		 * Assert.assertTrue(isElementPresent(addCustBtn),"Login not successful");
		 * log.debug("Login successfully executed");
		 */
	}

public Boolean isElementPresent(WebElement element)
{
	if(element.isDisplayed())
		return true;
	else
		return false;

	
}

}

