package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@SpringBootApplication
public class GradleSpringBootDockerizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(GradleSpringBootDockerizationApplication.class, args);
	}

	@Bean
	RouterFunction<ServerResponse> helloWorld(){
		return  RouterFunctions.route(GET("/"), request -> ok().body(fromValue("Hello World")));
	}
}
