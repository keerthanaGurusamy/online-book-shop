package com.onlinebookshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.onlinebookshop.model.Bookdetails;

public class BookdetailsDao {
	
	public void insertBooks(Bookdetails product)
	{
		String  insert="insert into bookdetails(category,description,publisher_id,book_title,book_code,price,publish_date,condition)values(?,?,?,?,?,?,?,?)";
		Connection con = Connectionutil.getDbConnection();
		PreparedStatement pstm=null;
		try {
			pstm =con.prepareStatement(insert);
			pstm.setString(1, product.getCategory());
			pstm.setString(2, product.getDescription());
			pstm.setInt(3, product.getPublisher_id());
			pstm.setString(4, product.getBook_title());
			pstm.setString(5, product.getBook_code());
			pstm.setInt(6, product.getPrice());
			pstm.setString(7, product.getPublish_date());
			pstm.setString(8, product.getCondition());
			pstm.executeUpdate();
			System.out.println("Book details are inserted ");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Try again");
		}
	}
	
	public void deleteBooks(String product) {
		String delete="delete from bookdetails where book_title=?";
		Connection con = Connectionutil.getDbConnection();
		PreparedStatement pstm=null;
		try {
			pstm=con.prepareStatement(delete);
			pstm.setString(1, product);
			int noOfRows=pstm.executeUpdate();
			System.out.println(noOfRows+ "row deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public List<Bookdetails> showProduct()
	{
		List<Bookdetails> productsList=new ArrayList<Bookdetails>();
		
		String show = "select * from bookdetails";
		Connection con = Connectionutil.getDbConnection();
		try {
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(show);
			while(rs.next())
			{
				Bookdetails product = new Bookdetails(rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getString(9));
				productsList.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return productsList;
	}
	public int findProduct(Bookdetails product) {
		String find="select book_id from bookdetails where book_title='"+product.getBook_title()+"'";
		Connection con = Connectionutil.getDbConnection();
		int productId=0;
		try {
			Statement stm =con.createStatement();
			ResultSet rs=stm.executeQuery(find);
			if(rs.next())
			{
				productId=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productId;
		
	}
	public void updateBooks(String updateBooks) {
		String updateQuery="update bookdetails set condition=? where book_title=?";
		Connection con = Connectionutil.getDbConnection();
		System.out.println("Connection sucessfull");
		try {
			PreparedStatement pst=con.prepareStatement(updateQuery);
			pst.setString(1, updateBooks.split(",")[0]);
			pst.setString(2, updateBooks.split(",")[1]);
			int i=pst.executeUpdate();
			System.out.println(i+"row updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Try again");
		}
	}
}
