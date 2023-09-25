package com.ssafy.sample.product.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.sample.product.ProductDto;
import com.ssafy.sample.product.service.ProductService;
import com.ssafy.sample.product.service.ProductServiceImpl;

@WebServlet("/product")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductService productService;

	public void init(ServletConfig config) throws ServletException {
		productService = ProductServiceImpl.getProductService();
	}

	// get으로 전달된 요청 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전달된 action에 따라 요청 처리
		String action = request.getParameter("action");
		
		String path = "";
		if ("list".equals(action)) {
			path = list(request, response);
			forward(request, response, path);
		} else if ("view".equals(action)) {
			path = view(request, response);
			forward(request, response, path);
		} else if ("mvregist".equals(action)) {
			path = "/product/regist.jsp";
			redirect(request, response, path);
		} else if ("regist".equals(action)) {
			path = regist(request, response);
			redirect(request, response, path);
		} else if ("mvmodify".equals(action)) {
			path = mvModify(request, response);
			forward(request, response, path);
		} else if ("modify".equals(action)) {
			path = modify(request, response);
			redirect(request, response, path);
		} else if ("delete".equals(action)) {
			path = delete(request, response);
			redirect(request, response, path);
		} else {
			redirect(request, response, path);
		}
	}

	// post로 전달된 요청 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	
	// forward로 페이지 이동 -> url이 변경되지 않고 그대로 유지됨
	private void forward(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	// redirect로 페이지 이동 -> url이 변경되고, request와 response도 새로운 객체가 됨
	private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		response.sendRedirect(request.getContextPath() + path);
	}
	
	// 상품 목록 불러오는 함수
	private String list(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<ProductDto> list = productService.productList();
			// list는 forward로 이동하니까 request에 값을 저장해두고 사용할 수 있음
			request.setAttribute("pcount", list.size());
			request.setAttribute("products", list);
			return "/product/list.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			return "/index.jsp";
		}
	}

	// 한 상품 페이지 보는 함수
	private String view(HttpServletRequest request, HttpServletResponse response) {
		// view 페이지 이동시 쿼리스트링으로 같이 전달된 code를 읽어와 상품 조회
		String code = request.getParameter("code");
		try {
			ProductDto productDto = productService.getProductInfo(code);
			request.setAttribute("product", productDto);
			return "/product/view.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
			return "/index.jsp";
		}
	}

	// 수정 페이지로 이동하기 전, 수정 페이지에 띄워줄 상품을 조회해서 값을 함께 넘겨줌
	private String mvModify(HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("code");
		try {
			ProductDto productDto = productService.getProductInfo(code);
			request.setAttribute("product", productDto);
			return "/product/modify.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
			return "/index.jsp";
		}
	}

	// 수정 페이지에서 새로운 값을 받아 정보 수정
	private String modify(HttpServletRequest request, HttpServletResponse response) {
		ProductDto productDto = new ProductDto();
		productDto.setCode(request.getParameter("code"));
		productDto.setModel(request.getParameter("model"));
		productDto.setPrice(Integer.parseInt(request.getParameter("price")));
		try {
			productService.updateProduct(productDto);
			// 수정 후 view 페이지로 이동
			return "/product?action=view&code=" + productDto.getCode();
		} catch (SQLException e) {
			e.printStackTrace();
			return "/index.jsp";
		}
	}

	// 상품 등록 함수
	private String regist(HttpServletRequest request, HttpServletResponse response) {
		ProductDto productDto = new ProductDto();
		productDto.setCode(request.getParameter("code"));
		productDto.setModel(request.getParameter("model"));
		productDto.setPrice(Integer.parseInt(request.getParameter("price")));
		try {
			productService.addProduct(productDto);
			// 상품 등록 후 view 페이지로 이동
			return "/product?action=view&code=" + productDto.getCode();
		} catch (SQLException e) {
			e.printStackTrace();
			return "/index.jsp";
		}
	}
	
	// 상품 삭제 함수
	private String delete(HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("code");
		try {
			productService.deleteProduct(code);
			return "/product?action=list";
		} catch (SQLException e) {
			e.printStackTrace();
			return "/index.jsp";
		}
	}

}
