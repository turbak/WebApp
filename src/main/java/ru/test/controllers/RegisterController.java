package ru.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.test.models.User;
import ru.test.service.UserAuth;
import ru.test.service.UserValidator;

import javax.validation.Valid;
import javax.xml.validation.Validator;

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
	public String processRegister(@Valid @ModelAttribute("userForm") User user, ModelMap modelMap, BindingResult bindingResult) {
		if (!bindingResult.hasErrors()) {
			modelMap.addAttribute("message", "Some fields are empty or username is longer than 12 characters");
			modelMap.addAttribute("user", new User());
			return "register";
		}
		if (userAuthImpl.registerUser(user) == null) {
			modelMap.addAttribute("message", "Username is taken");
			modelMap.addAttribute("user", new User());
			return "register";
		}
		modelMap.addAttribute("user", user.getFirstName() + " " + user.getLastName());
		return "index";
	}
}
