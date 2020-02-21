package ru.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.test.models.Login;
import ru.test.models.User;
import ru.test.service.UserAuth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/")
public class IndexController {
	@Autowired
	UserAuth userAuthImpl;

	@RequestMapping(method = RequestMethod.GET)
	public String getIndex(HttpServletRequest request, ModelMap modelMap) {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			User user = userAuthImpl.getUser((String)session.getAttribute("user"));
			modelMap.addAttribute("user", user.getFirstName() + " " + user.getLastName());
			modelMap.addAttribute("exit", "<a href=\"exit\">Exit</a>");
			return "index";
		}
		Login login = new Login();
		modelMap.addAttribute("userForm", login);
		return "login";
	}
}
