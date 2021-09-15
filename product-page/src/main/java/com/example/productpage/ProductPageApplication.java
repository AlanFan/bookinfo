package com.example.productpage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ProductPageApplication {

    String url = "http://details:8080";

    @GetMapping
    public String hello() {
        RestTemplate restTemplate = new RestTemplate();
        String name = restTemplate.getForEntity(url+"/name", String.class).getBody();

        return String.format("Hello %s", name);
    }

    public static void main(String[] args) {
        SpringApplication.run(ProductPageApplication.class, args);
    }

}
