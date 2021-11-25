package com.example.demo.config;

import com.example.demo.consumewebservice.countryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class countryConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
//        marshaller.setContextPath("com/example/demo/countries");
        marshaller.setPackagesToScan("com/example/demo/countries");
        return marshaller;
    }

//    @Bean
//    public countryClient countryClient(Jaxb2Marshaller marshaller) {
//        countryClient client = new countryClient();
//        client.setDefaultUri("http://localhost:8080/ws");
//        client.setMarshaller(marshaller);
//        client.setUnmarshaller(marshaller);
//        return client;
//    }

}