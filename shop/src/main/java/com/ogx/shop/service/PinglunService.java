package com.ogx.shop.service;

import com.github.pagehelper.PageInfo;
import com.ogx.shop.entity.Pinglun;

import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/
public interface PinglunService {
    int deleteByPrimaryKey(Integer id);

    int insert(Pinglun record);

    int insertSelective(Pinglun record);

    Pinglun selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Pinglun record);

    int updateByPrimaryKey(Pinglun record);

    List<Pinglun> selectAllById(Integer proId);



    /**
     * 查询全部商品类别分页
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<Pinglun> pageList(int currentPage, int pageSize);
}
