package com.ogx.shop.service;

import com.ogx.shop.entity.SysMenu;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/
public interface SysMenuService {
    int deleteByPrimaryKey(Long id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKeyWithBLOBs(SysMenu record);

    int updateByPrimaryKey(SysMenu record);
}
