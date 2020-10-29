package com.ogx.shop.dao;

import com.ogx.shop.entity.Discount;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/

public interface DiscountMapper {
    int deleteByPrimaryKey(String custLevel);

    int insert(Discount record);

    int insertSelective(Discount record);

    Discount selectByPrimaryKey(String custLevel);

    int updateByPrimaryKeySelective(Discount record);

    int updateByPrimaryKey(Discount record);
}