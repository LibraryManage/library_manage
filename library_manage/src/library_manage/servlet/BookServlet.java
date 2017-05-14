package library_manage.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import library_manage.entity.Book;
import library_manage.entity.Page;
import library_manage.entity.Type;
import library_manage.service.BookService;
import library_manage.serviceImpl.BookServiceImpl;
@WebServlet("/BOOK")
public class BookServlet extends BaseServlet{
	
	private static BookService bService = BookServiceImpl.getInstance();
	
	public void CreateBook(HttpServletRequest request,HttpServletResponse response){
		String jsonStr = request.getParameter("jsonStr");
		 System.out.println(jsonStr);
		Gson gson = new Gson();
		Book book = gson.fromJson(jsonStr, Book.class);
		int flag = bService.addBook(book);
	    System.out.println(flag);
		JsonObject json = new JsonObject();
		try {
			PrintWriter out = response.getWriter();
			json.addProperty("data",flag);
			out.println(json);
			out.close();
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deleteBook(HttpServletRequest request,HttpServletResponse response){
		String idStr = request.getParameter("idStr");
		int flag = bService.deleteBook(idStr);
		JsonObject json = new JsonObject();
		try {
			PrintWriter out = response.getWriter();
			json.addProperty("data",flag);
			out.println(json);
			out.close();
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void selectBook(HttpServletRequest request,HttpServletResponse response){
		
		String jsonStr = request.getParameter("jsonStr");
		Gson gson = new Gson();
		Page page = new Page();
		page.setPage(Integer.parseInt(request.getParameter("page")));
		Book book = gson.fromJson(jsonStr, Book.class);
		List<Book> books = bService.getBookList(book, page);
		JsonObject json = new JsonObject();
		try {
			PrintWriter out = response.getWriter();
			json.add("data", new JsonParser().parse(gson.toJson(books)).getAsJsonArray());
			json.addProperty("num", page.getPageNum());
			json.addProperty("currentNum", page.getCurruntNum());
			System.out.println(json);
			out.println(json);
			out.close();
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
   public void updateBook(HttpServletRequest request,HttpServletResponse response){
	   String jsonStr = request.getParameter("jsonStr");
	   Gson gson = new Gson();
	   Book book = gson.fromJson(jsonStr, Book.class);
	   int flag = bService.updateBook(book);
	   JsonObject json = new JsonObject();
		try {
			PrintWriter out = response.getWriter();
			json.addProperty("data", flag);
			out.println(json);
			out.close();
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	   
   } 
   public void getType(HttpServletRequest request,HttpServletResponse response){
	   Gson gson = new Gson();
	   JsonObject json = new JsonObject();
       List<Type> types = bService.getType();
       json.add("data", new JsonParser().parse(gson.toJson(types)).getAsJsonArray());
       try {
		PrintWriter out = response.getWriter();
		out.println(json);
		out.close();
		out.flush();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}