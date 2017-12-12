package org.volhvporechja.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import org.volhvporechja.demo.beans.Person;

@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling
@EnableCircuitBreaker
@Configuration
@ComponentScan("org.volhvporechja.demo.beans")
@ComponentScan("org.volhvporechja.demo.components")
@ComponentScan("org.volhvporechja.demo.services")
public class DemoApplication {

    @Bean
    public RestTemplate rest(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean("SomePerson")
    public Person GetSomePerson() {
        return new Person(123, "Fucker");
    }

    @Bean("OtherPerson")
    public Person GetOtherPerson() {
        return new Person(123, "Looser");
    }

    @Bean
    @Qualifier("FailedMessages")
    public ResourceBundleMessageSource exceptionsMessages() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("exceptions");
        return messageSource;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
