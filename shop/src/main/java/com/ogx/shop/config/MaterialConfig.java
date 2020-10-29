package com.ogx.shop.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-03-21 00:47
 * @title: MaterialConfig
 **/
@Configuration
@ConfigurationProperties(prefix = "material")
public class MaterialConfig {
    private String upload_dir;

    public String getUpload_dir() {
        return upload_dir;
    }

    public void setUpload_dir(String upload_dir) {
        this.upload_dir = upload_dir;
    }
}
