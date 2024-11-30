package digital.project.employeemanagement.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionManager {
	
	@ExceptionHandler (value = DuplicateFound.class)
	public ResponseEntity<ExceptionData> getDuplicateFound(HttpServletRequest request, DuplicateFound duplicate)
	{
		ExceptionData data = new ExceptionData();
		data.setMessage(duplicate.getMessage());
		data.setPath(request.getRequestURI());	
		return new ResponseEntity(data, HttpStatus.CONFLICT);	
	}
	
	@ExceptionHandler (value = EmployeeIsNull.class)
	public ResponseEntity<ExceptionData> getEmployeeNull(HttpServletRequest request, EmployeeIsNull employeeNull)
	{
		ExceptionData data = new ExceptionData();
		data.setMessage(employeeNull.getMessage());
		data.setPath(request.getRequestURI());	
		return new ResponseEntity(data, HttpStatus.NOT_ACCEPTABLE);	
	}
	
	@ExceptionHandler (value = EmployeeIsDeactivated.class)
	public ResponseEntity<ExceptionData> employeeDeatcivated(HttpServletRequest request, EmployeeIsDeactivated deactive){
		ExceptionData data = new ExceptionData();
		data.setMessage(deactive.getMessage());
		data.setPath(request.getRequestURI());	
		return new ResponseEntity(data, HttpStatus.NOT_FOUND);	
	}
	
	@ExceptionHandler (value = ResourceNotFound.class)
	public ResponseEntity<ExceptionData> resourceNotAvailable(HttpServletRequest request, ResourceNotFound notfound)
	{
		ExceptionData data = new ExceptionData();
		data.setCode(404);
		data.setMessage(notfound.getMessage());
		data.setPath(request.getRequestURI());	
		data.setTimestamp(LocalDateTime.now());
		return new ResponseEntity(data, HttpStatus.NOT_FOUND);
	}
}
