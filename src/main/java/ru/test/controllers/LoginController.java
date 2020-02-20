package ru.test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.test.models.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getLogin(HttpServletRequest request) {
	/*	HttpSession session = request.getSession(false);
		if (session == null)
			return "index";*/
		ModelAndView model = new ModelAndView("login");
		User userForm = new User();
		model.addObject("userForm", userForm);
		return model;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processLogin(@ModelAttribute("userForm") User user, HttpServletRequest request) {
		if (user.getName().equals("user") && user.getPassword().equals("qwerty")) {
			System.out.println("Hello " + user.getName());
			request.getSession().setAttribute("user", user.getName());
			return "index";
		}
		else {
			System.out.println("Wrong username or password");
			request.setAttribute("message", "Wrong username or password");
			return "login";
		}
	}
}
