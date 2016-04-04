package com.investors.ObjProperty;

public enum InvestorsLoginPageProperty {

	
	userIcon("//*[@class='signin-icon']"),
	signinbutton("loginButton"),
	loginFrame("//*[@id='loginFrame']//iframe[contains(@id,'easyXDM')]"),
	username("UserName"),password("Password"),welcomepopup("×");
	
	private String property;
	
	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	private InvestorsLoginPageProperty(String property){
		
		this.property=property;
		
	}
	
}
