package com.ssafy.ws.model.dto;

public class Book {
	public String isbn;
	public String title;
	public String author;
	public int price;
	public String content;
	public String img;
	public Book(String isbn, String title, String author, int price, String content, String img) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
		this.content = content;
		this.img = img;
	}
	public Book() {
		super();
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getIsbn() {
		return isbn;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public int getPrice() {
		return price;
	}
	public String getContent() {
		return content;
	}
	public String getImg() {
		return img;
	}
	
}
