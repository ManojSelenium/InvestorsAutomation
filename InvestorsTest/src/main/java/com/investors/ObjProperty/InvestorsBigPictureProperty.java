package com.investors.ObjProperty;

public enum InvestorsBigPictureProperty {

	
	bigpicturelink("//*[@class='inner-wrap']/section/ul/li[contains(@class,'market-trend')]/a/../ul[@class='sub-menu']/li/ul[@class='sub-menu']/li/a[contains(text(),'The Big Picture')]"),
	bigpictureimage("//img[@class='attachment-full size-full wp-post-image']"),
	getbigpictureimagename("//section[@class='stock-market-today']/article/header/h1"),
	bigpicturetooltip("//div[@id='category-posts-wrapper']/article/a"),
	reprinttext("//div[contains(@class,'custom-share-links share-links after-content top-share')]/a[contains(@class,'reprints-button sharing')]");
	
	private String property;
	
	private InvestorsBigPictureProperty(String property){
		this.property=property;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}
	
	
}
