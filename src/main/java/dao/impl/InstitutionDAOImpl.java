package dao.impl;

import dao.InstitutionDAO;
import entity.Institution;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.List;

/**
 * @author Bourbon
 * @date 2018/4/12
 * @description
 */
@Component
public class InstitutionDAOImpl implements InstitutionDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int addInstitution(Institution institution) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String sql = "insert into institution (password, info, permission) VALUES (?, ? ,?)";
		if (jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, institution.getPassword());
				ps.setString(2, institution.getInfo());
				ps.setBoolean(3, false);
				return ps;
			}
		}, keyHolder) > 0) {
			return keyHolder.getKey().intValue();
		}
		return 0;
	}

	@Override
	public boolean changeInstitutionInfo(int id, String info) {
		String sql = "UPDATE institution SET info = ? WHERE  id = ?";
		if (jdbcTemplate.update(sql, info, id) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean changeInstitutionPermission(int id, boolean permission) {
		String sql = "UPDATE institution SET permission = ? WHERE  id = ?";
		if (jdbcTemplate.update(sql, permission, id) > 0) {
			return true;
		}
		return false;
	}



	@Override
	public Institution findInstitution(int id) {
		String sql = "select * from institution where id = ?";
		try {
			return jdbcTemplate.queryForObject(sql, new InstitutionRowMapper(), id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Institution> findAllInstitutions() {
		String sql = "select * from institution";
		return jdbcTemplate.query(sql, new InstitutionRowMapper());
	}

	private static final class InstitutionRowMapper implements RowMapper<Institution> {

		@Override
		public Institution mapRow(ResultSet resultSet, int i) throws SQLException {
			Institution institution = new Institution();
			institution.setId(resultSet.getInt("id"));
			institution.setPassword(resultSet.getString("password"));
			institution.setInfo(resultSet.getString("info"));
			institution.setPermission(resultSet.getBoolean("permission"));
			return institution;
		}
	}
}
