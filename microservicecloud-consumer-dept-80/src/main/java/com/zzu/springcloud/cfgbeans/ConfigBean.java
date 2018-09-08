package com.zzu.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;

@Configuration
public class ConfigBean {//spring applicationContext.xml
    
	@Bean
	@LoadBalanced//客户端的负载均衡工具
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	@Bean
	public IRule myRule(){
		return new RetryRule();//重试选择逻辑，（轮训3次后无法链接，不去链接），重新选择服务器
	}

}
