package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
public class ClientconnectApplication {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

//    RestTemplate

//    @RequestMapping("/member")
//    String showMembers(){
//
//        final String uri = "http://localhost:8080/springrestexample/employees";
//        RestTemplate restTemplate = new RestTemplate();
//
//        Storage result = restTemplate.getForObject(uri, Storage.class);
//
//        System.out.println(result);
//
//        return "Lista";
//
//
//    }

    @RequestMapping("/member")
    String member() {
        final String uri = "andewalle.us-east-2.elasticbeanstalk.com/members";

        Member member = new Member ("Glenn", "Andersson", 21);


        RestTemplate restTemplate = new RestTemplate();
        Member result = restTemplate.postForObject( uri, member, Member.class);


        System.out.println(result);
        return "Person tillagd i listan!";
    }


    public static void main(String[] args) {
        SpringApplication.run(ClientconnectApplication.class, args);
    }


}
