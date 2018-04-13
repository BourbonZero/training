package entity;

/**
 * @author Bourbon
 * @date 2018/4/7
 * @description
 */
public class Institution {

	private int id;
	private String password;
	private String info = "";
	private boolean permission = false;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public boolean isPermission() {
		return permission;
	}

	public void setPermission(boolean permission) {
		this.permission = permission;
	}
}
