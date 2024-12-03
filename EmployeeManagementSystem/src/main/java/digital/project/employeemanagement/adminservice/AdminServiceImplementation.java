package digital.project.employeemanagement.adminservice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import digital.project.employeemanagement.admindao.EmployeeDao;
import digital.project.employeemanagement.admindao.RoleDao;

import digital.project.employeemanagement.model.UserRole;

import digital.project.employeemanagement.repository.EmployeeRepository;
import digital.project.employeemanagement.repository.UserRoleRepository;

@Service
public class AdminServiceImplementation implements AdminService {
	 
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	UserRoleRepository userRoleRepository;
	
	
//	public List<EmployeeDao> getAllEmployeeForRoleAssign(){
//		
//		List<EmployeeDao> empDetails = employeeRepository.findAll().stream().filter(EmployeeDetails::isEmployeeStatus).map(edetails -> {
//			EmployeeDao employeeDao = new EmployeeDao();
//			employeeDao.setEmployeeCode(edetails.getEmployeeCode());
//			employeeDao.setEmployeeFirstName(edetails.getEmployeeFirstName());
//			employeeDao.setEmployeeLastName(edetails.getEmployeeLastName());	
//			return employeeDao;
//		}).collect(Collectors.toList());
//		return empDetails;
//	}


	@Override
	public List<RoleDao> getAllRoleForEmployeeRoleAssign() {
		
		List<RoleDao> roleList = userRoleRepository.findAll()
				                 .stream().filter(UserRole::isRoleStatus)
				                 .map(role -> {
				                	 RoleDao roleDao = new RoleDao();
				                	 roleDao.setRoleId(role.getRoleId());
				                	 roleDao.setRoleName(role.getRoleName());
				                	 return roleDao;
				                 }).collect(Collectors.toList());
		return roleList;
	}


	@Override
	public List<EmployeeDao> getEmployeeNameAndCode() {
	//	 employeeRepository.findAllEmployeeProjections();
		 return employeeRepository.findAllEmployeeProjections();
	}
	
	

}
