package com.ssafy.test.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.test.model.ProductDto;
import com.ssafy.test.model.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService{
	
	private final ProductMapper productMapper;

	public ProductServiceImpl(ProductMapper productMapper) {
		super();
		this.productMapper = productMapper;
	}

	@Override
	public int regist(ProductDto productDto) throws Exception {
		
		//중복 검사
		List<ProductDto> list = selectAll();
		for(ProductDto d : list) {
			if(d.getAno().equals(productDto.getAno())) {
				throw new Exception("이미 등록된 이슈입니다");
			}
		}
		return productMapper.regist(productDto);
	}

	@Override
	public List<ProductDto> selectAll() throws Exception {
		return productMapper.selectAll();
	}

	@Override
	public ProductDto selectByCode(String code) throws Exception {
		return productMapper.selectByCode(code);
	}

	@Override
	public int deleteByCode(String code) throws Exception {
		return productMapper.deleteByCode(code);
	}

}
