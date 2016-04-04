package com.investors.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.investors.ObjProperty.InvestorsLoginPageProperty;
import com.investors.utility.BasePage;
import com.investors.utility.InvestorsConfig;
import com.investors.utility.SetUp;
import com.investors.utility.WebElements;

/* All the Actions related to login should be available hear */
/* All the data should be coming from "Setup.java" in com.investors.utilities */

public class InvestorsLoginPage extends WebElements implements SetUp{

	private WebDriver driver;
	private WebDriverWait wait;
	private BasePage basepage;
	
	//Click Login
	By loginButton=By.id(InvestorsLoginPageProperty.signinbutton.getProperty());
	// Clicking on UserIcon
	By userICon=By.xpath(InvestorsLoginPageProperty.userIcon.getProperty());
	// Switching Frame
	By LoginFrame=By.xpath(InvestorsLoginPageProperty.loginFrame.getProperty());
	// User-name
	By usernamelocator=By.id(InvestorsLoginPageProperty.username.getProperty());
	//Password
	By passwordlocator=By.id(InvestorsLoginPageProperty.password.getProperty());
	// Pop-up handling when 
	By welcomePopup=By.linkText(InvestorsLoginPageProperty.welcomepopup.getProperty());
	
	
	public InvestorsLoginPage(WebDriver driver,WebDriverWait wait, BasePage basepage) {
		super(driver,wait);
		this.driver=driver;
		this.wait=wait;
		this.basepage=basepage;
		
	}
 
	/*
	 * below method will verify the welcome popup then handel
	 */
	public void verify_WelcomePopupandclick(){
		if(isDisplayedWithoutException(welcomePopup)){
			click(welcomePopup);
			System.out.println("the Welcome popup is visible on the page and clicked done");
		}
		else {
			System.out.println("The Welcome popup is not present on the page");
		}
	}
	
	/* Below method will Mouse-over on user icon */
	public void clickUserIcon() throws InterruptedException {
	mouseOver(userICon);
	Thread.sleep(2000);
		System.out.println("Mouseover on user icon");
	}
	/* Below method will click Login Button */
	public void doLogin(String userName,String password) {
		enterText(usernamelocator, userName);
		enterText(passwordlocator, password);
		click(loginButton);
	}
	
	public void enterUserName(String userName) throws InterruptedException {
		Thread.sleep(1000);
		selectXpathFrame(LoginFrame);
		enterText(usernamelocator, userName);
		System.out.println("entered user name");
	}
	public void enterPassword(String passWord) {
		enterText(passwordlocator, passWord);
		System.out.println("entered password");
		switchBackFromFrame();
	}
	
	public InvestorsDashboardpage clickonSignInoption() throws InterruptedException {
		//mouseOver(userICon);
		Thread.sleep(2000);
		click(loginButton);
		Thread.sleep(5000);
		System.out.println("clicked on signoption");
		System.out.println("Login Page :: "+driver);
		System.out.println("Login Page :: "+basepage);
		return basepage.dashboardpage(driver, wait, basepage);
		//return new MarketTrandPage(driver,wait,basepage);
	}
	
}
