package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dao.LibrarianDAO;
import dao.LibrarianDAOImp;
import dto.ValidateLibrarian;

public class Validate extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	    private LibrarianDAO libdao = new LibrarianDAOImp();

	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        
	        ValidateLibrarian vl = new ValidateLibrarian();
	        vl.setLusername(username);
	        vl.setLpassword(password);

	        int id = libdao.librarianValidate(vl);
	        HttpSession session = request.getSession();

	        if (id != -1) {
	            session.setAttribute("lid", id);
	            response.sendRedirect("libMain.jsp");
	        } else {
	            response.sendRedirect("login.jsp?error=true");
	        }
	    }
	}