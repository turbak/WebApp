package ru.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.spring.entity.Profile;
import ru.spring.service.ProfileService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	private ProfileService profileService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getIndex(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView modelAndView = new ModelAndView();
		String username = (String)session.getAttribute("user");

		if (username == null) {
			modelAndView.addObject("profile", new Profile());
			modelAndView.setViewName("login");
			return modelAndView;
		}
		Profile profile = profileService.getProfileByLogin(username);
		modelAndView.addObject("profile", profile);
		modelAndView.setViewName("index");
		return modelAndView;
	}
}
