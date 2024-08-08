package myPackageServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import myPackageDao.User;
import myPackageDao.UserDao;
import myPackageDao.UserDaoImpl;

import java.io.IOException;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDao userDao = new UserDaoImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);

		if (userDao.addUser(user)) {
			response.sendRedirect("StudentSignIn.html?registration=success");
		} else {
			response.sendRedirect("StudentSignIn.html?error=1");
		}
	}
}