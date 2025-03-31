package com.dolaicorp.accountbuddy.app.client.dto;

import java.util.ArrayList;
import java.util.List;

import com.dolaicorp.accountbuddy.app.model.Product;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ProductDto {

	private List<Product> productList = new ArrayList<>();
}
