package com.ogx.shop.dao;

import com.ogx.shop.entity.Returns;

import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/

public interface ReturnMapper {
    int deleteByPrimaryKey(String chanNo);

    int insert(Returns record);

    int insertSelective(Returns record);

    Returns selectByPrimaryKey(String chanNo);

    int updateByPrimaryKeySelective(Returns record);

    int updateByPrimaryKey(Returns record);

    Returns selectByOrderNo(String orderNo);

    List<Returns> selectByCustId(int CustId);

    List<Returns> selectAll();

    //查询退货数目
    List<Returns> selectByCustId2(int CustId);
}