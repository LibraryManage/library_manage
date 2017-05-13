package library_manage.dao;

import java.util.List;

import library_manage.entity.Book;

public interface BookDao {
    
	int addBook(Book book);

	List<Book> getBookList(Book book, int page);

	int deleteBook(String idStr);
	
	int changeBook(Book book);

}
