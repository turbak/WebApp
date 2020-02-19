package ru.test.webapp.servlets;

import ru.test.webapp.entity.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class IndexServlet extends HttpServlet {
	Map<String, Person> bd;

	@Override
	public void init() throws ServletException {
		super.init();
		bd = new HashMap<>();
		Person person = new Person();
		person.setName("Иван");
		person.setSurname("Щербина");
		bd.put("user", person);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		/*Cookie[] cookies = req.getCookies();
		if (session.getAttribute("user") == null && cookies != null && cookies.length != 0) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("user")) {
					session.setAttribute("user", cookie.getValue());
					break;
				}
			}
		}*/
		if (session.getAttribute("user") == null) {
			resp.sendRedirect("login.jsp");
		}
		else {
			resp.setCharacterEncoding("UTF-8");
			String username = (String) session.getAttribute("user");
			Person person = bd.get(username);
			if (person == null)
				resp.sendRedirect("exit");
			PrintWriter writer = resp.getWriter();
			writer.println("Добро пожаловать, " + person.getSurname() + ". [" + person.getName().substring(0, 1) + "].!");
			writer.println("<a href=\"exit\">Exit");
		}
	}
}
