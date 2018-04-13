package service.impl;

import dao.InstitutionDAO;
import entity.Course;
import entity.Institution;
import entity.MyClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.InstitutionService;

/**
 * @author Bourbon
 * @date 2018/4/12
 * @description
 */
@Component
public class InstitutionServiceImpl implements InstitutionService {

	@Autowired
	private InstitutionDAO institutionDAO;

	@Override
	public int registerInstitution(Institution institution) {
		return 0;
	}

	@Override
	public Institution loginInstitution(String id, String password) {
		return null;
	}

	@Override
	public int changeInstitution(String id, String info) {
		return 0;
	}

	@Override
	public int publishCourse(Course course) {
		return 0;
	}

	@Override
	public int recordScore(MyClass myClass, double score) {
		return 0;
	}
}
