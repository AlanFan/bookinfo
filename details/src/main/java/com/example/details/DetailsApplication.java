package com.example.details;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DetailsApplication {

	@Value("${version: not-set}")
	String version;

	@GetMapping("/name")
	public String name(){

		return "world " + version;
	}

	public static void main(String[] args) {
		SpringApplication.run(DetailsApplication.class, args);
	}

}
