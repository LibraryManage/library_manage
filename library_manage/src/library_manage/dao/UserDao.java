package library_manage.dao;

import library_manage.entity.User;

public interface UserDao {

	/**
	 * 
	 *���ߣ�ZhangHuanMing
	 *ʱ�䣺2017��3��15������11:01:51
	 *��������isExitUser
	 *���ܣ������û��˺ź���������Ƿ��������û�
	 *������user���˺ţ����룩
	 *����ֵ��User
	 */
	User isExitUser(User user);
}
