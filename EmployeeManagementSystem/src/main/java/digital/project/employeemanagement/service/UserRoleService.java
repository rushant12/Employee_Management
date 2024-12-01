package digital.project.employeemanagement.service;

import java.util.List;

import digital.project.employeemanagement.model.UserRole;

public interface UserRoleService {
	
	UserRole addRole(UserRole userRole);
	
	List<UserRole> getAllRole();
	
	boolean deleteRole(int id);
	
	UserRole getRoleById(int id);

}
