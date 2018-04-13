package dao.impl;

import common.OrderState;
import dao.OrderDAO;
import entity.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author Bourbon
 * @date 2018/4/9
 * @description
 */
@Component
public class OrderDAOImpl implements OrderDAO {

	@Override
	public boolean addOrder(Order order) {
		return false;
	}

	@Override
	public ArrayList<Order> findOrdersByUserid(String userid) {
		return null;
	}

	@Override
	public boolean changeOrder(int orderid, OrderState state, double consumption) {
		return false;
	}

}
