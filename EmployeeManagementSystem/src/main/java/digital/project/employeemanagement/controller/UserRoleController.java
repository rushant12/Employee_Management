package digital.project.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import digital.project.employeemanagement.exception.DuplicateFound;
import digital.project.employeemanagement.exception.EmployeeIsNull;
import digital.project.employeemanagement.model.UserResponse;
import digital.project.employeemanagement.model.UserRole;
import digital.project.employeemanagement.service.UserRoleService;

@RestController
@RequestMapping ("/userRole")
public class UserRoleController {
	
	@Autowired
	UserRoleService userRoleService;
	
	@PostMapping(value = "/createRole")
	public ResponseEntity<UserResponse> createRole(@RequestBody UserRole userRole)
	{
		try {
		UserRole createRole = userRoleService.addRole(userRole);
		UserResponse response = new UserResponse();
		response.setCode("Success");
		response.setMsg("User Role Created Successfully");
		response.setData(createRole);
		return new ResponseEntity<UserResponse>(response, HttpStatus.CREATED);
		}
		catch(EmployeeIsNull nullException)
		{
			UserResponse response = new UserResponse();
			response.setCode("Failure");
			response.setMsg("User Role Values are Null");
			return new ResponseEntity<UserResponse>(response, HttpStatus.BAD_REQUEST);
		}
		catch (DuplicateFound duplicateException)
		{
			UserResponse response = new UserResponse();
			response.setCode("Failure");
			response.setMsg("User Role Already Exist");
			return new ResponseEntity<UserResponse>(response, HttpStatus.BAD_REQUEST);
		}
		catch (Exception exception){
			UserResponse response = new UserResponse();
			response.setCode("Error");
			response.setMsg("An Unexpected error");
			return new ResponseEntity<UserResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} 	
		
	}
}
