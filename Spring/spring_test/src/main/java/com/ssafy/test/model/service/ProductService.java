package com.ssafy.test.model.service;

import java.util.List;

import com.ssafy.test.model.ProductDto;

public interface ProductService {
	public void regist(ProductDto productDto)throws Exception;
	
	List<ProductDto> list() throws Exception; 
}
