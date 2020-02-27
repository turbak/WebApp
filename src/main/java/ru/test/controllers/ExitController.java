package ru.test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.test.entity.Profile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/exit")
public class ExitController {
	@RequestMapping(method = RequestMethod.GET)
	public String getExit(HttpServletRequest request, ModelMap model) {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		session.invalidate();
		model.addAttribute("userForm", new Profile());
		return "redirect:login";
	}
}
