package com.investors.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.investors.ObjProperty.InvestorsReseachProperty;
import com.investors.utility.BasePage;
import com.investors.utility.InvestorsConfig;
import com.investors.utility.WebElements;

//All the Actions related to Research Page should be available hear

public class InvestorsResearchPage extends WebElements {

	WebDriver driver;
	WebDriverWait wait;
	BasePage basepage;
	//Research Menu
	By researchlink=By.xpath(InvestorsReseachProperty.researchmenu.getProperty());
	//IBD-Stock-Check-Up
	By IBDStockCheckUpLink=By.linkText(InvestorsReseachProperty.ibdstockcheckup.getProperty());
	
	
	
	// Below method will wait for page load
	public InvestorsResearchPage(WebDriver driver,WebDriverWait wait,BasePage basepage) {
		super(driver,wait);
		this.driver=driver;
		this.wait=wait;
		this.basepage=basepage;
	}

	
	public InvestorsIBDStockCheckUpPage clickIBDStockCheckUplink(){
		click(IBDStockCheckUpLink);
		return basepage.ibdstockcheckuppage(driver, wait, basepage);
	}
	

}
