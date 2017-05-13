package library_manage.daoImpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import library_manage.dao.BookDao;
import library_manage.entity.Book;
import library_manage.tool.JdbcUtils_DBCP;

public class BookDaoImpl implements BookDao{
	private static QueryRunner runerUpdate = new QueryRunner();
	private static QueryRunner runerQuery = new QueryRunner(JdbcUtils_DBCP.getDataSource());
	
	//增加
	@Override
	public int addBook(Book book){
		String sql = "insert into book(name,author,des,book_path,img_path,press,state) value(?,?,?,?,?,?,?)";
		Object[] param = {book.getName(),book.getAuthor(),book.getDes(),book.getBook_path(),book.getImg_path(),book.getPress(),book.getState()};
		try {
			int flag = runerUpdate.update(sql);
			return flag;
		} catch (SQLException e) {
			System.out.println("新增书籍数据异常！");
			e.printStackTrace();
			return 0;
		}
		
	}
	//查询列表
	@Override
	public List<Book> getBookList(Book book,int page){
		List<Book> books = null;
		return books;
	}
	//删除书籍
	@Override
	public int deleteBook(int id){
		return 0;
	}
	//修改书籍
	@Override
	public int changeBook(int id){
		return 0;
	}
	
	
}
