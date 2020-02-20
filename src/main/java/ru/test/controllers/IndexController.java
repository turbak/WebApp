package ru.test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.test.models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/")
public class IndexController {

	@RequestMapping(method = RequestMethod.GET)
	public String getIndex(HttpServletRequest request, ModelMap modelMap) {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			modelMap.addAttribute("user", session.getAttribute("user"));
			modelMap.addAttribute("exit", "<a href=\"exit\">Exit</a>");
			return "index";
		}
		User userForm = new User();
		modelMap.addAttribute("userForm", userForm);
		return "login";
	}
}
