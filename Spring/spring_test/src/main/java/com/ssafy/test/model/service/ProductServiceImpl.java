package com.ssafy.test.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.test.model.ProductDto;
import com.ssafy.test.model.mapper.MemberMapper;

@Service
public class ProductServiceImpl implements ProductService{

	private final MemberMapper memberMapper;
	
	public ProductServiceImpl(MemberMapper memberMapper) {
		super();
		this.memberMapper = memberMapper;
	}

	public void regist(ProductDto productDto)throws Exception {
		memberMapper.regist(productDto);
	} ;
	
	public List<ProductDto> list() throws Exception{
		return memberMapper.list();
	}; 
}
