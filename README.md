# microservice-scaffolding
SpringCloud微服务系统脚手架。集成了Zuul网关，Eureka注册中心，SpringBootAdmin监控，可以在网关层查看所有服务的Swagger-Api。

master分支只更新README.md，用于说明。

---

* eureka-zuul，注册中心为eureka，网关为zuul

* dynamic-route，注册中心为eureka，网关为zuul

    * 实现了zuul动态路由配置及动态路由
    
    * 实现了feignclient动态请求不同服务