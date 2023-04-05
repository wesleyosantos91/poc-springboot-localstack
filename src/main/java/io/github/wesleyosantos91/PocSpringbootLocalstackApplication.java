package io.github.wesleyosantos91;

import io.github.wesleyosantos91.configuration.ParameterStoreConfiguration;
import io.github.wesleyosantos91.configuration.SecretsManagerConfiguration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PocSpringbootLocalstackApplication implements CommandLineRunner {


    private final ParameterStoreConfiguration parameterStoreConfiguration;
    private final SecretsManagerConfiguration secretsManagerConfiguration;

    public PocSpringbootLocalstackApplication(ParameterStoreConfiguration parameterStoreConfiguration, SecretsManagerConfiguration secretsManagerConfiguration) {
        this.parameterStoreConfiguration = parameterStoreConfiguration;
        this.secretsManagerConfiguration = secretsManagerConfiguration;
    }


    public static void main(String[] args) {
        SpringApplication.run(PocSpringbootLocalstackApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(parameterStoreConfiguration.getHelloWorld());
        System.out.println(secretsManagerConfiguration.getValor1() + " - " + secretsManagerConfiguration.getValor2() + " - " + secretsManagerConfiguration.getValor3());
    }
}
