package Controller.API;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AccountDao;
import Utils.JsonElement;
import Utils.JsonParser;

/**
 * Servlet implementation class RegisterAPI
 */
@WebServlet("/accounts/register")
public class RegisterAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		JsonParser parser = JsonParser.FromReader(request.getReader());
		List<JsonElement> requestElements = parser.Parse();
		
		if(requestElements.size() < 1)
		{
			//there's no json in request
			return;
		}
		
		String username = requestElements.get(0).GetValue();
		String password = requestElements.get(1).GetValue();
		String email = requestElements.get(2).GetValue();
		String phone_number = requestElements.get(3).GetValue();
		String address = requestElements.get(4).GetValue();
		String name = requestElements.get(5).GetValue();
		
		boolean logInSuccess = AccountDao.CheckUserAccount(username);
		
		if(logInSuccess == false)
		{
			String thongbao = AccountDao.AddAccount(username, password, email, phone_number, address, name);
			
			out.print(thongbao);
			out.flush();
		}
		else
		{
			String thongbao = "failed";
			
			out.print(thongbao);
			out.flush();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
