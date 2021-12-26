package com.onlinebookshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.onlinebookshop.model.Bookdetails;
import com.onlinebookshop.model.Rating;

public class Ratingdao {

	public int insertrating(Rating rating) {
		
			String  insert="insert into rating(cus_id,book_id,rating)values(?,?,?)";
			Connection con = Connectionutil.getDbConnection();
			PreparedStatement pstm=null;
			try {
				pstm =con.prepareStatement(insert);
				pstm.setInt(1, rating.getCus_id());
				pstm.setInt(2, rating.getBook_id());
				pstm.setDouble(3, rating.getRating());
				int res =pstm.executeUpdate();
				pstm.executeUpdate("commit");
				System.out.println("Book details are inserted ");
				return res;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Try again");
			}
		
		return -1;
	}
	public double fetchrating(Rating rating) {
		Connection con = Connectionutil.getDbConnection();
		String query ="select avg(rating) from rating where book_id =?";
		try {
			PreparedStatement pst =con.prepareStatement(query);
			pst.setInt(1, rating.getBook_id());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				return rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
}
