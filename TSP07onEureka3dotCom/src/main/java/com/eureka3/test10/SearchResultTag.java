package com.eureka3.test10;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class SearchResultTag extends TagSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String searchFrom = "";
	public void setSearchFrom(String value) {
		this.searchFrom = value;
	}
	
	private String searchTo = "";
	public void setSearchTo(String value) {
		this.searchTo = value;
	}
	
	private String methodName = "";
	public void setMethodName(String value) {
		this.methodName = value;
	}
	
	public int doStartTag() throws JspException {
		
		try {
			
			if (this.methodName.equals("GET")) {
				// 何もしない
			} else {
				
				BeanFactory myFactory = (BeanFactory)new ClassPathXmlApplicationContext("applicationContext.xml");
				
				ResultBean myBean = (ResultBean)myFactory.getBean("ResultBean");
				
				myBean.setSearchFrom(this.searchFrom);
				myBean.setSearchTo(this.searchTo);
				myBean.search_TEST03();
				
				SearchResultContextWriter w = new SearchResultContextWriter();
				w.setMyTable(myBean.getSession().get("session"));
				pageContext.getOut().write(w.writeSearchResult());
				
			}
			
		} catch (Exception e) {
			
			throw new JspException(e);
			
		}
		return SKIP_BODY;
		
	}
	
}
