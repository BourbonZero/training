package dao.impl;

import dao.CourseDAO;
import entity.Course;
import entity.Institution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bourbon
 * @date 2018/4/9
 * @description
 */
@Component
public class CourseDAOImpl implements CourseDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Course findCourse(int id) {
		String sql = "select * from courses where id = ?";
		try {
			return jdbcTemplate.queryForObject(sql, new CourseRowMapper(), id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Course> findCoursesByInstitution(int id) {
		String sql = "SELECT * FROM courses WHERE institutionid = ?";
		return jdbcTemplate.query(sql, new CourseRowMapper(), id);
	}

	@Override
	public List<Course> findAllCourses() {
		String sql = "SELECT * from courses";
		return jdbcTemplate.query(sql, new CourseRowMapper());
	}

	@Override
	public boolean addCourse(Course course) {
		String sql = "INSERT into courses VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		if (jdbcTemplate.update(sql, null, course.getCoursename(), course.getInstitutionid(),
				course.getInfo(), course.getWeekNum(), course.getClassesPerWeek(),
				course.getBigClassNum(), course.getBigClassCurrentNum(), course.getBigClassPrice(),
				course.getSmallClassNum(), course.getSmallClassCurrentNum(), course.getSmallClassPrice(), course.getBeginTime()) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean changeCourse(Course course) {
		String sql = "update courses SET bigClassCurrentNum = ?, smallClassCurrentNum = ? WHERE id= ?";
		if (jdbcTemplate.update(sql, course.getBigClassCurrentNum(), course.getSmallClassCurrentNum(), course.getCourseid()) > 0) {
			return true;
		}
		return false;
	}

	private static final class CourseRowMapper implements RowMapper<Course> {

		@Override
		public Course mapRow(ResultSet resultSet, int i) throws SQLException {
			Course course = new Course();
			course.setCourseid(resultSet.getInt("id"));
			course.setCoursename(resultSet.getString("name"));
			course.setInstitutionid(resultSet.getInt("institutionid"));
			course.setInfo(resultSet.getString("info"));
			course.setWeekNum(resultSet.getInt("weekNum"));
			course.setClassesPerWeek(resultSet.getInt("classPerWeek"));
			course.setBigClassNum(resultSet.getInt("bigClassNum"));
			course.setBigClassCurrentNum(resultSet.getInt("bigClassCurrentNum"));
			course.setBigClassPrice(resultSet.getDouble("bigClassPrice"));
			course.setSmallClassNum(resultSet.getInt("smallClassNum"));
			course.setSmallClassCurrentNum(resultSet.getInt("smallClassCurrentNum"));
			course.setSmallClassPrice(resultSet.getDouble("smallClassPrice"));
			course.setBeginTime(resultSet.getDate("beginTime").toLocalDate());
			return course;
		}
	}

}
