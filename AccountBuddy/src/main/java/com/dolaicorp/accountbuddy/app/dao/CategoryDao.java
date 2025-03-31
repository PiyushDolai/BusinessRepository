package com.dolaicorp.accountbuddy.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dolaicorp.accountbuddy.app.model.Category;

@Repository
public class CategoryDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Category> getProductCategoryDtlsList() throws Exception {
		List<Category> categoryList = null;
		categoryList = jdbcTemplate.query("select * from ab_category_master where acm_category_status='A' order by acm_category_name", 
				(rs, rowNum) -> new Category(rs.getInt("acm_pk"), rs.getString("acm_category_name"), rs.getString("acm_category_description"),
						rs.getString("acm_category_status"), rs.getString("acm_created_on"), rs.getString("acm_updated_on")));
		return categoryList;
	}
	
	public int insertCategoryDetails(Category category) throws Exception {
		return jdbcTemplate.update("'insert into accountbuddy.ab_category_master(acm_pk, acm_category_name, acm_category_description, acm_category_status, acm_created_on, acm_created_by, acm_updated_on, acm_updated_by)\n"
				+ "values(nextval('ab_category_master_pk'), ?, ?, 'A', now(), 'Application', null, null)'",
				category.getCategoryName(), category.getCategoryDescription());
	}
	
	public Category getCategoryDtls(int categoryPk) throws Exception {
		Category category = null;
		category = (Category) jdbcTemplate.query("select * from ab_category_master where acm_pk =?",
				(rs, rowNum) -> new Category(rs.getInt("acm_pk"), rs.getString("acm_category_name"), rs.getString("acm_category_description"),
						rs.getString("acm_category_status"), rs.getString("acm_created_on"), rs.getString("acm_updated_on")), categoryPk);
		return category;
	}
	
	public int updateCategoryDtls(Category categoryDtls) throws Exception {
		return jdbcTemplate.update("update ab_category_master set acm_category_name=?, acm_category_description=?, acm_category_status=?, acm_updated_on=now() where acm_pk=?",
				categoryDtls.getCategoryName(), categoryDtls.getCategoryDescription(), categoryDtls.getCategoryStatus(),
				categoryDtls.getId());
	}

}
