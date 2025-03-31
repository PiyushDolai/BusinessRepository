package com.dolaicorp.accountbuddy.app.model;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product {
	
	private int productPk;
	private String serialNumber;
	private String productName;
	private int categoryFk;
	private String productSize;
	private String prodStatus;
	private String createdDate;
	private String updatedDate;
	private Map<Integer, String> categoryMap;

}
