package digital.project.employeemanagement.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.util.IOUtils;

@Configuration
public class MailMessage {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public int mailSender(String mailTo, String name)
	{
//		try {
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setTo(mailTo);
//		message.setSubject("Registration Successfully");
//		message.setText("Hello" + name + "you have registered successfully");
//		javaMailSender.send(message);
//		}catch (Exception e){
//			System.out.println(e.getMessage());
//			return 0;
//		}
//		return 1;
		
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setTo(mailTo);
			helper.setSubject("Registration Successful");
			String htmlContent = getHtmlTemplate(name);
			 helper.setText(htmlContent, true);
			 javaMailSender.send(mimeMessage);
				}catch (Exception e){
				System.out.println(e.getMessage());
				return 0;
			}
			return 1;
		
	}
	
	
	private String getHtmlTemplate(String name) throws IOException
	{
				
        ClassPathResource templateResource = new ClassPathResource("templates/registration-email-template.html");
        
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(templateResource.getInputStream(), "UTF-8"))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }     
        return content.toString().replace("{{name}}", name);
	}
}
}
