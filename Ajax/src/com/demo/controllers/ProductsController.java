package com.demo.controllers;

import javax.jws.WebParam.Mode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.models.ProductsModel;

@Controller
@RequestMapping("/products")
public class ProductsController {

	@RequestMapping(name = "/products", method = RequestMethod.GET)
	public ModelAndView laodProducts() {
		ModelAndView mav = new ModelAndView("products");

		ProductsModel pm = new ProductsModel();
		mav.addObject("allProducts", pm.getAllProducts());

		return mav;

	}

}
