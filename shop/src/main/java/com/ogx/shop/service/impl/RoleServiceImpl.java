package com.ogx.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ogx.shop.dao.RoleMapper;
import com.ogx.shop.entity.Role;
import com.ogx.shop.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;
    @Override
    public int deleteByPrimaryKey(Integer roleNo) {
        return roleMapper.deleteByPrimaryKey(roleNo);
    }


    @Override
    public int insert(Role record) {
        return roleMapper.insert(record);
    }

    @Override
    public int insertSelective(Role record) { return roleMapper.insertSelective(record);
    }

    @Override
    public Role selectByPrimaryKey(Integer roleNo) {
        return roleMapper.selectByPrimaryKey(roleNo);
    }


    @Override
    public int updateByPrimaryKeySelective(Role record) {
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        return roleMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<String> selectAll() {
        List<Role> roles= roleMapper.selectAll();
        List<String> list=new ArrayList<>();
        for(int i=0;i<roles.size();i++){
            list.add(roles.get(i).getRoleName());
        }
        return list;
    }

    @Override
    public Role selectByRoleName(String name) {
        return roleMapper.selectByRoleName(name);
    }

    @Override
    public Role selectRoleNameByRoleNo(Integer roleNo) {
        return roleMapper.selectRoleNameByRoleNo(roleNo);
    }

    @Override
    public PageInfo<Role> pageList(int currentPage, int pageSize) {

        List<Role> list = new ArrayList<>();
        PageHelper.startPage(currentPage, pageSize);
        list = roleMapper.selectAll();
        PageInfo<Role> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
