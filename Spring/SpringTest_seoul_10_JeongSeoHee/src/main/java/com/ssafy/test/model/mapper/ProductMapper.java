package com.ssafy.test.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.test.model.ProductDto;

@Mapper
public interface ProductMapper {
	
	int regist(ProductDto productDto) throws Exception;
	List<ProductDto> selectAll() throws Exception;
	ProductDto selectByCode(String code) throws Exception;
	int deleteByCode(String code) throws Exception;
}
