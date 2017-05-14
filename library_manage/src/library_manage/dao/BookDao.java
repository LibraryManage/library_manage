package library_manage.dao;

import java.util.List;

import library_manage.entity.Book;
import library_manage.entity.Page;
import library_manage.entity.Type;

public interface BookDao {
    
	int addBook(Book book);

	int deleteBook(String idStr);
	
	int changeBook(Book book);

	List<Book> getBookList(Book book, Page page);

	List<Type> getType();

}
