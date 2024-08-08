package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import dao.StudentDAOImp;
import dto.Student;

public class SearchStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Receive search input
	        String strSearch = request.getParameter("txtSearch");

	        // Assuming search by ID (numeric) or by name (string)
	        List<Student> students;
	        if (strSearch != null && !strSearch.isEmpty()) {
	            try {
	                int id = Integer.parseInt(strSearch);
	                students = List.of(new StudentDAOImp().findById(id));
	            } catch (NumberFormatException e) {
	                students = new StudentDAOImp().findAllByName(strSearch);
	            }
	        } else {
	            students = new StudentDAOImp().findAll();
	        }
	        
	        request.setAttribute("students", students);
	        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Display.jsp");
	        requestDispatcher.forward(request, response);
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doGet(request, response);
	    }
	}