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
import com.investors.pages.InvestorsIBDStockCheckUpPage;
import com.investors.pages.InvestorsLoginPage;
import com.investors.pages.InvestorsResearchPage;
import com.investors.utility.BasePage;
import com.investors.utility.TestBase;

public class ResearchTest extends TestBase {

	private InvestorsLoginPage loginPageObj;
	//MarketTrandPage marketTrandPageObj;
	private InvestorsResearchPage researchPageObj;

	private BasePage basePage;
	private InvestorsDashboardpage dashboardpage;
	private InvestorsIBDStockCheckUpPage ibdstockcheckuppage;
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
	public void ibdStockCheckUp_tc() throws InterruptedException {
		loginPageObj.verify_WelcomePopupandclick();
		beanFactory.investorsLoginByBean(loginbeanpage);
		loginPageObj.clickUserIcon();
		loginPageObj.enterUserName(loginbeanpage.getUsername());
		loginPageObj.enterPassword(loginbeanpage.getPassword());
		dashboardpage=loginPageObj.clickonSignInoption();
		dashboardpage.verify_ClosePopup();
		researchPageObj=dashboardpage.clickResearchLink();
		ibdstockcheckuppage=researchPageObj.clickIBDStockCheckUplink();
		ibdstockcheckuppage.enterRateaStockdata();
		ibdstockcheckuppage.clickrateastockbutton();
		String actualResult=ibdstockcheckuppage.getstockcheckupresult();
		System.out.println("Actual Result :::: "+actualResult);
		Assert.assertEquals(actualResult, "BA");
	}
	
	@Test
	public void ibdcheckboingtext_tc() throws InterruptedException {
		loginPageObj.verify_WelcomePopupandclick();
		loginPageObj.clickUserIcon();
		loginPageObj.enterUserName(loginbeanpage.getUsername());
		loginPageObj.enterPassword(loginbeanpage.getPassword());
		dashboardpage=loginPageObj.clickonSignInoption();
		dashboardpage.verify_ClosePopup();
		researchPageObj=dashboardpage.clickResearchLink();
		
		ibdstockcheckuppage=researchPageObj.clickIBDStockCheckUplink();
		ibdstockcheckuppage.enterRateaStockdata();
		ibdstockcheckuppage.clickrateastockbutton();
		String actualResult=ibdstockcheckuppage.verifyBoeingtext();
		System.out.println("Actual Result :::: "+actualResult);
		Assert.assertTrue(actualResult.contains(boeingexpectedtext));
	}

	@AfterMethod
	public void quitBrowser() throws InterruptedException {
		closeBrowser(driver);
	}
}
