package com.aiguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置GateWay的第二种方式
 * @author: scott
 * @date: 2022年08月16日 17:32
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder locatorBuilder){
        RouteLocatorBuilder.Builder routes = locatorBuilder.routes();
        routes.route("pathRouteAtguigu",
                r->r.path("/guonei")
        .uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }
}
