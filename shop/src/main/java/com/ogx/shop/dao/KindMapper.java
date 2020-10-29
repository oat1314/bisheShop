package com.ogx.shop.dao;

import com.ogx.shop.entity.Kind;

import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/

public interface KindMapper {
    int deleteByPrimaryKey(Integer kindNo);

    int insert(Kind record);

    int insertSelective(Kind record);

    Kind selectByPrimaryKey(Integer kindNo);

    int updateByPrimaryKeySelective(Kind record);

    int updateByPrimaryKey(Kind record);

    List<Kind> selectAll();

    Kind selectByName(String name);

}