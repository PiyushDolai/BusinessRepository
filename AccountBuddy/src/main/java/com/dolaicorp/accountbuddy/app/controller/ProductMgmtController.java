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

@Controller
public class ProductMgmtController {
	
	@Autowired
	CommonService commonService;
	
	@GetMapping("/productMgmt")
	public String getProductManagementPage() {
		return "product/prodMgmtHome";
	}
	
	@GetMapping("/addProducts")
	public String showAddProductsPage(Model model) throws Exception {
		Map<Integer, String> categoryMap = commonService.getProductCategoryMap();

		Product productBean = new Product();
		productBean.setCategoryMap(categoryMap);
		
		model.addAttribute("productBean", productBean);
		return "client/productPage";
	}
	
	@PostMapping("/saveProducts")
	public String saveProducts(@ModelAttribute Product product, Model model) throws Exception {
		
		
		Map<Integer, String> categoryMap = commonService.getProductCategoryMap();
		
		System.out.println(product.toString());
		Product productBean = new Product();
		productBean.setCategoryMap(categoryMap);
		
		model.addAttribute("productBean", productBean);
		return "client/productPage";
	}

}
