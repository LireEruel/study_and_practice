package com.ssafy.ws.model.dto;

public class Comment {
	public String isbn;
	public String id;
	public String rating;
	public String comment;
	
	public Comment(String isbn, String id, String rating, String comment) {
		super();
		this.isbn = isbn;
		this.id = id;
		this.rating = rating;
		this.comment = comment;
	}
	
	public Comment() {
		super();
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
