package com.investors.utility;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

/* All Reusable Function should reside in WebElements*/

/* Reusable Function for Element Wait */
public abstract class WebElements extends  WaitElements{
	private WebDriver driver;
	public WebDriverWait wait;

	public WebElements(WebDriver driver,WebDriverWait wait) {
		super(driver,wait);
		this.driver=driver;
		this.wait=wait;
	}
	/*Reusable Function URL */
	public void enterURL(String sURL) {
		driver.get(sURL);
	}
	/*Reusable Function*/
	public void enterText(By prop, String testData) {
		waitForElementPresent(prop);
		driver.findElement(prop).sendKeys(testData);
	}
	
	public void pause(int pause) 
	{
		try {
			Thread.sleep(pause);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/*Reusable Function*/
	/*public void click(By prop) {
		waitForElementPresent(prop);
		WebElement element=driver.findElement(prop);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("window.scrollTo(0,"+element.getLocation().y+")");
		executor.executeScript("arguments[0].click();", element);
	//	logger.info("Clicked using javascript----CHROME-----");
//		driver.findElement(prop).click();
	}*/
	
	public void elements(By prop,String sobject)
	{
		List<WebElement> ele=driver.findElements(prop);
		for (int i = 0; i < ele.size(); i++) {
			if(ele.get(i).getText().equals(prop)) {
				ele.get(i).click();
			}
		}
	}
	
	public void click(By prop) {
		waitForElementPresent(prop);
		if(driver.toString().contains("Internet"))
		  {
			   WebElement element = driver.findElement(prop);
			   JavascriptExecutor executor = (JavascriptExecutor)driver;
			   executor.executeScript("arguments[0].click();", element); 
			  }
		else
		{
		try{
		driver.findElement(prop).click();
		}
		catch(StaleElementReferenceException staleelement)
		{
			pause(5000);
			System.out.println("I am Into stale Element Block");
			driver.findElement(prop).click();
			System.out.println("Clicked on button after getting stale element exception");		
		}
		catch(WebDriverException e)
		{
			//e.printStackTrace();
			driver.findElement(prop).sendKeys(Keys.ENTER);
			System.out.println("Clicked in error block");
		}
		}
	}
	/*Reusable Function */
	public boolean verifyElement(By prop) {
		if(driver.findElement(prop).isDisplayed()) {
			return true;
		}else {
			return false;
		}

	}
	/*Reusable Function GetText */
	public String getText(By prop) {
		waitForElementPresent(prop);
		return driver.findElement(prop).getText();
	}
	/*Reusable Function Frame */
	public void selectXpathFrame(By prop){
		waitForElementPresent(prop);
		driver.switchTo().frame(driver.findElement(prop));

	}
	/*Reusable Function MouseOver */
	public void mouseOver(By prop) {
		waitForElementPresent(prop);
		Actions builder=new Actions(driver);

		WebElement element=driver.findElement(prop);

		builder.moveToElement(element).build().perform();

	}
	/*Reusable Function for Frame */
	public void selectFrame(String frameId) {
		//waitForElementPresent(prop);
		driver.switchTo().frame(frameId);
	}
	/*Reusable Function URL*/
	public void switchBackFromFrame() {
		driver.switchTo().defaultContent();
	}
	public String getCurrentPageURL(){
		return driver.getCurrentUrl();
	}
	
	/*Reusable Function Get Attribute */
	public String getAttributeValue(By prop,String attributeKey) {
		waitForElementPresent(prop);
		return driver.findElement(prop).getAttribute(attributeKey);
	}
	/* Reusable Function for Br Close*/
	public void closeBrowser() {
		driver.close();
	}
	
	public void clickEscape(){
		
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.EQUALS);
	}
	
	public boolean isDisplayedWithoutException(By locator)
	{
		boolean displayedvalue=false;
		try{
			displayedvalue=driver.findElement(locator).isDisplayed();
		}catch(Exception e)
		{
			displayedvalue=false;
		}
		return displayedvalue;

	}
}