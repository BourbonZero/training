package dao.impl;

import dao.AdministratorDAO;
import entity.Administrator;
import entity.Institution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Bourbon
 * @date 2018/4/14
 * @description
 */
@Component
public class AdministratorDAOImpl implements AdministratorDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Administrator find(String id) {
		String sql = "select * from administrators where id = ?";
		try {
			return jdbcTemplate.queryForObject(sql, new AdministratorRowMapper(), id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	private static final class AdministratorRowMapper implements RowMapper<Administrator> {

		@Override
		public Administrator mapRow(ResultSet resultSet, int i) throws SQLException {
			Administrator administrator = new Administrator();
			administrator.setId(resultSet.getString("id"));
			administrator.setPassword(resultSet.getString("password"));
			return administrator;
		}
	}
}
