package com.onlinebookshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.onlinebookshop.model.AuthorDetails;
import com.onlinebookshop.model.Bookdetails;

public class AuthorDetailsDao {

	public void insertAuthor(AuthorDetails author)
	{
		String insert="insert into author_details(name,email_id,book_id)values(?,?,?)";
		Connection con = Connectionutil.getDbConnection();
		PreparedStatement pstm=null;
		try {
			pstm=con.prepareStatement(insert);
			pstm.setString(1, author.getName());
			pstm.setString(2, author.getEmail_id());
			pstm.setString(3, author.getBook_id());
			pstm.executeUpdate();
			System.out.println("Author inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Try again");
		}
	}
	public void updateAuthor(String email_id,String name) {
		String updateQuery="update author_details set email_id=? where name=?";
		Connection con = Connectionutil.getDbConnection();
		try {
			PreparedStatement pst=con.prepareStatement(updateQuery);
			pst.setString(2, name);
			pst.setString(1, email_id);
			int i=pst.executeUpdate();
			System.out.println(i+"row updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Try again");
		}
	}
	public List<AuthorDetails> showAuthor()
	{
       List<AuthorDetails> authorList=new ArrayList<AuthorDetails>();
		
		String show = "select * from author_details";
		Connection con = Connectionutil.getDbConnection();
		try {
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(show);
			while(rs.next())
			{
				AuthorDetails author = new AuthorDetails(rs.getString(2),rs.getString(3),rs.getString(4));
				authorList.add(author);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return authorList;
	}
}
