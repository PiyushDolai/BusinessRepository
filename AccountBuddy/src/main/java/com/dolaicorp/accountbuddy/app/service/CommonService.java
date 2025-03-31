package com.dolaicorp.accountbuddy.app.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dolaicorp.accountbuddy.app.dao.CategoryDao;
import com.dolaicorp.accountbuddy.app.model.Category;

@Service
public class CommonService {

	@Autowired
	CategoryDao categoryDao;
	
	public Map<Integer, String> getProductCategoryMap() throws Exception{
		List<Category> categoryList = categoryDao.getProductCategoryDtlsList();
		if(!categoryList.isEmpty()) {
			return categoryList.stream().collect(Collectors.toMap(Category::getId, Category::getCategoryName));
		}else {
			return null;
		}
	} 
}
