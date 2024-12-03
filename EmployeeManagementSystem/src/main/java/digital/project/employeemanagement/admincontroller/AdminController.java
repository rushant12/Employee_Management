package digital.project.employeemanagement.admincontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import digital.project.employeemanagement.admindao.EmployeeDao;
import digital.project.employeemanagement.admindao.RoleDao;
import digital.project.employeemanagement.adminservice.AdminService;
import digital.project.employeemanagement.projection.ProjectionImpl;

@RestController
@RequestMapping (value = "/api/role")
public class AdminController {
	
	@Autowired
	
	AdminService adminService;
	
//	@GetMapping(value = "/getAllEmployee")
//	public ResponseEntity<List<EmployeeDao>> getAllEmployeeDetailsForRoleAssign()
//	{
//		return new ResponseEntity<List<EmployeeDao>>(adminService.getAllEmployeeForRoleAssign(), HttpStatus.OK);
//	}
	
	@GetMapping(value = "/getAllRole")
	public ResponseEntity<List<RoleDao>> getAllRoleForAssign()
	{
		return new ResponseEntity<List<RoleDao>>(adminService.getAllRoleForEmployeeRoleAssign(), HttpStatus.OK);
	}
	
	@GetMapping (value = "/test")
	public List<EmployeeDao> getEmployeeNameAndCode()
	{
		return adminService.getEmployeeNameAndCode();
	}

}
