package Controller.API;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import Utils.*;
import DAO.*;

/**
 * Servlet implementation class TestAPI
 */
@WebServlet("/LogInAPI")
public class LogInAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInAPI() {
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
		
		boolean logInSuccess = AccountDao.CheckAccount(username, password);
		
		if(logInSuccess == true)
		{
			List<JsonElement> headerElements = new ArrayList<JsonElement>();
			headerElements.add(new JsonElement("alg", "HS256", true));
			headerElements.add(new JsonElement("typ", "JWT", true));
			
			List<JsonElement> payloadElements = new ArrayList<JsonElement>();
			Integer accountId = AccountDao.GetAccountId(username);
			payloadElements.add(new JsonElement("iss", "Book store", true));
			payloadElements.add(new JsonElement("sub", "login", true));
			payloadElements.add(new JsonElement("aud", "user", true));
			payloadElements.add(new JsonElement("account_id", accountId.toString(), true));
			
			JsonStringBuilder builder = new JsonStringBuilder(headerElements);
			String header = builder.BuildString();
			builder = new JsonStringBuilder(payloadElements);
			String payload = builder.BuildString();
			String secretKey = "LT-Android";
			
			
			JWT jwt = new JWT(header, payload, secretKey);
			String token = jwt.getToken();
			
			List<JsonElement> responseElements = new ArrayList<JsonElement>();
			responseElements.add(new JsonElement("result", "succedded", true));
			responseElements.add(new JsonElement("token", token, true));
			
			builder = new JsonStringBuilder(responseElements);
			
			String responseJson = builder.BuildString();
			out.print(responseJson);
			out.flush();
		}
		else
		{	
			List<JsonElement> responseElements = new ArrayList<JsonElement>();
			responseElements.add(new JsonElement("result", "failed", true));
			responseElements.add(new JsonElement("token", "none", true));
			
			JsonStringBuilder builder = new JsonStringBuilder(responseElements);
			
			String responseJson = builder.BuildString();
			out.print(responseJson);
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
