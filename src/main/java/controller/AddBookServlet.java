package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dao.BookDAO;
import dao.BookDAOImp;
import dto.Books;

public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Books book = new Books();
        BookDAO bookadd = new BookDAOImp();
        
        String bname = request.getParameter("bname");
        String bid = request.getParameter("bid"); // Changed to String
        String bautho = request.getParameter("bautho");
        String bsubject = request.getParameter("bsubject");
        
        book.setBname(bname);
        book.setBid(bid); // Changed to String
        book.setbautho(bautho);
        book.setBsubject(bsubject);
        
        String baddstatus = bookadd.save(book);
        HttpSession session = request.getSession();
        session.setAttribute("baddstatus", baddstatus);
        
        response.sendRedirect("addBook.jsp");
    }
}