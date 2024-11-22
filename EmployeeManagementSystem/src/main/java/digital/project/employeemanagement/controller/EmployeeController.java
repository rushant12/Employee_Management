package digital.project.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import digital.project.employeemanagement.util.EmployeeUtility;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeUtility employeeUtility;
	
	@GetMapping (value = "/")
	public String test()
	{
		System.out.println(employeeUtility.employeeCodeGenerator());
		System.out.println(EmployeeUtility.generateCurrentDate());
		return employeeUtility.employeeCodeGenerator();
	}

}
