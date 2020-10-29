package com.ogx.shop.dao;

import com.ogx.shop.entity.Customer;

import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/

public interface CustomerMapper {
    int deleteByPrimaryKey(Integer custId);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer custId);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    Customer selectByName(String custName);

    List<Customer> findAll();
    List<Customer> findToday();
    List<Customer> findWeek();
    List<Customer> findYestoday();

    List<Customer> selectAll();
}