package service;

import entity.Institution;
import sun.security.util.Password;

/**
 * @author Bourbon
 * @date 2018/4/8
 * @description
 */
public interface AdministratorService {

	boolean checkLogin(String id, String password);

	boolean checkAddInstitution(Institution institution);

	int distributePay();


}
