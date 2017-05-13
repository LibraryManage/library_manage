package library_manage.serviceImpl;

import library_manage.dao.BookDao;
import library_manage.factory.DaoFactory;
import library_manage.service.BookService;

public class BookServiceImpl implements BookService{
	
	private static final BookServiceImpl instance = new BookServiceImpl();
    private BookDao daoInstance = null;                //���ݷ��ʲ����
	
	private BookServiceImpl(){
		
		daoInstance = (BookDao) DaoFactory.getInstance().getBean(BookDao.class);
	}
	public static BookServiceImpl getInstance(){
		
		return instance;
	}
	
	
}