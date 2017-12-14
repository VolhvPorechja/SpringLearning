package org.volhvporechja.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import org.volhvporechja.demo.aspects.SomeAspect;
import org.volhvporechja.demo.beans.Person;

import javax.sql.DataSource;

@SpringBootApplication

@EnableScheduling

@EnableCircuitBreaker

@EnableAutoConfiguration
@Configuration

@ComponentScan("org.volhvporechja.demo.beans")
@ComponentScan("org.volhvporechja.demo.components")
@ComponentScan("org.volhvporechja.demo.services")

@EnableAspectJAutoProxy
public class DemoApplication {

	@Value("${ENVIR}")
	String Environment;

	@Bean
	public RestTemplate rest(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean("SomePerson")
	public Person GetSomePerson() {
		return new Person(123, "Fucker" + Environment);
	}

	@Bean("OtherPerson")
	public Person GetOtherPerson() {
		return new Person(123, "Looser" + Environment);
	}

	@Bean
	public SomeAspect aspect() {
		return new SomeAspect();
	}

	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager(@Autowired DataSource dataSource) {
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
		dataSourceTransactionManager.setDataSource(dataSource);
		return dataSourceTransactionManager;
	}

//    @Bean("datasource")
//    public DataSource dataSource() {
//        HikariConfig config = new HikariConfig("/datasource.properties");
//        HikariDataSource dataSource = new HikariDataSource(config);
//        return dataSource;
//    }

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
