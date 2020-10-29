package com.ogx.shop.dao;

import com.ogx.shop.entity.Warehouse;

import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/

public interface WarehouseMapper {
    int deleteByPrimaryKey(String whNo);

    int insert(Warehouse record);

    int insertSelective(Warehouse record);

    Warehouse selectByPrimaryKey(String whNo);

    int updateByPrimaryKeySelective(Warehouse record);

    int updateByPrimaryKey(Warehouse record);

    List<Warehouse> selectAll();

    Warehouse selectByName(String name);
}