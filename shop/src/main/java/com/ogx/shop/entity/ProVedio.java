package com.ogx.shop.entity;

import lombok.Data;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-03-21 22:27
 * @title: ProImg
 **/
@Data
public class ProVedio {
    private Integer id;
    private Integer proId;
    private String url;
    private Integer flag;
    private String title;
}
