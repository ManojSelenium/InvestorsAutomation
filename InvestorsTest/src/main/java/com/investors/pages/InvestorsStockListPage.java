package com.investors.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.investors.utility.BasePage;
import com.investors.utility.InvestorsConfig;
import com.investors.utility.WebElements;

public class InvestorsStockListPage extends WebElements{

	
	WebDriver driver;
	WebDriverWait wait;
	BasePage basepage;
	
	By stockList=By.xpath(InvestorsConfig.prop.getProperty("StockList"));
	By selectorLeader=By.xpath(InvestorsConfig.prop.getProperty("SelectLeader"));
	
	public InvestorsStockListPage(WebDriver driver,WebDriverWait wait, BasePage basepage) {
	
		super(driver,wait);
		this.driver=driver;
		this.wait=wait;
		this.basepage=basepage;
	}
	
	
	
	
	public InvestorsSelectLeaderPage clickSelectLeaders() {
		click(selectorLeader);
		return basepage.selectleaderpage(driver, wait, basepage);
	}
	
	public String getStockListURL(){
		return getCurrentPageURL();
	}
}
