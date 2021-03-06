package org.volhvporechja.springcontext;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.volhvporechja.springcontext.beans.Person;

@Configuration
@PropertySource("classpath:application.yaml")
@ComponentScan("org.volhvporechja.springcontext.beans")
public class ContextConfig {

    @Bean("SomePerson")
    public Person GetSomePerson(){
        return new Person(123, "Fucker");
    }

    @Bean("OtherPerson")
    @Qualifier("OtherPerson")
    public Person GetOtherPerson(){
        return new Person(123, "Looser");
    }

}
