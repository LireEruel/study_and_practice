package com.ssafy.test.model.service;

import java.util.List;

import com.ssafy.test.model.ProductDto;

public interface ProductService {
	int regist(ProductDto productDto) throws Exception;	//상품 등록
	List<ProductDto> selectAll() throws Exception;	//상품 목록 조회
	ProductDto selectByCode(String code) throws Exception;	//상품 조회
	int deleteByCode(String code) throws Exception;	//상품 삭제
}
