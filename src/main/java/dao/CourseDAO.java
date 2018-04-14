package dao;

import entity.Course;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bourbon
 * @date 2018/4/9
 * @description
 */
public interface CourseDAO {

	Course findCourse(int courseid);

	List<Course> findCoursesByInstitution(int id);

	List<Course> findAllCourses();

	boolean addCourse(Course course);

	boolean changeCourse(Course course);
}
