package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.ResultSet;

import dao.BookDAO;
import dao.BookDAOImp;

public class ListBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   	 HttpSession session = request.getSession();
        if (session.getAttribute("lid") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        BookDAO bookDAO = new BookDAOImp();
        ResultSet rs = null;
        try {
            rs = bookDAO.findAll();
            if (rs != null) {
                request.setAttribute("booksResultSet", rs);
            } else {
                System.out.println("No data fetched from database.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        request.getRequestDispatcher("allbook.jsp").forward(request, response);
    }
}