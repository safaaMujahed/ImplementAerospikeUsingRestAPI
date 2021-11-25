package com.example.demo;

import com.example.demo.consumewebservice.countryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.countries.GetCountryResponse;
import com.example.demo.countries.GetCountryRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConsumingWebServiceApplication {
    @Autowired
    private countryClient client;
    String country = "Spain";
    @PostMapping("/getCountry")
    public  GetCountryResponse  invokeCountryClientToGetDetails(@RequestBody GetCountryRequest  request) {
        return client.getCountry(country);
    }
    public static void main(String[] args) {
        SpringApplication.run(ConsumingWebServiceApplication.class, args);
    }
}