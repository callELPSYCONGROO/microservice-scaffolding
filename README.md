# microservice-scaffolding

SpringCloud微服务系统脚手架。

包含：

* eureka注册中心

* zuul网关

* SpringBoot Admin监控

* demo service 服务

### eureka 注册中心

常规注册中心，未做集群配置，集群注册中心暂时不稳定

### zuul 网关

网关中ErrorHandlerController配合ErrorFilter处理了网关层ZuulException的处理，可以将其转换为自定义结果返回。

RequestPathFilter可以进行请求路径拦截，拦截非法请求。

同时，网关层集成了swagger文档统一配置，可以直接访问网关层swagger地址，访问到内部所有服务的swagger文档。

### SpringBoot Admin 监控

可以发送邮件通知

### demo service 服务

Mybatis + Druid + PageHelper + MySql。

配置了FeignClient，服务熔断。

javax.validation的异常使用统一异常处理进行处理，封装为自定义响应。
