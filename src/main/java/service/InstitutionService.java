package service;

import entity.Course;
import entity.Institution;
import entity.MyClass;

/**
 * @author Bourbon
 * @date 2018/4/7
 * @description
 */
public interface InstitutionService {

	int registerInstitution(Institution institution);

	Institution loginInstitution(String id, String password);

	int changeInstitution(String id, String info);

	int publishCourse(Course course);

	int recordScore(MyClass myClass, double score);

}
