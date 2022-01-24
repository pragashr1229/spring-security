package com.example.securityapp1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SecurityApp3Application2 implements CommandLineRunner {
	
	@Autowired
	private PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(SecurityApp3Application2.class, args);
	}
	@GetMapping("/test")
	public String getMessage() {
		return "SecurityApp3Application2 - getMessage";
	}

	@Override
	public void run(String... args) throws Exception {
			Person p = new Person();
			p.setPassWord(getPasswordEncoder().encode("xyz"));
			p.setUserName("xyz");
			p.setRole("ROLE_ADMIN");
			
			Person p1 = new Person();
			p1.setPassWord(getPasswordEncoder().encode("xyz"));
			p1.setUserName("hello");
			p1.setRole("ROLE_ADMIN");
			
			personService.save(p);
			personService.save(p1);
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}