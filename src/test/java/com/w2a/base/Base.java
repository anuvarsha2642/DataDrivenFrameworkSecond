package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.w2a.utilities.ExcelReader;

public class Base {
	
	//Webdriver,properties,logs,ExtentReports,DB,Excel,MAil
	public static WebDriver driver=null;
	
	public static 	Properties configProp=new Properties();
	public static 	Properties pageObjectsProp=new Properties();
	public static FileInputStream fis;
	public static Logger log=Logger.getLogger("devpinoyLogger");
	
	public static ExcelReader excel=new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\testData.xlsx");
	
@BeforeSuite	
public void setUp() throws FileNotFoundException
{
	
	if(driver==null)
	{
		//Initialising the Properties file 1.PageObjects 2.Config
		try {
				fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Configurations.properties");
				configProp.load(fis);
				log.debug("Configuration file loaded");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		 fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\PageObjects.properties");
		 pageObjectsProp.load(fis);
			log.debug("Page object Properties file loaded");

	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	String browserName=configProp.getProperty("browser");
	
	if(browserName.equalsIgnoreCase("Chrome"))
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\anuva\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	else if(browserName.equalsIgnoreCase("IE"))
	{
		System.setProperty("webdriver.ie.driver",configProp.getProperty(System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\IEDriverServer.exe"));
		 driver = new InternetExplorerDriver();
	}
	else if(browserName.equalsIgnoreCase("firefox"))
	{
			System.setProperty("webdriver.gecko.driver",configProp.getProperty(System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\geckodriver.exe"));
		 driver = new FirefoxDriver();
	}
	driver.get(configProp.getProperty("testSiteURl"));
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(Integer.parseInt(configProp.getProperty("implicit.wait")), TimeUnit.MILLISECONDS);
	
	
	
	
}
	/*
	 * @AfterSuite public void tearDOwn() { if(driver!=null) driver.quit();
	 * log.info("Testing done!!!"); }
	 */
}
