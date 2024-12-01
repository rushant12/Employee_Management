package digital.project.employeemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import digital.project.employeemanagement.configuration.Constants;
import digital.project.employeemanagement.exception.DuplicateFound;
import digital.project.employeemanagement.exception.EmployeeIsDeactivated;
import digital.project.employeemanagement.exception.EmployeeIsNull;
import digital.project.employeemanagement.exception.ResourceNotFound;
import digital.project.employeemanagement.model.UserRole;
import digital.project.employeemanagement.repository.UserRoleRepository;

@Service
public class UserRoleImplementation implements UserRoleService {

        System.out.println("Repository Testing");
	
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

	@Override
	public List<UserRole> getAllRole() {
		return userRoleRepository.findAll();
	}

	@Override
	public boolean deleteRole(int id) {
		boolean flag = false;
		if (userRoleRepository.existsById(id)) {
			UserRole role = userRoleRepository.findById(id).get();
			if(role.isRoleStatus() == true)
			{
				role.setRoleStatus(Constants.DEACTIVE);
				userRoleRepository.save(role);
				flag = true;
			}else {
				throw new DuplicateFound("User is already deactivated");
			}	
		}else {
			throw new ResourceNotFound("Invalid Id:");
			}	
		return flag;
	}

	@Override
	public UserRole getRoleById(int id) {
		if(id == 0 && !userRoleRepository.existsById(id))
		{
			throw new ResourceNotFound("Invalid Id:");
		} if (!userRoleRepository.findById(id).get().isRoleStatus()) {
			throw new EmployeeIsDeactivated("Role is deactivated");
		}
		return userRoleRepository.findById(id).get();	
	}
}
