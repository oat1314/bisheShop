package com.ogx.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ogx.shop.dao.KindMapper;
import com.ogx.shop.entity.Kind;
import com.ogx.shop.service.KindService;
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
public class KindServiceImpl implements KindService {
    @Resource
    private KindMapper kindMapper;
    @Override
    public int deleteByPrimaryKey(Integer kindNo) {
        return kindMapper.deleteByPrimaryKey(kindNo);
    }

    @Override
    public int insert(Kind record) {
        return kindMapper.insert(record);
    }

    @Override
    public int insertSelective(Kind record) {
        return kindMapper.insertSelective(record);
    }

    @Override
    public Kind selectByPrimaryKey(Integer kindNo) {
        return kindMapper.selectByPrimaryKey(kindNo);
    }

    @Override
    public int updateByPrimaryKeySelective(Kind record) {
        return kindMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Kind record) {
        return kindMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<String> selectAll() {
        List<Kind> kinds= kindMapper.selectAll();
        List<String> list=new ArrayList<>();
        for(int i=0;i<kinds.size();i++){
            list.add(kinds.get(i).getKindName());
        }
        return list;
    }

    @Override
    public PageInfo<Kind> pageList(int currentPage, int pageSize) {

        List<Kind> list = new ArrayList<>();
        PageHelper.startPage(currentPage, pageSize);
        list = kindMapper.selectAll();
        PageInfo<Kind> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
