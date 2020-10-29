package com.ogx.shop.service;

import com.github.pagehelper.PageInfo;
import com.ogx.shop.entity.Customer;

import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/
public interface CustomerService {
    int deleteByPrimaryKey(Integer custId);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer custId);

    int updateByPrimaryKeySelective(Customer record);



    int updateByPrimaryKey(Customer record);

    /**
     * 根据用户名查找用户
     * @param custName
     * @return
     */
    Customer selectByName(String custName);

    /**
     * 注册
     * @param customer
     * @return
     */
    int registerData(Customer customer);
    List<Customer> findAll();

    /**
     * 查询全部顾客分页
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<Customer> pageList(int currentPage, int pageSize);
}
