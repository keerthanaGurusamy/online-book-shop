package com.onlinebookshop.model;

import java.util.Objects;

public class OrderDetails {

	private int book_id;
	private int cus_id;
	private int quantity;
	private double total_cost;
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public int getCus_id() {
		return cus_id;
	}
	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotal_cost() {
		return total_cost;
	}
	public void setTotal_cost(double total_cost) {
		this.total_cost = total_cost;
	}
	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDetails(int book_id, int cus_id, int quantity, double total_cost) {
		super();
		this.book_id = book_id;
		this.cus_id = cus_id;
		this.quantity = quantity;
		this.total_cost = total_cost;
	}
	@Override
	public String toString() {
		return "Cart [book_id=" + book_id + ", cus_id=" + cus_id + ", quantity=" + quantity + ", total_cost="
				+ total_cost + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(book_id, cus_id, quantity, total_cost);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetails other = (OrderDetails) obj;
		return book_id == other.book_id && cus_id == other.cus_id && quantity == other.quantity
				&& Double.doubleToLongBits(total_cost) == Double.doubleToLongBits(other.total_cost);
	}
	
}