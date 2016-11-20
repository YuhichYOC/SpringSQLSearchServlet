package com.eureka3.test10;

import java.io.Serializable;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class ResultBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static String QueryStringSELECT_TEST03 = ""
			+ "SELECT                "
			+ "       PREF_CODE      "
			+ "     , PREF_NAME      "
			+ "FROM                  "
			+ "       test           "
			+ "WHERE                 "
			+ "       PREF_CODE >= ? "
			+ "   AND                "
			+ "       PREF_CODE <= ? ";
	
	private String searchFrom = "";
	public void setSearchFrom(String value) throws Exception {
		this.searchFrom = value;
		if (this.searchTo.equals("")) {
			// 何もしない
		} else {
			// 検索実行
			search_TEST03();
		}
	}
	public String getSearchFrom() {
		return this.searchFrom;
	}
	
	private String searchTo = "";
	public void setSearchTo(String value) throws Exception {
		this.searchTo = value;
		if (this.searchFrom.equals("")) {
			// 何もしない
		} else {
			// 検索実行
			search_TEST03();
		}
	}
	public String getSearchTo() {
		return this.searchTo;
	}
	
	private HashMap<String, ArrayList<OneRow>> mySession;
	public HashMap<String, ArrayList<OneRow>> getSession() {
		return mySession;
	}
	
	public void search_TEST03() throws Exception {
		
		try {
			
			BeanFactory myFactory = (BeanFactory)new ClassPathXmlApplicationContext("applicationContext.xml");
			MySQLAccessor myAccessor = (MySQLAccessor)myFactory.getBean("MySQLAccessor");
			
			myAccessor.createConnectionString();
			myAccessor.createConnection();
			
			myAccessor.setQueryString(QueryStringSELECT_TEST03);
			myAccessor.createPreparedStatement();
			myAccessor.setParameterIntoQuery(1, this.searchFrom);
			myAccessor.setParameterIntoQuery(2, this.searchTo);
			ResultSet rs = myAccessor.executeSelectQuery();
			
			Cast c = (Cast)myFactory.getBean("Cast");
			c.setMyResultSet(rs);
			c.doCast();
			
			this.mySession = new HashMap<String, ArrayList<OneRow>>();
			this.mySession.put("session", c.getMyTable());
			
		} catch (Exception e) {
			
			throw new Exception(e);
			
		}
		
	}
	
}
