package ru.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.test.entity.Profile;
import ru.test.service.ProfileService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private ProfileService profileService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getLogin() {
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("profile", new Profile());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView postLogin(@ModelAttribute("profile") Profile profile, HttpServletRequest request) {
		Profile login = profileService.getProfileByLoginAndPassword(profile.getLogin(), profile.getPassword());
		ModelAndView modelAndView = new ModelAndView();
		if (login == null) {
			modelAndView.addObject("message", "wrong username or password");
			modelAndView.addObject("profile", new Profile());
			modelAndView.setViewName("login");
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("user", login.getLogin());
			modelAndView.addObject("profile", login);
			modelAndView.setViewName("index");
		}
		return modelAndView;
	}
}
