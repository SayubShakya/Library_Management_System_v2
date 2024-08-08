package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dao.BookDAOImp;
import dto.Books;

public class DelBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bid = Integer.parseInt(request.getParameter("book-id"));
		String delBstatus = null;
		BookDAOImp bookdao = new BookDAOImp();
		Books book = new Books();
		
	    book = bookdao.findById(bid);
	    if(book!=null)
	    {
	    	delBstatus = bookdao.deleteById(bid);
	    }
	    HttpSession session = request.getSession();     
	    session.setAttribute("delBstatus",delBstatus);
	    response.sendRedirect("delbook.jsp");
		}


	}
