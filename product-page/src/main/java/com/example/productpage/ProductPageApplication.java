package com.example.productpage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

@SpringBootApplication
@RestController
public class ProductPageApplication {

    String url = "http://details:8080";

    @GetMapping
    public String hello(@RequestHeader HttpHeaders httpHeaders, HttpServletRequest request) {

        System.out.println("remote host: "+request.getRemoteHost());

        Set<String> set = httpHeaders.keySet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String key  = it.next().toString().toUpperCase(Locale.ROOT);
            System.out.println(String.format("%s=%s",key,httpHeaders.get(key).get(0)));
        }
        System.out.println("###############################");

        RestTemplate restTemplate = new RestTemplate();
        String name = restTemplate.getForEntity(url+"/name", String.class).getBody();

        return String.format("Hello %s", name);
    }

    public static void main(String[] args) {
        SpringApplication.run(ProductPageApplication.class, args);
    }

}
