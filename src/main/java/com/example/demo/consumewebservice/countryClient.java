package com.example.demo.consumewebservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
//import org.springframework.ws.soap.client.core.SoapActionCallback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import com.example.demo.countries.GetCountryRequest;
import com.example.demo.countries.GetCountryResponse;

@Service
public class countryClient {
    @Autowired
    private Jaxb2Marshaller marshaller;

    private WebServiceTemplate template;


//    private static final Logger log = LoggerFactory.getLogger(countryClient.class);

    public GetCountryResponse getCountry(String country) {

        GetCountryRequest request = new GetCountryRequest();
        request.setName(country);

//        log.info("Requesting location for " + country);
        template = new WebServiceTemplate(marshaller);
        GetCountryResponse response = (GetCountryResponse) template.marshalSendAndReceive("http://localhost:8080/ws",
                request);
        return response;
//        GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
//                .marshalSendAndReceive("http://localhost:8080/ws/countries", request,
//                        new SoapActionCallback(
//                                "http://spring.io/guides/gs-producing-web-service/GetCountryRequest"));
//
//        return response;
    }
}
