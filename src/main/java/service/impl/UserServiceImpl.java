package service.impl;

import common.OrderState;
import dao.*;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.UserService;
import util.VIPCalculator;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Bourbon
 * @date 2018/4/7
 * @description
 */
@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private CourseDAO courseDAO;
	@Autowired
	private AccountDAO accountDAO;
	@Autowired
	private ClassDAO classDAO;

	@Override
	public boolean registerUser(User user) {
		return userDAO.addUser(user);
	}

	@Override
	public User loginUser(String id, String password) {
		User user = userDAO.findUserInfo(id);
		if (user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}

	@Override
	public boolean setAccount(String userid, String id, String password) {
		Account account = accountDAO.findAccount(id);
		if (account != null && account.getPassword().equals(password)) {
			User user = userDAO.findUserInfo(userid);
			user.setAccountid(id);
			return userDAO.changeUser(user);
		}
		return false;
	}

	@Override
	public User findInfo(String id) {
		return userDAO.findUserInfo(id);
	}

	@Override
	public boolean setInfo(User user) {
		return userDAO.changeUser(user);
	}

	@Override
	public boolean exchangePoint(String userid) {
		User user = userDAO.findUserInfo(userid);
		double change = VIPCalculator.calChangeFromPoint(user.getPoint());
		if (accountDAO.changeAccount(user.getAccountid(), change)){
			user.setPoint(0);
			return userDAO.changeUser(user);
		}
		return false;
	}

	@Override
	public boolean submitOrder(Order order) {
		Course course = courseDAO.findCourse(order.getCourseid());
		boolean flag = false;
		if (order.getClassType().equals("大班")){
			if (course.getBigClassCurrentNum()<course.getBigClassNum()){
				flag = true;
			}
		}else {
			if (course.getSmallClassCurrentNum()<course.getSmallClassNum()){
				flag = true;
			}
		}
		if (flag){
			order.setDiscount(VIPCalculator.calDiscountByViplevel(userDAO.findUserInfo(order.getUserid()).getViplevel()));
			return orderDAO.addOrder(order);
		}
		return false;
	}

	@Override
	public boolean payOrder(Order order) {
		double consumption = order.getPrice() * (1 - order.getDiscount());
		orderDAO.changeOrder(order.getOrderid(), OrderState.已付款, consumption);
		double total = userDAO.findUserInfo(order.getUserid()).getTotalConsumption();

		return true;
	}

	@Override
	public boolean cancelOrder(Order order) {
		if (order.getState() == OrderState.待付款){
			return orderDAO.changeOrder(order.getOrderid(),OrderState.已取消, 0);
		}else if (order.getState() == OrderState.已付款){
			LocalDate localDate = courseDAO.findCourse(order.getCourseid()).getBeginTime();
			double consumption = order.getConsumption();
			if (localDate.isAfter(LocalDate.now())){
				accountDAO.changeAccount(userDAO.findUserInfo(order.getUserid()).getAccountid(), consumption);
				consumption = 0;
			}
			return orderDAO.changeOrder(order.getOrderid(), OrderState.已退款,consumption);
		}
		return false;
	}

	@Override
	public ArrayList<Order> lookoverOrders(String userid) {
		return orderDAO.findOrdersByUserid(userid);
	}

	@Override
	public ArrayList<Course> lookoverCourses() {

		return courseDAO.findAllCourses();
	}

	@Override
	public ArrayList<MyClass> lookoeverMyclasses(String userid) {

		return classDAO.findClassByUserid(userid);
	}

}
