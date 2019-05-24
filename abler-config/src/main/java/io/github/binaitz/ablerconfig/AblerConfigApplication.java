package io.github.binaitz.ablerconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class AblerConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(AblerConfigApplication.class, args);
	}

}
