package com.example.demo.consumewebservice;

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

    public GetCountryResponse getCountry(String country) {

        GetCountryRequest request = new GetCountryRequest();
        request.setName(country);

        template = new WebServiceTemplate(marshaller);
        GetCountryResponse response = (GetCountryResponse) template.marshalSendAndReceive("http://localhost:8080/ws",
                request);
        return response;

    }
}
