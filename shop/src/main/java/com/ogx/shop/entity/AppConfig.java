package com.ogx.shop.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-03-21 04:16
 * @title: AppConfig
 **/
@Component
@Data
@ConfigurationProperties(prefix = "system") // 接收application.yml中的myProps下面的属性
public class AppConfig {
    public String filepath;
    public String urlpath;
}


