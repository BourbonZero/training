package dao.impl;

import dao.CourseDAO;
import dao.OrderDAO;
import entity.Course;
import entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bourbon
 * @date 2018/4/9
 * @description
 */
@Component
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private CourseDAO courseDAO;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int addOrder(Order order) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String sql = "insert into orders VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		if (jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1,0);
				ps.setString(2,order.getUserid());
				ps.setInt(3,order.getCourseid());
				ps.setString(4,order.getCourseName());
				ps.setString(5,order.getClassType());
				ps.setString(6,order.getState());
				ps.setDouble(7,order.getPrice());
				ps.setDouble(8,order.getDiscount());
				ps.setDouble(9,order.getConsumption());
				ps.setDouble(10,order.getActualConsumption());
				ps.setDouble(11, order.getInstitutionIncome());
				ps.setDouble(12, order.getCollegeIncome());
				return ps;
			}
		}, keyHolder) > 0) {
			return keyHolder.getKey().intValue();
		}
		return 0;
	}

	@Override
	public Order find(int id) {
		String sql = "select * from orders where id = ?";
		try {
			return jdbcTemplate.queryForObject(sql, new OrderRowMapper(), id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Order> findOrdersByUserid(String userid) {
		String sql = "SELECT * FROM orders WHERE userid = ?";
		return jdbcTemplate.query(sql, new OrderRowMapper(),userid);
	}

	@Override
	public List<Order> findOrdersByInstitutionid(int id) {
		List<Course> courses = courseDAO.findCoursesByInstitution(id);
		String sql = "SELECT * FROM orders WHERE courseid = ?";
		List<Order> orders = new ArrayList<>();
		for (Course course:courses){
			orders.addAll(jdbcTemplate.query(sql, new OrderRowMapper(), course.getCourseid()));
		}
		return orders;
	}

	@Override
	public boolean changeOrder(Order order) {
		String sql = "update orders set state = ?, actualConsumption = ? , institutionIncome = ?, collegeIncome = ? WHERE id = ?";
		if (jdbcTemplate.update(sql, order.getState(), order.getActualConsumption(), order.getInstitutionIncome(), order.getCollegeIncome(), order.getOrderid()) > 0) {
			return true;
		}
		return false;
	}

	private static final class OrderRowMapper implements RowMapper<Order> {

		@Override
		public Order mapRow(ResultSet resultSet, int i) throws SQLException {
			Order order = new Order();
			order.setOrderid(resultSet.getInt("id"));
			order.setUserid(resultSet.getString("userid"));
			order.setCourseid(resultSet.getInt("courseid"));
			order.setCourseName(resultSet.getString("courseName"));
			order.setClassType(resultSet.getString("classType"));
			order.setState(resultSet.getString("state"));
			order.setPrice(resultSet.getDouble("price"));
			order.setDiscount(resultSet.getDouble("discount"));
			order.setConsumption(resultSet.getDouble("consumption"));
			order.setActualConsumption(resultSet.getDouble("actualConsumption"));
			order.setInstitutionIncome(resultSet.getDouble("institutionIncome"));
			order.setCollegeIncome(resultSet.getDouble("collegeIncome"));
			return order;
		}
	}
}
