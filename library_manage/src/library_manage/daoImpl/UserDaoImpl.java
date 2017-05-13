package library_manage.daoImpl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import library_manage.dao.UserDao;
import library_manage.entity.User;
import library_manage.tool.JdbcUtils_DBCP;

public class UserDaoImpl implements UserDao {
	
	private static QueryRunner runerUpdate = new QueryRunner();
	private static QueryRunner runerQuery = new QueryRunner(JdbcUtils_DBCP.getDataSource());

	@Override
	public User isExitUser(User user) {
		
		User result = null;
		String sql = "select userId,userAccount from user where userAccount = ? and userPassword = ? and userState = ?";
		Object[] param = {user.getUserAccount(),user.getUserPassword(),1};
		try {
			result =  runerQuery.query(sql, new BeanHandler<>(User.class), param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("result:"+result);
		return result;
	}

}
