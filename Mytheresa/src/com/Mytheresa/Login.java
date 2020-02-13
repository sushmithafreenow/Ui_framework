package com.Mytheresa;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import org.testng.annotations.Test;


/**
 * <p>Login operations performs search operations
 * date 12-jan-2020
 * version:1.0
 * Author sushmitha
 * </p>
 */
public class Login extends BaseClass

{
	Logger logger;

	private String searchElement="Gucci bags";
	private String searchTxt="//input[@id='search']";
	private String clickSearch="//span[@id='search_callout']";
	public String searcToolBar= "//div[@class='breadcrumbs']//li[@class='search']/span[contains(.,'{search}')]".replace("{search}", searchElement);
	private String allItems="//ul[contains(@class,'products-grid products')]/li[contains(@class,'item')]";

	@Test(priority = 1 ,description="This TC will perform valid login")
	public void loginToApplication() throws Throwable
	{
		try{logger=Logger.getLogger("MytheresaLogger");//added Logger

		driver.findElement(By.xpath(searchTxt)).sendKeys(searchElement);//perform search 
		logger.info("Entered serach text");
		driver.findElement(By.xpath(clickSearch)).click();//click on search item
		logger.info("clicked on search button");
		driver.findElement(By.xpath(searcToolBar)).isDisplayed(); //verify tool tip has searched item matching
		logger.info("search tool bar for serach item" + searchElement + " is present");
		List<WebElement> listOfElements = driver.findElements(By.xpath(allItems)); //collecting all elements in search criteria in list of webelements
		int num=listOfElements.size();
		logger.info("number of searched item "+ num);
		for (WebElement element : listOfElements) {
			element.isDisplayed();//verifying all matching webelements
		}
		logger.info("Verifies all "+ num +" elements");
		}
		catch(Exception e) {
			e.printStackTrace();
		}


	}
}





