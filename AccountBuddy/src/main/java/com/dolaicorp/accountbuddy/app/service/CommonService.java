package com.dolaicorp.accountbuddy.app.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class CommonService {

	public Map<Integer, String> getProductCategoryMap(){
		Map<Integer, String> categoryMap = new HashMap<>();
		categoryMap.put(1, "Detergent");
		categoryMap.put(2, "Soap");
		categoryMap.put(3, "Chanachur");
		categoryMap.put(4, "Biscuit");
		categoryMap.put(5, "Snacks");
		
		return categoryMap;
	} 
}
