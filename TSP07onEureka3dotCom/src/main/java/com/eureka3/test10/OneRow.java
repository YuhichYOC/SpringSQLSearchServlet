package com.eureka3.test10;

import java.io.Serializable;

import java.util.ArrayList;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OneRow implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public OneRow() {
		
		this.myRow = new ArrayList<OneItem>();
		
	}
	
	private int columnCount;
	public void setColumnCount(int value) {
		this.columnCount = value;
	}
	public int getColumnCount() {
		return this.columnCount;
	}
	
	private ArrayList<OneItem> myRow;
	public void setMyRow(ArrayList<OneItem> value) {
		this.myRow = value;
	}
	public ArrayList<OneItem> getMyRow() {
		return this.myRow;
	}
	
	public void setItemWithColumnIndex(int columnIndex, String value) {
		this.myRow.get(columnIndex).setColumnContent(value);
	}
	
	public OneRow addRow() {
		
		BeanFactory myFactory = (BeanFactory)new ClassPathXmlApplicationContext("applicationContext.xml");
		int loopCount = 0;
		for (loopCount = 0; loopCount < this.columnCount; loopCount++) {
			myRow.add((OneItem)myFactory.getBean("OneItem"));
		}
		return this;
		
	}
	
}
