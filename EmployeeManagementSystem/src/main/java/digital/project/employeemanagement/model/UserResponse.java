package digital.project.employeemanagement.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
@ToString
@NoArgsConstructor
public class UserResponse {
	
	private String msg;
	
	private String code;
	
	private UserRole data;

	
}