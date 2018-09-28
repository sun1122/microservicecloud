package com.zzu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // 本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient // 服务发现
@EnableCircuitBreaker // 对hystrix熔断机制的支持
public class DeptProvider8001_Hystrix_App {
	/**
	 * 10秒内20次请求
	 * 
	 * 50%
	 * This property sets the error percentage at or above which the circuit
	 * should trip open and start short-circuiting requests to fallback logic.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(DeptProvider8001_Hystrix_App.class, args);
	}
}
