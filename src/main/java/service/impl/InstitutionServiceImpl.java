package service.impl;

import common.OrderState;
import dao.*;
import entity.Course;
import entity.Institution;
import entity.MyClass;
import entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.InstitutionService;
import util.VIPCalculator;

import java.util.List;

/**
 * @author Bourbon
 * @date 2018/4/12
 * @description
 */
@Component
public class InstitutionServiceImpl implements InstitutionService {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private InstitutionDAO institutionDAO;
	@Autowired
	private CourseDAO courseDAO;
	@Autowired
	private MyClassDAO myClassDAO;

	@Override
	public int registerInstitution(Institution institution) {
		return institutionDAO.addInstitution(institution);
	}

	@Override
	public boolean loginInstitution(int id, String password) {
		Institution institution = institutionDAO.findInstitution(id);
		if (institution != null && institution.getPassword().equals(password) && institution.isPermission()) {
			return true;
		}
		return false;
	}

	@Override
	public Institution findInstitution(int id) {
		return institutionDAO.findInstitution(id);
	}

	@Override
	public boolean changeInstitution(int id, String info) {

		return institutionDAO.changeInstitutionInfo(id, info);
	}

	@Override
	public boolean publishCourse(Course course) {
		course.setBigClassCurrentNum(0);
		course.setSmallClassCurrentNum(0);
		return courseDAO.addCourse(course);
	}

	@Override
	public boolean createOfflineOrder(String userid, int courseid, String classType) {
		Course course = courseDAO.findCourse(courseid);
		Order order = new Order();
		order.setUserid(userid);
		order.setCourseid(courseid);
		order.setCourseName(course.getCoursename());
		order.setClassType(classType);
		order.setState(OrderState.pay);
		if (classType.equals("大班")) {
			course.setBigClassCurrentNum(course.getBigClassCurrentNum() + 1);
			courseDAO.changeCourse(course);
			order.setPrice(course.getBigClassPrice());
		} else {
			course.setSmallClassCurrentNum(course.getSmallClassCurrentNum() + 1);
			courseDAO.changeCourse(course);
			order.setPrice(course.getSmallClassPrice());
		}
		order.setDiscount(VIPCalculator.calDiscountByViplevel(userDAO.findUserInfo(order.getUserid()).getViplevel()));
		order.setConsumption(order.getPrice() * (1 - order.getDiscount()));
		order.setActualConsumption(order.getConsumption());

		orderDAO.addOrder(order);

		MyClass myClass = new MyClass();
		myClass.setUserid(order.getUserid());
		myClass.setCourseid(order.getCourseid());
		myClass.setCourseName(courseDAO.findCourse(order.getCourseid()).getCoursename());

		return myClassDAO.addMyClass(myClass);
	}

	@Override
	public boolean recordScore(String userid, int courseid, int score) {
		return myClassDAO.recordScore(userid, courseid, score);
	}

	@Override
	public List<Order> lookoverOrders(int id) {
		return orderDAO.findOrdersByInstitutionid(id);
	}
}
