package com.onlinebookshop.model;

import java.util.Objects;

public class AuthorDetails {

	private String name;
	private String email_id;
	private String book_id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public AuthorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AuthorDetails(String name, String email_id, String book_id) {
		super();
		this.name = name;
		this.email_id = email_id;
		this.book_id = book_id;
	}
	@Override
	public String toString() {
		return "AuthorDetails [name=" + name + ", email_id=" + email_id + ", book_id=" + book_id + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(book_id, email_id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthorDetails other = (AuthorDetails) obj;
		return Objects.equals(book_id, other.book_id) && Objects.equals(email_id, other.email_id)
				&& Objects.equals(name, other.name);
	}
	
}
