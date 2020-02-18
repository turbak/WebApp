package ru.test.webapp.servlets;

import ru.test.webapp.db.Login;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String passwd = req.getParameter("password");
		String name = req.getParameter("name");
		String surname = req.getParameter("surname");

		if (Login.register(login, passwd, name, surname)) {
			HttpSession session = req.getSession();
			session.setAttribute("user", login);
			Cookie cookie = new Cookie("user", login);
			cookie.setMaxAge(700);
			resp.addCookie(cookie);
			resp.sendRedirect("index");
		}
		else
			resp.sendRedirect("register.jsp");
	}
}
