package library_manage.serviceImpl;

import java.util.List;

import library_manage.dao.BookDao;
import library_manage.entity.Book;
import library_manage.entity.Page;
import library_manage.factory.DaoFactory;
import library_manage.service.BookService;

public class BookServiceImpl implements BookService{
	
	private static BookServiceImpl instance = new BookServiceImpl();
    private BookDao daoInstance = null;                //数据访问层对象
	
	private BookServiceImpl(){
		
		daoInstance = (BookDao) DaoFactory.getInstance().getBean(BookDao.class);
	}
	public static BookServiceImpl getInstance(){
		
		return instance;
	}
	@Override
	public int addBook(Book book){
		return  daoInstance.addBook(book);
	}
	@Override
	public List<Book> getBookList(Book book,Page page){
		
		return daoInstance.getBookList(book, page);
	}
	@Override
	public int deleteBook(String idStr){
		return daoInstance.deleteBook(idStr);
	}
	@Override
	public int updateBook(Book book){
		return daoInstance.changeBook(book);
	}
}