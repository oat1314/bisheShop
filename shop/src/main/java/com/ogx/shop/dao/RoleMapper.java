package com.ogx.shop.dao;

import com.ogx.shop.entity.Role;

import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/

public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleNo);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleNo);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> selectAll();

    Role selectByRoleName(String name);

    Role selectRoleNameByRoleNo(Integer roleNo);

}