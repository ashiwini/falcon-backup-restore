package com.falcon.backup.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.falcon.backup")
@EnableJpaRepositories("com.falcon.backup.repositories")
@EntityScan("com.falcon.backup.entities")
/*@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "com.falcon.backup")
@EnableJpaRepositories("com.falcon.backup.repositories")
@EntityScan("com.falcon.backup.entities")*/
public class StartupService {

	public static void main(String[] args) {
		SpringApplication.run(StartupService.class, args);
	}
}
