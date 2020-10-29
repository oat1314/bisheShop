package com.ogx.shop.service;

import com.ogx.shop.entity.Delivery;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/
public interface DeliveryService {
    int deleteByPrimaryKey(Integer delivNo);

    int insert(Delivery record);

    int insertSelective(Delivery record);

    Delivery selectByPrimaryKey(Integer delivNo);

    int updateByPrimaryKeySelective(Delivery record);

    int updateByPrimaryKey(Delivery record);

    Delivery selectByOrderNo(String orderNo);

    /**
     *根据订单号查询配送表
     * @param orderNo
     * @return
     */
    Delivery selectByInvoiceNo(String orderNo);
}
