package com.investors.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.investors.ObjProperty.InvestorsLeaderBoardProperty;
import com.investors.utility.BasePage;
import com.investors.utility.WebElements;

public class InvestorsLeaderBoardPage extends WebElements {

	WebDriver driver;
	WebDriverWait wait;
	BasePage basepage;
	
	By clicktoviewLeaderBoardchartLocator=By.id(InvestorsLeaderBoardProperty.clicktoviewLeaderBoardChart.getProperty());
	By cutlistlocator=By.id(InvestorsLeaderBoardProperty.cutlist.getProperty());
	By leaderboardTheBigPictureLocator=By.id(InvestorsLeaderBoardProperty.thebigpicture.getProperty());
	By leaderboardSelectLeaderslocator=By.id(InvestorsLeaderBoardProperty.selectleaders.getProperty());
	By IBD50locator=By.id(InvestorsLeaderBoardProperty.IBD50.getProperty());
	By clicktodataviewlocatorlocator=By.id(InvestorsLeaderBoardProperty.GotoDateView.getProperty());
	By stockspotlightlocator=By.id(InvestorsLeaderBoardProperty.stockspoltlight.getProperty());

	
	public  InvestorsLeaderBoardPage(WebDriver driver,WebDriverWait wait,BasePage basepage){
		super(driver, wait);
		this.driver=driver;
		this.wait=wait;
		this.basepage=basepage;
		
	}

	public String getleaderboardURL(){
		return getCurrentPageURL();
	}
	
	public void clickCutListlink(){
		click(cutlistlocator);
	}
	
	public void clickleaderboardibd50link(){
		click(IBD50locator);
	}
	
	public void clickgotodataviewoption(){
		click(clicktodataviewlocatorlocator);
	}
	
	public void clickleaderboardselectleaderslink(){
		click(leaderboardSelectLeaderslocator);
	}
	public void clickleaderboardstockspotlightlink(){
		click(stockspotlightlocator);
	}
	
	public void clickviewleaderboardchart(){
		click(clicktoviewLeaderBoardchartLocator);
	}
	
	public void clickleaderboardthebigpicturelink(){
		click(leaderboardTheBigPictureLocator);
	}
}

