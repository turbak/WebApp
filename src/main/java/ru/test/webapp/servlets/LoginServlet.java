package ru.test.webapp.servlets;

import ru.test.webapp.db.Login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String login = req.getParameter("login").toLowerCase();
		String password = req.getParameter("password");
		HttpSession session = req.getSession();
		RequestDispatcher dispatcher = req.getRequestDispatcher("/index");
		if (login.isEmpty() || password == null)
		{
			resp.getWriter().write("login or passwd are null");
			dispatcher.include(req, resp);
		}
		PrintWriter writer = resp.getWriter();
		if (Login.login(login, password)) {
			writer.println("login successful");
			session.setAttribute("user", login);
/*			Cookie cookie = new Cookie("user", login);
			cookie.setMaxAge(700);
			resp.addCookie(cookie);*/
			resp.sendRedirect("index");
		}
		else {
			writer.println("login failed");
			resp.sendRedirect("login.html");
		}
		dispatcher.include(req, resp);
	}
}
