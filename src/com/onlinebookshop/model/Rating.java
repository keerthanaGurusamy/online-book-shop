package com.onlinebookshop.model;

public class Rating {

	private int id;
	private int cus_id;
	private int book_id;
	private double rating;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCus_id() {
		return cus_id;
	}
	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public Rating(int id, int cus_id, int book_id, double rating) {
		super();
		this.id = id;
		this.cus_id = cus_id;
		this.book_id = book_id;
		this.rating = rating;
	}
	public Rating(int cus_id, int book_id, double rating) {
		super();
		this.cus_id = cus_id;
		this.book_id = book_id;
		this.rating = rating;
	}
	public Rating(int book_id) {
		super();
		
		this.book_id = book_id;
		
	}
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Rating [id=" + id + ", cus_id=" + cus_id + ", book_id=" + book_id + ", rating=" + rating + "]";
	}
	
}
