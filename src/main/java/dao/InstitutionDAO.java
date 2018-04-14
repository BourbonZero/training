package dao;

import entity.Institution;

import java.util.List;

/**
 * @author Bourbon
 * @date 2018/4/12
 * @description
 */
public interface InstitutionDAO {

	int addInstitution(Institution institution);

	boolean changeInstitutionInfo(int id, String info);

	boolean changeInstitutionPermission(int id, boolean permission);

	Institution findInstitution(int id);

	List<Institution> findAllInstitutions();
}
