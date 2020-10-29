package com.ogx.shop.service;

import com.github.pagehelper.PageInfo;
import com.ogx.shop.entity.ProVedio;

import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/
public interface ProVedioService {
    int deleteByPrimaryKey(Integer id);

    int insert(ProVedio record);

    int insertSelective(ProVedio record);

    ProVedio selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProVedio record);

    int updateByPrimaryKey(ProVedio record);

    List<ProVedio> selectByProId(Integer proId);

    List<ProVedio> selectAll();


    /**
     * 查询全部商品类别分页
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<ProVedio> pageList(int currentPage, int pageSize);
}
