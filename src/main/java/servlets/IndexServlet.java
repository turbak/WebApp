package servlets;

import Entity.Person;
import db.Login;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class IndexServlet extends HttpServlet {
	static HashMap<String, Person> map;

	@Override
	public void init() throws ServletException {
		super.init();
		map = new HashMap<String, Person>();
		Person person = new Person("Ivan", "Shcherbina");
		map.put("user", person);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		Cookie[] cookies = req.getCookies();
		if (session.getAttribute("user") == null && cookies != null && cookies.length == 2)
			session.setAttribute("user", cookies[0].getValue());
		if (session.getAttribute("user") == null) {
			resp.sendRedirect("login.html");
		}
		else {
			String username = (String) session.getAttribute("user");
			Person person = Login.getPerson(username);
			PrintWriter writer = resp.getWriter();
			writer.println("Welcome, " + person.getSurname() + ". [" + person.getName().substring(0, 1) + "].!");
			writer.println("<a href=\"exit\">Exit");
		}
		resp.setCharacterEncoding("UTF-8");
	}
}
