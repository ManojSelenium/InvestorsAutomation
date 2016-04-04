package com.investors.ObjProperty;

public enum InvestorsRecentIssuesProperty {

	firstPDFlocator("//*[contains(@class,'pdfLinks')]/ul/li[1]/a");
	
	private String property;
	
	
	private InvestorsRecentIssuesProperty(String property){
		
		this.property=property;
		
	}


	public String getProperty() {
		return property;
	}


	public void setProperty(String property) {
		this.property = property;
	}
	
	
}
