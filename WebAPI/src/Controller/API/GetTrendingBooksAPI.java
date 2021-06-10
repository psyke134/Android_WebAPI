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

import DAO.*;
import Model.*;
import Utils.*;
/**
 * Servlet implementation class GetTrendingBooksAPI
 */
@WebServlet("/books/trend")
public class GetTrendingBooksAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTrendingBooksAPI() {
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
		
		List<Book> books = BookDao.GetTrendingBooks();
		
		List<List<JsonElement>> bookJsons = new ArrayList<List<JsonElement>>();
		String listKey = "books";
		for(Book book:books)
		{
			List<JsonElement> bookJson = new ArrayList<JsonElement>();
			
			bookJson.add(new JsonElement("book_id", book.getBook_id(), false));
			bookJson.add(new JsonElement("name", book.getName(), true));
			bookJson.add(new JsonElement("author", book.getAuthor(), true));
			bookJson.add(new JsonElement("category", book.getCategory(), true));
			bookJson.add(new JsonElement("pirce", String.valueOf(book.getPrice()), false));
			bookJson.add(new JsonElement("save", String.valueOf(book.getSave()), false));
			bookJson.add(new JsonElement("overview", book.getOverview(), true));
			bookJson.add(new JsonElement("image", book.getImage(), true));
			bookJson.add(new JsonElement("flash_sale", String.valueOf(book.isFlat_sale()), false));
			bookJson.add(new JsonElement("publisher", book.getPublisher(), true));
			bookJson.add(new JsonElement("publish_date", book.getPublish_date(), true));
			bookJson.add(new JsonElement("page_count", book.getPage_count(), false));
			bookJson.add(new JsonElement("dimensions", book.getDemensions(), true));
			bookJson.add(new JsonElement("shipping_weight", book.getShipping_weight(), false));
			bookJson.add(new JsonElement("stock", book.getStock(), false));
			bookJson.add(new JsonElement("book_format", book.getBook_format(), true));
			bookJson.add(new JsonElement("rating", book.getRating(), false));
			bookJson.add(new JsonElement("trend", String.valueOf(book.getTrend()), false));
			
			bookJsons.add(bookJson);
		}
		JsonListElement listElement = new JsonListElement(listKey, bookJsons);
		JsonStringBuilder builder = new JsonStringBuilder(null, listElement);
		
		String jsonString = builder.BuildString2();
		
		out.print(jsonString);
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
