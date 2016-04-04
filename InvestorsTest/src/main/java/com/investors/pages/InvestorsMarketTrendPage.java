package com.investors.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.investors.ObjProperty.InvestorsBigPictureProperty;
import com.investors.ObjProperty.InvestorsDashBoardProperty;
import com.investors.utility.BasePage;
import com.investors.utility.InvestorsConfig;
import com.investors.utility.WebElements;

public class InvestorsMarketTrendPage  extends WebElements{
	
	private WebDriver driver;
	private WebDriverWait wait;
	private BasePage basepage;
	
	
	By marketTrend=By.xpath(InvestorsDashBoardProperty.markettrendmenu.getProperty());
	// BP-Link
	By bigPicturelink=By.xpath(InvestorsBigPictureProperty.bigpicturelink.getProperty());
	//BP Image
	By bigPictureImage=By.xpath(InvestorsBigPictureProperty.bigpictureimage.getProperty());
	//BPImage Name
	By bigPictureName=By.xpath(InvestorsBigPictureProperty.getbigpictureimagename.getProperty());
		
		public InvestorsMarketTrendPage(WebDriver driver,WebDriverWait wait, BasePage basepage){
			super(driver, wait);
			this.driver=driver;
			this.wait=wait;
			this.basepage=basepage;
		}
		
		
		public void clickMarketTrendLink(){
		
				if(waitForElementPresent(marketTrend)) {
					mouseOver(marketTrend);
					click(marketTrend);
			}
		}
		
	public String getmatkettrendpagetitle() {
		return getCurrentPageURL();
	}
	
	public void clickBigPictureLink(){
		click(bigPicturelink);
		
	}
}
