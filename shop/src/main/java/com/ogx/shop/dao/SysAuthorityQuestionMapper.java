package com.ogx.shop.dao;

import com.ogx.shop.entity.SysAuthorityQuestion;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/

public interface SysAuthorityQuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysAuthorityQuestion record);

    int insertSelective(SysAuthorityQuestion record);

    SysAuthorityQuestion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysAuthorityQuestion record);

    int updateByPrimaryKey(SysAuthorityQuestion record);
}