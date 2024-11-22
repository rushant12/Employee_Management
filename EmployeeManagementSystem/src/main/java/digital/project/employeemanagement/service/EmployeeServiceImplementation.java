package digital.project.employeemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import digital.project.employeemanagement.model.EmployeeDetails;
import digital.project.employeemanagement.repository.EmployeeRepository;

public class EmployeeServiceImplementation implements EmployeeService{

	@Autowired
	public EmployeeRepository employeeRepository;
	
	
	@Override
	public EmployeeDetails createEmployee(EmployeeDetails employeeDetails) {
		return null;
	}

	@Override
	public EmployeeDetails updateEmployee(int employeeCode, EmployeeDetails employeeDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<EmployeeDetails> getEmployeeDetailsById(int employeeCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDetails> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteEmployee(int employeeCode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EmployeeDetails getEmployeeByDomainEmail(String domainEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDetails> getEmployeeDetailsByDepartmentId(int departmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDetails> getEmployeesByGender(String gender) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDetails> getEmployeesByJobType(String jobType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDetails> getEmployeesBySalaryRange(double minSalary, double maxSalary) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDetails> getEmployeesByMaritalStatus(String maritalStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDetails> getEmployeesByBloodGroup(String bloodGroup) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDetails> getEmployeesByManagerName(String managerName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDetails> getEmployeesByJoiningDateAfter(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getEmployeeCountByDepartment(long departmentId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
