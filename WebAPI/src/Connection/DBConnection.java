package Connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class lamTest
 */
@WebServlet("/DBConnection")
public class DBConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @throws ServletException 
     * @throws IOException 
     * @see HttpServlet#HttpServlet()
     */
	public static Connection getConn() throws ServletException, IOException
	{
		try
        {
        	Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e)
        {
        	throw new ServletException(e);
        }
		Connection c = null;
		try
		{
			String url = "jdbc:mysql://localhost/book_store";
			String username = "root";
			String password = "ZZthang456";
			c = DriverManager.getConnection(url, username, password);
			return c;
		}
		catch(SQLException e)
		{
			return null;
		}
		
	}
    public DBConnection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getConn();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}