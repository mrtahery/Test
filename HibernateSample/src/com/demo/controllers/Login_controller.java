package com.demo.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.models.Login_Model;
import com.demo.pojo.Clients;

@Controller
public class Login_controller {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loadloginpage(HttpServletResponse response,
			@CookieValue(value = "hits", defaultValue = "0") Long hits) {
		ModelAndView mav = new ModelAndView("login");
		System.out.println("Login method has been called");

		hits++;
		Cookie cookie = new Cookie("hits", hits.toString());

		response.addCookie(cookie);
		// cookie.setMaxAge(60);

		Clients clients = new Clients();
		mav.addObject("clients", clients);

		mav.addObject("hits", "You Have visited this page " + hits.toString() + " times so far");

		return mav;

	}
	/*
	 * @RequestMapping(value = "/login", method = RequestMethod.GET) public String
	 * loadloginpage() { return "login"; }
	 */

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String do_login(HttpServletRequest req, Model md, HttpSession session, @Valid Clients clients,
			BindingResult br) {
		try {
			System.out.println("Number of errors are : " + br.getAllErrors().size());

			if (br.getAllErrors().size() > 0) {
				System.out.println("Server side validation occurred");
			} else {

				String username = req.getParameter("username");
				String password = req.getParameter("password");

				System.out.println("username is:" + username + "\n password is : " + password);
				Login_Model lm = new Login_Model();
				//String message = lm.do_login_process(username, password);
				String message = lm.doHibernateLogin(username, password);
				if (message.equals("login success")) {
					session.setAttribute("username", username);
					return "redirect:/myprofile";
				} else {
					md.addAttribute("error_msg", message);
				}
			}
			return "login";
		} catch (Exception e) {
			return "login";
		}
	}

}
