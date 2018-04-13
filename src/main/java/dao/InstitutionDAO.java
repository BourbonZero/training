package dao;

import entity.Institution;

/**
 * @author Bourbon
 * @date 2018/4/12
 * @description
 */
public interface InstitutionDAO {

	String addInstitution(Institution institution);

	int changeInstitution(Institution institution);

	Institution findInstitution(String id);
}
