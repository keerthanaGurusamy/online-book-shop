package com.onlinebookshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.onlinebookshop.model.Cart;

public class CartDao {

	public void insertOrder(Cart cart)
	{
		String insertQuery="insert into cart(book_id,quantity,total_cost) values(?,?,?)";
		Connection con = Connectionutil.getDbConnection();
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(insertQuery);
			pst.setInt(1, cart.getBook_id());
			pst.setInt(2, cart.getQuantity());
			pst.setDouble(3, cart.getTotal_cost());
			pst.executeUpdate();
			System.out.println("Value inserted successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Value not inserted");
		}
	}
}
