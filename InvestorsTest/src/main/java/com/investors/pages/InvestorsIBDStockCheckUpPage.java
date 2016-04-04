package com.investors.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.investors.ObjProperty.InvestorsIBDStockCheckUpProperty;
import com.investors.utility.BasePage;
import com.investors.utility.WebElements;

public class InvestorsIBDStockCheckUpPage extends WebElements{

	WebDriver driver;
	WebDriverWait wait;
	BasePage basepage;
	
	By rateastocktextbox=By.id(InvestorsIBDStockCheckUpProperty.rateastocktextbox.getProperty());
	By rateastockbutton=By.id(InvestorsIBDStockCheckUpProperty.rateastockbutton.getProperty());
	By stockcheckupresult=By.id(InvestorsIBDStockCheckUpProperty.ibdstockcheckupresult.getProperty());
	By boingtextlocator=By.xpath(InvestorsIBDStockCheckUpProperty.boingtext.getProperty());;
	public InvestorsIBDStockCheckUpPage(WebDriver driver,WebDriverWait wait,BasePage basepage){
		super(driver, wait);
		this.driver=driver;
		this.wait=wait;
		this.basepage=basepage;
	}
	public void enterRateaStockdata(){
		enterText(rateastocktextbox,"BA");
	}
	public void clickrateastockbutton(){
		click(rateastockbutton);
	}
	public String getstockcheckupresult(){
		return getText(stockcheckupresult);
	}
	public String verifyBoeingtext(){
		return getText(boingtextlocator);
	}
	
}
