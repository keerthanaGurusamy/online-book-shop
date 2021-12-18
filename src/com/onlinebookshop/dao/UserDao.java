package com.onlinebookshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.onlinebookshop.model.Products;
import com.onlinebookshop.model.User;

public class UserDao {

	private static final String update = null;

	public void insertUser(User user) {
		String insertQuery = "insert into users(name,phoneNo,address,email_id,password) values(?,?,?,?,?)";

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
		String validateQuery="select * from users where email_id='"+email_id+"' and password='"+password+"'";
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
	
	public void update(String update) {
		String updateQuery="update users set password=? where email_id=?";
		Connection con = Connectionutil.getDbConnection();
		System.out.println("Connection sucessfull");
		
		try {
			PreparedStatement pst=con.prepareStatement(updateQuery);
			pst.setString(1, update.split(",")[0]);
			pst.setInt(2, Integer.parseInt(update.split(",")[1]));
			int i=pst.executeUpdate();
			System.out.println(i+"row updated");
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connection failed");
		}
		
		//Delete user details
	
	}

	public void deletedDetails(String delete) {
		String deleteQuery="delete from users where email_id=?";
		Connection con=Connectionutil.getDbConnection();
		System.out.println("Connection Sucessfull");
		try {
			PreparedStatement pst =con.prepareStatement(deleteQuery);
			pst.setString(1, delete);
			int i=pst.executeUpdate();
			System.out.println(i+" row deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
	


