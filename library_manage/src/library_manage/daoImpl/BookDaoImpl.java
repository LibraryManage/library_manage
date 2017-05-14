package library_manage.daoImpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import library_manage.dao.BookDao;
import library_manage.entity.Book;
import library_manage.entity.Page;
import library_manage.entity.Type;
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
			int flag = runerQuery.update(sql, param);
			return flag;
		} catch (SQLException e) {
			System.out.println("新增书籍数据异常！");
			e.printStackTrace();
			return 0;
		}
		
	}
	//查询列表
	@Override
	public List<Book> getBookList(Book book,Page page){
		List<Book> books = null;
		int start = (page.getPage()-1)*10;
		String sql = "select * from book where 1=1";
		if(book.getName()!= null){
			sql +=" and name like '%"+book.getName()+"%'";
		}
		if(book.getAuthor() != null){
			sql += " and author like '%"+book.getAuthor()+"%'";
		}
		try {
			page.setPageNum(runerQuery.query(sql, new BeanListHandler<Book>(Book.class)).size());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		sql +=" limit "+start+" ,"+ 10;
		
		try {
			page.setCurruntNum(runerQuery.query(sql, new BeanListHandler<Book>(Book.class)).size());
			return runerQuery.query(sql, new BeanListHandler<Book>(Book.class));
		} catch (SQLException e) {
			System.out.println("查询书籍数据异常！");
			e.printStackTrace();
			return null;
		}
	}
	//删除书籍
	@Override
	public int deleteBook(String idStr){
		String sql = "delete from book where id in("+idStr+")";
		try {
			return  runerQuery.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("删除书籍失败！");
			return 0;
		}
	
	}
	//修改书籍
	@Override
	public int changeBook(Book book){
		String sql = Book.updateSql(book);
		try {
			return runerQuery.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("书籍修改数据异常");
			return 0;
		}
	}
	@Override
	public List<Type> getType(){
		String sql ="select * from type";
		try {
			return runerQuery.query(sql, new BeanListHandler<Type>(Type.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}
