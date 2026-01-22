package com.microservice.com.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

@EnableDiscoveryClient
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		/*.route("service1", r -> r.path("/order/**")
	      .filters(f -> f.stripPrefix(1))
	      .uri("http://localhost:8092/"))*/
		
		
	  return builder.routes()
	    .route("service1", r -> r.path("/itemslist/**")
	  	      .filters(f -> f.stripPrefix(1))
	  	      .uri("http://localhost:9832/"))
	    .build();
	}

}
