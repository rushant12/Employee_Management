package digital.project.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import digital.project.employeemanagement.configuration.UserResponse;
import digital.project.employeemanagement.model.EmployeeDetails;
import digital.project.employeemanagement.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	
	  @PostMapping (value = "/createEmployee")
      public ResponseEntity<UserResponse> createEmployee(@RequestBody EmployeeDetails employeeDetails)
      {
		 System.out.println("Test");  
		  UserResponse response = employeeService.createEmployee(employeeDetails);
		  return new ResponseEntity<UserResponse>(response, HttpStatus.CREATED);
    	  
      }
	  
	  @GetMapping ("/value/{empCode}")
	  public ResponseEntity<?> getEmployeeByEmployeeCode(@PathVariable int empCode)
	  {
		return employeeService.getEmployeeDetailsByEmployeeCode(empCode);  
		 
	  }
	  
	  @DeleteMapping ("/delete/{empCode}")
	  public ResponseEntity<String> deleteEmployeeByEmployeeCode(@PathVariable int empCode)
	  {
		  return new ResponseEntity(employeeService.deleteEmployee(empCode),HttpStatus.OK);
	  }

}
