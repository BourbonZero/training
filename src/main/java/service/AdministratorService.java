package service;

import entity.Institution;
import entity.Order;
import entity.User;
import sun.security.util.Password;

import java.util.List;

/**
 * @author Bourbon
 * @date 2018/4/8
 * @description
 */
public interface AdministratorService {

	boolean checkLogin(String id, String password);

	boolean checkAddInstitution(int id);

	boolean distributePay();

	List<User> lookoverUsers();

	List<Institution> lookoverInstitutions();

	List<Order> lookoverOrders();
}
