package com.ssafy.sample.product.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.sample.product.ProductDto;

public interface ProductService {

	List<ProductDto> productList() throws SQLException;
	ProductDto getProductInfo(String code) throws SQLException;
	void addProduct(ProductDto productDto) throws SQLException;
	void deleteProduct(String code) throws SQLException;
	void updateProduct(ProductDto productDto) throws SQLException;
	
}
