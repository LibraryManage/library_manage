package library_manage.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import library_manage.entity.Book;
import library_manage.entity.Page;
import library_manage.service.BookService;
import library_manage.serviceImpl.BookServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class BookServlet extends BaseServlet{
	
	private static BookService bService = BookServiceImpl.getInstance();
	
	public void CreateBook(HttpServletRequest request,HttpServletResponse response){
		String jsonStr = request.getParameter("jsonStr");
		Gson gson = new Gson();
		Book book = gson.fromJson(jsonStr, Book.class);
		int flag = bService.addBook(book);
		JSONObject json = new JSONObject();
		try {
			PrintWriter out = response.getWriter();
			json.put("data",flag);
			out.println(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deleteBook(HttpServletRequest request,HttpServletResponse response){
		String idStr = request.getParameter("idStr");
		int flag = bService.deleteBook(idStr);
		JSONObject json = new JSONObject();
		try {
			PrintWriter out = response.getWriter();
			json.put("data",flag);
			out.println(json);
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
		JSONObject json = new JSONObject();
		JSONArray jsons = new JSONArray();
		try {
			PrintWriter out = response.getWriter();
			jsons.fromObject(books);
			json.put("data", jsons);
			json.put("num", page.getPageNum());
			out.println(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}