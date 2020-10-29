package com.ogx.shop.dao;

import com.ogx.shop.entity.Pinglun;

import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/

public interface PinglunMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Pinglun record);

    int insertSelective(Pinglun record);

    Pinglun selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Pinglun record);

    int updateByPrimaryKey(Pinglun record);

    List<Pinglun> selectAllById(Integer proId);

    List<Pinglun> selectAll();


}