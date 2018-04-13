package entity;

/**
 * @author Bourbon
 * @date 2018/4/11
 * @description
 */
public class Login {

	private String loginid;
	private String password;
	private String role;

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
