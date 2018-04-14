package dao;

import entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Bourbon
 * @date 2018/4/8
 * @description
 */
public interface UserDAO {

	boolean addUser(User user);

	User findUserInfo(String userid);

	boolean changeUser(User user);

	List<User> findAllUsers();
}
