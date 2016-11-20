package com.eureka3.test10;

import java.util.ArrayList;

public class SearchResultContextWriter {
	
	private ArrayList<OneRow> myTable;
	public void setMyTable(ArrayList<OneRow> value) {
		this.myTable = value;
	}
	
	public String writeSearchResult() {
		
		String retValue = "";
		retValue += this.writeTableHead();
		if (myTable.isEmpty()) {
			// 何もしない
		} else {
			for (OneRow thisRow: this.myTable) {
				retValue += this.writeTRHead();
				retValue += this.writeOneRow(thisRow.getMyRow().get(0).getColumnContent(), thisRow.getMyRow().get(1).getColumnContent());
				retValue += this.writeTRTail();
			}
		}
		retValue += this.writeTableTail();
		
		return retValue;
		
	}
	
	private String writeTableHead() {
		
		return "<table class=\"resultTable\">" + "\n";
		
	}
	
	private String writeTRHead() {
		
		return "<tr>" + "\n";
		
	}
	
	private String writeOneRow(String prefCode, String prefName) {
		
		String retValue = "";
		retValue += "<td class=\"resultTable\">" + prefCode + "</td>" + "\n";
		retValue += "<td class=\"resultTable\">" + prefName + "</td>" + "\n";
		return retValue;
		
	}
	
	private String writeTRTail() {
		
		return "</tr>" + "\n";
		
	}
	
	private String writeTableTail() {
		
		return "</table>" + "\n";
		
	}
	
}
