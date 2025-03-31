package com.dolaicorp.accountbuddy.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dolaicorp.accountbuddy.app.model.Product;
import com.dolaicorp.accountbuddy.app.service.CommonService;

@Controller()
public class RetailBillingController {
	
	@Autowired
	private CommonService commonService;
	
	
	@GetMapping("/billing")
	public String showBillingPage() {
		return "client/billingPage";	
	}
	
	@GetMapping("/addProducts")
	public String showAddProductsPage(Model model) {
		//model.addAttribute("productDto", new ProductDto());
		Map<Integer, String> categoryMap = commonService.getProductCategoryMap();

		Product productBean = new Product();
		productBean.setCategoryMap(categoryMap);
		
		model.addAttribute("productBean", productBean);
		return "client/productPage";
	}
	
	@PostMapping("/saveProducts")
	public String saveProducts(@ModelAttribute Product product, Model model) {
		//System.out.println(productDto.getProductList().get(0).getProductName());
		
		Map<Integer, String> categoryMap = commonService.getProductCategoryMap();
		
		System.out.println(product.toString());
		Product productBean = new Product();
		productBean.setCategoryMap(categoryMap);
		
		model.addAttribute("productBean", productBean);
		return "client/productPage";
	}
}
