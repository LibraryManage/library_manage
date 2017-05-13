package library_manage.entity;

public class User {

	private int userId;                     //�û�id
	private String userAccount;             //�û��˺�
	private String userPassword;            //�û�����
	private String userEmail;               //�û�����
	private String userPhone;               //�û��ֻ�
	private int userState;                  //�û�״̬��0��ʾɾ����1��ʾ���ڣ�
	private String userNickname;            //�û��ǳ�
	private String userSex;                 //�û��Ա�
	private String userPic;                 //�û�ͷ��
	
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


