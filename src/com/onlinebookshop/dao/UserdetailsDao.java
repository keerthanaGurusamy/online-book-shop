package com.onlinebookshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.onlinebookshop.model.Bookdetails;
import com.onlinebookshop.model.Userdetails;

public class UserdetailsDao {

	private static final String update = null;

	public void insertUser(Userdetails user) {
		String insertQuery = "insert into user_details(name,phoneNo,address,email_id,password) values(?,?,?,?,?)";

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
	//admin
	public Userdetails admin(String email_id,String password)
	{
		String AdminQuery="select * from user_details where role='admin'and email_id='"+email_id+"'and password='"+password+"'";
		
		Connection con=Connectionutil.getDbConnection();
		Userdetails user=null;
		try {
			Statement stm =con.createStatement();
			ResultSet rs=stm.executeQuery(AdminQuery);
			if(rs.next())
			{
				 user=new Userdetails(rs.getString(2),rs.getLong(3),rs.getString(5),email_id, password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	//user
	public Userdetails validateUser(String email_id,String password)
	{
		String validateQuery="select * from user_details where email_id='"+email_id+"' and password='"+password+"'";
		Connection con=Connectionutil.getDbConnection();
		Userdetails user=null;
		try {
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(validateQuery);
			if(rs.next())
			{
				user=new Userdetails(rs.getString(2),rs.getLong(3),rs.getString(4),email_id, password);
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
	// update profile
	public void update(String email_id,String password) {
		String updateQuery="update user_details set password=? where email_id=?";
		Connection con = Connectionutil.getDbConnection();
		try {
			PreparedStatement pst=con.prepareStatement(updateQuery);
			pst.setString(2, email_id);
			pst.setString(1,password);
			int i=pst.executeUpdate();
			System.out.println(i+"row updated");
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connection failed");
		}
		
		
	}
	//Delete user details
	
	public void deletedDetails(String delete) {
		String deleteQuery="delete from user_details where email_id=?";
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
	
	public List<Userdetails> viewUser(){
		List<Userdetails> userList=new ArrayList<Userdetails>();
		String show="select * from user_details where role='user'";
		Connection con=Connectionutil.getDbConnection();
		try {
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(show);
			while(rs.next()) {
				Userdetails user=new Userdetails(rs.getString(2),rs.getLong(3),rs.getString(5),rs.getString(6),rs.getString(7));
				userList.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}
	
	public int findUserId(String emailId)
	{
		String findUser="select cus_id from user_details where email_id='"+emailId+"'";
		Connection con=Connectionutil.getDbConnection();
        int CusId=0;
        try {
			Statement stm = con.createStatement();
			ResultSet rs=stm.executeQuery(findUser);
			if(rs.next())
			{
				CusId=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return CusId;
	}
	
	public int walletbal(int userid) throws Exception 
	{
		Connection con = Connectionutil.getDbConnection();
		String query = "select wallet from user_details where cus_id = ?";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setInt(1, userid);
		ResultSet rs = statement.executeQuery();
		while(rs.next()) {
				return rs.getInt(1);
		}
		return -1;
	}
	//update wallet:
	public int  updatewall(Userdetails userdetails)throws Exception {
		Connection con = Connectionutil.getDbConnection();
		String query = "update user_details set wallet = ? where cus_id = ?";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setDouble(1, userdetails.getWallet());
		statement.setInt(2,userdetails.getCus_id());
		int res = statement.executeUpdate();
		return res;
	}
}
	


