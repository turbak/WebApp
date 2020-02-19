package ru.test.webapp.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class LoginServlet extends HttpServlet {
	Map<String, String> bd;

	@Override
	public void init() throws ServletException {
		super.init();
		bd = new HashMap<>();
		bd.put("user", "qwerty");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

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
		if (bd.get(login).equals(password)) {
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
