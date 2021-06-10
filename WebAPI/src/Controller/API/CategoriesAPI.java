package Controller.API;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CategoriesDao;
import Model.Categories;
import Utils.*;


/**
 * Servlet implementation class CategoriesAPI
 */
@WebServlet("/books/categories")
public class CategoriesAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriesAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		List<Categories> list_category = new ArrayList<Categories>();
		
		list_category = CategoriesDao.GetCategory();
			

		List<JsonElement> danhsachelement = new ArrayList<JsonElement>();
		
		List<List<JsonElement>> danhsachjson = new ArrayList< List<JsonElement>>();
		
		
		for(Categories phantu:list_category) {
			JsonElement jsonpt = new JsonElement("category",phantu.GetCategory(),true);
			danhsachelement.add(jsonpt);
			danhsachjson.add(danhsachelement);	
			danhsachelement = new ArrayList<JsonElement>();
		}	
		


		
		JsonListElement json = new JsonListElement("categories",danhsachjson);
		
		JsonStringBuilder builder = new JsonStringBuilder(null,json);
		
		String chuoijson = builder.BuildString2();
		
		out.print(chuoijson);
		out.flush();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
