package digital.project.employeemanagement.util;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import digital.project.employeemanagement.repository.EmployeeRepository;

@Component
public class EmployeeUtility {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public synchronized String employeeCodeGenerator()
	{	
		long count = employeeRepository.count() + 1;
		StringBuilder employeeCode = new StringBuilder();
		employeeCode.append("EMP").append(count);
		return employeeCode.toString();	
	}
	
	public static LocalDate generateCurrentDate()
	{
		return LocalDate.now();
	}
	
	
}
