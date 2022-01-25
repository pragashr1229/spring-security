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
	
	@GetMapping("/") //ADMIN or USER
	public String getMessages() {
		return "SecurityApp3Application2";
	}
	
	
	@GetMapping("/test") //ADMIN
	public String getMessage() {
		return "SecurityApp3Application2 - test";
	}
	
	@GetMapping("/test1") //ADMIN
	public String getMessage1() {
		return "SecurityApp3Application2 - test1";
	}
	
	@GetMapping("/test2") //USER
	public String getMessage2() {
		return "SecurityApp3Application2 - test2";
	}
	
	@GetMapping("/test3") //USER
	public String getMessage3() {
		return "SecurityApp3Application2 - test3";
	}
	@GetMapping("/test4") //USER
	public String getMessage4() {
		return "SecurityApp3Application2 - test4";
	}

	
	@GetMapping("/test1/a1")
	public String test11() {
		System.out.println("from test11");
		return "from test11/a1";
	}
	@GetMapping("/test1/b1")
	public String test12() {
		System.out.println("from test12");
		return "from test11/b1";
	}
	
	@GetMapping("/test1/hello/a1")
	public String test13() {
		System.out.println("from test12");
		return "from test11/hello/a1";
	}	
	@GetMapping("/test1/hello")
	public String test14() {
		System.out.println("from test12");
		return "from test11/hello/";
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
			p1.setRole("ROLE_USER");
			
			personService.save(p);
			personService.save(p1);
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}