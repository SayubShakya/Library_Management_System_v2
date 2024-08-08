package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import myPackageDao.UserDao;
import myPackageDao.UserDaoImpl;
import myPackageDao.User;
import myPackageDao.file;

import java.io.IOException;


public class ChangePasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao = new UserDaoImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            String username = (String) session.getAttribute("username");
            String oldPassword = request.getParameter("old_password");
            String newPassword = request.getParameter("new_password");

            boolean isPasswordChanged = userDao.changeUserPassword(username, oldPassword, newPassword);

            if (isPasswordChanged) {
                response.sendRedirect("ChangePasswordSuccess.jsp");
            } else {
                response.sendRedirect("errorPage.jsp?error=Password change failed");
            }
        } else {
            response.sendRedirect("signin.html");
        }
    }
}