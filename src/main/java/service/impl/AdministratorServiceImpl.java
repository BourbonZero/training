package service.impl;

import dao.AdministratorDAO;
import dao.InstitutionDAO;
import dao.OrderDAO;
import dao.UserDAO;
import entity.Administrator;
import entity.Institution;
import entity.Order;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.AdministratorService;

import java.util.List;

/**
 * @author Bourbon
 * @date 2018/4/14
 * @description
 */
@Component
public class AdministratorServiceImpl implements AdministratorService {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private OrderDAO orderDAO;

	@Autowired
	private AdministratorDAO administratorDAO;

	@Autowired
	private InstitutionDAO institutionDAO;

	@Override
	public boolean checkLogin(String id, String password) {
		Administrator administrator = administratorDAO.find(id);
		if (administrator != null && administrator.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkAddInstitution(int id) {
		return institutionDAO.changeInstitutionPermission(id, true);
	}

	@Override
	public boolean distributePay(int orderid) {
		Order order = orderDAO.find(orderid);
		order.setInstitutionIncome(order.getActualConsumption()*0.8);
		order.setCollegeIncome(order.getActualConsumption()*0.2);
		return orderDAO.changeOrder(order);
	}

	@Override
	public List<User> lookoverUsers() {
		return userDAO.findAllUsers();
	}

	@Override
	public List<Institution> lookoverInstitutions() {
		return institutionDAO.findAllInstitutions();
	}

	@Override
	public List<Order> lookoverOrders() {
		return null;
	}
}
