package library_manage.service;

import java.util.List;

import library_manage.entity.Book;

public interface  BookService {

	int addBook(Book book);

	List<Book> getBookList(Book book, int page);

	int deleteBook(String idStr);

	int updateBook(Book book);
	
}