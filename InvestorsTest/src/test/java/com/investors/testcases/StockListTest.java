package com.investors.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.investors.beanfactory.BeanFactory;
import com.investors.dao.LoginBeanPage;
import com.investors.pages.InvestorsDashboardpage;
import com.investors.pages.InvestorsLoginPage;
import com.investors.pages.InvestorsSelectLeaderPage;
import com.investors.pages.InvestorsStockListPage;
import com.investors.utility.BasePage;
import com.investors.utility.TestBase;

public class StockListTest extends TestBase {


	private InvestorsLoginPage loginPageObj;
	private BasePage basePage;
	//private MarketTrandPage markettrandpage;
	private InvestorsDashboardpage dashboardpage;
	private InvestorsStockListPage stocklistpage;
	private InvestorsSelectLeaderPage selectleaderpage;
	private WebDriver driver;
	private BeanFactory beanFactory;
	private LoginBeanPage loginbeanpage;
	
	
	@BeforeClass
	public void beforeClass(){
		
		beanFactory=new BeanFactory();
		loginbeanpage=new LoginBeanPage();
		
	}
	@Parameters("sBrowser")
	@BeforeMethod
	public void setup(@Optional(SBROWSER)String sbrowser)
	{
		driver=initilizeBrowser(SBROWSER);
		enterURL(sURL);
		System.out.println("LeaderBoard Driver :::: "+driver);
		basePage=new BasePage(driver, wait, new BasePage());
		loginPageObj=new InvestorsLoginPage(driver, wait, basePage);
	}
	
	
	@Test
	public void stocklist_tc() throws InterruptedException{
		loginPageObj.verify_WelcomePopupandclick();
		loginPageObj.clickUserIcon();
		beanFactory.investorsLoginByBean(loginbeanpage);
		loginPageObj.enterUserName(loginbeanpage.getUsername());
		loginPageObj.enterPassword(loginbeanpage.getPassword());
		dashboardpage=loginPageObj.clickonSignInoption();
		dashboardpage.verify_ClosePopup();
		stocklistpage=dashboardpage.clickSTockListLink();
		String actualResult=stocklistpage.getStockListURL();
		System.out.println("Actual Stock List URL :::: "+actualResult);
		System.out.println("Expected Stock List URL :::: "+stocklisturl);
		Assert.assertTrue(stocklisturl.contains(actualResult));
		
	}
/*	@Test
	public void selectleader_tc() throws InterruptedException{
		loginPageObj.verify_WelcomePopupandclick();
		loginPageObj.clickUserIcon();
		loginPageObj.enterUserName(loginbeanpage.getUsername());
		loginPageObj.enterPassword(loginbeanpage.getPassword());
		dashboardpage=loginPageObj.clickonSignInoption();
		stocklistpage=dashboardpage.clickSTockListLink();
		stocklistpage.mouseoveronStockList();
		selectleaderpage=stocklistpage.clickSelectLeaders();
		String actualResult=selectleaderpage.getSelectLeaderTitle();
		Assert.assertTrue(selectleaderurl.contains(actualResult));
	}*/
	
	@AfterMethod
	public void closebrowser()
	{
		closeBrowser(driver);
	}
}
