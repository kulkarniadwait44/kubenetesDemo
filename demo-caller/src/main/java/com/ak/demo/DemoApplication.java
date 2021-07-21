package com.ak.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class DemoApplication {
	
	@Autowired
	RestTemplate restTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@RequestMapping("/caller")
	public String index() {
		String str=""; 
		
		str = "Greetings from Spring Boot Caller";
		str = str + "  "+restTemplate.getForObject("http://Demo-service/hello", String.class);
				
		
		return str;
	}
}
