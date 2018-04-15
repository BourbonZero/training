package service.impl;

import common.OrderState;
import dao.*;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.UserService;
import util.VIPCalculator;

import java.time.LocalDate;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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
	private MyClassDAO myClassDAO;

	@Override
	public boolean registerUser(String userid, String password) {
		User user = new User();
		user.setUserid(userid);
		user.setPassword(password);
		user.setVIP(true);
		return userDAO.addUser(user);
	}

	@Override
	public boolean loginUser(String id, String password) {
		User user = userDAO.findUserInfo(id);
		if (user != null && user.getPassword().equals(password)) {
			return true;
		}
		return false;
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
		if (accountDAO.changeAccount(user.getAccountid(), change)) {
			user.setPoint(0);
			return userDAO.changeUser(user);
		}
		return false;
	}

	@Override
	public boolean submitOrder(String userid, int courseid, String classType) {
		Course course = courseDAO.findCourse(courseid);
		Order order = new Order();
		boolean flag = false;
		if (classType.equals("big")) {
			if (course.getBigClassCurrentNum() < course.getBigClassNum()) {
				course.setBigClassCurrentNum(course.getBigClassCurrentNum() + 1);
				courseDAO.changeCourse(course);
				order.setClassType("大班");
				order.setPrice(course.getBigClassPrice());
				flag = true;
			}
		} else {
			if (course.getSmallClassCurrentNum() < course.getSmallClassNum()) {
				course.setSmallClassCurrentNum(course.getSmallClassCurrentNum()+1);
				courseDAO.changeCourse(course);
				order.setClassType("小班");
				order.setPrice(course.getSmallClassPrice());
				flag = true;
			}
		}
		if (flag) {
			order.setUserid(userid);
			order.setCourseid(courseid);
			order.setCourseName(course.getCoursename());
			order.setState(OrderState.submit);
			order.setDiscount(VIPCalculator.calDiscountByViplevel(userDAO.findUserInfo(order.getUserid()).getViplevel()));
			order.setConsumption(order.getPrice() * (1 - order.getDiscount()));

			Timer timer = new Timer();
			int id = orderDAO.addOrder(order);
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					Order o = orderDAO.find(id);
					if (o.getState().equals(OrderState.submit)){
						o.setState(OrderState.cancel);
						orderDAO.changeOrder(o);
					}
				}
			}, 1000*60*15);
			return true;
		}
		return false;
	}

	@Override
	public boolean payOrder(int orderid) {
		Order order = orderDAO.find(orderid);
		if (order.getState().equals(OrderState.submit)) {
			accountDAO.changeAccount(userDAO.findUserInfo(order.getUserid()).getAccountid(), 0 - order.getConsumption());

			order.setActualConsumption(order.getConsumption());
			order.setState(OrderState.pay);

			addConsumption(order.getUserid(), order.getActualConsumption());

			MyClass myClass = new MyClass();
			myClass.setUserid(order.getUserid());
			myClass.setCourseid(order.getCourseid());
			myClass.setCourseName(courseDAO.findCourse(order.getCourseid()).getCoursename());
			myClassDAO.addMyClass(myClass);

			return orderDAO.changeOrder(order);
		}
		return false;
	}

	@Override
	public boolean cancelOrder(int orderid) {
		Order order = orderDAO.find(orderid);
		if (order.getState().equals(OrderState.submit)) {
			order.setState(OrderState.cancel);
			return orderDAO.changeOrder(order);
		}
		else if (order.getState().equals(OrderState.pay)) {
			order.setState(OrderState.back);
			LocalDate localDate = courseDAO.findCourse(order.getCourseid()).getBeginTime();
			if (!LocalDate.now().isAfter(localDate)) {
				addConsumption(order.getUserid(), -order.getActualConsumption());
				accountDAO.changeAccount(userDAO.findUserInfo(order.getUserid()).getAccountid(), order.getActualConsumption());
				order.setActualConsumption(0);
			}
			myClassDAO.delete(order.getUserid(), order.getCourseid());
			return orderDAO.changeOrder(order);
		}
		return false;
	}

	@Override
	public List<Order> lookoverOrders(String userid) {
		return orderDAO.findOrdersByUserid(userid);
	}

	@Override
	public List<Course> lookoverCourses() {
		return courseDAO.findAllCourses();
	}

	@Override
	public List<MyClass> lookoverMyclasses(String userid) {
		return myClassDAO.findClassByUserid(userid);
	}

	private void addConsumption(String userid, double consumption) {
		User user = userDAO.findUserInfo(userid);
		user.setTotalConsumption(user.getTotalConsumption() + consumption);
		user.setViplevel(VIPCalculator.calViplevelFromConsumption(user.getTotalConsumption()));
		user.setPoint(user.getPoint() + VIPCalculator.calPointFromConsumption(consumption));
		userDAO.changeUser(user);
	}
}
