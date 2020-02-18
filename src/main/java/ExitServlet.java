import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class ExitServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		String username = (String) session.getAttribute("user");

		if (cookies.length == 3) {
			Cookie cookie = new Cookie("user", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		session.invalidate();

		request.getRequestDispatcher("index").forward(request, response);
	}
}
