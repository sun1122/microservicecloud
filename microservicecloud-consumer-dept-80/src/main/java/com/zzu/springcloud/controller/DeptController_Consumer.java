package com.zzu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zzu.springcloud.entities.Dept;

@RestController
public class DeptController_Consumer {

	//public static final String REST_URL_PREFIX = "http://localhost:8001";
	public static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";//微服名

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "consumer/dept/add")
	public boolean add(Dept dept) {

		return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
	}

	@RequestMapping(value = "consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		// TODO Auto-generated method stub
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "consumer/dept/list")
	public List<Dept> list() {

		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
	}

	// 测试@EnableDiscoveryClient,消费端可以调用服务发现
	@RequestMapping(value = "/consumer/dept/discovery")
	public Object discovery() {
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
	}

}
