package service;

import entity.Course;
import entity.MyClass;
import entity.Order;
import entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bourbon
 * @date 2018/4/7
 * @description
 */
public interface UserService {

	boolean registerUser(String userid, String password);

	boolean loginUser(String id, String password);

	boolean setAccount(String userid, String id, String password);

	User findInfo(String id);

	boolean setInfo(User user);

	boolean exchangePoint(String userid);

	boolean submitOrder(String userid, int courseid, String classType);

	boolean payOrder(int orderid);

	boolean cancelOrder(int orderid);

	List<Order> lookoverOrders(String userid);

	List<Course> lookoverCourses();

	List<MyClass> lookoverMyclasses(String userid);
}
