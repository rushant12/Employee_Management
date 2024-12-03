package digital.project.employeemanagement.adminservice;

import java.util.List;

import digital.project.employeemanagement.admindao.EmployeeDao;
import digital.project.employeemanagement.admindao.RoleDao;
import digital.project.employeemanagement.projection.ProjectionImpl;

public interface AdminService {
	
//	public List<EmployeeDao> getAllEmployeeForRoleAssign();
	
	public List<RoleDao> getAllRoleForEmployeeRoleAssign();
	
	public List<EmployeeDao> getEmployeeNameAndCode();

}
