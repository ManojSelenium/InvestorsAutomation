package com.investors.ObjProperty;

public enum InvestorsLeaderBoardProperty {

	clicktoviewLeaderBoardChart("MainContent_SymbolsRepeater_ChartStoryView_0_ResearchTools_0_lnkLeaderboardChart_0"),
	cutlist("SecondaryNavigation_rptNavigation1_rptNavigation2_0_lnkSection_1"),
	thebigpicture("TopNavigation_rptTopNavigation_lnkNav_1"),
	selectleaders("TopNavigation_rptTopNavigation_lnkNav_2"),
	IBD50("TopNavigation_rptTopNavigation_lnkNav_3"),
	stockspoltlight("TopNavigation_rptTopNavigation_lnkNav_4"),
	GotoDateView("MainContent_SymbolsRepeater_ChartStoryView_0_SectionHeader_0_SwitchViewLink_0");
	
	
	private String property;
	
	private InvestorsLeaderBoardProperty(String property) {
		this.property=property;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}
	
	
}

