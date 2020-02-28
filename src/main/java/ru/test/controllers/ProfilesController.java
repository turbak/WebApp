package ru.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.test.entity.Profile;
import ru.test.entity.Referrer;
import ru.test.service.ProfileService;
import ru.test.service.ReferrerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProfilesController {

	@Autowired
	private ProfileService profileService;
	@Autowired
	private ReferrerService referrerService;

	@RequestMapping(value = "/profiles", method = RequestMethod.GET)
	public ModelAndView getProfiles() {
		ModelAndView modelAndView = new ModelAndView("profiles");
		List<Profile> profiles = profileService.getAll();
		if (profiles.size() == 0)
			modelAndView.addObject("message", "No profiles registred");
		else {
			modelAndView.addObject("profiles", profiles);
		}
		return modelAndView;
	}

	@RequestMapping(value = "/profiles/{profileName}", method = RequestMethod.GET)
	public ModelAndView getProfile(@PathVariable String profileName) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("profileName", profileName);
		Profile profile = profileService.getProfileByLogin(profileName);
		Referrer referrer = profile.getReferrer();
		if (referrer.getRef_name() == null)
			referrer.setRef_name("None");
		modelAndView.addObject("referrer", referrer);
		modelAndView.addObject("profile", profile);
		modelAndView.setViewName("profile");
		return modelAndView;
	}

	@RequestMapping(value = "/delete/{profileName}", method = RequestMethod.GET)
	public String deleteProfile(@PathVariable String profileName) {
		profileService.deleteProfile(profileName);
		return "redirect:/admin";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView postProfileUpdate(@ModelAttribute Profile profile, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("index");
		HttpSession session = request.getSession();
		String login = (String) session.getAttribute("user");
		profile = profileService.updateProfile(profile.getName(), profile.getSurname(), login);
		modelAndView.addObject("profile", profile);

		return modelAndView;
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView getUpdate(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("modif");
		HttpSession session = request.getSession();
		modelAndView.addObject("username", session.getAttribute("user"));
		modelAndView.addObject("profile", new Profile());
		return modelAndView;
	}
}
