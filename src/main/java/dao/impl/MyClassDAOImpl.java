package dao.impl;

import dao.MyClassDAO;
import entity.MyClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Bourbon
 * @date 2018/4/9
 * @description
 */
@Component
public class MyClassDAOImpl implements MyClassDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean addMyClass(MyClass myClass) {
		String sql = "INSERT INTO myclass VALUES (?,?,?,?,?)";
		if (jdbcTemplate.update(sql, null, myClass.getUserid(), myClass.getCourseid(), myClass.getCourseName(), myClass.getScore()) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(String userid, int courseid) {
		String sql = "DELETE FROM myclass WHERE userid = ?, courseid = ?";
		if (jdbcTemplate.update(sql, userid, courseid) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<MyClass> findClassByUserid(String userid) {
		String sql = "SELECT * FROM myclass WHERE userid = ?";
		return jdbcTemplate.query(sql, new MyClassRowMapper(), userid);
	}

	@Override
	public boolean recordScore(String userid, int courseid, double score) {
		String sql = "UPDATE myclass SET score = ? WHERE userid = ? AND courseid = ?";
		if (jdbcTemplate.update(sql, score, userid, courseid) > 0) {
			return true;
		}
		return false;
	}

	private static final class MyClassRowMapper implements RowMapper<MyClass> {

		@Override
		public MyClass mapRow(ResultSet resultSet, int i) throws SQLException {
			MyClass myClass = new MyClass();
			myClass.setId(resultSet.getInt("id"));
			myClass.setUserid(resultSet.getString("userid"));
			myClass.setCourseid(resultSet.getInt("courseid"));
			myClass.setCourseName(resultSet.getString("courseName"));
			myClass.setScore(resultSet.getInt("score"));
			return myClass;
		}
	}
}
