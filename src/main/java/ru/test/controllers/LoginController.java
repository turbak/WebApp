package ru.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.test.models.Login;
import ru.test.models.User;
import ru.test.service.UserAuth;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	@Autowired
	UserAuth userAuthImpl;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getLogin(HttpServletRequest request) {
	/*	HttpSession session = request.getSession(false);
		if (session == null)
			return "index";*/
		ModelAndView model = new ModelAndView("login");
		Login login = new Login();
		model.addObject("userForm", login);
		return model;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processLogin(@ModelAttribute("userForm") Login login, HttpServletRequest request, ModelMap modelMap) {
		if (userAuthImpl.isValid(login)) {
			System.out.println("Hello " + login.getName());
			request.getSession().setAttribute("user", login.getName());
			User user = userAuthImpl.getUser(login.getName());
			modelMap.addAttribute("user", user.getFirstName() + " " + user.getLastName());
			return "index";
		}
		else {
			System.out.println("Wrong username or password");
			request.setAttribute("message", "Wrong username or password");
			return "login";
		}
	}
}
