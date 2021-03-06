package entity;

import org.springframework.stereotype.Component;

/**
 * @author Bourbon
 * @date 2018/4/8
 * @description
 */
@Component
public class Account {

	private String id;
	private String password;
	private double balance;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
