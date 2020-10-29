package com.ogx.shop.dao;

import com.ogx.shop.entity.ProImg;

import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/

public interface ProImgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProImg record);

    int insertSelective(ProImg record);

    ProImg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProImg record);

    int updateByPrimaryKey(ProImg record);

    List<ProImg> selectByProId(Integer proId);

    List<ProImg> selectAll();


}