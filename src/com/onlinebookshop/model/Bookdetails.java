package com.onlinebookshop.model;

import java.util.Objects;

public class Bookdetails {

	private String category;
	private String description;
	private int publisher_id;
	private String book_title;
	private String book_code;
	private int price;
	private String publish_date;
	private String condition;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPublisher_id() {
		return publisher_id;
	}
	public void setPublisher_id(int publisher_id) {
		this.publisher_id = publisher_id;
	}
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public String getBook_code() {
		return book_code;
	}
	public void setBook_code(String book_code) {
		this.book_code = book_code;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(String publish_date) {
		this.publish_date = publish_date;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public Bookdetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bookdetails(String category, String description, int publisher_id, String book_title, String book_code,
			int price, String publish_date, String condition) {
		super();
		this.category = category;
		this.description = description;
		this.publisher_id = publisher_id;
		this.book_title = book_title;
		this.book_code = book_code;
		this.price = price;
		this.publish_date = publish_date;
		this.condition = condition;
	}
	@Override
	public String toString() {
		return "Products [category=" + category + ", description=" + description + ", publisher_id=" + publisher_id
				+ ", book_title=" + book_title + ", book_code=" + book_code + ", price=" + price + ", publish_date="
				+ publish_date + ", condition=" + condition + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(book_code, book_title, category, condition, description, price, publish_date, publisher_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bookdetails other = (Bookdetails) obj;
		return Objects.equals(book_code, other.book_code) && Objects.equals(book_title, other.book_title)
				&& Objects.equals(category, other.category) && Objects.equals(condition, other.condition)
				&& Objects.equals(description, other.description) && price == other.price
				&& Objects.equals(publish_date, other.publish_date) && publisher_id == other.publisher_id;
	}
	
}
