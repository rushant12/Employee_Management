package digital.project.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import digital.project.employeemanagement.exception.DuplicateFound;
import digital.project.employeemanagement.exception.EmployeeIsDeactivated;
import digital.project.employeemanagement.exception.EmployeeIsNull;
import digital.project.employeemanagement.exception.ResourceNotFound;
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
	
	@GetMapping (value = "/getAllRole")
	public ResponseEntity<List<UserRole>> getAllRole()
	{
		return new ResponseEntity<List<UserRole>>(userRoleService.getAllRole(), HttpStatus.OK);
	}
	
	@DeleteMapping (value = "/delete/{id}")
	public ResponseEntity<UserResponse> deleteRole(@PathVariable int id)
	{
		UserResponse userResponse = new UserResponse();
		if(userRoleService.deleteRole(id)) {
			userResponse.setCode("Success");
			userResponse.setMsg("Role Deleted successfully");	
		}else {
			userResponse.setCode("Failure");
			userResponse.setMsg("Unable to delete Role");
			return new ResponseEntity<UserResponse>(userResponse, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);	
	}
	
	
	@GetMapping(value = "/getRole/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable int id)
	{
		UserResponse userResponse = new UserResponse();
		try {
		 UserRole role = userRoleService.getRoleById(id);
		 return new ResponseEntity(role, HttpStatus.OK);
		}catch(ResourceNotFound resourceNotFound) {
			userResponse.setCode("Failure");
			userResponse.setMsg("Role not found");
			return new ResponseEntity(userResponse, HttpStatus.NOT_FOUND);
		} catch(EmployeeIsDeactivated deactive) {
			userResponse.setCode("Failed");
			userResponse.setMsg("Role is Deactivated");
			return new ResponseEntity(userResponse, HttpStatus.FORBIDDEN);
		} catch (Exception e) {
			userResponse.setCode("Error");
			userResponse.setMsg("Unexpected error occur");
			return new ResponseEntity(userResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
