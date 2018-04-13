package dao.impl;

import dao.AccountDAO;
import entity.Account;
import org.springframework.stereotype.Component;

/**
 * @author Bourbon
 * @date 2018/4/9
 * @description
 */
@Component
public class AccountDAOImpl implements AccountDAO {

	@Override
	public boolean changeAccount(String id, double change) {
		return false;
	}

	@Override
	public Account findAccount(String id) {
		return null;
	}
}
