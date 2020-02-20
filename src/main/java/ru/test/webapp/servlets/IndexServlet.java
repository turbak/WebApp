package ru.test.webapp.servlets;

import ru.test.webapp.db.Login;
import ru.test.webapp.entity.Person;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class IndexServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		Cookie[] cookies = req.getCookies();
		if (session.getAttribute("user") == null && cookies != null && cookies.length == 2) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("user")) {
					session.setAttribute("user", cookie.getValue());
					break;
				}
			}
		}
		if (session.getAttribute("user") == null) {
			resp.sendRedirect("login.html");
		}
		else {
			resp.setCharacterEncoding("UTF-8");
			String username = (String) session.getAttribute("user");
			Person person = Login.getPerson(username);
			if (person == null)
				resp.sendRedirect("exit");
			PrintWriter writer = resp.getWriter();
			writer.println("Добро пожаловать, " + person.getSurname() + ". [" + person.getName().substring(0, 1) + "].!");
			writer.println("<a href=\"exit\">Exit");
		}
	}
}
