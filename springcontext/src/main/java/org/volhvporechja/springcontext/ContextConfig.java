package org.volhvporechja.springcontext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.volhvporechja.springcontext.beans.Person;

@Configuration
@PropertySource("classpath:main.properties")
@ComponentScan("org.volhvporechja.springcontext.beans")
public class ContextConfig {

    @Bean("SomePerson")
    public Person GetSomePerson(){
        return new Person(123, "Fucker");
    }

    @Bean("OtherPerson")
    public Person GetOtherPerson(){
        return new Person(123, "Looser");
    }

}
