package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dao.BookDAOImp;
import dao.IssueBookImp;
import dao.StudentDAOImp;
import dto.Books;
import dto.Student;

public class IssueBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sid = Integer.parseInt(request.getParameter("sid"));
        int bid = Integer.parseInt(request.getParameter("bid"));
        String issuedate = request.getParameter("issuedate");
        String duedate = request.getParameter("duedate");

        String issuestatus = "error";

        IssueBookImp isbook = new IssueBookImp();
        BookDAOImp bk = new BookDAOImp();
        StudentDAOImp student = new StudentDAOImp();
        Student std = null;
        Books book = null;

        book = bk.findById(bid);
        std = student.findById(sid);

        if (book != null && std != null) {
            issuestatus = isbook.issuebook(sid, bid, issuedate, duedate);
        }

        HttpSession session = request.getSession();
        session.setAttribute("issuestatus", issuestatus);
        response.sendRedirect("issuebook.jsp");
    }
}
