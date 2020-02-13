package com.Mytheresa;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
/**
 * <p>Base class initializing property file 
 * web driver ,launching driver in Before class method
 * date 12-jan-2020
 * version:1.0
 * Author sushmitha
 * </p>
 */
public class BaseClass 
{  //initia
	static Properties prop=new Properties();  
	public static WebDriver driver;
	private static String chromeDriverPath = System.getProperty("user.dir")+ "/driver/chromedriver.exe";

	@BeforeClass
	public void setupApplication()
	{
		Properties prop=new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream(System.getProperty("user.dir")+ "/config.properties");
			prop.load(ip);
			System.out.println(System.getProperty("user.dir"));
			System.out.println(prop.getProperty("url"));

			Reporter.log("=====Browser Session Started=====", true);
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);        
			driver  = new ChromeDriver();
			driver.manage().window().maximize();

			driver.get(prop.getProperty("url"));

			Reporter.log("=====Application Started=====", true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@AfterClass
	public void closeApplication()
	{
		driver.quit();
		Reporter.log("=====Browser Session End=====", true);

	}



}

