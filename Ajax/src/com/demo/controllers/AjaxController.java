package com.demo.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.models.ProductsModel;

@Controller
public class AjaxController {
	
	@RequestMapping(value="/deleteProduct" , method=RequestMethod.POST)
	@ResponseBody
	public String deleteProduct(HttpServletRequest request)
	{
		String productId = request.getParameter("productId");
		ProductsModel prm = new ProductsModel();
		boolean flag = prm.deleteProductById(productId);
		if (flag)
		{
			return "Product deleted successfully ...";
		}
		else 
		{
			return "Please read the log file...";
		}
	}

}
