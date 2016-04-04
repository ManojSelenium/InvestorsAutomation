package com.investors.ObjProperty;

public enum InvestorsDashBoardProperty {

	markettrendmenu("//*[@class='inner-wrap']/section/ul/li/a[contains(text(),'Market Trend')]"),
	researchmenu("//*[@class='inner-wrap']/section/ul/li/a[contains(text(),'Research')]"),
	leaderboard("//*[@class='inner-wrap']/section/ul/li/a[contains(text(),'Leaderboard')]"),
	stocklists("//*[@class='inner-wrap']/section/ul/li/a[contains(text(),'Stock Lists')]"),
	closePopup("close-welcome-ad"),
	MyIBDLink("//div[@id='mySettingsModal']/div/div[2]/a[contains(text(),'MY IBD')]"),
	cogsymbol("//*[@id='menu-main-nav-1']/li[contains(@class,'right settings-dropdown')]//*[@class='fa fa-cog']");
	public String getProperty() {
		return property;
	}


	public void setProperty(String property) {
		this.property = property;
	}


	private String property;
	
	
	private InvestorsDashBoardProperty(String property) {
		this.property=property;
	}
	
}
