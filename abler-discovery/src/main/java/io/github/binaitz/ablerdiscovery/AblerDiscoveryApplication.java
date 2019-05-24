package io.github.binaitz.ablerdiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AblerDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(AblerDiscoveryApplication.class, args);
	}

}
