package com.example.details;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

@SpringBootApplication
@RestController
public class DetailsApplication {

    @Value("${version: not-set}")
    String version;

    @GetMapping("/name")
    public String name(@RequestHeader HttpHeaders httpHeaders) {


        Set<String> set = httpHeaders.keySet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
        	String key  = it.next().toString().toUpperCase(Locale.ROOT);
			System.out.println(String.format("%s=%s",key,httpHeaders.get(key).get(0)));
		}
		System.out.println("###############################");

		System.out.println("\n\n");
        return "world " + version;
    }

    public static void main(String[] args) {
        SpringApplication.run(DetailsApplication.class, args);
    }

}
