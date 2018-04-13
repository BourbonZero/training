package dao.impl;

import dao.CourseDAO;
import entity.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author Bourbon
 * @date 2018/4/9
 * @description
 */
@Component
public class CourseDAOImpl implements CourseDAO{

	@Override
	public Course findCourse(String courseid) {
		return null;
	}

	@Override
	public ArrayList<Course> findAllCourses() {
		return null;
	}

	@Override
	public int addCourse(Course course) {
		return 0;
	}
}
