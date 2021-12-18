package com.onlinebookshop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.onlinebookshop.model.Products;

public class ProductsDao {

	public List<Products> showProduct()
	{
		List<Products> productsList=new ArrayList<Products>();
		
		String show = "select * from books";
		Connection con = Connectionutil.getDbConnection();
		try {
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(show);
			while(rs.next())
			{
				Products product = new Products(rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getString(9));
				productsList.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return productsList;
	}
	public int findProduct(Products product) {
		String finduser="select category,description,price from books where book_title='"+product.getBook_title()+"'";
		Connection con = Connectionutil.getDbConnection();
		int productId=0;
		try {
			Statement stm =con.createStatement();
			ResultSet rs=stm.executeQuery(finduser);
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
}
