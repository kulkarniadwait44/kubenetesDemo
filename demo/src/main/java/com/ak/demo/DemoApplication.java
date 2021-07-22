package com.ak.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {
	
	@Value("${APPLICATION_PROPERTIES_HOSTNAME}")
	String hostName;
	@Value("${st.tmeplate}")
	String hostNameAdwait;
	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@RequestMapping("/hello")
	public String index() {
		return "Greetings from applicaiton : "+hostNameAdwait +"..!! Greetings from kubernets: "+hostName;
	}
}
