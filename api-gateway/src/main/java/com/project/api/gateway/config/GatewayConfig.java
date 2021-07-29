package com.project.api.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.project.api.gateway.filter.JwtAuthenticationFilter;

/*

# Example routing for user-service
spring.cloud.gateway.routes[0].id=user-service
spring.cloud.gateway.routes[0].uri=lb://user-service
spring.cloud.gateway.routes[0].predicates[0]=Path=/user-service/**
spring.cloud.gateway.routes[0].filters[0]=RewritePath=/user-service(?<segment>.*), $\{segment}

spring.cloud.gateway.routes[1].id=card-service
spring.cloud.gateway.routes[1].uri=lb://card-service
spring.cloud.gateway.routes[1].predicates[0]=Path=/card-service/**
spring.cloud.gateway.routes[1].filters[0]=RewritePath=/card-service(?<segment>.*), $\{segment}

spring.cloud.gateway.routes[2].id=product-service
spring.cloud.gateway.routes[2].uri=lb://product-services
spring.cloud.gateway.routes[2].predicates[0]=Path=/product-service/**
spring.cloud.gateway.routes[2].filters[0]=RewritePath=/product-service(?<segment>.*), $\{segment}
*/

//localhost:8765/user-service/login
//loginhost:8765/login

@Configuration
public class GatewayConfig {

	@Autowired
	private JwtAuthenticationFilter filter;

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes().route("auth", r -> r.path("/auth/**").filters(f -> f.filter(filter)).uri("lb://auth"))
				.route("hello", r -> r.path("/hello/**").filters(f -> f.filter(filter)).uri("lb://hello"))
				.route("alert", r -> r.path("/alert22/**").filters(f -> f.filter(filter)).uri("lb://alert"))
				.route("product-service", r -> r.path("/product/**").filters(f -> f.filter(filter)).uri("lb://product-service"))
				.route("user-service", r -> r.path("/user-service/**").filters(f -> f.filter(filter)).uri("lb://user-service")).build();
	}

}
//user-service/login