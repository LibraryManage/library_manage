package library_manage.service;

import library_manage.entity.User;

public interface UserService {

	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2017年3月15日上午11:01:51
	 *函数名：isExitUser
	 *功能：用户登录
	 *参数：user（账号，密码）
	 *返回值：User
	 */
	User isExitUser(User user);
}
