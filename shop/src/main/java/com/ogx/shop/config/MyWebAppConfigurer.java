package com.ogx.shop.config;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-03-21 04:18
 * @title: MyWebAppConfigurer
 **/

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 资源映射路径
 */
@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations("file:D:/upload/");
    }
}