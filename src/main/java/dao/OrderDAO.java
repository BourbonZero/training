package dao;

import common.OrderState;
import entity.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * @author Bourbon
 * @date 2018/4/8
 * @description
 */
@Repository
public interface OrderDAO {

	boolean addOrder(Order order);

	ArrayList<Order> findOrdersByUserid(String userid);

	boolean changeOrder(String orderid, OrderState state, double consumption);
}
