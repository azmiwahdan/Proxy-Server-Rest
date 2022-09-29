package com.example.restServer;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class ProxyServerRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProxyServerRestApplication.class, args);
    }

}
