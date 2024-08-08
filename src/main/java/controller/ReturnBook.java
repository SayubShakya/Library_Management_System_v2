package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dao.ReturnBooksClass;

public class ReturnBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sid = Integer.parseInt(request.getParameter("sid"));
		int bid = Integer.parseInt(request.getParameter("bid"));
		ReturnBooksClass retbook = new ReturnBooksClass();
		String retstatus = null;
		retstatus = retbook.bookReturn(sid, bid);
		
		HttpSession session = request.getSession();
		session.setAttribute("retstatus", retstatus);
		response.sendRedirect("returnstatus.jsp");
				
	}	
}

