package digital.project.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import digital.project.employeemanagement.model.EmployeeDetails;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDetails, Integer>{
	
	

}
