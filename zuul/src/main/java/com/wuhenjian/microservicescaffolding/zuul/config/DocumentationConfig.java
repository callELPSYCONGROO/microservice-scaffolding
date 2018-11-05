package com.wuhenjian.microservicescaffolding.zuul.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 加农炮
 * @review:
 * @date: 2018/8/28 14:22
 */
@Component
@Primary
public class DocumentationConfig implements SwaggerResourcesProvider {

    private final RouteLocator routeLocator;

    @Autowired
    public DocumentationConfig( RouteLocator routeLocator) {

        this.routeLocator = routeLocator;
    }

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        List<Route> routes= routeLocator.getRoutes();
        routes.forEach(route-> resources.add(swaggerResource(route.getId(), route.getFullPath().replace("**", "v2/api-docs"), "1.0")));
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }

}
