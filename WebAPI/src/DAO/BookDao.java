package DAO;

import Connection.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import Model.*;

import javax.servlet.ServletException;

public class BookDao {

	public static List<Book> GetBooks() throws ServletException, IOException 
	{
		List<Book> results = new ArrayList<Book>();
		Connection c = null;
		try
		{
			c = DBConnection.getConn();
			String sql = "select *\r\n" + 
					"from book_store.books, book_store.categories\r\n" + 
					"where books.category_id = categories.category_id";
			PreparedStatement prstm = c.prepareStatement(sql);
			ResultSet rs = prstm.executeQuery();
			while(rs.next())
			{
				Book entry = new Book(
						String.valueOf(rs.getInt("book_id")),
						rs.getString("name"),
						rs.getString("author"),
						rs.getString("category_name"),
						rs.getFloat("price"),
						rs.getInt("save"),
						rs.getString("overview"),
						rs.getString("image"),
						rs.getBoolean("flash_sale"),
						rs.getString("publisher"),
						rs.getString("publish_date"),
						String.valueOf(rs.getInt("page_count")),
						rs.getString("dimensions"),
						rs.getString("shipping_weight"),
						String.valueOf(rs.getInt("stock")),
						rs.getString("book_format"),
						"5",
						rs.getBoolean("is_trending")
						);
				results.add(entry);
			}
			if(c != null)
				c.close();
			return results;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.print(e.toString());
			return null;
		}
	}
}
