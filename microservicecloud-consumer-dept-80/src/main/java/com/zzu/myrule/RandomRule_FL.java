package com.zzu.myrule;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

public class RandomRule_FL extends AbstractLoadBalancerRule {

	private AtomicInteger total; // 总共被调用的次数，目前要求每台被调用5次
	private AtomicInteger currentIndex;// 当前提供服务的机器号

	public RandomRule_FL() {
		total = new AtomicInteger(0);
		currentIndex = new AtomicInteger(0);
    }
	public Server choose(ILoadBalancer lb, Object key) {
		if (lb == null) {
			return null;
		}
		Server server = null;

		while (server == null) {
			if (Thread.interrupted()) {
				return null;
			}
			List<Server> upList = lb.getReachableServers();
			List<Server> allList = lb.getAllServers();

			int serverCount = allList.size();
			if (serverCount == 0) {
				/*
				 * No servers. End regardless of pass, because subsequent passes
				 * only get more restrictive.
				 */
				return null;
			}

//			int index = chooseRandomInt(serverCount);
//			server = upList.get(index);
			
			  if(total.get() < 5)
	            {
	            server = upList.get(currentIndex.get());
	            total.getAndIncrement();
	            }else {
	            total = new AtomicInteger(0);
	            currentIndex.getAndIncrement();
	            if(currentIndex.get() >= upList.size())
	            {
	              currentIndex = new AtomicInteger(0);
	            }
	            
	            }

			if (server == null) {
				/*
				 * The only time this should happen is if the server list were
				 * somehow trimmed. This is a transient condition. Retry after
				 * yielding.
				 */
				Thread.yield();
				continue;
			}

			if (server.isAlive()) {
				return (server);
			}

			// Shouldn't actually happen.. but must be transient or a bug.
			server = null;
			Thread.yield();
		}

		return server;

	}

	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig arg0) {
		// TODO Auto-generated method stub

	}

}
