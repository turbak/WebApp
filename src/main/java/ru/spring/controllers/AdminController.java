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
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private ProfileService profileService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAdmin(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession();
		String admin = (String) session.getAttribute("user");
		Profile adminProfile = profileService.getProfileByLogin(admin);

		if (adminProfile == null)
			modelAndView.setViewName("redirect:/index");
		else {
			List<Profile> profiles = profileService.getAll();
			modelAndView.addObject("profiles", profiles);
			modelAndView.setViewName("admin");
		}
		return modelAndView;
	}
}
