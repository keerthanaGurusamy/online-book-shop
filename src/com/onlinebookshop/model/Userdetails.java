package com.onlinebookshop.model;

import java.util.Objects;

public class Userdetails {

	private String name;
	private long phoneNo;
	private String address;
	private String email_id;
	private String password;
private int cus_id;
private int wallet;
	public int getCus_id() {
	return cus_id;
}

public void setCus_id(int cus_id) {
	this.cus_id = cus_id;
}

public int getWallet() {
	return wallet;
}

public void setWallet(int wallet) {
	this.wallet = wallet;
}

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

	public Userdetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Userdetails(String name, long phoneNo, String address, String email_id, String password) {
		
		this.name = name;
		this.phoneNo = phoneNo;
		this.address = address;
		this.email_id = email_id;
		this.password = password;
	}
	
	

	public Userdetails(int cus_id, int wallet) {
		
		this.cus_id = cus_id;
		this.wallet = wallet;
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
		Userdetails other = (Userdetails) obj;
		return Objects.equals(address, other.address) && Objects.equals(email_id, other.email_id)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& phoneNo == other.phoneNo;
	}

}
