package digital.project.employeemanagement.repository;



import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import digital.project.employeemanagement.admindao.EmployeeDao;
import digital.project.employeemanagement.model.EmployeeDetails;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDetails, Integer>{
	
  
//	@Query(value = "SELECT CASE WHEN EXISTS (SELECT 1 FROM employees_details WHERE pan_card_number = :panNumber AND personal_email = :personalEmail) THEN TRUE ELSE FALSE END", nativeQuery = true)
	boolean existsByPanNumberAndPersonalEmailAddress(String panNumber, String personalEmail);
	
	EmployeeDetails findByEmployeeCode(String code);
	
//	@Query("SELECT new digital.project.employeemanagement.projection.EmployeeProjection(e.employeeFirstName, e.employeeLastName, e.employeeCode) FROM EmployeeDetails e")
	@Query("SELECT new digital.project.employeemanagement.admindao.EmployeeDao(e.employeeFirstName, e.employeeLastName, e.employeeCode) FROM EmployeeDetails e")
	List<EmployeeDao> findAllEmployeeProjections();
	
	
}






