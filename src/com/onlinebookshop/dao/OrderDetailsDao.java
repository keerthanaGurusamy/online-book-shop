package com.onlinebookshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.onlinebookshop.model.OrderDetails;

public class OrderDetailsDao {

	public void insertInvoice(OrderDetails orderdetails)
	{
		String insert="insert into order_details(order_id,cus_id,book_id,order_date,status) values(?,?,?,?,?)";
		Connection con = Connectionutil.getDbConnection();
		try {
			PreparedStatement pst = con.prepareStatement(insert);
		    pst.setInt(1, orderdetails.getOrder_id());
		    pst.setInt(2, orderdetails.getCus_id());
		    pst.setInt(3, orderdetails.getBook_id());
		    pst.setDate(4, orderdetails.getOrder_date());
		    pst.setString(5, orderdetails.getStatus());
		    pst.executeUpdate();
		    System.out.println("Value inserted sucessfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
