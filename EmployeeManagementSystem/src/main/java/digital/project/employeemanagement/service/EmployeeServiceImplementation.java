package digital.project.employeemanagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import digital.project.employeemanagement.configuration.Constants;
import digital.project.employeemanagement.configuration.UserResponse;
import digital.project.employeemanagement.exception.DuplicateFound;
import digital.project.employeemanagement.exception.EmployeeIsDeactivated;
import digital.project.employeemanagement.exception.EmployeeIsNull;
import digital.project.employeemanagement.exception.ResourceNotFound;
import digital.project.employeemanagement.model.EmployeeDetails;
import digital.project.employeemanagement.repository.EmployeeRepository;
import digital.project.employeemanagement.util.EmployeeUtility;
import digital.project.employeemanagement.util.MailMessage;

@Service
public class EmployeeServiceImplementation implements EmployeeService{

	@Autowired
	public EmployeeRepository employeeRepository;
	
	@Autowired
	public MailMessage mailmessage;
	
	@Transactional
	@Override
	public UserResponse createEmployee(EmployeeDetails employeeDetails) {
		UserResponse userResponse = new UserResponse();
		
		if (employeeDetails == null)
	    {
	       throw new EmployeeIsNull("Employee Details is Null");
	    }	
		
	boolean flag = employeeRepository.existsByPanNumberAndPersonalEmailAddress(employeeDetails.getPanNumber(),
			                                               employeeDetails.getPersonalEmailAddress());
	
    System.out.println(flag);
	if(flag)
    {
       throw new DuplicateFound("Employee already exist");							
    } 
       String employeeCode = EmployeeUtility.employeeCodeGenerator(employeeRepository.count());
	   employeeDetails.setEmployeeCode(employeeCode);
	   
	   StringBuilder domainEmail = new StringBuilder();
	   employeeDetails.setDomainEmailAddress(domainEmail.append(employeeDetails.getEmployeeFirstName()).append(".")
			                                                    .append(employeeDetails.getEmployeeLastName()).append("@anweb.com").toString());
	   
	   employeeDetails.setEmployeeStatus(Constants.ACTIVE); // Activating Employee Status True While creating 
	   System.out.println(employeeDetails.isEmployeeStatus());
	   
	   // Adding Generated Password
	   employeeDetails.setPassword(EmployeeUtility.passwordGenerator());
	   EmployeeDetails employee = employeeRepository.save(employeeDetails);
	   
	   
	   if (employee == null) {
		   throw new EmployeeIsNull("Employee Details not updated");
	   }
	   userResponse.setMsg("Employee Added Successfully");
	   userResponse.setUrl("/create");
	   mailmessage.mailSender(employee.getPersonalEmailAddress(), employee.getEmployeeFirstName());
	   return userResponse;
		
	}
	
	

	@Override
	public EmployeeDetails updateEmployee(int employeeCode, EmployeeDetails employeeDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> getEmployeeDetailsByEmployeeCode(int employeeCode) {
		String empCode = EmployeeUtility.employeeCodeCreate(employeeCode);
		EmployeeDetails employeeDetails = employeeRepository.findByEmployeeCode(empCode);
		
		if(employeeDetails == null)
		{
			    throw new ResourceNotFound("Invalid Code");
		}
		if(employeeDetails.isEmployeeStatus() == false)
		{
		        throw new EmployeeIsDeactivated("Employee Deactivated, Please contact to admin");
		}
			
		return new ResponseEntity(employeeDetails, HttpStatus.OK);
	}

	@Override
	public List<EmployeeDetails> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEmployee(int employeeCode) {
		
	String empCode = EmployeeUtility.employeeCodeCreate(employeeCode);	
	EmployeeDetails employeeDetails = employeeRepository.findByEmployeeCode(empCode);	
	if(employeeDetails == null)
	{
		    throw new ResourceNotFound("Invalid Code");
	}
	if(employeeDetails.isEmployeeStatus() == false)
	{
	        throw new EmployeeIsDeactivated("Employee Already Deactivated, Please contact to admin");
	}
	
	employeeDetails.setEmployeeStatus(Constants.DEACTIVE);
	EmployeeDetails employee = employeeRepository.save(employeeDetails);	
	if(employee.getEmployeeId() == 0)
	{
		throw new ResourceNotFound("Unable to Delet Employee");
	}
		return "Employee Deavtivated Successfully";
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
