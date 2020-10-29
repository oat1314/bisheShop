package com.ogx.shop.service.impl;

import com.ogx.shop.dao.SysMenuMapper;
import com.ogx.shop.entity.SysMenu;
import com.ogx.shop.service.SysMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: shop
 * @description:
 * @author: OGX
 * @create: 2020-02-16 22:50
 * @title:
 **/
@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Resource
    private SysMenuMapper sysMenuMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysMenuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysMenu record) {
        return sysMenuMapper.insert(record);
    }

    @Override
    public int insertSelective(SysMenu record) {
        return sysMenuMapper.insertSelective(record);
    }

    @Override
    public SysMenu selectByPrimaryKey(Long id) {
        return sysMenuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysMenu record) {
        return sysMenuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(SysMenu record) {
        return sysMenuMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(SysMenu record) {
        return sysMenuMapper.updateByPrimaryKey(record);
    }
}
