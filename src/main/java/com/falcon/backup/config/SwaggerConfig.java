package com.falcon.backup.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.joda.time.DateTime;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.directModelSubstitute(DateTime.class, String.class).apiInfo(apiInfo()).select().paths(postPaths())
				.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
				.paths(springBootActuatorJmxPaths()).build();
	}

	private Predicate<String> postPaths() {
		return regex("/.*");
	}

	private Predicate<String> springBootActuatorJmxPaths() {
		return regex("^/(?!env|restart|pause|resume|refresh).*$");
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Falcon Backup and Restore").build();
	}

}