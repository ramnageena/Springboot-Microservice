package net.microservice.employee;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
@OpenAPIDefinition(
		info = @Info(
				title = "Employee Service REST API's",
				description = "Employee Service REST APIs Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Ram Tiwari",
						email = "ramtiwari8716@gmail.com",
						url = "github.com/ramnageena"
				),
				license = @License(
						name = "Apache 2.0",
						url = "github.com/ramnageena"
				)

		),
		externalDocs = @ExternalDocumentation(
				description = "Employee Service REST APIs Doc",
				url = "github.com/ramnageena"
		)
)
@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
		System.out.println("Employee-service");
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	//RestTemplate Bean
//	@Bean
//	public RestTemplate restTemplate(){
//		return  new RestTemplate();
//	}

//WebClient Bean
	@Bean
	public WebClient webClient(){
	return  WebClient.builder().build();
	}

}
