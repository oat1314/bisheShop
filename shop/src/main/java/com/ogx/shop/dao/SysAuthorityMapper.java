package com.ogx.shop.dao;

import com.ogx.shop.entity.SysAuthority;

import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/

public interface SysAuthorityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysAuthority record);

    int insertSelective(SysAuthority record);

    SysAuthority selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysAuthority record);

    int updateBySysId(SysAuthority record);

    int updateByPrimaryKey(SysAuthority record);

    int updateInfo(SysAuthority record);

    int updateFlagById(int record);

    SysAuthority selectByUsername(String username);

    List<SysAuthority> selectByName1(String username);

    List<SysAuthority> selectByRoleNo(String roleNo);

    List<SysAuthority> selectAll();

}