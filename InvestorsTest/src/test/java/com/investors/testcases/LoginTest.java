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
import com.investors.pages.InvestorsLoginPage;
import com.investors.pages.InvestorsMyIBDPage;
import com.investors.utility.BasePage;
import com.investors.utility.TestBase;



public class LoginTest extends TestBase{

	private InvestorsLoginPage loginPageObj;
	private BasePage basepage;
	private BeanFactory beanFactory;
	private LoginBeanPage loginbeanpage;
	private InvestorsDashboardpage dashboardpageObj;
	private InvestorsMyIBDPage myibdpageObj;
	
	@BeforeClass
	public void beforeClass(){
		beanFactory=new BeanFactory();
		loginbeanpage=new LoginBeanPage();
		
		
	}
	@Parameters("sBrowser")
	@BeforeMethod()
	public void setUp(@Optional(SBROWSER)String sbrowser){
		driver=initilizeBrowser(SBROWSER);
		basepage=new BasePage(driver, wait, new BasePage());
		loginPageObj=new InvestorsLoginPage(driver, wait, basepage);
	}
	@Test
	public void verifyIBDLink_tc() throws InterruptedException{
		
		enterURL(sURL);
		loginbeanpage.setUsername("testibd01@w.won");
		loginbeanpage.setPassword("test");
		loginPageObj.clickUserIcon();
		loginPageObj.enterUserName(loginbeanpage.getUsername());
		loginPageObj.enterPassword(loginbeanpage.getPassword());
		dashboardpageObj=loginPageObj.clickonSignInoption();
		myibdpageObj=dashboardpageObj.clickMyIBDLink();
		String actualURL=myibdpageObj.getMyIBDpageurl();
		System.out.println("MYIBD Page Actual URl ::::: "+actualURL);
		Assert.assertEquals(myIBDPageURl, actualURL);
	}
}
