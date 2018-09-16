package com.zzu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class Hystrix_DashBoard_App {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Hystrix_DashBoard_App.class, args);
	}

}
