package com.investors.ObjProperty;

public enum InvestorsIBDStockCheckUpProperty {

	rateastocktextbox("ctl00_ctl00_secondaryContent_leftContent_StockSearch3_txtSearchBox"),
	rateastockbutton("ctl00_ctl00_secondaryContent_leftContent_StockSearch3_btnSearch"),
	ibdstockcheckupresult("ctl00_ctl00_secondaryContent_leftContent_ckupPanel_rptComposite_ctl04_lnkStockSymbol"),
	boingtext("//div[contains(@id,'ctl00_ctl00_secondaryContent_leftContent_pnlContent')]/div/div[contains(@class,'companyTitle')]/span/b");
	
	
	private String property;
	
	
	public String getProperty() {
		return property;
	}


	public void setProperty(String property) {
		this.property = property;
	}


	private InvestorsIBDStockCheckUpProperty(String property){
		this.property=property;
		
	}
}
