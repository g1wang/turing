### Eureka Server
服务注册中心

#### 依赖
```
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>
```

#### 配置
```
info:
  app: eureka-server
  version: v1.0.0
spring:
  application:
    name: eureka-server
server:
  port: 8081

eureka:
  client:
    #register-with-eureka和fetch-registry false 防止自己注册自己
    register-with-eureka: false
    fetch-registry: false
    service-url:
     defaultZone: http://localhost:8081/eureka/
    #eureka client间隔多久去拉取服务注册信息，默认为30秒
    #对于api-gateway，如果要迅速获取服务注册状态，可以缩小该值，比如5秒
    registry-fetch-interval-seconds: 30
    healthcheck:
      enabled: true
  instance:
    prefer-ip-address: true
    hostname: localhost
    #eureka client发送心跳给server端的频率
    lease-renewal-interval-in-seconds: 30
    #eureka server至上一次收到client的心跳之后，等待下一次心跳的超时时间
    lease-expiration-duration-in-seconds: 90
    metadata-map:
      zone: zone1
```

#### 实现类
```
启动类 EurekaServerApplication加注解@EnableEurekaServer
启动后在根据service-url的配置 http://host:port 访问eureka-server界面

```