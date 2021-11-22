package com.example.demo.demospringbootaerospike.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "aerospike")
public class aerospikeConfigurationProperties {
    private String host;
    private int port;
    private String namespace;
}
