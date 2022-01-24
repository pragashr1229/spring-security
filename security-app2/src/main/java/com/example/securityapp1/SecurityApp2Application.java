package com.example.securityapp1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SecurityApp2Application {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApp2Application.class, args);
	}

	
	@GetMapping("/")
	public String getMessage() {
		return "From GetMessage";
	}
}