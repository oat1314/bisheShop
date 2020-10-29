package com.ogx.shop.service;

import com.github.pagehelper.PageInfo;
import com.ogx.shop.entity.Kind;

import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/
public interface KindService {
    int deleteByPrimaryKey(Integer kindNo);

    int insert(Kind record);

    int insertSelective(Kind record);

    Kind selectByPrimaryKey(Integer kindNo);

    int updateByPrimaryKeySelective(Kind record);

    int updateByPrimaryKey(Kind record);

    List<String> selectAll();

    /**
     * 查询全部商品类别分页
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<Kind> pageList(int currentPage, int pageSize);
}
