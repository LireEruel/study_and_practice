package com.ssafy.sample.product.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.sample.product.ProductDto;
import com.ssafy.sample.product.dao.ProductDao;
import com.ssafy.sample.product.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {
	
	private static ProductService productService = new ProductServiceImpl();
	private ProductDao productDao;
	
	private ProductServiceImpl() {
		productDao = ProductDaoImpl.getProductDao();
	}
	
	public static ProductService getProductService() {
		return productService;
	}

	@Override
	public List<ProductDto> productList() throws SQLException {
		return productDao.productList();
	}

	@Override
	public ProductDto getProductInfo(String code) throws SQLException {
		return productDao.getProductInfo(code);
	}

	@Override
	public void addProduct(ProductDto productDto) throws SQLException {
		productDao.addProduct(productDto);
	}

	@Override
	public void deleteProduct(String code) throws SQLException {
		productDao.deleteProduct(code);
	}

	@Override
	public void updateProduct(ProductDto productDto) throws SQLException {
		productDao.updateProduct(productDto);
	}

}
