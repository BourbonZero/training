package dao.impl;

import dao.UserDAO;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Bourbon
 * @date 2018/4/8
 * @description
 */
@Component
public class UserDAOImpl implements UserDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean addUser(User user) {
		if (findUserInfo(user.getUserid()) == null) {
			String sql = "insert into user values (?,?,?,?,?,?)";
			if (jdbcTemplate.update(sql, user.getUserid(), user.getPassword(), user.getTotalConsumption(), user.isVIP(), user.getViplevel(), user.getInfo()) > 0)
				return true;
		}
		return false;
	}

	@Override
	public User findUserInfo(String userid) {
		String sql = "select * from user where userid = ?";
		return jdbcTemplate.queryForObject(sql, new UserRowMapper(), userid);
	}

	@Override
	public boolean changeUser(User user) {
		String sql = "update user set consumption = ? , isvip = ? , viplevel = ?, info = ?, accountid = ? point = where userid = ?";
		if (jdbcTemplate.update(sql, user.getTotalConsumption(), user.isVIP(), user.getViplevel(), user.getInfo(), user.getAccountid(), user.getPoint(), user.getUserid()) > 0) {
			return true;
		}
		return false;
	}

	private static final class UserRowMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet resultSet, int i) throws SQLException {
			User user = new User();
			user.setUserid(resultSet.getString("userid"));
			user.setPassword(resultSet.getString("password"));
			user.setTotalConsumption(resultSet.getDouble("totalConsumption"));
			user.setVIP(resultSet.getBoolean("isVIP"));
			user.setViplevel(resultSet.getInt("viplevel"));
			user.setInfo(resultSet.getString("info"));
			return user;
		}
	}
}
