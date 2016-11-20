package com.eureka3.test10;

import java.io.Serializable;

public class OneItem implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int columnIndex;
	public void setColumnIndex(int value) {
		this.columnIndex = value;
	}
	public int getColumnIndex() {
		return this.columnIndex;
	}
	
	private String columnContent;
	public void setColumnContent(String value) {
		this.columnContent = value;
	}
	public String getColumnContent() {
		return this.columnContent;
	}
	
}
