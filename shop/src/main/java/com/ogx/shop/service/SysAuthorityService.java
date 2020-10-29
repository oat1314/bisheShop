package com.ogx.shop.service;

import com.github.pagehelper.PageInfo;
import com.ogx.shop.entity.SysAuthority;

import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/
public interface SysAuthorityService {
    int deleteByPrimaryKey(Integer id);

    int insert(SysAuthority record);

    int insertSelective(SysAuthority record);

    SysAuthority selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysAuthority record);

    int updateByPrimaryKey(SysAuthority record);

    int updateBySysId(SysAuthority record);

    int updateInfo(SysAuthority record);

   SysAuthority selectByName(String username);

    List<SysAuthority> selectByName1(String username);

    List<SysAuthority> selectByRoleNo(String roleNo);

    List<SysAuthority> selectAll();

    int updateFlagById(int record);

    /**
     * 分页展示
     * @param sysAuthority
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<SysAuthority> pageList1(SysAuthority sysAuthority, int currentPage, int pageSize);

    /**
     * 注册
     * @param sysAuthority
     * @return
     */
    int registerData1(SysAuthority sysAuthority);


}
