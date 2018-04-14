package service.impl;

import dao.AdministratorDAO;
import dao.InstitutionDAO;
import entity.Administrator;
import entity.Institution;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.AdministratorService;

import java.util.List;

/**
 * @author Bourbon
 * @date 2018/4/14
 * @description
 */
@Component
public class AdministratorServiceImpl implements AdministratorService {

	@Autowired
	private AdministratorDAO administratorDAO;

	@Autowired
	private InstitutionDAO institutionDAO;

	@Override
	public boolean checkLogin(String id, String password) {
		Administrator administrator = administratorDAO.find(id);
		if (administrator != null && administrator.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkAddInstitution(int id) {
		return institutionDAO.changeInstitutionPermission(id, true);
	}

	@Override
	public boolean distributePay() {
		return false;
	}

	@Override
	public List<User> lookoverUsers() {
		return null;
	}

	@Override
	public List<Institution> lookoverInstitutions() {
		return null;
	}
}
