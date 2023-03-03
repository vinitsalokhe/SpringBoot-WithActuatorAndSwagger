package com.pro.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class SpringBootWithActuatorAndSwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithActuatorAndSwaggerApplication.class, args);
	}
	
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.api"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
 
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("My API")
                .description("Description of my API")
                .version("1.0")
                .build();
    }
}
