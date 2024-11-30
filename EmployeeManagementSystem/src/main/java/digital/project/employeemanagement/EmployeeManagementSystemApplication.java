package digital.project.employeemanagement;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@SpringBootApplication
public class EmployeeManagementSystemApplication {
	
	private static final Logger LOGGER = LogManager.getLogger(EmployeeManagementSystemApplication.class);
	

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystemApplication.class, args);
	//	LOGGER.info("INFO LOG: ");
		LOGGER.debug("DEBUG LOG: ");
	}
	


}
