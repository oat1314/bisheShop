package com.ogx.shop.service;

import com.ogx.shop.entity.Shopcart;

import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/
public interface ShopcartService {
    int deleteByPrimaryKey(Integer shopNo);

    int insert(Shopcart record);

    int insertSelective(Shopcart record);

    Shopcart selectByPrimaryKey(Integer shopNo);

    int updateById(Integer shopNo);

    int updateByShopId(Integer shopNo);

    int updateByPrimaryKey(Shopcart record);

    /**
     * 根据顾客id查询购物车
     * @param custId
     * @return
     */
    List<Shopcart> selectByCustId(Integer custId);


}
