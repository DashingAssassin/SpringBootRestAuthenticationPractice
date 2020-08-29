package com.docker.springauth.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.docker.springauth.model.User;

@Controller
public class LoginController {

	@ModelAttribute
	public void getUser(Model model) {
		User user = new User(null, null);
		model.addAttribute(user);
	}

	@GetMapping(value = { "/" })
	public String getLoginPage() {
		return "login";
	}

	@PostMapping(value = { "/homePage" })
	public String getHomePage(Model model, ModelAndView view, ModelMap map, HttpServletRequest request) {
		System.out.println("All Model Params" + model.toString());
		System.out.println("All Model Params" + model.asMap().keySet().toString());
		System.out.println("All ModelAndView Params" + view.getModelMap().toString());
		System.out.println("All ModelAndView Params" + view.getModelMap().keySet().toString());
		System.out.println("All ModelMap Params" + map.toString());
		System.out.println("All ModelMap Params" + map.keySet().toString());
		System.out.println("All request Params" + request.getParameterMap());
		return "homePage";
	}
}
