package com.investors.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.investors.beanfactory.BeanFactory;
import com.investors.dao.LoginBeanPage;
import com.investors.pages.InvestorsDashboardpage;
import com.investors.pages.InvestorsLeaderBoardPage;
import com.investors.pages.InvestorsLoginPage;
import com.investors.pages.InvestorsRecentIssuesPage;
import com.investors.utility.BasePage;
import com.investors.utility.TestBase;



public class RecentIssuesTest extends TestBase{

	private InvestorsLoginPage loginPageObj;
	private BasePage basePage;
	//private MarketTrandPage markettrandpage;
	private InvestorsDashboardpage dashboardpage;

	private BeanFactory beanFactory;
	private LoginBeanPage loginbeanpage;
	private InvestorsRecentIssuesPage recentissuepage;
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
	public void verifyRecentIssues_tc() throws InterruptedException {

		System.out.println("VerifyleaderboardURL_tc test case started ");
		loginPageObj.verify_WelcomePopupandclick();
		loginPageObj.clickUserIcon();
		beanFactory.investorsLoginByBean(loginbeanpage);
		System.out.println("loginbeanpage.getUsername() ::: "+loginbeanpage.getUsername());
		loginPageObj.enterUserName(loginbeanpage.getUsername());
		loginPageObj.enterPassword(loginbeanpage.getPassword());
		dashboardpage=loginPageObj.clickonSignInoption();
		dashboardpage.verify_ClosePopup();
		enterURL(sRecentIssuesURL);
		recentissuepage=dashboardpage.clickRecentIsueFirstPDFlink();
		String actualTitle=recentissuepage.getRecentIssuestitle();
		Assert.assertEquals(actualTitle, sRecentIssuesURL);
	}
	
	
	
	
}
