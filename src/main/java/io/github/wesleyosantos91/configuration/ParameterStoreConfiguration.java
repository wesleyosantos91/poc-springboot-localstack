package io.github.wesleyosantos91.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@EnableConfigurationProperties
public class ParameterStoreConfiguration {

    @Value("${helloWorld}")
    private String helloWorld;
}
