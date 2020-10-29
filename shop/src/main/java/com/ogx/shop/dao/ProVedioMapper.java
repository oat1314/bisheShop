package com.ogx.shop.dao;

import com.ogx.shop.entity.ProVedio;

import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/

public interface ProVedioMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProVedio record);

    int insertSelective(ProVedio record);

    ProVedio selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProVedio record);

    int updateByPrimaryKey(ProVedio record);

    List<ProVedio> selectByProId(Integer proId);

    List<ProVedio> selectAll();

}