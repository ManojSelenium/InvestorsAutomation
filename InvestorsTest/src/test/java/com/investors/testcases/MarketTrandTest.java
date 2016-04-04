package com.investors.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.investors.beanfactory.BeanFactory;
import com.investors.dao.LoginBeanPage;
import com.investors.pages.InvestorsBigPicturePage;
import com.investors.pages.InvestorsDashboardpage;
import com.investors.pages.InvestorsLoginPage;
import com.investors.utility.BasePage;
import com.investors.utility.TestBase;

public class MarketTrandTest extends TestBase{


	private InvestorsLoginPage loginPageObj;
	private InvestorsDashboardpage dashboardpage;
	private InvestorsBigPicturePage bigpicturepage;
	private BasePage basepage;
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
		basepage=new BasePage(driver, wait, new BasePage());
		loginPageObj=new InvestorsLoginPage(driver, wait, basepage);
		
	}

	@Test
	public void verifyBigPictureLink_tc() throws InterruptedException {

		System.out.println("Verify Big Picture Link test case started ");
		basepage.loginPage(driver, wait, basepage);

		loginPageObj.verify_WelcomePopupandclick();
		loginPageObj.clickUserIcon();
		beanFactory.investorsLoginByBean(loginbeanpage);;
		loginPageObj.enterUserName(loginbeanpage.getUsername());
		loginPageObj.enterPassword(loginbeanpage.getPassword());
		dashboardpage=loginPageObj.clickonSignInoption();
		dashboardpage.verify_ClosePopup();
		dashboardpage.pause(3000);
		dashboardpage.mouseOverOnMarketTrend();
		bigpicturepage=dashboardpage.clickBigPictureLink();

		String expectedData=bigpicturepage.getbigpictureToolTip();
		bigpicturepage.clickBigPictureImage();
		System.out.println("Click Big Picture Image");
		String actualData=bigpicturepage.getBigPictureName();

		System.out.println("expected Big Picture:::: "+expectedData);
		System.out.println("actual Big Picture:::: "+actualData);
		Assert.assertEquals(actualData, expectedData);
	}


	@Test
	public void verifyReptintText_tc() throws InterruptedException{
		basepage.loginPage(driver, wait, basepage);

		loginPageObj.verify_WelcomePopupandclick();
		loginPageObj.clickUserIcon();

		loginPageObj.enterUserName(loginbeanpage.getUsername());
		loginPageObj.enterPassword(loginbeanpage.getPassword());
		dashboardpage=loginPageObj.clickonSignInoption();
		dashboardpage.verify_ClosePopup();
		dashboardpage.pause(3000);
		dashboardpage.mouseOverOnMarketTrend();
		bigpicturepage=dashboardpage.clickBigPictureLink();

		String expectedData=bigpicturepage.getbigpictureToolTip();
		bigpicturepage.clickBigPictureImage();
		System.out.println("Click Big Picture Image");
		String actualData=bigpicturepage.getBigPictureName();

		System.out.println("expected Big Picture:::: "+expectedData);
		System.out.println("actual Big Picture:::: "+actualData);
		String actualText=bigpicturepage.verifyReprinttext();
		System.out.println("Reprint Test Case Actual Text :::: "+actualText);
		Assert.assertEquals(actualText, reprintexpectedText);
	}
	//@AfterMethod
	public void quitBrowser() throws InterruptedException {
		System.out.println("After Method ");
		closeBrowser(driver);
	}
}
