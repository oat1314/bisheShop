package com.ogx.shop.service;

import com.github.pagehelper.PageInfo;
import com.ogx.shop.entity.Role;

import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/
public interface RoleService {
    int deleteByPrimaryKey(Integer roleNo);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleNo);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<String> selectAll();

    Role selectByRoleName(String name);

    Role selectRoleNameByRoleNo(Integer roleNo);

    /**
     * 查询全部商品类别分页
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<Role> pageList(int currentPage, int pageSize);
}
