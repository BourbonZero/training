package service;

import entity.Institution;

/**
 * @author Bourbon
 * @date 2018/4/8
 * @description
 */
public interface AdministratorService {

	boolean checkInstitution(Institution institution);

	int distributePay();


}
