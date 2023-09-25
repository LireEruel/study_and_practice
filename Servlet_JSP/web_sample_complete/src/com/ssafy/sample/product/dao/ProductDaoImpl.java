package com.ssafy.sample.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.sample.product.ProductDto;
import com.ssafy.sample.util.DBUtil;

public class ProductDaoImpl implements ProductDao {
	
	private static ProductDao productDao = new ProductDaoImpl();
	private DBUtil dbUtil;
	
	private ProductDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}
	
	public static ProductDao getProductDao() {
		return productDao;
	}

	@Override
	public List<ProductDto> productList() throws SQLException {
		List<ProductDto> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder("select code, model, price from product");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductDto dto = new ProductDto();
				dto.setCode(rs.getString("code"));
				dto.setModel(rs.getString("model"));
				dto.setPrice(rs.getInt("price"));
				list.add(dto);
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public ProductDto getProductInfo(String code) throws SQLException {
		ProductDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder("select code, model, price from product \n");
			sql.append("where code = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new ProductDto();
				dto.setCode(rs.getString("code"));
				dto.setModel(rs.getString("model"));
				dto.setPrice(rs.getInt("price"));
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return dto;
	}

	@Override
	public void addProduct(ProductDto productDto) throws SQLException {
		System.out.println(productDto);
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder("insert into product (code, model, price) \n");
			sql.append("values (?, ?, ?)");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, productDto.getCode());
			pstmt.setString(2, productDto.getModel());
			pstmt.setInt(3, productDto.getPrice());
			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}

	@Override
	public void deleteProduct(String code) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder("delete from product \n");
			sql.append("where code = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, code);
			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}

	@Override
	public void updateProduct(ProductDto productDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder("update product \n");
			sql.append("set model = ? \n");
			sql.append(", price = ? \n");
			sql.append("where code = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, productDto.getModel());
			pstmt.setInt(2, productDto.getPrice());
			pstmt.setString(3, productDto.getCode());
			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}
	
}
