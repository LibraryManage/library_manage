package library_manage.serviceImpl;

import library_manage.dao.UserDao;
import library_manage.entity.User;
import library_manage.factory.DaoFactory;
import library_manage.service.UserService;

public class UserServiceImpl implements UserService {

	private static UserServiceImpl instance = new UserServiceImpl();
	private UserDao daoInstance = null;                //数据访问层对象
	
	private UserServiceImpl(){
		
		daoInstance = (UserDao) DaoFactory.getInstance().getBean(UserDao.class);
	}
	public static UserServiceImpl getInstance(){
		
		return instance;
	}
	@Override
	public User isExitUser(User user) {
		
		User result = null;
		result = daoInstance.isExitUser(user);
		return result;
	}
}
