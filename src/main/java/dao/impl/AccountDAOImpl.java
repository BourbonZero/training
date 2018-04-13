package dao.impl;

import dao.AccountDAO;
import entity.Account;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Bourbon
 * @date 2018/4/9
 * @description
 */
@Component
public class AccountDAOImpl implements AccountDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean changeAccount(String id, double change) {
		Account account = findAccount(id);
		double result = account.getBalance() + change;
		System.out.println(account.getBalance());
		System.out.println(result);
		String sql = "update account set balance = ? where id = ?";
		if (jdbcTemplate.update(sql, result, id)> 0 ){
			return true;
		}
		return false;
	}

	@Override
	public Account findAccount(String id) {
		try{
			String sql = "SELECT * from account WHERE id = ?";
			Account account = jdbcTemplate.queryForObject(sql, new AccountRowMapper(),id);
			return account;
		}catch (EmptyResultDataAccessException e){
			return null;
		}
	}

	private static final class AccountRowMapper implements RowMapper<Account>{

		@Override
		public Account mapRow(ResultSet resultSet, int i) throws SQLException {
			Account account = new Account();
			account.setId(resultSet.getString("id"));
			account.setPassword(resultSet.getString("password"));
			account.setBalance(resultSet.getDouble("balance"));
			return account;
		}
	}
}
