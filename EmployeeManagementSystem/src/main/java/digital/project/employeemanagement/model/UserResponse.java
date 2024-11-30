package digital.project.employeemanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class UserResponse {
	
	private String msg;
	
	private String code;
	
	private UserRole data;

	
}