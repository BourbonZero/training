package dao;

import entity.MyClass;

import java.util.ArrayList;

/**
 * @author Bourbon
 * @date 2018/4/8
 * @description 我的课程
 */
public interface ClassDAO {

	ArrayList<MyClass> findClassByUserid(String userid);

	int recordScore(MyClass myClass, double score);

	int deleteClassDAO(MyClass myClass);
}
