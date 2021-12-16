package com.book.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {

	public void insertUser(User user) {
		String insertQuery = "insert into customer_details(name,phoneNo,address,email_id,password) values(?,?,?,?,?)";

		Connectionutil conUtil = new Connectionutil();
		Connection con = conUtil.getDbConnection();
		PreparedStatement pst = null;

		try {
			pst = con.prepareStatement(insertQuery);
			pst.setString(1, user.getName());
			pst.setLong(2, user.getPhoneNo());
			pst.setString(3, user.getAddress());
			pst.setString(4, user.getEmail_id());
			pst.setString(5, user.getPassword());
			pst.executeUpdate();
			System.out.println("Value inserted Succes");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Value not inserted in the table");
		}

	}

	public User validateUser(String email_id,String password)
	{
		String validateQuery="select * from customer_register where email_id='"+email_id+"' and password='"+password+"'";
		Connection con=Connectionutil.getDbConnection();
		User user=null;
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(validateQuery);
			if(rs.next())
			{
				user=new User(rs.getString(2),rs.getLong(3),rs.getString(4),email_id, password);
			}
			else {
				System.out.println("Not a valid user");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Statement error");
		} 
		return user;
	}

}
