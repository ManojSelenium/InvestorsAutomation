package com.investors.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.investors.ObjProperty.InvestorsBigPictureProperty;
import com.investors.ObjProperty.InvestorsDashBoardProperty;
import com.investors.ObjProperty.InvestorsRecentIssuesProperty;
import com.investors.utility.BasePage;
import com.investors.utility.InvestorsConfig;
import com.investors.utility.WebElements;

//All the Actions related to MTP should be available hear

public class InvestorsDashboardpage extends WebElements {

	private WebDriver driver;
	private WebDriverWait wait;
	private BasePage basepage;
		
		public InvestorsDashboardpage(WebDriver driver,WebDriverWait wait, BasePage basepage){
			super(driver, wait);
			this.driver=driver;
			this.wait=wait;
			this.basepage=basepage;
		}
		
	

	//MTP
	By marketTrend=By.xpath(InvestorsDashBoardProperty.markettrendmenu.getProperty());
	// BP-Link
	By bigPicturelink=By.xpath(InvestorsBigPictureProperty.bigpicturelink.getProperty());
	

	//Research Menu
	By researchMenu=By.xpath(InvestorsDashBoardProperty.researchmenu.getProperty());
	//IBD-Stock-Check-up
	//By ibdstockuplink=By.linkText(InvestorsConfig.prop.getProperty("ibdstockcheckup"));
	
	By clickleaderboard=By.xpath(InvestorsDashBoardProperty.leaderboard.getProperty());
	
	By stockList=By.xpath(InvestorsDashBoardProperty.stocklists.getProperty());
	
	By closePopup=By.id(InvestorsDashBoardProperty.closePopup.getProperty());
	
	By myibdlocator=By.xpath(InvestorsDashBoardProperty.MyIBDLink.getProperty());
	By cogsymbollocator=By.xpath(InvestorsDashBoardProperty.cogsymbol.getProperty());
	
	By recentIssuesFirstPDFLocator=By.xpath(InvestorsRecentIssuesProperty.firstPDFlocator.getProperty());
	// Below method will wait for page load
	// Below method will MouseOver MT
	public void mouseOverOnMarketTrend() {
		if(waitForElementPresent(marketTrend)) {
			mouseOver(marketTrend);
		}
	}
	
	
	
	public void verify_ClosePopup(){
		
		if(isDisplayedWithoutException(closePopup)) {
			click(closePopup);
			System.out.println("Close Popup Present on the screen and clicked");
		}else {
			System.out.println("Close popup is not present on the screen");
		}
		
		
	}
	public void mouseOveronResearch(){
		if(waitForElementPresent(researchMenu)) {
			mouseOver(researchMenu);
		}
	}
	
	
	// Below method will click on BP link
	public InvestorsBigPicturePage clickBigPictureLink() {
		click(bigPicturelink);
		return basepage.bigpicturepage(driver, wait, basepage);
	}
	
	
	
	// Below method gets Page URL
	public String getPageUrl() {
		return getCurrentPageURL();
	}
	
	// Frame
	public void selectMarketTrendFrame() {
		selectFrame("pmtracker");
	}
	
	// Below method gets BP Title
	
	// Below method will click Research-link
	public InvestorsResearchPage clickResearchLink(){
		
		mouseOver(researchMenu);
		click(researchMenu);
		return basepage.researchPage(driver, wait,basepage);
		
	}
	
	public InvestorsLeaderBoardPage clickleaderboardpagelink(){
		click(clickleaderboard);
		return basepage.leaderBoardPage(driver, wait, basepage);
	}
	
	public void mouseoveronStockList(){
		mouseOver(stockList);
	}
	
	public InvestorsStockListPage clickSTockListLink(){
		//elements(stockList,"Stock");
		click(stockList);
		System.out.println("Clicked on Stock List Link");
		return basepage.stocklistpage(driver, wait, basepage);
	}
	
	public InvestorsMyIBDPage clickMyIBDLink(){
		mouseOver(cogsymbollocator);
		click(myibdlocator);
		return new InvestorsMyIBDPage(driver, wait, basepage);
	}
	
	public InvestorsRecentIssuesPage clickRecentIsueFirstPDFlink(){
		click(recentIssuesFirstPDFLocator);
		return new InvestorsRecentIssuesPage(driver,wait,basepage);
	}

}