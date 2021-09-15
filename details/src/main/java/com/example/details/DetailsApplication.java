package com.example.details;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DetailsApplication {

	@GetMapping("/name")
	public String name(){

		return "world (v1)";
	}

	public static void main(String[] args) {
		SpringApplication.run(DetailsApplication.class, args);
	}

}
