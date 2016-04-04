package com.investors.ObjProperty;

public enum InvestorsLeaderBoardChartsProperty {

	leaderboardchartsearchtextbox("predictiveSearchBox"),
	leaderboardchartsearchbutton("lnkSiteSearch");
	
	
	private String property;
	
	private InvestorsLeaderBoardChartsProperty(String property) {
		
		this.property=property;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}
	
	
	
}
