package com.onlinebookshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.onlinebookshop.model.OrderDetails;
import com.onlinebookshop.model.Userdetails;

public class OrderDetailsDao {

	public void insertOrder(OrderDetails cart)
	{
		String insertQuery="insert into orderdetails(cus_id,book_id,quantity,total_cost) values(?,?,?,?)";
		Connection con = Connectionutil.getDbConnection();
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(insertQuery);
			pst.setInt(1, cart.getCus_id());
			pst.setInt(2, cart.getBook_id());
			pst.setInt(3, cart.getQuantity());
			pst.setDouble(4, cart.getTotal_cost());
			pst.executeUpdate();
			System.out.println("Value inserted successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Value not inserted");
		}
	}
	
	public List<OrderDetails> viewCart()
	{
		List<OrderDetails> cartList=new ArrayList<OrderDetails>();
		String view ="select * from orderdetails";
		Connection con = Connectionutil.getDbConnection();
		try {
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(view);
			while(rs.next())
			{
				OrderDetails cart=new OrderDetails(rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getDouble(5));
				cartList.add(cart);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cartList;
	}
	
	public int updateCart(int quantity,int book_id)
	{
		String updateQuery="update orderdetails set quantity=? where book_id=?";
		Connection con = Connectionutil.getDbConnection();
		try {
			PreparedStatement pst=con.prepareStatement(updateQuery);
			pst.setInt(2, book_id);
			pst.setInt(1, quantity);
			int i=pst.executeUpdate();
			System.out.println(i+"row updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Try again");
		}
		return 0;
		
	}
	
	public int deleteCart(int bookid) {
		String delete="delete from orderdetails where book_id=?";
		Connection con = Connectionutil.getDbConnection();
		PreparedStatement pstm=null;
		try {
			pstm=con.prepareStatement(delete);
			pstm.setInt(1, bookid);
			int noOfRows=pstm.executeUpdate();
			System.out.println(noOfRows+ "row deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public ResultSet viewUserCart(Userdetails currentUser){
		String myCart ="select * from orderdetails where cus_id=?";
		
		Connection con = Connectionutil.getDbConnection();
		try {
			PreparedStatement pstm = con.prepareStatement(myCart);
			pstm.setInt(1, currentUser.getCus_id());
			ResultSet rs = pstm.executeQuery();
			
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
