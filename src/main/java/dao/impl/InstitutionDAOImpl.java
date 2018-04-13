package dao.impl;

import dao.InstitutionDAO;
import entity.Institution;
import org.springframework.stereotype.Component;

/**
 * @author Bourbon
 * @date 2018/4/12
 * @description
 */
@Component
public class InstitutionDAOImpl implements InstitutionDAO {
	@Override
	public String addInstitution(Institution institution) {
		return null;
	}

	@Override
	public int changeInstitution(Institution institution) {
		return 0;
	}

	@Override
	public Institution findInstitution(String id) {
		return null;
	}
}
