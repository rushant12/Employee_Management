package digital.project.employeemanagement.util;


import java.security.SecureRandom;

import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.core.impl.MementoMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.stereotype.Component;

@Component
public class EmployeeUtility {
	
	
	public static synchronized String employeeCodeGenerator(long count)
	{	
		count = count + 1;
		StringBuilder employeeCode = new StringBuilder();
		employeeCode.append("EMP").append(count);
		return employeeCode.toString();	
	}
	
	public static String employeeCodeCreate(int code)
	{
		StringBuilder employeeCode = new StringBuilder();
		employeeCode.append("EMP").append(code);
		return employeeCode.toString();	
	}
	
	public static String passwordGenerator()
	{
		 String LOWERCASE = "abcdefghijklmnopqrstuvwxyz"; 
	     String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	     String DIGITS = "0123456789";
	     String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";
	     int length = 8;
	     SecureRandom random = new SecureRandom();
	     StringBuilder password = new StringBuilder();
	     password.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
	     password.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
	     password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
	     password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));
	     String allCharacter = LOWERCASE + UPPERCASE + DIGITS + SPECIAL_CHARACTERS;
	     for (int i = 4; i < length; i++) {
	            password.append(allCharacter.charAt(random.nextInt(allCharacter.length())));
	        } 
	       StringBuilder shuffledPassword = new StringBuilder(password.length());
	        while (password.length() > 0) {
	            int index = random.nextInt(password.length());
	            shuffledPassword.append(password.charAt(index));
	            password.deleteCharAt(index);
	        }
	        return shuffledPassword.toString();
	}
	
	
}
