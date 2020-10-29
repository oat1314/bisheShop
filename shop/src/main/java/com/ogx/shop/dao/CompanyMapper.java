package com.ogx.shop.dao;

import com.ogx.shop.entity.Company;

import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/

public interface CompanyMapper {
    int deleteByPrimaryKey(Integer supNo);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(Integer supNo);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);

    List<Company> selectAll();

    Company selectByName(String name);
}