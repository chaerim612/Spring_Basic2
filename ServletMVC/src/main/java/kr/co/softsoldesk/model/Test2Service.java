package kr.co.softsoldesk.model;

import javax.servlet.http.HttpServletRequest;

public class Test2Service {
	public static int minus(HttpServletRequest request) {
		String str1=request.getParameter("data1");
		String str2=request.getParameter("data2");
		
		int num1=Integer.parseInt(str1);
		int num2=Integer.parseInt(str2);
		
		int result=num1-num2;
		
		return result;
	}
}
