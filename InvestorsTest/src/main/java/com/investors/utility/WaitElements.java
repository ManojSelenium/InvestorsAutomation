package com.investors.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class WaitElements {

	public WebDriver driver;
	public WebDriverWait wait;

		
	WaitElements(WebDriver driver,WebDriverWait driverWait)
	{
		this.driver=driver;
		this.wait=driverWait;
	}
	
	/*Reusable Function Wait */
	public boolean waitForElementPresent(By prop) {

		if(wait.until(ExpectedConditions.visibilityOfElementLocated(prop)).isDisplayed())  {
			return true;
		}else
			return false;
	}
}
