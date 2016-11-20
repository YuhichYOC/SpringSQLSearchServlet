package com.eureka3.test10;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.sql.ResultSet;

public class Cast {
	
	private ArrayList<OneRow> myTable;
	public ArrayList<OneRow> getMyTable() {
		return this.myTable;
	}
	
	private ResultSet myResultSet;
	public void setMyResultSet(ResultSet value) {
		this.myResultSet = value;
	}
	
	public Cast() throws Exception {
		
		this.myTable = new ArrayList<OneRow>();
		
	}
	
	public void doCast() throws Exception {
		
		BeanFactory myFactory = (BeanFactory)new ClassPathXmlApplicationContext("applicationContext.xml");
		
		if (this.myResultSet == null) {
			
			return;
			
		} else {
			
			this.myResultSet.first();
			
			while (this.myResultSet.next()) {
				
				OneRow row = (OneRow)myFactory.getBean("OneRow");
				OneRow currentRow = row.addRow();
				int loopCount = 1;
				for (loopCount = 1; loopCount < currentRow.getColumnCount() + 1; loopCount++) {
					currentRow.setItemWithColumnIndex(loopCount - 1, this.myResultSet.getString(loopCount));
				}
				
				this.myTable.add(currentRow);
				
			}
			
		}
		
	}
}
