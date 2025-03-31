package com.dolaicorp.accountbuddy.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dolaicorp.accountbuddy.app.model.Category;

@Repository
public class CommonDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Category> getProductCategoryList() throws Exception{
		List<Category> categoryList = null;
		categoryList = jdbcTemplate.query("select * from ab_category_master where acm_category_status='A' order by acm_category_name", 
				(rs, rowNum) -> new Category(rs.getInt("acm_pk"), rs.getString("acm_category_name"), rs.getString("acm_category_description")));
		return categoryList;
	}
}
