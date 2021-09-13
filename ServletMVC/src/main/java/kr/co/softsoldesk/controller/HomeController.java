package kr.co.softsoldesk.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.softsoldesk.model.Test2Service;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("*.mvc")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=request.getRequestURI();
		//System.out.println(url);
		String viewName=null;
		
		if(url.contains("main.mvc")) {
			//System.out.println("main 요청");
			viewName="main.jsp";
		}else if(url.contains("test1.mvc")) {
			//System.out.println("test1 요청");
			
			//파라미터값
			String str1=request.getParameter("data1");
			String str2=request.getParameter("data2");
			//형변환
			int num1=Integer.parseInt(str1);
			int num2=Integer.parseInt(str2);
			//합계
			int result=num1+num2;
			request.setAttribute("result", result);
			viewName="test1.jsp";
			
		}else if(url.contains("test2.mvc")) {
			//System.out.println("test2 요청");
			//모델 별도 요청
			int result=Test2Service.minus(request);
			
			request.setAttribute("result", result);
			
			viewName="test2.jsp";
		}
		
		RequestDispatcher dis=request.getRequestDispatcher(viewName);
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
