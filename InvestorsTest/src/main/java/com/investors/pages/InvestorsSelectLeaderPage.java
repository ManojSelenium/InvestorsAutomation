package com.investors.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.investors.utility.BasePage;
import com.investors.utility.WebElements;

public class InvestorsSelectLeaderPage extends WebElements{

	private WebDriver driver;
	private WebDriverWait wait;
	private BasePage basepage;
	
	
	public InvestorsSelectLeaderPage(WebDriver driver,WebDriverWait wait, BasePage basepage){
		super(driver,wait);
		this.driver=driver;
		this.wait=wait;
		this.basepage=basepage;
	}
	
	
	public String getSelectLeaderTitle()
	{
		return getCurrentPageURL();
	}
	
}
