package dao;

import entity.Institution;

/**
 * @author Bourbon
 * @date 2018/4/12
 * @description
 */
public interface InstitutionDAO {

	int addInstitution(Institution institution);

	boolean changeInstitution(Institution institution);

	Institution findInstitution(int id);
}
