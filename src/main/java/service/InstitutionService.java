package service;

import entity.Course;
import entity.Institution;
import entity.MyClass;
import entity.Order;

import java.util.List;

/**
 * @author Bourbon
 * @date 2018/4/7
 * @description
 */
public interface InstitutionService {

	int registerInstitution(Institution institution);

	boolean loginInstitution(int id, String password);

	Institution findInstitution(int id);

	boolean changeInstitution(int id, String info);

	boolean publishCourse(Course course);

	boolean createOfflineOrder(String userid, int courseid, String classType);

	boolean recordScore(String userid, int courseid, int score);

	List<Order> lookoverOrders(int id);
}
