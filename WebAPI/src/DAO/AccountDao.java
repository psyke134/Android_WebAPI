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

public class AccountDao {
	public static boolean CheckAccount(String username, String password) throws ServletException, IOException
	{
		Connection c = null;
		try
		{
			boolean result = false;
			c = DBConnection.getConn();
			String sql = "select * from accounts where username = \"" + username + "\" and password = \"" + password + "\"";
			PreparedStatement prstm = c.prepareStatement(sql);
			ResultSet rs = prstm.executeQuery();
			if(rs.next() == true)
			{
				result = true;
			}
			
			if(c != null)
			{
				c.close();
			}
			
			return result;
		}
		catch(SQLException e)
		{
			return false;
		}
		
	}
	
	public static int GetAccountId(String username) throws ServletException, IOException
	{
		int result = -1;
		Connection c = null;
		try
		{
			c = DBConnection.getConn();
			String sql = "select account_id from accounts where username = \"" + username + "\"";
			PreparedStatement prstm = c.prepareStatement(sql);
			ResultSet rs = prstm.executeQuery();
			if(rs.next() == true)
			{
				result = Integer.parseInt(rs.getString("account_id"));
			}
			
			if(c != null)
			{
				c.close();
			}
			
			return result;
		}
		catch(SQLException e)
		{
			return result;
		}
	}
	
	public static String AddAccount(String username, String password, String email, String phone_number, 
			String address, String name) throws ServletException, IOException
	{
		Connection c = null;
		String thongBao = null;
		try
		{
			c = DBConnection.getConn();
			String sql = "insert into accounts values(username, password, email, phone_number, address, name)";
			PreparedStatement prstm = c.prepareStatement(sql);
			prstm.setString(1, username);
			prstm.setString(2, password);
			prstm.setString(3, email);
			prstm.setString(4, phone_number);
			prstm.setString(5, address);
			prstm.setString(6, name);
			prstm.executeUpdate();
			thongBao = "Thêm người dùng thành công.";
			if(c != null)
				c.close();
			return thongBao;
		}
		catch(SQLException e)
		{
			thongBao = "Thêm người dùng không thành công.\n";
			thongBao += "Thông tin lỗi: "+e.toString();
			return thongBao;
		}
	}
	
	public static List<Account> GetAccounts() throws ServletException, IOException
	{
		List<Account> results = new ArrayList<Account>();
		Connection c = null;
		try
		{
			c = DBConnection.getConn();
			String sql = "select * from user";
			PreparedStatement prstm = c.prepareStatement(sql);
			ResultSet rs = prstm.executeQuery();
			while(rs.next())
			{
				Account entry = new Account(
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("email"),
						rs.getString("phone_number"),
						rs.getString("address"),
						rs.getString("name")
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
