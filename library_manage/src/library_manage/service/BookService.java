package library_manage.service;

import java.util.List;

import library_manage.entity.Book;
import library_manage.entity.Page;

public interface  BookService {

	int addBook(Book book);

	int deleteBook(String idStr);

	int updateBook(Book book);

	List<Book> getBookList(Book book, Page page);
	
}