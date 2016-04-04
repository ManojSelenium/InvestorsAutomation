package com.investors.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

/* All driver objects */
public class TestBase implements SetUp {

	public WebDriver driver;
	public WebDriverWait wait;

	public WebDriver initilizeBrowser(String sBrowser) {

		if (sBrowser.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
		} else if (sBrowser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver();
		} else {
			driver = new HtmlUnitDriver(true);
		}
		wait = new WebDriverWait(driver, 100);
		return driver;
	}

	public void enterURL(String surl)
	{
		driver.get(surl);
		driver.manage().window().maximize();
	}
	
	public void logout(WebDriver driver) throws InterruptedException {
		System.out.println("Logout From the application");
		Thread.sleep(5000);
//		driver.switchTo().frame(driver.findElement(By.id(id)))
		/*Actions builder = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath(".//*[@id='menu-main-nav-1']/li[10]/i"));
		builder.moveToElement(ele).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.linkText("SIGN OUT")).click();
	*/
		driver.findElement(By.linkText("SIGN OUT")).click();
		driver.quit();
		Thread.sleep(4000);

	}

	public void closeBrowser(WebDriver driver) {
		//logout(driver);
		driver.quit();
	}

}
