package io.github.binaitz.ableruserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AblerUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AblerUserServiceApplication.class, args);
	}

}
