import Entity.Person;

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
		if (session.getAttribute("user") == null && cookies != null && cookies.length == 3)
			session.setAttribute("user", cookies[0].getValue());
		if (session.getAttribute("user") == null) {
			resp.sendRedirect("login.html");
		}
		else {
			String username = (String) session.getAttribute("user");
			PrintWriter writer = resp.getWriter();
			writer.println("Welcome, " + map.get(username).getSurname() + ". [" + map.get(username).getName().substring(0, 1) + "].!");
			writer.println("<a href=\"exit\">Exit");
		}
		resp.setCharacterEncoding("UTF-8");
	}
}
