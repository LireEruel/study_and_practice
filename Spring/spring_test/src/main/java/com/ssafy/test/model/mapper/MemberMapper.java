package com.ssafy.test.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.test.model.ProductDto;

@Mapper
public interface MemberMapper {
	void regist(ProductDto productDto) throws Exception;
	
	List<ProductDto> list() throws Exception; 
}

