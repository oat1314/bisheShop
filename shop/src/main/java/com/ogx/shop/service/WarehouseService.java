package com.ogx.shop.service;

import com.github.pagehelper.PageInfo;
import com.ogx.shop.entity.Warehouse;

import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/
public interface WarehouseService {
    int deleteByPrimaryKey(String whNo);

    int insert(Warehouse record);

    int insertSelective(Warehouse record);

    Warehouse selectByPrimaryKey(String whNo);

    int updateByPrimaryKeySelective(Warehouse record);

    int updateByPrimaryKey(Warehouse record);

    /**
     * 查询全部品牌类别分页
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<Warehouse> pageList(int currentPage, int pageSize);

    List<String> selectAll();
}
