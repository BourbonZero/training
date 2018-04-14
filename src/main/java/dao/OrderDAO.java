package dao;

import common.OrderState;
import entity.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bourbon
 * @date 2018/4/8
 * @description
 */
@Repository
public interface OrderDAO {

	int addOrder(Order order);

	Order find(int id);

	List<Order> findOrdersByUserid(String userid);

	List<Order> findOrdersByInstitutionid(int id);

	boolean changeOrder(Order order);
}
