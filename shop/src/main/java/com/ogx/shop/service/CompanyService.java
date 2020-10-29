package com.ogx.shop.service;

import com.github.pagehelper.PageInfo;
import com.ogx.shop.entity.Company;

import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/
public interface CompanyService {
    int deleteByPrimaryKey(Integer supNo);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(Integer supNo);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);

    /**
     * 根据商品名称查询
     * @param name
     * @return
     */
    Company selectByName(String name);



    /**
     * 查询全部活动分页
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<Company> pageList(int currentPage, int pageSize);

    List<String> selectAll();


}
