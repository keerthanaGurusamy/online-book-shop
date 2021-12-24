package com.onlinebookshop.model;

import java.sql.Date;
import java.util.Objects;

public class OrderDetails {

	private int order_id;
	private int cus_id;
	private int book_id;
	private Date order_date;
	private String status;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
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
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public OrderDetails(int order_id, int cus_id, int book_id, Date order_date, String status) {
		super();
		this.order_id = order_id;
		this.cus_id = cus_id;
		this.book_id = book_id;
		this.order_date = order_date;
		this.status = status;
	}
	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "OrderDetails [order_id=" + order_id + ", cus_id=" + cus_id + ", book_id=" + book_id + ", order_date="
				+ order_date + ", status=" + status + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(book_id, cus_id, order_date, order_id, status);
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
		return book_id == other.book_id && cus_id == other.cus_id && Objects.equals(order_date, other.order_date)
				&& order_id == other.order_id && Objects.equals(status, other.status);
	}

}