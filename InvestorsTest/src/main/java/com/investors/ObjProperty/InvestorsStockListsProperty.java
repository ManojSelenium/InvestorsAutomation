package com.investors.ObjProperty;

public enum InvestorsStockListsProperty {

	stocklists("//section[@class='nav-container']//li[contains(@class,'stock-lists')]/a"),
	selectleaders("//a[text()='Sector Leaders']");
	
	private String property;
	
	private InvestorsStockListsProperty(String property){
		
		this.property=property;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}
}
