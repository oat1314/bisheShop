package com.ogx.shop.dao;

import com.ogx.shop.entity.Delivery;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/

public interface DeliveryMapper {
    int deleteByPrimaryKey(Integer delivNo);

    int insert(Delivery record);

    int insertSelective(Delivery record);

    Delivery selectByPrimaryKey(Integer delivNo);

    int updateByPrimaryKeySelective(Delivery record);

    int updateByPrimaryKey(Delivery record);

    Delivery selectByOrderNo(String orderNo);

    Delivery selectByInvoiceNo(String orderNo);
}