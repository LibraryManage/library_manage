package library_manage.dao;

import library_manage.entity.User;

public interface UserDao {

	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2017年3月15日上午11:01:51
	 *函数名：isExitUser
	 *功能：根据用户账号和密码查找是否存在这个用户
	 *参数：user（账号，密码）
	 *返回值：User
	 */
	User isExitUser(User user);
}
