package com.zzu.springcloud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.zzu.springcloud.entities.Dept;

import feign.hystrix.FallbackFactory;
/**
 * 服务降级处理是在客户端实现完成的，与服务端没有关系
 * @author Administrator
 *
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

	@Override
	public DeptClientService create(Throwable arg0) {
		// TODO Auto-generated method stub
		return new DeptClientService() {

			@Override
			public List<Dept> list() {
				ArrayList<Dept> arrayList = new ArrayList();
				Dept dept = new Dept();
				dept.setDname( "没有对应的信息,Consumer客户端提供的降级信息")
				.setDb_source("no this database");
				arrayList.add(dept);
				return arrayList;
			}

			@Override
			public Dept get(long id) {
				// TODO Auto-generated method stub
				return new Dept().setDeptno(id).setDname("该ID：" + id + "没有对应的信息,Consumer客户端提供的降级信息")
						.setDb_source("no this database");
			}

			@Override
			public boolean add(Dept dept) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}

}
