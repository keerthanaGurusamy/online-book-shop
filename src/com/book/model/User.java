package com.book.model;

import java.util.Objects;

public class User {

	private String name;
	private long phoneNo;
	private String address;
	private String email_id;
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, long phoneNo, String address, String email_id, String password) {
		super();
		this.name = name;
		this.phoneNo = phoneNo;
		this.address = address;
		this.email_id = email_id;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", phoneNo=" + phoneNo + ", address=" + address + ", email_id=" + email_id
				+ ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, email_id, name, password, phoneNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(address, other.address) && Objects.equals(email_id, other.email_id)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& phoneNo == other.phoneNo;
	}

}
