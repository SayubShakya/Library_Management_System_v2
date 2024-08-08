  package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dao.StudentDAO;
import dao.StudentDAOImp;
import dto.Student;

public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	 String name = request.getParameter("name");
	         String email = request.getParameter("email");
	         String course = request.getParameter("course");
	         String phoneno = request.getParameter("phoneno");
	         int sid = Integer.parseInt(request.getParameter("sid"));

	         Student std = new Student();
	         std.setSname(name);
	         std.setScourse(course);
	         std.setSemail(email);
	         std.setSid(sid);
	         std.setSphone(phoneno);

	         StudentDAO studentDAO = new StudentDAOImp();
	         String status = studentDAO.save(std);

	         HttpSession session = request.getSession();
	         session.setAttribute("stdstatus", status);
	         response.sendRedirect("addstudent.jsp");
	     }
	 }