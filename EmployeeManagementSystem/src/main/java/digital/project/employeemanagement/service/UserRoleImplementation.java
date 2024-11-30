package digital.project.employeemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import digital.project.employeemanagement.configuration.Constants;
import digital.project.employeemanagement.exception.DuplicateFound;
import digital.project.employeemanagement.exception.EmployeeIsNull;
import digital.project.employeemanagement.model.UserRole;
import digital.project.employeemanagement.repository.UserRoleRepository;

@Service
public class UserRoleImplementation implements UserRoleService {
	
	@Autowired
	UserRoleRepository userRoleRepository;

	@Override
	public UserRole addRole(UserRole userRole) {
		
		if (userRole.getRoleName() == null) {
			throw new EmployeeIsNull("Role Name is Required");
		}
		if (userRoleRepository.existsByRoleName(userRole.getRoleName())){
			throw new DuplicateFound("Role Already Exist");
		}
		userRole.setRoleStatus(Constants.ACTIVE);
		return userRoleRepository.save(userRole);
	}

}
