package com.ogx.shop.service.impl;

import com.ogx.shop.dao.DeliveryMapper;
import com.ogx.shop.entity.Delivery;
import com.ogx.shop.service.DeliveryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/
@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Resource
    private DeliveryMapper deliveryMapper;


    @Override
    public int deleteByPrimaryKey(Integer delivNo) {
        return deliveryMapper.deleteByPrimaryKey(delivNo);
    }

    @Override
    public int insert(Delivery record) {
        return deliveryMapper.insert(record);
    }

    @Override
    public int insertSelective(Delivery record) {
        return deliveryMapper.insertSelective(record);
    }

    @Override
    public Delivery selectByPrimaryKey(Integer delivNo) {
        return deliveryMapper.selectByPrimaryKey(delivNo);
    }

    @Override
    public int updateByPrimaryKeySelective(Delivery record) {
        return deliveryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Delivery record) {
        return deliveryMapper.updateByPrimaryKey(record);
    }

    /**
     * 根据配送单查找
     * @param orderNo
     * @return
     */
    @Override
    public Delivery selectByOrderNo(String orderNo) {
        return deliveryMapper.selectByOrderNo(orderNo);
    }

    @Override
    public Delivery selectByInvoiceNo(String orderNo) {
        return deliveryMapper.selectByInvoiceNo(orderNo);
    }
}
