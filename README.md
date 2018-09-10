# microservicecloud
springcloud+springboot+mybatis+mysql微服务学习（Restful风格）


1,   microservicecloud maven 聚合管理
            子模块：
      microservicecloud-api 公共的api 目前是部门的实体类
      microservicecloud-provider-dept-8001 部门服务提供者
      microservicecloud-provider-dept-8002 部门服务提供者
      microservicecloud-provider-dept-8003 部门服务提供者
      microservicecloud-provider-dept-hystrix-8003 部门服务提供者
      microservicecloud-consumer-dept-80 部门微服务消费者
      microservicecloud-consumer-dept-fegin-80 部门微服务消费者
      Eureka集群 ---微服务的注册与发现
               由于本地单机部署修改hosts文件
      127.0.0.1 eureka7001.com eureka7002.com eureka7003.com
       microservicecloud-eureka-7001 
       microservicecloud-eureka-7002
       microservicecloud-eureka-7003