package com.example.demo.demospringbootaerospike.configuration;

    import com.example.demo.demospringbootaerospike.repositories.aerospikeUserRepository;
    import com.aerospike.client.Host;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.context.properties.EnableConfigurationProperties;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.data.aerospike.config.AbstractAerospikeDataConfiguration;
    import org.springframework.data.aerospike.repository.config.EnableAerospikeRepositories;

    import java.util.Collection;
    import java.util.Collections;

@Configuration
@EnableConfigurationProperties(aerospikeConfigurationProperties.class)
@EnableAerospikeRepositories(basePackageClasses = aerospikeUserRepository.class)
public class aerospikeConfiguration extends AbstractAerospikeDataConfiguration {
    @Autowired
    private aerospikeConfigurationProperties aerospikeConfigurationProperties;

    @Override
    protected Collection<Host> getHosts() {
        return Collections.singleton(new Host(aerospikeConfigurationProperties.getHost(), aerospikeConfigurationProperties.getPort()));
    }

    @Override
    protected String nameSpace() {
        return aerospikeConfigurationProperties.getNamespace();
    }
}
