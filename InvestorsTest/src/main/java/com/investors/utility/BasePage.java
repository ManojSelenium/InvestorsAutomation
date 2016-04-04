package com.investors.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.investors.ObjProperty.InvestorsIBDStockCheckUpProperty;
import com.investors.pages.InvestorsBigPicturePage;
import com.investors.pages.InvestorsDashboardpage;
import com.investors.pages.InvestorsIBDStockCheckUpPage;
import com.investors.pages.InvestorsLeaderBoardPage;
import com.investors.pages.InvestorsLoginPage;
import com.investors.pages.InvestorsMarketTrendPage;
import com.investors.pages.InvestorsMyIBDPage;
import com.investors.pages.InvestorsResearchPage;
import com.investors.pages.InvestorsSelectLeaderPage;
import com.investors.pages.InvestorsStockListPage;

public class BasePage {

	WebDriver driver;
	BasePage basepage;
	WebDriverWait wait;
	private InvestorsLoginPage loginPage;
	private InvestorsLeaderBoardPage leaderBoardPage;
	private InvestorsDashboardpage dashboardpage;
	private InvestorsResearchPage researchpage;
	private InvestorsBigPicturePage bigpicturepage;
	private InvestorsSelectLeaderPage selectleaderpage;
	private InvestorsStockListPage stocklistpage;
	private InvestorsMarketTrendPage matkettrendpage;
	private InvestorsIBDStockCheckUpPage ibdstockcheckuppage;
	private InvestorsMyIBDPage myibdpage;
	
	public BasePage()
	{
		
	}
	
	
	public BasePage(WebDriver driver,WebDriverWait wait,BasePage basepage){
		this.driver=driver;
		this.basepage=basepage;
		this.wait=wait;
	}
	
	public InvestorsLoginPage loginPage(WebDriver driver,WebDriverWait wait,BasePage basepage){
		if(loginPage==null) {
			loginPage=new InvestorsLoginPage(driver, wait,basepage);
		}
		return loginPage;
	}
	
	public InvestorsLeaderBoardPage leaderBoardPage(WebDriver driver,WebDriverWait wait,BasePage basepage) {
		if(leaderBoardPage==null) {
			leaderBoardPage=new InvestorsLeaderBoardPage(driver, wait,basepage);
		}
		return leaderBoardPage;
	}
	
	public InvestorsDashboardpage dashboardpage(WebDriver driver,WebDriverWait wait,BasePage basepage){
		
		if(dashboardpage==null) {
			dashboardpage=new InvestorsDashboardpage(driver, wait,basepage);
		}
		return dashboardpage;
		
	}
	
	public InvestorsResearchPage researchPage(WebDriver driver,WebDriverWait wait,BasePage basepage) {
		
		if(researchpage==null) {
			researchpage=new InvestorsResearchPage(driver, wait,basepage);
		}
		return researchpage;
	}
	
	public InvestorsBigPicturePage bigpicturepage(WebDriver driver,WebDriverWait wait,BasePage basepage) {
		
		if(bigpicturepage==null) {
			bigpicturepage=new InvestorsBigPicturePage(driver, wait, basepage);
		}
		return bigpicturepage;
	}
	
	public InvestorsSelectLeaderPage selectleaderpage(WebDriver driver,WebDriverWait wait,BasePage basepage){
		
		if(selectleaderpage==null) {
			selectleaderpage=new InvestorsSelectLeaderPage(driver,wait,basepage);
		}
		return selectleaderpage;
	}
	
	public InvestorsStockListPage stocklistpage(WebDriver driver,WebDriverWait wait,BasePage basepage){
		
		if(stocklistpage==null) {
			stocklistpage=new InvestorsStockListPage(driver, wait, basepage);
		}
		return stocklistpage;
	}
	
public InvestorsMarketTrendPage matkettrendpage(WebDriver driver,WebDriverWait wait,BasePage basepage){
		
		if(matkettrendpage==null) {
			matkettrendpage=new InvestorsMarketTrendPage(driver, wait, basepage);
		}
		return matkettrendpage;
	}
	
public InvestorsIBDStockCheckUpPage ibdstockcheckuppage(WebDriver driver,WebDriverWait wait,BasePage basepage){
	
	if(ibdstockcheckuppage==null) {
		ibdstockcheckuppage=new InvestorsIBDStockCheckUpPage(driver, wait, basepage);
	}
	return ibdstockcheckuppage;
}

public InvestorsMyIBDPage myibdpage(WebDriver driver,WebDriverWait wait,BasePage basepage){
	
	if(myibdpage==null) {
		
		myibdpage=new InvestorsMyIBDPage(driver, wait, basepage);
	}
	return myibdpage;
}
}
