package myPackageServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("chkSave");

        boolean isValidUser = false;

        if ("admin".equals(username) && "admin".equals(password)) {
            isValidUser = true;
        }

        if (isValidUser) {
            request.getSession().setAttribute("username", username);

            if ("yes".equals(remember)) {
                Cookie userCookie = new Cookie("user", username);
                userCookie.setMaxAge(60 * 60 * 24); // 1 day
                response.addCookie(userCookie);
            } else {
                Cookie userCookie = new Cookie("user", "");
                userCookie.setMaxAge(0);
                response.addCookie(userCookie);
            }

            response.sendRedirect("libMain.jsp");
        } else {
            response.sendRedirect("login.jsp?error=true");
        }
    }
}