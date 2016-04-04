package com.investors.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.investors.beanfactory.BeanFactory;
import com.investors.dao.LoginBeanPage;
import com.investors.pages.InvestorsDashboardpage;
import com.investors.pages.InvestorsLeaderBoardPage;
import com.investors.pages.InvestorsLoginPage;
import com.investors.utility.BasePage;
import com.investors.utility.SetUp;
import com.investors.utility.TestBase;



public class LeaderBoardTest extends TestBase implements SetUp{


	private InvestorsLoginPage loginPageObj;
	private BasePage basePage;
	//private MarketTrandPage markettrandpage;
	private InvestorsDashboardpage dashboardpage;
	private InvestorsLeaderBoardPage leaderboardpage;
	private BeanFactory beanFactory;
	private LoginBeanPage loginbeanpage;
	WebDriver driver;


	@BeforeClass
	public void launchBrowser() throws InterruptedException {
		beanFactory=new BeanFactory();
		loginbeanpage=new LoginBeanPage();
		//leaderboardpage=new LeaderBoardPage(driver, wait, basePage);
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
	public void verifyleaderboardURL_tc() throws InterruptedException {

		System.out.println("VerifyleaderboardURL_tc test case started ");
		loginPageObj.verify_WelcomePopupandclick();
		loginPageObj.clickUserIcon();
		beanFactory.investorsLoginByBean(loginbeanpage);
		System.out.println("loginbeanpage.getUsername() ::: "+loginbeanpage.getUsername());
		loginPageObj.enterUserName(loginbeanpage.getUsername());
		loginPageObj.enterPassword(loginbeanpage.getPassword());
		dashboardpage=loginPageObj.clickonSignInoption();
		dashboardpage.verify_ClosePopup();
		leaderboardpage=dashboardpage.clickleaderboardpagelink();
		System.out.println("Leader Board Page Obj :::: "+leaderboardpage);
		String actualText=leaderboardpage.getleaderboardURL();
		System.out.println("Actual Text ::::: "+actualText);
		System.out.println("Expected Text :::: "+leaderboardurl);
		Assert.assertTrue(leaderboardurl.contains(actualText));

	}

	@Test
	public void verifyLeaderBoardPerformence_tc() throws InterruptedException{
		loginPageObj.verify_WelcomePopupandclick();
		loginPageObj.clickUserIcon();
		loginbeanpage.setUsername("testleaderboard02@w.won");
		loginbeanpage.setPassword("Dai2014!");
		loginPageObj.enterUserName(loginbeanpage.getUsername());
		loginPageObj.enterPassword(loginbeanpage.getPassword());
		dashboardpage=loginPageObj.clickonSignInoption();
		leaderboardpage=dashboardpage.clickleaderboardpagelink();
	
		leaderboardpage.clickviewleaderboardchart();
		leaderboardpage.clickCutListlink();
		leaderboardpage.clickleaderboardthebigpicturelink();
		leaderboardpage.clickleaderboardselectleaderslink();
		leaderboardpage.clickleaderboardibd50link();
		leaderboardpage.clickgotodataviewoption();
		leaderboardpage.clickleaderboardstockspotlightlink();
	}

	@AfterClass
	public void closebrowser()
	{
		closeBrowser(driver);
	}

}
