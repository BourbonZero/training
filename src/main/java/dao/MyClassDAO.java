package dao;

import entity.MyClass;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bourbon
 * @date 2018/4/8
 * @description 我的课程
 */
public interface MyClassDAO {

	boolean addMyClass(MyClass myClass);

	boolean delete(String userid, int courseid);

	List<MyClass> findClassByUserid(String userid);

	boolean recordScore(String userid, int courseid, double score);
}
