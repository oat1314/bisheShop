package com.ogx.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ogx.shop.dao.PinglunMapper;
import com.ogx.shop.entity.Pinglun;
import com.ogx.shop.service.PinglunService;
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
public class PinglunServiceImpl implements PinglunService {
    @Resource
    PinglunMapper pinglunMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return pinglunMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Pinglun record) {
        return pinglunMapper.insert(record);
    }

    @Override
    public int insertSelective(Pinglun record) {
        return pinglunMapper.insertSelective(record);
    }


    @Override
    public Pinglun selectByPrimaryKey(Integer id) {
        return pinglunMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Pinglun record) {
        return pinglunMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Pinglun record) {
        return pinglunMapper.updateByPrimaryKey(record);
    }


    public List<Pinglun> selectAllById(Integer proId) {
        return pinglunMapper.selectAllById(proId);
    }

  /*  @Override
    public List<Pinglun> selectAll() {
        List<Pinglun> roles= pinglunMapper.selectAll();
        List<String> list=new ArrayList<>();
        for(int i=0;i<roles.size();i++){
            list.add(roles.get(i).getRoleName());
        }
        return list;
    }*/

    @Override
    public PageInfo<Pinglun> pageList(int currentPage, int pageSize) {
        List<Pinglun> list = new ArrayList<>();
        PageHelper.startPage(currentPage, pageSize);
        list = pinglunMapper.selectAll();
        PageInfo<Pinglun> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }


}
