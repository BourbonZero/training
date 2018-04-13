package dao.impl;

import dao.ClassDAO;
import entity.MyClass;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author Bourbon
 * @date 2018/4/9
 * @description
 */
@Component
public class ClassDAOImpl implements ClassDAO {

	@Override
	public ArrayList<MyClass> findClassByUserid(String userid) {
		return null;
	}

	@Override
	public int recordScore(MyClass myClass, double score) {
		return 0;
	}

	@Override
	public int deleteClassDAO(MyClass myClass) {
		return 0;
	}
}
