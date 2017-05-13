package library_manage.entity;

public class User {

	private int userId;                     //用户id
	private String userAccount;             //用户账号
	private String userPassword;            //用户密码
	private String userEmail;               //用户邮箱
	private String userPhone;               //用户手机
	private int userState;                  //用户状态（0表示删除；1表示存在）
	private String userNickname;            //用户昵称
	private String userSex;                 //用户性别
	private String userPic;                 //用户头像
	
	public User(){}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public int getUserState() {
		return userState;
	}

	public void setUserState(int userState) {
		this.userState = userState;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickName(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserPic() {
		return userPic;
	}

	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userAccount=" + userAccount + ", userPassword=" + userPassword
				+ ", userEmail=" + userEmail + ", userPhone=" + userPhone + ", userState=" + userState
				+ ", userNickname=" + userNickname + ", userSex=" + userSex + ", userPic=" + userPic + "]";
	}
	
}


