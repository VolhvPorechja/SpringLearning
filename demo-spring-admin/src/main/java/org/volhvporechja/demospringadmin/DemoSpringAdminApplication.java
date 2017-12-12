package org.volhvporechja.demospringadmin;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
@EnableAdminServer
public class DemoSpringAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringAdminApplication.class, args);
	}
}
