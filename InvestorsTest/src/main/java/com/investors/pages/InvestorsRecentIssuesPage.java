package com.investors.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.investors.ObjProperty.InvestorsRecentIssuesProperty;

import com.investors.utility.BasePage;
import com.investors.utility.WebElements;

public class InvestorsRecentIssuesPage extends WebElements{

	

	WebDriver driver;
	WebDriverWait wait;
	BasePage basepage;
	
	By firstPDFlocator=By.xpath(InvestorsRecentIssuesProperty.firstPDFlocator.getProperty());
	public InvestorsRecentIssuesPage(WebDriver driver,WebDriverWait wait,	BasePage basepage){
		super(driver, wait);
		this.driver=driver;
		this.wait=wait;
		this.basepage=basepage;
	}
	
	public void clickFirstPDFLink(){
	click(firstPDFlocator);	
	}
	
	public String getRecentIssuestitle(){
		return getCurrentPageURL();
	}
}
