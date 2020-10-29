package com.ogx.shop.service;

import com.ogx.shop.entity.Collect;
import com.ogx.shop.entity.Product;

import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/
public interface CollectService {
    int deleteByPrimaryKey(Integer id);

    int insert(Collect record);

    int insertSelective(Collect record);

    Collect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Collect collect);

    int updateByPrimaryKey(Collect record);

    List<Product> findAll(Integer custId);

    Collect selectByCollect(Collect collect);

}
