package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import myPackageDao.User;
import myPackageDao.UserDao;
import myPackageDao.UserDaoImpl;

import java.io.IOException;


public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            String username = (String) session.getAttribute("username");
            String email = request.getParameter("email");

            UserDao userDao = new UserDaoImpl();
            boolean isProfileUpdated = userDao.updateUserProfile(username, email);

            if (isProfileUpdated) {
                response.sendRedirect("EditProfileSuccess.jsp");
            } else {
                response.sendRedirect("EditProfileError.jsp"); 
            }
        } else {
            response.sendRedirect("signin.html");
        }
    }
}