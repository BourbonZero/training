package entity;

import org.springframework.stereotype.Component;

/**
 * @author Bourbon
 * @date 2018/4/7
 * @description
 */
public class User {

	private String userid;
	private String password;
	private double totalConsumption = 0;
	private boolean isVIP = false;
	private int viplevel = 0;
	private String info = "";
	private String accountid;
	private int point = 0;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getTotalConsumption() {
		return totalConsumption;
	}

	public void setTotalConsumption(double totalConsumption) {
		this.totalConsumption = totalConsumption;
	}

	public boolean isVIP() {
		return isVIP;
	}

	public void setVIP(boolean VIP) {
		isVIP = VIP;
	}

	public int getViplevel() {
		return viplevel;
	}

	public void setViplevel(int viplevel) {
		this.viplevel = viplevel;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
}
