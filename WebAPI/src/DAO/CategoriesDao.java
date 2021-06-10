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

public class CategoriesDao {
	
	public static List<Categories> GetCategory() throws ServletException, IOException
	{
		List<Categories> results = new ArrayList<Categories>();
		Connection c = null;
		try
		{
			c = DBConnection.getConn();
			String sql = "select category_name from book_store.categories";
			PreparedStatement prstm = c.prepareStatement(sql);
			ResultSet rs = prstm.executeQuery();
			while(rs.next())
			{
				Categories entry = new Categories(
						rs.getString("category_name")
						);
				results.add(entry);
			}
			if(c != null)
				c.close();
			return results;
		}
		catch(SQLException e)
		{
			return null;
		}
		
	}
	
}
