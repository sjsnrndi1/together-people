package jung.spring.vo;

public class UserInfoPasswordVO {
	private String user_id;
	private String user_password;
	private String user_passwordCheck;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_passwordCheck() {
		return user_passwordCheck;
	}
	public void setUser_passwordCheck(String user_passwordCheck) {
		this.user_passwordCheck = user_passwordCheck;
	}
}
