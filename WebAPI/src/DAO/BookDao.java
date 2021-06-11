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
				String publisher = rs.getString("publisher");
				String publish_date = rs.getString("publish_date");
				int page_count = rs.getInt("page_count");
				String dimensions = rs.getString("dimensions");
				String shipping_weight = rs.getString("shipping_weight");
				String book_format = rs.getString("book_format");
				
				if(publisher == null) publisher = "";
				if(publish_date == null) publish_date = "";
				if(page_count == 0) page_count = -1;
				if(dimensions == null) dimensions = "";
				if(shipping_weight == null) shipping_weight = "-1";
				if(book_format == null) book_format = "";
				
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
						publisher,
						publish_date,
						String.valueOf(page_count),
						dimensions,
						shipping_weight,
						String.valueOf(rs.getInt("stock")),
						book_format,
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
	
	public static List<Book> GetBooksWithCategory(String category) throws ServletException, IOException 
	{
		List<Book> results = new ArrayList<Book>();
		Connection c = null;
		try
		{
			c = DBConnection.getConn();
			String sql = "select *\r\n" + 
					"from book_store.books, book_store.categories\r\n" + 
					"where books.category_id = categories.category_id and categories.category_name = \"" + category + "\"";
			PreparedStatement prstm = c.prepareStatement(sql);
			
			ResultSet rs = prstm.executeQuery();
			while(rs.next())
			{
				String publisher = rs.getString("publisher");
				String publish_date = rs.getString("publish_date");
				int page_count = rs.getInt("page_count");
				String dimensions = rs.getString("dimensions");
				String shipping_weight = rs.getString("shipping_weight");
				String book_format = rs.getString("book_format");
				
				if(publisher == null) publisher = "";
				if(publish_date == null) publish_date = "";
				if(page_count == 0) page_count = -1;
				if(dimensions == null) dimensions = "";
				if(shipping_weight == null) shipping_weight = "-1";
				if(book_format == null) book_format = "";
				
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
						publisher,
						publish_date,
						String.valueOf(page_count),
						dimensions,
						shipping_weight,
						String.valueOf(rs.getInt("stock")),
						book_format,
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
	
	public static List<Book> GetTrendingBooks() throws ServletException, IOException 
	{
		List<Book> results = new ArrayList<Book>();
		Connection c = null;
		try
		{
			c = DBConnection.getConn();
			String sql = "select *\r\n" + 
					"from book_store.books, book_store.categories\r\n" + 
					"where books.category_id = categories.category_id and books.is_trending = true";
			PreparedStatement prstm = c.prepareStatement(sql);
			
			ResultSet rs = prstm.executeQuery();
			while(rs.next())
			{
				String publisher = rs.getString("publisher");
				String publish_date = rs.getString("publish_date");
				int page_count = rs.getInt("page_count");
				String dimensions = rs.getString("dimensions");
				String shipping_weight = rs.getString("shipping_weight");
				String book_format = rs.getString("book_format");
				
				if(publisher == null) publisher = "";
				if(publish_date == null) publish_date = "";
				if(page_count == 0) page_count = -1;
				if(dimensions == null) dimensions = "";
				if(shipping_weight == null) shipping_weight = "-1";
				if(book_format == null) book_format = "";
				
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
						publisher,
						publish_date,
						String.valueOf(page_count),
						dimensions,
						shipping_weight,
						String.valueOf(rs.getInt("stock")),
						book_format,
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
