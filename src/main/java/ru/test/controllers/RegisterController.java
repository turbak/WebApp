package ru.test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.test.entity.Profile;
import ru.test.entity.Referrer;
import ru.test.service.ProfileService;
import ru.test.service.ReferrerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class RegisterController {
	private final ProfileService profileService;
	private final ReferrerService referrerService;

	public RegisterController(ProfileService profileService, ReferrerService referrerService) {
		this.profileService = profileService;
		this.referrerService = referrerService;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView getRegister() {
		ModelAndView map = new ModelAndView("register");

		map.addObject("profile", new Profile());
		map.addObject("referrers", referrerService.getAll());
		return map;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView postRegister(@ModelAttribute("profile") Profile profile, HttpServletRequest request) {
		ModelAndView map = new ModelAndView("index");
		if (profile.getReferrer().getId() == null)
			profile.setReferrer(null);
		Profile register = profileService.addProfile(profile);
		HttpSession session = request.getSession();

		map.addObject("profile", register);
		session.setAttribute("user", register.getLogin());
		return map;
	}

	@RequestMapping(value = "/register/referrer", method = RequestMethod.GET)
	public ModelAndView getRefRegister() {
		ModelAndView modelAndView = new ModelAndView("referrer");
		modelAndView.addObject("referrer", new Referrer());
		return modelAndView;
	}

	@RequestMapping(value = "/register/referrer", method = RequestMethod.POST)
	public ModelAndView postRefRegister(@ModelAttribute("referrer") Referrer referrer) {
		ModelAndView modelAndView = new ModelAndView("redirect:/");
		referrerService.addReferrer(referrer);
		return modelAndView;
	}
}
