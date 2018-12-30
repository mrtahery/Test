package com.demo.controllers;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.models.Signup_Model;
import com.demo.pojo.Clients;

@Controller
public class Signup_controller {

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView load_signup() {
		ModelAndView mav = new ModelAndView("signup");
		return mav;
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView doSignupProcess(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("signup");
		String message = null;

//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		
//		System.out.println("username and password are " + username + " , " + password);

		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> data = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				if (data.size() == 7) {
					String username = data.get(0).getString();
					String password = data.get(1).getString();
					String repassword = data.get(2).getString();
					String gender = data.get(3).getString();
					String vehicle = data.get(4).getString();
					String country = data.get(5).getString();

					String image = new File(data.get(6).getName()).getName();

					System.out.println(
							"username and password are " + username + " , " + password + "\n" + "filename is " + image);

					if (password.equals(repassword)) {
						Signup_Model sm = new Signup_Model();
						//message =sm.doSignUp(username, repassword, gender, vehicle, country, image);
						message =sm.doHibernateSignUp( new Clients(username, password, gender, vehicle, country, image));
						
						String path = request.getSession().getServletContext().getRealPath("/") + "//WEB-INF//images//";
						System.out.println("path is :" + path);
						
						data.get(6).write(new File(path + File.separator + image));
						
						

					} else {
						message = "Password doesn't match.. Please try again";
					}
				} else {
					message = "Please fill out all the columns";

				}

			} catch (Exception e) {
				System.err.println(e);
			}

		}
		mav.addObject("status", message);
		return mav;
	}
	
	@RequestMapping(value="/dynamic/{status}" , method=RequestMethod.GET)
	public ModelAndView dynamicDemo(@PathVariable("status") String message)
	{
		ModelAndView mav = new ModelAndView("signup");
		System.out.println("message is " + message);
		return mav;
	}
}
