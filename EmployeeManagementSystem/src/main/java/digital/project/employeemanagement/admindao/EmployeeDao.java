package digital.project.employeemanagement.admindao;

import lombok.Data;

@Data
public class EmployeeDao {
	
	String getEmployeeFirstName;

	String getEmployeeLastName;

	String getEmployeeCode;
	
	public EmployeeDao()
	{
		
	}

	public EmployeeDao(String getEmployeeFirstName, String getEmployeeLastName, String getEmployeeCode) {
		super();
		this.getEmployeeFirstName = getEmployeeFirstName;
		this.getEmployeeLastName = getEmployeeLastName;
		this.getEmployeeCode = getEmployeeCode;
	}

	public String getGetEmployeeFirstName() {
		return getEmployeeFirstName;
	}

	public String getGetEmployeeLastName() {
		return getEmployeeLastName;
	}

	public String getGetEmployeeCode() {
		return getEmployeeCode;
	}
	

}
