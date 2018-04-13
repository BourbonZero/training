package service;

import entity.Course;
import entity.MyClass;
import entity.Order;
import entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author Bourbon
 * @date 2018/4/7
 * @description
 */
public interface UserService {

	boolean registerUser(User user);

	User loginUser(String id, String password);

	boolean setAccount(String userid, String id, String password);

	User findInfo(String id);

	boolean setInfo(User user);

	boolean exchangePoint(String userid);

	boolean submitOrder(Order order);

	boolean payOrder(Order order);

	boolean cancelOrder(Order order);

	ArrayList<Order> lookoverOrders(String userid);

	ArrayList<Course> lookoverCourses();

	ArrayList<MyClass> lookoeverMyclasses(String userid);
}
