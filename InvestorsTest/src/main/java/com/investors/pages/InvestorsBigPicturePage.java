package com.investors.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.investors.ObjProperty.InvestorsBigPictureProperty;
import com.investors.utility.BasePage;
import com.investors.utility.InvestorsConfig;
import com.investors.utility.WebElements;
import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;

public class InvestorsBigPicturePage extends WebElements{

	
	WebDriver driver;
	WebDriverWait wait;
	BasePage basepage;
	// BP-Link
	By bigPicturelink=By.xpath(InvestorsBigPictureProperty.bigpicturelink.getProperty());
	//BP Image
	By bigPictureImage=By.xpath(InvestorsBigPictureProperty.bigpictureimage.getProperty());
	//BPImage Name
	By bigPictureName=By.xpath(InvestorsBigPictureProperty.getbigpictureimagename.getProperty());
	By bigPictureToolTip=By.xpath(InvestorsBigPictureProperty.bigpicturetooltip.getProperty());
	By reprintlocator=By.xpath(InvestorsBigPictureProperty.reprinttext.getProperty());	
	public InvestorsBigPicturePage(WebDriver driver,WebDriverWait wait, BasePage basepage) {
		super(driver, wait);
		this.driver=driver;
		this.wait=wait;
		this.basepage=basepage;
	}
	
	
	// Below method will click on BP link
		public void clickBigPictureLink() {
			click(bigPicturelink);
			System.out.println("Clicking Big Picture Link");
		}
		// Below method will click on BP Image
		public void clickBigPictureImage() {
			click(bigPictureImage);
		}
		
		// Below method gets BP Name
		public String getBigPictureName() {
			return getText(bigPictureName);
		}
		
		public String getbigpictureToolTip() {
			
			return	getAttributeValue(bigPictureToolTip,"title");

			}
		
		public String verifyReprinttext(){
			
			return getText(reprintlocator);
		}
}
