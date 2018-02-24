package com.example.spring.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfigQuickStartApplication {

//	@Value("${config.name}")
//	String name = "World";
//
//	@RequestMapping("/")
//	public String home() {
//		return "Hello " + name;
//	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigQuickStartApplication.class, args);
	}
}
