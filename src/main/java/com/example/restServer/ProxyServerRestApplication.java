package com.example.restServer;

import com.example.serverone.GetUserResponse;
import com.example.serverone.User;
import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@SpringBootApplication
@RestController
public class ProxyServerRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProxyServerRestApplication.class, args);
    }
    @GetMapping("/test")
    public String sayHello(int userId) {
        GetUserResponse response = new GetUserResponse();
        response.setUser(new User());
        return"azmi";
    }

}
