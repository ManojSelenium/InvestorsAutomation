package com.investors.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.investors.utility.BasePage;
import com.investors.utility.WebElements;

public class InvestorsMyIBDPage extends WebElements{

	private WebDriver driver;
	private WebDriverWait wait;
	private BasePage basepage;
	
	public InvestorsMyIBDPage(WebDriver driver,WebDriverWait wait,BasePage basepage) {
		super(driver, wait);
		this.driver=driver;
		this.wait=wait;
		this.basepage=basepage;
	}
	
	public String getMyIBDpageurl(){
		return getCurrentPageURL();
	}
}
