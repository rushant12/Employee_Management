package digital.project.employeemanagement.service;

import java.util.List;
import java.util.Optional;

import digital.project.employeemanagement.model.EmployeeDetails;

public interface EmployeeService {
	
	EmployeeDetails createEmployee(EmployeeDetails employeeDetails);
	
	EmployeeDetails updateEmployee(int employeeCode, EmployeeDetails employeeDetails);
	
	Optional<EmployeeDetails> getEmployeeDetailsById(int employeeCode);
	
	List<EmployeeDetails> getAllEmployees();
	
	boolean deleteEmployee(int employeeCode);
	
	 EmployeeDetails getEmployeeByDomainEmail(String domainEmail);
	
	 List<EmployeeDetails> getEmployeeDetailsByDepartmentId(int departmentId);
	 
	 List<EmployeeDetails> getEmployeesByGender(String gender);
	
	 List<EmployeeDetails> getEmployeesByJobType(String jobType);
	 
	 List<EmployeeDetails> getEmployeesBySalaryRange(double minSalary, double maxSalary);
	 
	 List<EmployeeDetails> getEmployeesByMaritalStatus(String maritalStatus);
	 
	 List<EmployeeDetails> getEmployeesByBloodGroup(String bloodGroup);
	 
	 List<EmployeeDetails> getEmployeesByManagerName(String managerName);
	 
	 List<EmployeeDetails> getEmployeesByJoiningDateAfter(String date);
	 
	 long getEmployeeCountByDepartment(long departmentId);

}
