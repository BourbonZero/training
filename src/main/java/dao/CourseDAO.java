package dao;

import entity.Course;

import java.util.ArrayList;

/**
 * @author Bourbon
 * @date 2018/4/9
 * @description
 */
public interface CourseDAO {

	Course findCourse(String courseid);

	ArrayList<Course> findAllCourses();

	int addCourse(Course course);
}
