package com.investors.ObjProperty;

public enum InvestorsReseachProperty {

	researchmenu("html/body/div[1]/header/section/div[2]/ul/li[3]/a"),
	ibdstockcheckup("IBD Stock Checkup"),
	rateastocktextbox("ctl00_ctl00_secondaryContent_leftContent_StockSearch3_txtSearchBox"),
	rateastockbutton("ctl00_ctl00_secondaryContent_leftContent_StockSearch3_btnSearch"),
	ibdstockcheckupresult("ctl00_ctl00_secondaryContent_leftContent_ckupPanel_rptComposite_ctl04_lnkStockSymbol");
	
	private String property;
	
	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	private InvestorsReseachProperty(String property){
		this.property=property;
	}
	
	
	
}
