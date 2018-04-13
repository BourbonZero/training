package dao;

import entity.Account;

/**
 * @author Bourbon
 * @date 2018/4/8
 * @description
 */
public interface AccountDAO {

	boolean changeAccount(String id, double change);

	Account findAccount(String id);
}
