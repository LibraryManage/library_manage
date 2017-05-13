package library_manage.test;

import org.junit.Test;

import library_manage.entity.Book;
import library_manage.service.BookService;
import library_manage.service.UserService;
import library_manage.serviceImpl.BookServiceImpl;
import library_manage.serviceImpl.UserServiceImpl;

public class testService{
	private UserService uDao = UserServiceImpl.getInstance();
	private BookService bDao = BookServiceImpl.getInstance();
	
	@Test
	public void addbooktest(){
		
		Book book = new Book();
		
		System.out.println(bDao.getBookList(book, 1));
	}
	@Test
	public void testdelete(){
		String id = "1,2";
		System.out.println(bDao.deleteBook(id));
	}
	
	
}