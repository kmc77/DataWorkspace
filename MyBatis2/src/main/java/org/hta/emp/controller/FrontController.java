package org.hta.emp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



	
	@WebServlet("*.emp")
	public class FrontController extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet{
		private static final long serialVersionUID = 1L;
		
		protected void doProcess(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
		   String RequestURI = request.getRequestURI();
		   String contextPath = request.getContextPath();
		   String command = RequestURI.substring(contextPath.length());
		   ActionForward forward = null;
		   Action action = null;
		   
		   
		   System.out.println("RequestURI=" + RequestURI);
		   System.out.println("contextPath=" + contextPath);
		   System.out.println("command=" + command);
		   

			switch (command) {
			case "/term.emp":
				action = new Term();
				break;
				
			case "/term2.emp":
				action = new Term2();
				break;
				
			case "/term3.emp":
				action = new Term3();
				break;
				
			case "/check.emp":
				action = new Check();
				break;
				
			

			}// switch end

		   forward = action.execute(request, response);
		   
		   if(forward != null) {
			   if(forward.isRedirect()) { //리다이텍트 됩니다.
				   response.sendRedirect(forward.getPath());
			   } else { //포워딩됩니다.
				   RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				   dispatcher.forward(request, response);
			   }
		   }
		   
		}// doProcess() end
		
		//doProcess(request,response)메서드를 구현하여 요청이 GET방식이든
		//POST방식으로 전송되어 오든 같은 메서드에서 요청을 처리할 수 있도록 하였습니다.
		
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			doProcess(request, response);
		}
		
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			doProcess(request, response);
		}
	}


