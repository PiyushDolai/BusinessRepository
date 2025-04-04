package com.dolaicorp.accountbuddy.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Category {

	private Integer id;
	private String categoryName;
	private String categoryDescription;
	private String categoryStatus;
	private String createdOn;
	private String updatedOn;
	
	public Category() {}
	
	public Category(Integer id, String categoryName) {
		super();
		this.id = id;
		this.categoryName = categoryName;
	}
}
