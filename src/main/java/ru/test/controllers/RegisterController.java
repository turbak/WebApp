package ru.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.test.models.User;
import ru.test.service.UserAuth;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	UserAuth userAuthImpl;

	@RequestMapping(method = RequestMethod.GET)
	public String getRegister(ModelMap modelMap) {
		modelMap.addAttribute("user", new User());
		return "register";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processRegister(@ModelAttribute("userForm") User user, ModelMap modelMap) {
		if (userAuthImpl.registerUser(user) != null) {
			modelMap.addAttribute("user", user.getFirstName() + " " + user.getLastName());
			return "index";
		}
		else {
			modelMap.addAttribute("message", "Username is taken");
			modelMap.addAttribute("user", new User());
			return "register";
		}
	}
}
