package com.ogx.shop.dao;

import com.ogx.shop.entity.Shopcart;

import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/

public interface ShopcartMapper {
    int deleteByPrimaryKey(Integer shopNo);

    int insert(Shopcart record);

    int insertSelective(Shopcart record);

    Shopcart selectByPrimaryKey(Integer shopNo);

    int updateById(Integer shopNo);

    int updateByPrimaryKey(Shopcart record);
    List<Shopcart> selectByCustId(Integer custId);

    int updateByShopId(Integer shopNo);


}