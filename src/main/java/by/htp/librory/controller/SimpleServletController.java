package by.htp.librory.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.librory.action.BaseAction;
import by.htp.librory.action.util.ActionManager;

/**
 * Servlet implementation class SimpleServletController
 */
public class SimpleServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private BookDao dao = new SimpleBookDaoImpl(); // dao
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String userAction = request.getParameter("action");
		//String userAction2 = request.getParameter("action2");
		int value = Integer.parseInt(userAction);
		//int value2 = Integer.parseInt(userAction2);
		BaseAction action = ActionManager.defineAction(value);
		PrintWriter out = response.getWriter();
		if(value==1) {
			action.doSmth(out);
		}else if(value==2) {
			action.doSmth2(out);
		}else {
			System.out.println("asfdasdf");
		}
		
		
		/*BaseAction action2 = ActionManager.defineAction(value2);
		PrintWriter out2 = response.getWriter();
		action2.doSmth2(out2);*/
	//	response.getWriter().append("Hello again!");
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
